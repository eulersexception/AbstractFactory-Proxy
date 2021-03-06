//@formatter:off
/*
 * Abstract data reader - demonstrates ABSTRACT PRODUCT
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
 * Abstract data reader is one base class of the ABSTRACT PRODUCTs each concrete ABSTRACT FACTORY can create.
 *
 * @author <a href="mailto:Karl.Eilebrecht(a/t)calamanari.de">Karl Eilebrecht</a>
 * @modified Gudrun Socher, 22.4.2019
 */
public abstract class AbstractDataReader {
    protected Logger logger = Logger.getLogger(this.getClass().getSimpleName());
    /**
     * source file
     */
    private File sourceFile = null;

    public File getSourceFile() {
        return sourceFile;
    }

    protected void setSourceFile(File sourceFile) {
        if (sourceFile == null) {
            throw new IllegalArgumentException("Argument file must not be null!");
        }
        this.sourceFile = sourceFile;
    }

    /**
     * describes the source
     */
    private String sourceInfo = null;

    public String getSourceInfo() {
        return sourceInfo;
    }

    protected void setSourceInfo(String sourceInfo) {
        this.sourceInfo = sourceInfo;
    }

    /**
     * Reads the string from the source.
     *
     * @return string from source
     */
    public abstract String readString();

}
