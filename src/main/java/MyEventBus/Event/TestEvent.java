package MyEventBus.Event;

import MyEventBus.EventBus;

public class TestEvent implements EventBus.Event {
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