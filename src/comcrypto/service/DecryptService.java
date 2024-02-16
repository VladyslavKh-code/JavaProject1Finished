package comcrypto.service;

import comcrypto.transformer.TextTransformer;

import java.io.*;

public class DecryptService {
    private TextTransformer textTransformer = new TextTransformer();
    private FileToStringBuilder fileToStringBuilder = new FileToStringBuilder();

    public void decrypt(File file, int key) {
        StringBuilder stringBuilder = fileToStringBuilder.fileToStringBuilder(file); // read data from file
        TextTransformer transformer = new TextTransformer();
        String decryptedText = transformer.moveLetterOnLeftPositions(key, stringBuilder.toString());//use method moveLetterOnLeftPositions to decrypt shifted text

        String decryptedName = file.getName().replace("[ENCRYPTED]", "[DECRYPTED]"); // new file name
        File newFile = new File(decryptedName);
        try (FileWriter fileWriter = new FileWriter(newFile)) {
            fileWriter.write(decryptedText); // file decrypted into new file
        } catch (IOException e) {
            System.out.println("Error writing in to the file");
        }

    }
}
