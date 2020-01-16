package MyEventBus;

import MyEventBus.Event.TeamDowngradeToFreeEvent;
import MyEventBus.Event.TeamUpgradeToProEvent;

public class Main {
    public static void main(String[] args) {

        EventBus eventBus = new EventBus();
        NotificationDispatcher notificationDispatcher = new NotificationDispatcher(eventBus);
        eventBus.post(new TeamDowngradeToFreeEvent("xyz"));
        eventBus.post(new TeamUpgradeToProEvent("xyz"));
    }
}
