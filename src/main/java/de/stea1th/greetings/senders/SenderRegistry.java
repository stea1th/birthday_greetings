package de.stea1th.greetings.senders;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class SenderRegistry {

    private Set<Class<?>> registry;

    public SenderRegistry() {
        initRegistry();
    }

    private void initRegistry() {
        Reflections reflections = new Reflections("de.stea1th.greetings", new TypeAnnotationsScanner(), new SubTypesScanner());

        registry = reflections.getTypesAnnotatedWith(Sender.class);
    }

    public List<MessageSender> getMessageSenders() {
        return registry
                .stream()
                .map(s -> {
                    try {
                        return (MessageSender) s.getConstructor().newInstance();
                    } catch (InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    throw new IllegalArgumentException("Not possible to create an instance");
                }).collect(Collectors.toList());
    }
}
