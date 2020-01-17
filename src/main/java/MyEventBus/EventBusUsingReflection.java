package MyEventBus;

import MyEventBus.Annotation.Subscribe;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ConcurrentHashMap;

public class EventBusUsingReflection {

//    private final ConcurrentHashMap<Class<?>, List<ListenerMethodDetails>> listenerMethods;
//
//    public EventBusUsingReflection() {
//        this.listenerMethods = new ConcurrentHashMap<>();
//    }
//
//    public CompletionStage<Void> post(T event) throws InvocationTargetException, IllegalAccessException {
//        listenerMethods.computeIfAbsent(event.getClass(), __ -> new ArrayList<>());
//        List<ListenerMethodDetails> methods = listenerMethods.get(event.getClass());
//        for (ListenerMethodDetails listenerMethodDetails : methods) {
//            listenerMethodDetails.method.invoke(listenerMethodDetails.classObject, event);
//        }
//        return CompletableFuture.completedFuture(null);
//    }
//
//    public void register(Object listener) {
//        registerListenerMethods(listener);
//    }
//
//    private void registerListenerMethods(Object listener) {
//        Class<?> clazz = listener.getClass();
//        for (Method method : getAnnotatedMethods(clazz)) {
//            Class<?>[] parameterTypes = method.getParameterTypes();
//            Class<?> eventType = parameterTypes[0];
//            listenerMethods.computeIfAbsent(eventType, __ -> new ArrayList<>());
//            List<ListenerMethodDetails> methods = listenerMethods.get(eventType);
//            methods.add(new ListenerMethodDetails(method, listener));
//        }
//    }
//
//    private List<Method> getAnnotatedMethods(Class<?> clazz) {
//        List<Method> methods = new ArrayList<>();
//
//        for (Method method : clazz.getDeclaredMethods()) {
//            if (method.isAnnotationPresent(Subscribe.class)) {
//                //TODO: validate parameters
//                methods.add(method);
//            }
//        }
//        return methods;
//    }
//
//    public void unregister(Object object) {
//    }
//
//    public interface Event {
//    }
//
//    public class ListenerMethodDetails {
//        final Method method;
//        final Object classObject;
//
//        ListenerMethodDetails(Method method, Object classObject) {
//            this.method = method;
//            this.classObject = classObject;
//        }
//    }
}
