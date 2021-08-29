package io.justinjordan.userlogin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.function.Consumer;

public class DataStorage {
    private static String readPath = "src/main/resources/users.csv";
    private static String writePath = "src/main/resources/users.temp.csv";
    private static File readFile = null;
    private static File writeFile = null;
    private static BufferedReader reader = null;
    private static FileReader fileReader = null;
    private static FileWriter fileWriter = null;

    public static BufferedReader getReader() {
        try {
            if (reader == null) {
                readFile = new File(readPath);
                fileReader = new FileReader(readFile);
                reader = new BufferedReader(fileReader);
            }

            return reader;
        } catch (Exception e) {
            System.out.println("Data Storage Error: " + e.getMessage());
            return null;
        }
    }

    public static FileWriter getWriter() {
        try {
            if (fileWriter == null) {
                writeFile = new File(writePath);
                fileWriter = new FileWriter(writeFile);
            }

            return fileWriter;
        } catch (Exception e) {
            System.out.println("Data Storage Error: " + e.getMessage());
            return null;
        }
    }

    public static void removeTemp() {
        if (readFile != null && writeFile != null && readFile.exists() && writeFile.exists()) {
            readFile.delete();
            writeFile.renameTo(readFile);
        }
    }

    public static void cleanUp() {
        removeTemp();

        if (reader != null) {
            try {
                reader.close();
                reader = null;
            } catch (Exception e) {
                //
            }
        }

        if (fileReader != null) {
            try {
                fileReader.close();
                fileReader = null;
            } catch (Exception e) {
                //
            }
        }

        if (fileWriter != null) {
            try {
                fileWriter.close();
                fileWriter = null;
            } catch (Exception e) {
                //
            }
        }
    }
}
