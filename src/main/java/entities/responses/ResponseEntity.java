package entities.responses;

public class ResponseEntity<T> {
    private final T arg;
    private final short statusCode;

    public ResponseEntity(T arg, short statusCode) {
        this.arg = arg;
        this.statusCode = statusCode;
    }

    public T getArg() {
        return arg;
    }

    public short getStatusCode() {
        return statusCode;
    }
}
