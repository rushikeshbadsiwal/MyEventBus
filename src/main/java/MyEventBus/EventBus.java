package MyEventBus;


import MyEventBus.Exception.NoListenerRegisteredException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.function.Function;

public class EventBus {

    private static final HashMap<Class<?>, List<Function<Object, CompletionStage<Void>>>> listenerMethods = new HashMap<>();

    private EventBus() {
    }

    public static synchronized <T> void register(Class<T> e, Function<T, CompletionStage<Void>> f) {
        listenerMethods.computeIfAbsent(e, __ -> new ArrayList<>()).add((Function<Object, CompletionStage<Void>>) f);
    }

    public static <T> CompletionStage<Void> post(T e) {
        return CompletableFuture.completedFuture(null)
                .thenCompose(__ -> CompletableFuture.allOf(listenerMethods.computeIfAbsent(e.getClass(), k -> {
                    throw new NoListenerRegisteredException("No listener found for " + e);
                }).stream().map(f -> f.apply(e).toCompletableFuture()).toArray(CompletableFuture[]::new)));
    }
}
