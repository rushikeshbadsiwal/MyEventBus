package MyEventBus;

import MyEventBus.Event.TeamDowngradeToFreeEvent;
import MyEventBus.Event.TeamUpgradeToProEvent;
import MyEventBus.Event.TestEvent;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {

        EventBus eventBus = new EventBus();
        EventBusUsingReflection eventBusUsingReflection = new EventBusUsingReflection();
        NotificationDispatcher notificationDispatcher = new NotificationDispatcher(eventBus, eventBusUsingReflection);
        eventBus.post(new TeamDowngradeToFreeEvent("No Reflection"));
        eventBus.post(new TeamUpgradeToProEvent("No Reflection"));
        eventBusUsingReflection.post(new TeamDowngradeToFreeEvent("Using Reflection"));
        eventBus.post(new TeamUpgradeToProEvent("Using Reflection"));

        eventBus.post(new TestEvent("TestEvent"))
                .exceptionally(ex -> {
                    System.out.println("Exception handled " + ex);
                    return null;
                });
    }
}
