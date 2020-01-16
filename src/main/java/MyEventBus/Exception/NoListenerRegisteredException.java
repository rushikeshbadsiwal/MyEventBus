package MyEventBus.Exception;

public class NoListenerRegisteredException extends RuntimeException {

    public NoListenerRegisteredException(String message) {
        super(message);
    }
}
