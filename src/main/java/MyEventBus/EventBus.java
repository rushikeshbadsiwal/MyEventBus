package MyEventBus;


import MyEventBus.Exception.NoListenerRegisteredException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.function.Function;

//Event interface

public class EventBus<T extends EventBus.Event> {

    private final HashMap<Class<?>, List<Function<T, CompletionStage<Void>>>> listenerMethods;

    public EventBus() {
        this.listenerMethods = new HashMap<>();
    }

    public synchronized void register(Class<T> e, Function<T, CompletionStage<Void>> f) {
        listenerMethods.computeIfAbsent(e, __ -> new ArrayList<>()).add(f);
    }

    public CompletionStage<Void> post(T e) {
        return CompletableFuture.completedFuture(null)
                .thenCompose(__ -> CompletableFuture.allOf(listenerMethods.computeIfAbsent(e.getClass(), v -> {
                    throw new NoListenerRegisteredException("No listener found for " + e);
                }).stream().map(f -> f.apply(e).toCompletableFuture()).toArray(CompletableFuture[]::new)));
    }

    public interface Event {
    }
}
