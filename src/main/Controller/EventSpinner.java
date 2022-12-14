package main.Controller;

import main.events.ButtonPressEvent;
import main.events.EventType;
import main.events.GuiEventManager;
import main.events.SpinnerChangedEvent;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.DefaultFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventSpinner extends JSpinner {

    private final EventType eventType;


    public EventSpinner(SpinnerModel model, EventType type) {
        super(model);
        this.eventType = type;

        // Enable sending events on changed value
        // https://stackoverflow.com/questions/3949382/jspinner-value-change-events
        JComponent component = this.getEditor();
        JFormattedTextField textField = (JFormattedTextField) component.getComponent(0);
        DefaultFormatter formatter = (DefaultFormatter) textField.getFormatter();
        formatter.setCommitsOnValidEdit(true);

        this.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                GuiEventManager.getInstance().publish(new SpinnerChangedEvent(EventSpinner.this.eventType, (int)EventSpinner.this.getValue()));
            }
        });
    }

    public EventType getEventType() { return this.eventType; }

}
