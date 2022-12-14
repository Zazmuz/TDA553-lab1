package main.events;

import java.util.ArrayList;


public class EventManager {

    private final ArrayList<EventListener> handlers = new ArrayList<>();

    
    public void register(EventListener eventListener) {
        this.handlers.add(eventListener);
    }

    public void unregister(EventListener eventListener) {
        this.handlers.remove(eventListener);
    }

    public void publish(Event e) {
        for (EventListener eventListener : this.handlers) {
            eventListener.onEvent(e);
        }
    }

}
