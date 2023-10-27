package entities.responses;

import java.util.List;

public class ResponseEntity<T> {
    private final T arg;
    private final short statusCode;
    private final List<String> errors;

    public ResponseEntity(T arg, short statusCode, List<String> errors) {
        this.arg = arg;
        this.statusCode = statusCode;
        this.errors = errors;
    }

    public T getArg() {
        return arg;
    }

    public short getStatusCode() {
        return statusCode;
    }

    public List<String> getErrors() {
        return errors;
    }
}
