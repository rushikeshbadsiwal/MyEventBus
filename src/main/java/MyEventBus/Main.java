package MyEventBus;

import MyEventBus.Event.TeamDowngradeToFreeEvent;
import MyEventBus.Event.TeamUpgradeToProEvent;
import MyEventBus.Event.TestEvent;

public class Main {
    public static void main(String[] args) {

        new NotificationDispatcher();
        EventBus.post(new TeamDowngradeToFreeEvent("No Reflection"));
        EventBus.post(new TeamUpgradeToProEvent("No Reflection"));
        EventBus.post(new TeamUpgradeToProEvent("Using Reflection"));

        EventBus.post(new TestEvent("TestEvent"))
                .exceptionally(ex -> {
                    System.out.println("Exception handled " + ex);
                    return null;
                });
    }
}
