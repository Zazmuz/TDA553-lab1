package main.events;

public class SpinnerChangedEvent extends Event {

    private int value;
    public SpinnerChangedEvent(EventType type, int value) {
        super(type);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
