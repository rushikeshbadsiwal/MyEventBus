package MyEventBus.Event;

import MyEventBus.EventBus;

public class TeamDowngradeToFreeEvent implements EventBus.Event {
    private String name;

    public TeamDowngradeToFreeEvent(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TeamDowngradeToFreeEvent: " +
                "{name: " + name +
                "}";
    }
}
