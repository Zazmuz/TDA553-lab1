package main.events;

import java.util.ArrayList;


public class EventManager {

    private final ArrayList<EventListener> handlers = new ArrayList<>();


    public void register(EventListener e) {
        this.handlers.add(e);
    }

    public void unregister(EventListener e) {
        this.handlers.remove(e);
    }

    public void publish(Event e) {
        for (EventListener eventListener : this.handlers) {
            eventListener.onEvent(e);
        }
    }

}
