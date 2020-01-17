package MyEventBus;

import MyEventBus.Annotation.Subscribe;
import MyEventBus.Event.TeamDowngradeToFreeEvent;
import MyEventBus.Event.TeamUpgradeToProEvent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public class NotificationDispatcher {

    NotificationDispatcher() {
        EventBus.register(TeamDowngradeToFreeEvent.class, this::onTeamDowngradeToFree);
        EventBus.register(TeamDowngradeToFreeEvent.class, this::onTeamDowngradeToFree2);
        EventBus.register(TeamUpgradeToProEvent.class, this::onTeamUpgrade);
    }

    private CompletionStage<Void> onTeamDowngradeToFree(TeamDowngradeToFreeEvent event) {
        System.out.println("Event handled " + event);
        return CompletableFuture.completedFuture(null);
    }

    private CompletionStage<Void> onTeamDowngradeToFree2(TeamDowngradeToFreeEvent event) {
        System.out.println("Event handled 2 " + event);
        return CompletableFuture.completedFuture(null);
    }


    @Subscribe
    public CompletionStage<Void> onTeamUpgrade(TeamUpgradeToProEvent event) {
        System.out.println("Event handled " + event);
        return CompletableFuture.completedFuture(null);
    }

    @Subscribe
    public CompletionStage<Void> onTeamDowngradeToFree3(TeamDowngradeToFreeEvent event) {
        System.out.println("Event handled " + event);
        return CompletableFuture.completedFuture(null);
    }

}
