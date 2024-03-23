package lld.cachedesign.exception;

public class InvalidElementException extends RuntimeException {
    public InvalidElementException() {
    }

    public InvalidElementException(String message) {
        super(message);
    }

    public InvalidElementException(String message, Throwable cause) {
        super(message, cause);
    }
}
