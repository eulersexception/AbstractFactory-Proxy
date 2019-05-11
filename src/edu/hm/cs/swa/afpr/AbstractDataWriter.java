//@formatter:off
/*
 * Abstract data writer - demonstrates ABSTRACT PRODUCT
 * Code-Beispiel zum Buch Patterns Kompakt, Verlag Springer Vieweg
 * Copyright 2014 Karl Eilebrecht
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
//@formatter:on
package edu.hm.cs.swa.afpr;

import java.io.File;
import java.util.logging.Logger;

/**
 * Abstract data writer is one base class of the ABSTRACT PRODUCTs each concrete ABSTRACT FACTORY can create.
 *
 * @author <a href="mailto:Karl.Eilebrecht(a/t)calamanari.de">Karl Eilebrecht</a>
 * @modified Gudrun Socher, 22.4.2019
 */
public abstract class AbstractDataWriter {
    protected Logger logger = Logger.getLogger(this.getClass().getSimpleName());

    /**
     * destination file
     */
    private File destinationFile = null;

    public File getDestinationFile() {
        return destinationFile;
    }

    protected void setDestinationFile(File destinationFile) {
        if (destinationFile == null) {
            throw new IllegalArgumentException("Argument file must not be null!");
        }
        this.destinationFile = destinationFile;
    }

    /**
     * describes the destination
     */
    private String destinationInfo = null;


    public String getDestinationInfo() {
        return destinationInfo;
    }

    protected void setDestinationInfo(String destinationInfo) {
        this.destinationInfo = destinationInfo;
    }

    /**
     * writes the given string.
     *
     * @param item string to write
     * @return size (bytes written), -1 if unsupported
     */
    public abstract long writeString(String item);
}
