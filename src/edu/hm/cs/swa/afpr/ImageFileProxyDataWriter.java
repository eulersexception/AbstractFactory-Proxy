package edu.hm.cs.swa.afpr;

import java.io.File;

public class ImageFileProxyDataWriter extends AbstractDataWriter {

    private ImageFileDataWriter imageFileDataWriter;

    public ImageFileProxyDataWriter(File file) {
        logger.info(this.getClass().getSimpleName()+" created for "+file.toString());
        if(file == null) {
            throw new IllegalArgumentException("Argument file must not be null");
        }
        this.setDestinationInfo("Image file "+ file +"'");
        this.setDestinationFile(file);
    }

    @Override
    public long writeString(String item) {
        final long result = imageFileDataWriter.writeString(item);
        logger.info(this.getClass().getSimpleName() + " .writeString() = "+result);
        return result;
    }
}
