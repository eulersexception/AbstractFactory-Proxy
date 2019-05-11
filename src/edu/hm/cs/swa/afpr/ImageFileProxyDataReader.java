package edu.hm.cs.swa.afpr;

import java.io.File;

public class ImageFileProxyDataReader extends AbstractDataReader {

    private ImageFileDataReader imageFileDataReader;

    public ImageFileProxyDataReader(File file) {
        logger.info(this.getClass().getSimpleName()+" created for file "+file+toString());
        if(file == null) {
            throw new IllegalArgumentException("Argument file must not be null");
        }
        imageFileDataReader = new ImageFileDataReader(file);
    }

    @Override
    public String readString() {
        final String result = imageFileDataReader.readString();
        logger.info(this.getClass().getSimpleName()+" .readString() = "+ result);
        return result;
    }
}
