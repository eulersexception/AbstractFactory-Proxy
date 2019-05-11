package edu.hm.cs.swa.afpr;

import java.io.File;

public class ImageFileDataReader extends AbstractDataReader {

    public ImageFileDataReader(File source) {
        logger.info(this.getClass().getSimpleName()+" created for file "+source.toString());
        if(source == null) {
            throw new IllegalArgumentException("Argument source must not be null");
        }
        this.setSourceInfo("Image file '"+ source + "'");
        this.setSourceFile(source);
    }

    @Override
    public String readString() {
        final String result = Util.readStringFromImage(this.getSourceFile());
        logger.info(this.getClass().getSimpleName()+" .readString() = "+result);
        return result;
    }
}
