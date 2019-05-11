package edu.hm.cs.swa.afpr;

import java.io.File;
import java.nio.file.Files;

public class PlainFileDataManager extends AbstractDataManager {

    public PlainFileDataManager() { this.setName(" Plain File Data Manager");}

    @Override
    public PlainFileDataReader createDataReader(String fileName) {
        logger.info(this.getClass().getSimpleName() + " createDataReader() called.");
        if(fileName == null || fileName.trim().length() == 0) {
            throw new IllegalArgumentException("Argument fileName must not be null or empty.");
        }
        File sourceFile = new File(fileName+".plain");
        return new PlainFileDataReader(sourceFile);
    }

    @Override
    public PlainFileDataWriter createDataWriter(String fileName) {
        logger.info(this.getClass().getSimpleName()+" createDataWriter() called.");
        if(fileName == null || fileName.trim().length() == 0) {
            throw new IllegalArgumentException("Argument fileName must not be null or empty");
        }
        File destinationFile = new File(fileName+".plain");
        return new PlainFileDataWriter(destinationFile);
    }
}
