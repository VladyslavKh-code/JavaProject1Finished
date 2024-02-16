package comcrypto.service;

import java.io.*;

public class BruteForceService {

    private DecryptService decryptService = new DecryptService();
    private BruteForceHelper bruteForceHelper = new BruteForceHelper();
    private FileToStringBuilder fileToStringBuilder = new FileToStringBuilder();

    public void decrypt(File file) { // special decrypt(BRUTE_FORCE) that decrypts the file without using key
        String result = fileToStringBuilder.fileToStringBuilder(file).toString(); // get the data from file
        int key = 0;
        if (result != null) {
            key = bruteForceHelper.findEncryptionKey(result); // use the function that returns the appropriate key
        }

        decryptService.decrypt(file, key); // decrypt service
    }
}
