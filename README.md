# Abstract Factory and Proxy Patterns


In this exercise, we want to implement an abstract factory for different file formats. We are using the abstract factory and the proxy patterns. 

We are starting with the abstract factory example of 
 the 'Patterns kompakt' book by Eilebrecht & Starke [http://www.patterns-kompakt.de/](http://www.patterns-kompakt.de/).
 Check out the abstract factory pattern at [http://www.patterns-kompakt.de/patterns/abstractfactory.html](http://www.patterns-kompakt.de/patterns/abstractfactory.html)

**You have the following task:**

### Part 1: add a PlainFileDataManager to the abstract file data factory

The abstract file data factory is a factory for different file readers and writers. 
The existing code implements a `SecureFileDataManager`. The `SecureFileDataManager` provides a reader and writer to store data in an 'encrypted' format. Add a `PlainFileDataManager` with a `PlainFileDataReader` and `PlainFileDataWriter`. The `PlainFileDataManager` provides a reader and writer for files in plain text.

1. ✅[Implement PlainFileDataManager](testClass[PlainFileDataManager],testAttributes[PlainFileDataManager],testMethods[PlainFileDataManager])

2. ✅[Implement PlainFileDataReader](testClass[PlainFileDataReader],testAttributes[PlainFileDataReader],testMethods[PlainFileDataReader])

3. ✅[Implement PlainFileDataWriter](testClass[PlainFileDataWriter],testAttributes[PlainFileDataWriter],testMethods[PlainFileDataWriter])



### Part 2: add an ImageFileDataManager and proxies to the abstract file data factory

We want to add a reader and writer for images to the factory. The image writer takes a text string and creates a JPEG image with the text written on the image. The image reader is able to read the text from a JPEG image. The reader creates an output string based on the text in an image.

We try to combine design patterns. The `ImageFileDataManager`is a good example to add in the **Proxy pattern**. Image files are larger than text files and it could take longer to read and write those files. Your task is to provide a proxy image file reader and a proxy image file writer in addition to the image file reader and writer.  


1. ✅[Implement ImageFileDataManager](testClass[ImageFileDataManager],testAttributes[ImageFileDataManager],testMethods[ImageFileDataManager])

2. ✅[Implement ImageFileDataReader](testClass[ImageFileDataReader],testAttributes[ImageFileDataReader],testMethods[ImageFileDataReader])

3. ✅[Implement ImageFileDataWriter](testClass[ImageFileDataWriter],testAttributes[ImageFileDataWriter],testMethods[ImageFileDataWriter])

4. ✅[Implement ImageFileProxyDataReader](testClass[ImageFileProxyDataReader],testAttributes[ImageFileProxyDataReader],testMethods[ImageFileProxyDataReader])

5. ✅[Implement ImageFileProxyDataWriter](testClass[ImageFileProxyDataWriter],testAttributes[ImageFileProxyDataWriter],testMethods[ImageFileProxyDataWriter])


### Part 3: make sure everything works

Remove all comments from  `Client.java` and make sure the program runs. This example is a maven project. You see a `pom.xml`.
Call `mvn clean install` to compile and `mvn exec:java` to run the executable jar in the `target` directory.

### Please note
You see the class `Util.java` in your project. This class provides utilities to read and write data including images. Writing text to a jpeg image is done using `java.awt.Graphics`. Reading text from images uses [Tesseract](https://opensource.google.com/projects/tesseract) for optical character recognition on images.



@startuml
skinparam linetype polyline
skinparam linetype ortho
abstract class AbstractDataManager{
    - name: String 
    + {abstract}  createDataWriter(fileName: String): AbstractDataWriter
    + {abstract}  createDataReader(fileName: String): AbstractDataReader
}

abstract class AbstractDataReader{
    - sourceFile: File 
    + {abstract} readString(): String
}

abstract class AbstractDataWriter{
    - destinationFile: File 
    + {abstract} writeString(): long
}

class SecureFileDataManager{
    + createDataWriter(fileName: String): SecureFileDataWriter
    + createDataReader(fileName: String): SecureFileDataReader
}
class PlainFileDataManager{
    + <color:testsColor(testMethods[PlainFileDataManager])>createDataWriter(fileName: String): PlainFileDataWriter</color>
    + <color:testsColor(testMethods[PlainFileDataManager])>createDataReader(fileName: String): PlainFileDataReader</color>
}
class ImageFileDataManager{
    + <color:testsColor(testMethods[ImageFileDataManager])>createDataWriter(fileName: String): ImageFileProxyDataWriter</color>
    + <color:testsColor(testMethods[ImageFileDataManager])>createDataReader(fileName: String): ImageFileProxyDataReader</color>
}

class SecureFileDataReader{
    - unscramble(scrambled: String): String
    + readString(): String
}

class SecureFileDataWriter{
    - scramble(source: String): String
    + writeString(): long
}
class PlainFileDataReader{
    + <color:testsColor(testMethods[PlainFileDataReader])>readString(): String</color>
}

class PlainFileDataWriter{
    + <color:testsColor(testMethods[PlainFileDataWriter])>writeString(): long</color>
}
class ImageFileDataReader{
    + <color:testsColor(testMethods[ImageFileDataReader])>readString(): String</color>
}

class ImageFileDataWriter{
    + <color:testsColor(testMethods[ImageFileDataWriter])>writeString(): long</color>
}

class ImageFileProxyDataReader{
    - <color:testsColor(testAttributes[ImageFileProxyDataReader])>imageFileDataReader: ImageFileDataReader</color>
    + <color:testsColor(testMethods[ImageFileProxyDataReader])>readString(): String</color>
}

class ImageFileProxyDataWriter{
    - <color:testsColor(testAttributes[ImageFileProxyDataWriter])>imageFileDataWriter: ImageFileDataWriter</color>
    + <color:testsColor(testMethods[ImageFileProxyDataWriter])>writeString(): long</color>
}

AbstractDataManager <|-- SecureFileDataManager
AbstractDataManager <|-- PlainFileDataManager
AbstractDataManager <|-- ImageFileDataManager

SecureFileDataReader --|> AbstractDataReader
PlainFileDataReader --|> AbstractDataReader
ImageFileDataReader --|> AbstractDataReader
ImageFileProxyDataReader --|> AbstractDataReader
ImageFileProxyDataReader --> ImageFileDataReader

SecureFileDataWriter --|> AbstractDataWriter
PlainFileDataWriter --|> AbstractDataWriter
ImageFileDataWriter --|> AbstractDataWriter
ImageFileProxyDataWriter --|> AbstractDataWriter
ImageFileProxyDataWriter --> ImageFileDataWriter

SecureFileDataManager ..>SecureFileDataReader: <<create>>
SecureFileDataManager ..>SecureFileDataWriter: <<create>>

PlainFileDataManager ..>PlainFileDataReader: <<create>>
PlainFileDataManager ..>PlainFileDataWriter: <<create>>

ImageFileDataManager ..>ImageFileProxyDataReader: <<create>>
ImageFileDataManager ..>ImageFileProxyDataWriter: <<create>>


@enduml


