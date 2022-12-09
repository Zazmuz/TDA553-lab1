package main.events;


public abstract class Event {

    public final EventType type;

    public Event(EventType type) {
        this.type = type;
    }

}
