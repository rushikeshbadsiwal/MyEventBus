package MyEventBus.Event;

import MyEventBus.EventBus;

public class TeamUpgradeToProEvent implements EventBus.Event {
    private String name;

    public TeamUpgradeToProEvent(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TeamUpgradeToProEvent: " +
                "{name: " + name +
                "}";
    }
}
