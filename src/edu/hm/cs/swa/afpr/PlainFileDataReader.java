package edu.hm.cs.swa.afpr;

import java.io.File;

public class PlainFileDataReader extends AbstractDataReader {

    public PlainFileDataReader(File source) {
        logger.info(this.getClass().getSimpleName()+" created for file " + source.toString());
        if(source == null) {
            throw new IllegalArgumentException("Argument source must not be null.");
        }
        this.setSourceInfo("Plain file '"+ source +"'");
        this.setSourceFile(source);
    }

    @Override
    public String readString() {
        String str = Util.readStringFromFile(getSourceFile());
        logger.info(this.getClass().getSimpleName()+" .readString() = "+ str);
        return str;
    }
}
