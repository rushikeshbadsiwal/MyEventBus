package MyEventBus;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

public class EventBus <T extends EventBus.Event>{


    private final ConcurrentHashMap<Class<?>, List<Function<T, CompletionStage<Void>>>> listenerMethods;

    public EventBus() {
        this.listenerMethods = new ConcurrentHashMap<>();
    }


    public void register(Class<?> event, Function<T, CompletionStage<Void>> f) {
        listenerMethods.computeIfAbsent(event, __ -> new ArrayList<>());
        listenerMethods.get(event).add(f);
    }

    public CompletionStage<Void> post(T e) {
        listenerMethods.computeIfAbsent(e.getClass(), __ -> new ArrayList<>());
        listenerMethods.get(e.getClass()).forEach(f -> f.apply(e));
        return CompletableFuture.completedFuture(null);
    }

    public void unregister(Object object) {
    }

    public interface Event {
    }
}
