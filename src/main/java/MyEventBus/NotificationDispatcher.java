package MyEventBus;

import MyEventBus.Event.TeamDowngradeToFreeEvent;
import MyEventBus.Event.TeamUpgradeToProEvent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public class NotificationDispatcher {

    NotificationDispatcher(EventBus eventBus) {
        eventBus.register(TeamDowngradeToFreeEvent.class, (event) -> onTeamDowngradeToFree((TeamDowngradeToFreeEvent)event));
        eventBus.register(TeamDowngradeToFreeEvent.class, (event) -> onTeamDowngradeToFree2((TeamDowngradeToFreeEvent)event));
        eventBus.register(TeamUpgradeToProEvent.class, (event) -> onTeamUpgrade((TeamUpgradeToProEvent) event));
    }

    private CompletionStage<Void> onTeamDowngradeToFree(TeamDowngradeToFreeEvent event) {
        System.out.println("Event handled " + event);
        return CompletableFuture.completedFuture(null);
    }

    private CompletionStage<Void> onTeamDowngradeToFree2(TeamDowngradeToFreeEvent event) {
        System.out.println("Event handled 2 " + event);
        return CompletableFuture.completedFuture(null);
    }

    private CompletionStage<Void> onTeamUpgrade(TeamUpgradeToProEvent event) {
        System.out.println("Event handled  " + event);
        return CompletableFuture.completedFuture(null);
    }

}
