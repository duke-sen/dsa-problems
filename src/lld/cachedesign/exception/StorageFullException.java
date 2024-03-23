package lld.cachedesign.exception;

public class StorageFullException extends RuntimeException {
    public StorageFullException() {
    }

    public StorageFullException(String message) {
        super(message);
    }

    public StorageFullException(String message, Throwable cause) {
        super(message, cause);
    }
}
