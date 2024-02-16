package comcrypto.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileToStringBuilder {
    public StringBuilder fileToStringBuilder(File file) { // funcion to convert File to StringBuilder
        String line;
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) { // use BufferedReader to effectively read the data from file
            while ((line = bufferedReader.readLine()) != null) { // first store into String
                stringBuilder.append(line).append("\n"); // Then add it to StringBuilder to keep the format
            }

        }catch(IOException e){
                System.err.println("Error can't read the file");
            }
            return stringBuilder;
        }
    }

