package main.events;

import main.world.World;

public class WorldUpdateEvent extends Event {

    public final World worldState;

    public WorldUpdateEvent(World world) {
        super(EventType.worldUpdate);
        this.worldState = world;
    }
}
