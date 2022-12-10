package main.vehicles;

import main.events.*;
import main.events.Event;
import main.math.Vector2D;

import java.awt.*;


public abstract class Vehicle implements Movable, EventListener {

    private final Vector2D position; // The position of the vehicle
    private double direction = 0; // The angle of the vehicle

    private final String modelName; // The car model name
    private Color color; // Color of the vehicle
    private final int nrDoors; // Number of doors on the vehicle
    private boolean motorOn; // If the engine is powered on or not
    private double enginePower; // Engine power of the vehicle
    private double currentSpeed; // The current speed of the vehicle
    private final double turningRate; // How much the car turns in degrees
    private boolean isParked = false;
    
    public EventManager eventManager;


    public Vehicle(String modelName, Color color, int nrDoors, double enginePower, double turningRate) {
        this.modelName = modelName;
        this.color = color;
        this.nrDoors = nrDoors;
        this.setEnginePower(enginePower);
        this.turningRate = turningRate;
        this.position = new Vector2D(0,0);
        this.eventManager = new EventManager();
        stopEngine();
    }

    @Override
    public void move() {
        if (canDrive()) {
            this.position.x += Math.cos(this.direction) * this.getCurrentSpeed();
            this.position.y += Math.sin(this.direction) * this.getCurrentSpeed();
            eventManager.publish(new MovedEvent(this.getPosition()));
        }
    }

    @Override
    public void turnLeft() {
        this.direction += Math.toRadians(this.turningRate);
        this.direction %= 2 * Math.PI;
    }

    @Override
    public void turnRight() {
        this.direction -= Math.toRadians(this.turningRate);
        this.direction %= 2 * Math.PI;
    }

    public void onEvent(Event e) {
        if (e.type == EventType.onMove) {
            this.position.set(((MovedEvent)e).position);
        }
    }

    public boolean canDrive() {
        return !isParked;
    }

    public double getXCoordinate() { return this.position.x; }

    public double getYCoordinate() { return this.position.y; }

    public Vector2D getPosition() { return this.position; }

    public double getDirection() { return this.direction; }

    public boolean getIsParked() {
        return isParked;
    }

    public void setIsParked(boolean value) {
        this.isParked = value;
    }

    public String getModelName() { return this.modelName; }

    public Color getColor() { return this.color; }

    public void setColor(Color color) { this.color = color; }

    public int getNrDoors() { return this.nrDoors; }

    public double getEnginePower() { return this.enginePower; }

    protected void setEnginePower(double value) { this.enginePower = Math.max(value, 0); }

    public double getCurrentSpeed() { return this.currentSpeed; }

    protected void setCurrentSpeed(double speed) {
        this.currentSpeed = Math.min(speed, this.getEnginePower());
        this.currentSpeed = Math.max(this.currentSpeed, 0);
    }

    abstract protected double getSpeedFactor();

    public double getTurningRate() { return this.turningRate; }

    public boolean getMotorOn() { return this.motorOn; }

    public void setMotorOn(boolean state) { this.motorOn = state; }

    public void startEngine() { this.setMotorOn(true); }

    public void stopEngine() { this.setMotorOn(false); }

    private void incrementSpeed(double amount) {
        if (getMotorOn()) setCurrentSpeed(this.getCurrentSpeed() + this.getSpeedFactor() * amount);
    }

    private void decrementSpeed(double amount) {
        setCurrentSpeed(this.getCurrentSpeed() - this.getSpeedFactor() * amount);
    }

    public void gas(double amount) {
        amount = Math.min(amount, 1);
        amount = Math.max(amount, 0);
        incrementSpeed(amount);
    }

    public void brake(double amount) {
        amount = Math.min(amount, 1);
        amount = Math.max(amount, 0);
        decrementSpeed(amount);
    }

}
