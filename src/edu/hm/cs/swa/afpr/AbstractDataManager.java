//@formatter:off
/*
 * Abstract data manager - demonstrates ABSTRACT FACTORY
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

import java.util.logging.Logger;

/**
 * Abstract data manager is the abstract base class (aka ABSTRACT FACTORY)
 * 
 * @author <a href="mailto:Karl.Eilebrecht(a/t)calamanari.de">Karl Eilebrecht</a>
 * @modified Gudrun Socher, 22.4.2019
 */
public abstract class AbstractDataManager {
    protected Logger logger = Logger.getLogger(this.getClass().getSimpleName());

    /**
     * name of data manager, textual description
     */
    private String name = null;

    /**
     * Textual description of this manager.
     * 
     * @return name may be null
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the manager name
     * 
     * @param name textual description, may be null
     */
    protected void setName(String name) {
        this.name = name;
    }

    /**
     * Creates a data writer.
     * 
     * @param fileName NOT NULL
     * @return data writer
     */
    public abstract AbstractDataWriter createDataWriter(String fileName);

    /**
     * Creates a data reader
     * 
     * @param fileName NOT NULL
     * @return data reader
     */
    public abstract AbstractDataReader createDataReader(String fileName);

}
