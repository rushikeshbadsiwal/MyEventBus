package MyEventBus.Event;

public class TeamUpgradeToProEvent {
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
