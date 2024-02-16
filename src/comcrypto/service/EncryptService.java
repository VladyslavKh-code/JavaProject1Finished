package comcrypto.service;

import comcrypto.transformer.TextTransformer;

import java.io.*;

public class EncryptService {
    private TextTransformer textTransformer = new TextTransformer();
    private BruteForceService bruteForceService = new BruteForceService();
    private FileToStringBuilder fileToStringBuilder = new FileToStringBuilder();

    public void encrypt(File file, int key) {
        StringBuilder dataFromFile = fileToStringBuilder.fileToStringBuilder(file); // read data from file

        TextTransformer textTransformer = new TextTransformer();
        String encryptedText = textTransformer.moveLetterOnRightPositions(key, dataFromFile.toString()); //use method moveLetterOnRightPositions to shift original text


        String encryptedName = file.getName().replace(".txt", "[ENCRYPTED].txt"); //new file name according to requirements
        File encryptedFile = new File(encryptedName);

        try (FileWriter writer = new FileWriter(encryptedFile)) {
            writer.write(encryptedText); // write encrypted data into new file
        } catch (IOException e) {
            System.err.println("Error writing encrypted text to file");
        }

    }

}
