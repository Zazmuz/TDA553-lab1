package main.views;

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

    public final EventManager eventManager;
    private static final int windowWidth = 800;
    private static final int windowHeight = 800;
    private static final int guiHeight = 240;

    ObjectView drawPanel;
    JPanel controlPanel;

    JPanel gasPanel = new JPanel();
    JSpinner gasSpinner = new JSpinner();
    int gasAmount = 0;
    JLabel gasLabel = new JLabel("Amount of gas");

    JButton gasButton = new JButton("Gas");
    JButton brakeButton = new JButton("Brake");
    JButton turboOnButton = new JButton("Saab Turbo on");
    JButton turboOffButton = new JButton("Saab Turbo off");
    JButton liftBedButton = new JButton("Scania Lift Bed");
    JButton lowerBedButton = new JButton("Lower Lift Bed");
    JButton startButton = new JButton("Start all cars");
    JButton stopButton = new JButton("Stop all cars");

    public WorldView(String frameName, World world) {
        world.eventManager.register(this);
        this.drawPanel = new ObjectView(windowWidth, windowHeight - guiHeight);
        this.controlPanel = new JPanel();
        this.eventManager = new EventManager();

        initComponents(frameName);
    }

    // Sets everything in place and fits everything
    private void initComponents(String title) {
        this.setTitle(title);
        this.setPreferredSize(new Dimension(windowWidth, windowHeight));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        this.add(drawPanel);

        addButtonStyles();
        addButtonLogic();

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
        gasSpinner = new JSpinner(spinnerModel);

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

    public void addButtonLogic() {

        // Gas spinner
        gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner)e.getSource()).getValue();
            }
        });

        // Most buttons
        Map<JButton, EventType> buttons = Map.of(turboOnButton, EventType.turboOnButton,
                turboOffButton, EventType.turboOffButton,
                liftBedButton, EventType.raiseLiftBedButton,
                lowerBedButton, EventType.lowerLiftBedButton,
                startButton, EventType.startCarsButton,
                stopButton, EventType.stopCarsButton);

        int i = 0;
        for (var item : buttons.entrySet()) {
            item.getKey().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // If the button is brake or gas, pass along the gas amount
                    int value = (item.getValue()==EventType.gasButton || item.getValue()==EventType.brakeButton) ?
                            gasAmount : 0;
                    WorldView.this.eventManager.publish(new ButtonPressEvent(item.getValue(), value));
                }
            });
            i++;
        }

        // Gas and brake
        gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WorldView.this.eventManager.publish(new ButtonPressEvent(EventType.gasButton, WorldView.this.gasAmount));
            }
        });

        brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WorldView.this.eventManager.publish(new ButtonPressEvent(EventType.brakeButton, WorldView.this.gasAmount));
            }
        });
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