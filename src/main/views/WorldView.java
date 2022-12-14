package main.views;

import main.Controller.EventButton;
import main.Controller.EventSpinner;
import main.events.*;
import main.events.Event;
import main.world.World;
import org.w3c.dom.events.EventException;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching its controller in its state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of its components.
 **/

public class WorldView extends JFrame implements EventListener {

    private static final int windowWidth = 800;
    private static final int windowHeight = 800;
    private static final int guiHeight = 240;

    private final ObjectView drawPanel;
    private final JPanel controlPanel;

    private final JPanel gasPanel = new JPanel();
    private EventSpinner gasSpinner;
    private final JLabel gasLabel = new JLabel("Amount of gas");

    private final EventButton gasButton = new EventButton("Gas", EventType.gasButton);
    private final EventButton brakeButton = new EventButton("Brake", EventType.brakeButton);
    private final EventButton turboOnButton = new EventButton("Saab Turbo on", EventType.turboOnButton);
    private final EventButton turboOffButton = new EventButton("Saab Turbo off", EventType.turboOffButton);
    private final EventButton liftBedButton = new EventButton("Scania Lift Bed", EventType.raiseLiftBedButton);
    private final EventButton lowerBedButton = new EventButton("Lower Lift Bed", EventType.lowerLiftBedButton);
    private final EventButton startButton = new EventButton("Start all cars", EventType.startCarsButton);
    private final EventButton stopButton = new EventButton("Stop all cars", EventType.stopCarsButton);

    public WorldView(String frameName, World world) {
        world.getEventManager().register(this);
        this.drawPanel = new ObjectView(windowWidth, windowHeight - guiHeight);
        this.controlPanel = new JPanel();

        initComponents(frameName);
    }

    // Sets everything in place and fits everything
    private void initComponents(String title) {
        this.setTitle(title);
        this.setPreferredSize(new Dimension(windowWidth, windowHeight));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        this.add(drawPanel);

        addButtonStyles();

        // Make the frame pack all it's components by respecting the sizes if possible.
        this.pack();

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width/2 - this.getSize().width/2, dim.height/2 - this.getSize().height/2);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }



    public void addButtonStyles()
    {
        // Gas spinner
        SpinnerModel spinnerModel =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        100, //max
                        1);//step
        gasSpinner = new EventSpinner(spinnerModel, EventType.gasSpinnerChanged);

        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);
        this.add(gasPanel);

        controlPanel.setLayout(new GridLayout(2,4));

        controlPanel.add(gasButton, 0);
        controlPanel.add(turboOnButton, 1);
        controlPanel.add(liftBedButton, 2);
        controlPanel.add(brakeButton, 3);
        controlPanel.add(turboOffButton, 4);
        controlPanel.add(lowerBedButton, 5);
        controlPanel.add(startButton, 6);
        controlPanel.add(stopButton, 7);

        controlPanel.setPreferredSize(new Dimension((windowWidth/2)+4, 200));
        this.add(controlPanel);
        controlPanel.setBackground(Color.CYAN);

        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        startButton.setPreferredSize(new Dimension(windowWidth/5-15,200));
        this.add(startButton);

        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension(windowWidth/5-15,200));
        this.add(stopButton);

    }

    public void draw(World world) {
        drawPanel.drawVehicles(world.vehicles);
    }

    public void onEvent(Event e) {
        if (e.type == EventType.worldUpdate) {
            World world = ((WorldUpdateEvent)e).worldState;
            draw(world);
        }
    }

}