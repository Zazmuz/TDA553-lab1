package main.events;

public class ButtonPressEvent extends Event {

    public int value = 0;
    public ButtonPressEvent(EventType type, int value) {
        super(type);
        this.value = value;
    }
    public ButtonPressEvent(EventType type) {
        this(type, 0);
    }
}
