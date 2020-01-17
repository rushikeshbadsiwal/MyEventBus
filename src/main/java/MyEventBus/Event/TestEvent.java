package MyEventBus.Event;

public class TestEvent {
    private String name;

    public TestEvent(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TestEvent: " +
                "{name: " + name +
                "}";
    }
}