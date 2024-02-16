package comcrypto;

import comcrypto.exception.InvalidArgumentException;
import comcrypto.models.Mode;
import comcrypto.service.BruteForceService;
import comcrypto.service.DecryptService;
import comcrypto.service.EncryptService;

import java.io.File;
import java.util.Scanner;

import static comcrypto.util.InputValidation.*;


public class Main {
    private static final int COMMAND_ARGUMENT_POSITION = 0;
    private static final int FILEPATH_ARGUMENT_POSITION = 1;
    private static final int KEY_ARGUMENT_POSITION = 2;

    public static void main(String[] args) {
        validate(args);
        validateCommand(args[COMMAND_ARGUMENT_POSITION]);
        validateFilepath(args[FILEPATH_ARGUMENT_POSITION]);
        File originalFile = new File((args[FILEPATH_ARGUMENT_POSITION]));
        if (args[COMMAND_ARGUMENT_POSITION].equals("BRUTE_FORCE")) {
            BruteForceService bruteForceService = new BruteForceService();
            bruteForceService.decrypt(originalFile);
        } else {
            validateKey(args[KEY_ARGUMENT_POSITION]);
            int key = Integer.parseInt(args[KEY_ARGUMENT_POSITION]);
            if (args[COMMAND_ARGUMENT_POSITION].equals("ENCRYPT")) {
                EncryptService encryptService = new EncryptService();
                encryptService.encrypt(originalFile, key);
            } else if (args[COMMAND_ARGUMENT_POSITION].equals("DECRYPT")) {
                DecryptService decryptService = new DecryptService();
                decryptService.decrypt(originalFile, key);
            }
        }
        System.out.println("check");

    }

}
