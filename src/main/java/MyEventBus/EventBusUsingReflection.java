package MyEventBus;

import MyEventBus.Annotation.Subscribe;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

public class EventBusUsingReflection {
//
//    private final ConcurrentHashMap<Object, List<Function<EventBus.Event, CompletionStage<Void>>>> listenerMethods;
//
//    public EventBus() {
//        this.listenerMethods = new ConcurrentHashMap<>();
//    }
//
//    public <T extends EventBus.Event> void dispatch(T event) throws InvocationTargetException, IllegalAccessException {
//        List<ListenerMethodDetails> methods = listenerMethods.get(event);
//        for (ListenerMethodDetails listenerMethodDetails : methods) {
//            listenerMethodDetails.method.invoke(listenerMethodDetails.classObject, event);
//        }
//    }
//
//    public void register(Function<EventBus.Event, CompletionStage<Void>> f) {
//        listenerMethods.get(EventBus.Event.class).add(f)
//    }
//
//    public CompletableFuture<v> post(EventBus.Event e) {
//        listenerMethods.get(e.getClass()).forEach(f -> f.apply(e));
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
//                //TODO: validate number of parameters
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
//    public class ListenerMethodDetails{
//        final Method method;
//        final Object classObject;
//
//        public ListenerMethodDetails(Method method, Object classObject) {
//            this.method = method;
//            this.classObject = classObject;
//        }
//
//        public Method getMethod() {
//            return method.invoke();
//        }
//
//        public Object getClassObject() {
//            return classObject;
//        }
//    }
}
