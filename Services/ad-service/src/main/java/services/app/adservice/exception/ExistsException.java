package services.app.adservice.exception;

@SuppressWarnings("serial")
public class ExistsException extends RuntimeException {

    public ExistsException() {
    }

    public ExistsException(String message) {
        super(message);
    }
}
