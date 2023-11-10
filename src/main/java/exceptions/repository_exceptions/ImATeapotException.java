package exceptions.repository_exceptions;

public class ImATeapotException extends RepositoryException{
    public ImATeapotException() {
    }

    public ImATeapotException(String message) {
        super(message);
    }

    public ImATeapotException(String message, Throwable cause) {
        super(message, cause);
    }

    public ImATeapotException(Throwable cause) {
        super(cause);
    }

    public ImATeapotException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
