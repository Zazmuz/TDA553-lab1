package main.Controller;

import main.events.ButtonPressEvent;
import main.events.EventType;
import main.events.GuiEventManager;
import main.events.Event;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class EventButton extends JButton {

    private final EventType eventType;

    public EventButton(String label, EventType type) {
        super(label);
        this.eventType = type;
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiEventManager.getInstance().publish(new ButtonPressEvent(EventButton.this.eventType));
            }
        });
    }

    public EventType getEventType() { return this.eventType; }
}
