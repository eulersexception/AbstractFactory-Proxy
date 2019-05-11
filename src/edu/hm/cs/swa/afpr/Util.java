package edu.hm.cs.swa.afpr;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;

public class Util {

    /**
     * Reads the given file and returns its content as a string
     *
     * @return String with file content, line separator = '\n'
     */

    public static String readStringFromFile(File sourceFile) {
        StringBuilder res = null;
        try {
            List<String> lines = Files.readAllLines(sourceFile.toPath(), Charset.forName("UTF-8"));
            int count = 0;
            int len = lines.size();
            if (len > 0) {
                res = new StringBuilder(100 + len * 20);
                for (String line : lines) {
                    if (count > 0) {
                        res.append("\n");
                    }
                    res.append(line);
                    count++;
                }
                res.append("\n");
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return (res == null ? "" : res.toString());
    }

    public static long writeStringToFile(String str, File destinationFile) {

        try {
            Files.write(destinationFile.toPath(), str.getBytes("UTF-8"));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return destinationFile.length();
    }

    public static String readStringFromImage(File sourceFile) {
        String res = null;
        ITesseract instance = new Tesseract();
        try {
            res = instance.doOCR(sourceFile);
        } catch (TesseractException e) {
            System.err.println(e.getMessage());
            return "Error while reading image";
        }
        return (res == null ? "" : res);
    }

    public static long writeStringToImage(String str, File destinationFile) {

        String key;
        BufferedImage bufferedImage = new BufferedImage(280, 280,
                BufferedImage.TYPE_INT_RGB);
        Graphics graphics = bufferedImage.getGraphics();
        graphics.setColor(Color.LIGHT_GRAY);
        graphics.fillRect(0, 0, 280, 280);
        graphics.setColor(Color.BLACK);
        graphics.setFont(new Font("Arial Black", Font.BOLD, 16));
        int char_counter = 0;
        int line_length = 20;
        int line_nr = 0;
        while (str.length() > char_counter) {
            line_length = 20;
            if (char_counter + line_length <= str.length()) {
                //find suitable substring
                while (str.charAt(char_counter + line_length) != ' ')
                    line_length++;
                key = str.substring(char_counter, char_counter + line_length);
            } else {
                key = str.substring(char_counter);
            }
            graphics.drawString(key, 10, (line_nr + 1) * 25);
            line_nr++;
            char_counter += line_length;
        }
        try {
            ImageIO.write(bufferedImage, "jpg", destinationFile);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return destinationFile.length();
    }
}
