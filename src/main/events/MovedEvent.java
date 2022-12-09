package main.events;

import main.math.Vector2D;


public class MovedEvent extends Event {

    public final Vector2D position;

    public MovedEvent(Vector2D position) {
        super(EventType.onMove);
        this.position = position;
    }

}
