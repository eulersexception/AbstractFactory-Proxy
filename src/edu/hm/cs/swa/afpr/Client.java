package edu.hm.cs.swa.afpr;

import java.text.*;

public class Client {
    private static final String FUNNY_TEXT = "My dog used to chase people on a bike a lot. It got so bad, finally I had to take his bike away.\n";
    private static final String FUNNY_TEXT_FILE_NAME = "FunnyText";

    public static void main(String[] args) throws ParseException {

        AbstractDataManager manager;
        AbstractDataWriter writer;
        AbstractDataReader reader;

        /*
        PlainFileDataManager plainFileDataManager = new PlainFileDataManager();
        */
        SecureFileDataManager secureFileDataManager = new SecureFileDataManager();
        /*
        ImageFileDataManager imageFileProxyDataManager = new ImageFileDataManager();

        manager = plainFileDataManager;
        writer = manager.createDataWriter(FUNNY_TEXT_FILE_NAME);
        writer.writeString(FUNNY_TEXT);
        */
        manager = secureFileDataManager;
        writer = manager.createDataWriter(FUNNY_TEXT_FILE_NAME);
        writer.writeString(FUNNY_TEXT);

        /*
        manager = plainFileDataManager;
        reader = manager.createDataReader(FUNNY_TEXT_FILE_NAME);
        System.out.println("Reading from plain file");
        System.out.println(reader.readString());

        manager = secureFileDataManager;
        */
        reader = manager.createDataReader(FUNNY_TEXT_FILE_NAME);
        System.out.println("Reading from secure file");
        System.out.println(reader.readString());

        /*
        manager = imageFileProxyDataManager;
        writer = manager.createDataWriter(FUNNY_TEXT_FILE_NAME);
        writer.writeString(FUNNY_TEXT);

        manager = imageFileProxyDataManager;
        reader = manager.createDataReader(FUNNY_TEXT_FILE_NAME);
        System.out.println("Reading from image file");
        System.out.println(reader.readString());
        */
    }
}
