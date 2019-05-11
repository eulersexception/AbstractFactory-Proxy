//@formatter:off
/*
 * Secure file data writer - CONCRETE PRODUCT
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

/**
 * Secure file data writer, a CONCRETE PRODUCT of CONCRETE FACTORY
 * 
 * @author <a href="mailto:Karl.Eilebrecht(a/t)calamanari.de">Karl Eilebrecht</a>
 * @modified Gudrun Socher, 22.4.2019
 */
public class SecureFileDataWriter extends AbstractDataWriter {

    public SecureFileDataWriter(File file) {
        logger.info(this.getClass().getSimpleName() + " created for file " + file.toString());
        this.setDestinationInfo("Secure File '" + file + "'");
        this.setDestinationFile(file);
    }

    @Override
    public long writeString(String item) {
        logger.info(this.getClass().getSimpleName() + ".writeString: " + item);
        String scrambledItem = scramble(item);
        logger.info(this.getClass().getSimpleName() + ": write scrambled: " + scrambledItem);
        return Util.writeStringToFile(scrambledItem, this.getDestinationFile());
    }

    /**
     * This method decodes a given string - using top secret algorithm! :-)
     *
     * @param source (is scrambled text)
     * @return unscrambled text
     */

    private String scramble(String source) {
        char[] characters = source.toCharArray();
        int len = characters.length;
        int startOffset = len % 17;
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char ch = characters[i];
            if (ch >= 65 && ch <= 90) {
                int code = ch;
                code = code - 65;
                code = code + startOffset + i;
                code = code % 26;
                code = code + 97;
                ch = (char) code;
            }
            else if (ch >= 97 && ch <= 122) {
                int code = ch;
                code = code - 97;
                code = code + startOffset + i;
                code = code % 26;
                code = code + 65;
                ch = (char) code;
            }
            sb.append(ch);
        }
        return sb.toString();
    }
}
