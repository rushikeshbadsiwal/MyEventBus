package MyEventBus.Event;

public class TeamDowngradeToFreeEvent {
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
