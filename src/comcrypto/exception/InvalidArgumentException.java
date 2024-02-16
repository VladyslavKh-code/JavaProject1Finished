package comcrypto.exception;

public class InvalidArgumentException extends RuntimeException { // used to return created Exception
    public InvalidArgumentException(String message) {
        super(message);
    }
}
