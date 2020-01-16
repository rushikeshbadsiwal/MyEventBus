package MyEventBus;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EventBus<T extends EventBus.Event> {


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
        return allOf(listenerMethods.get(e.getClass()).stream().map(f -> f.apply(e)).collect(Collectors.toList()))
                .thenApply(__ -> null);
    }

    public void unregister(Object object) {
    }

    public interface Event {
    }

    private static <T> CompletionStage<List<T>> allOf(final List<CompletionStage<T>> futures) {
        return CompletableFuture.allOf(futures.stream().map(CompletionStage::toCompletableFuture).toArray(CompletableFuture[]::new))
                .thenApply(__ -> {
                    final List<T> list = new ArrayList<>();
                    futures.forEach(future -> future.thenAccept(list::add));
                    return list;
                });
    }
}
