package edu.hm.cs.swa.afpr;

import java.io.File;

public class ImageFileDataManager extends AbstractDataManager {

    public ImageFileDataManager() {
        this.setName("Image File Data Manager");
    }

    @Override
    public ImageFileProxyDataWriter createDataWriter(String fileName) {
        logger.info(this.getClass().getSimpleName()+" createImageDataWriter() called.");
        if(fileName == null || fileName.trim().length() == 0) {
            throw new IllegalArgumentException("Argument fileName must not be null or empty");
        }
        File dest = new File(fileName+".JPEG");
        return new ImageFileProxyDataWriter(dest);
    }

    @Override
    public ImageFileProxyDataReader createDataReader(String fileName) {
        logger.info(this.getClass().getSimpleName()+" createDataReader() call");
        if(fileName == null || fileName.trim().length() == 0) {
            throw new IllegalArgumentException("Argument fileName must not be null or empty");
        }
        File source = new File(fileName+".JPEG");
        return new ImageFileProxyDataReader(source);
    }
}

