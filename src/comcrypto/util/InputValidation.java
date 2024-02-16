package comcrypto.util;

import comcrypto.exception.InvalidArgumentException;
import comcrypto.models.Mode;

import java.nio.file.Files;
import java.nio.file.Path;

public class InputValidation {
    public static void validate(String[] args) { // used to check the amount of arguments
        if (args.length < 2) {
            throw new InvalidArgumentException("Command and File are required");
        }
        if (args.length > 3) {
            throw new InvalidArgumentException("More than 3 arguments");
        }
    }

    public static void validateCommand(String command) { // check if the first argument is written properly
        boolean isCommandExist = false;
        for (Mode mode : Mode.values()) {
            if (mode.toString().equals(command)) {
                isCommandExist = true;
                break;
            }
        }
        if (!isCommandExist) {
            throw new InvalidArgumentException("Command does not exist");
        }
    }

    public static void validateFilepath(String path) { // used to check the availability of file
        if (path.isBlank()) {
            throw new InvalidArgumentException("Filename is empty!");
        }
        if (!Files.exists(Path.of(path))) {
            throw new InvalidArgumentException("File not found");
        }
    }

    public static void validateKey(String key) { // check if the key is correct
        if (key.isBlank()) {
            throw new InvalidArgumentException("Please enter something");
        }
        if (!containsDigit(key)) {
            throw new InvalidArgumentException("Please enter an appropriate number");
        }
    }

    private static boolean containsDigit(String str) {
        return str.matches("[0-9]+");
    } //used for validateKey
}
