package edu.hm.cs.swa.afpr;

import java.io.File;

public class PlainFileDataWriter extends AbstractDataWriter {

    public PlainFileDataWriter(File dest) {
        logger.info(this.getClass().getSimpleName()+" created for file " + dest.toString());
        if(dest == null) {
            throw new IllegalArgumentException("Argument dest must not be null");
        }
        this.setDestinationInfo("Plain file '" + dest + "'");
        this.setDestinationFile(dest);
    }

    @Override
    public long writeString(String item) {
        final long result = Util.writeStringToFile(item, this.getDestinationFile());
        logger.info(this.getClass().getSimpleName() + " .writeString() = " + result);
        return result;
    }
}
