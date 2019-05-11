//@formatter:off
/*
 * Secure file data reader - CONCRETE PRODUCT
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
 * Secure file data reader, a CONCRETE PRODUCT of CONCRETE FACTORY
 *
 * @author <a href="mailto:Karl.Eilebrecht(a/t)calamanari.de">Karl Eilebrecht</a>
 * @modified Gudrun Socher, 22.4.2019
 */
public class SecureFileDataReader extends AbstractDataReader {

    public SecureFileDataReader(File file) {
        logger.info(this.getClass().getSimpleName() + " created for file " + file.toString());
        if (file == null) {
            throw new IllegalArgumentException("Argument file must not be null!");
        }
        this.setSourceInfo("Secure File '" + file + "'");
        this.setSourceFile(file);
    }

    @Override
    public String readString() {
        String scrambledItem = Util.readStringFromFile(getSourceFile());
        String item = unscramble(scrambledItem);
        logger.info(this.getClass().getSimpleName() + ".readString() = " + item);
        return item;
    }

    /**
     * This method decodes a given string - using top secret algorithm! :-)
     *
     * @param scrambled text
     * @return unscrambled text
     */

    private String unscramble(String scrambled) {
        logger.info(this.getClass().getSimpleName() + ".unscramble() called.");
        char[] characters = scrambled.toCharArray();
        int len = characters.length;
        int startOffset = len % 17;
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char ch = characters[i];
            if (ch >= 65 && ch <= 90) {
                int code = ch;
                code = code - 65;
                int dif = (startOffset + i) - code;
                if (dif > 0) {
                    dif = dif + ((26 - (dif % 26)) % 26);
                    code = code + dif;
                }
                code = code - (startOffset + i);
                code = code + 97;
                ch = (char) code;
            } else if (ch >= 97 && ch <= 122) {
                int code = ch;
                code = code - 97;
                int dif = (startOffset + i) - code;
                if (dif > 0) {
                    dif = dif + ((26 - (dif % 26)) % 26);
                    code = code + dif;
                }
                code = code - (startOffset + i);
                code = code + 65;
                ch = (char) code;
            }
            sb.append(ch);
        }
        return sb.toString();
    }
}
