package src.Car;

import java.awt.*;

import src.Movable;


abstract public class Car implements Movable {

    private double xCoordinate = 0; // The x coordinate of the car
    private double yCoordinate = 0; // The y coordinate of the car
    private double direction = 0; // The angle of the car

    private final String modelName; // The car model name
    private Color color; // Color of the car
    private final int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car

    public Car(String modelName, Color color, int nrDoors, double enginePower) {
        this.modelName = modelName;
        this.color = color;
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        stopEngine();
    }

    @Override
    public void move(double currentSpeed) {
        xCoordinate += Math.cos(direction)*currentSpeed;
        yCoordinate += Math.sin(direction)*currentSpeed;
    }

    @Override
    public void turnLeft(double angle) {
        direction += Math.toRadians(angle);
        direction %= Math.PI;
    }

    @Override
    public void turnRight(double angle) {
        direction -= Math.toRadians(angle);
        direction %= Math.PI;
    }

    public double getXCoordinate() { return xCoordinate; }

    public double getYCoordinate() { return yCoordinate; }

    public String getModelName() { return modelName; }

    public Color getColor() { return color; }

    public void setColor(Color color) { this.color = color; }

    public int getNrDoors() { return nrDoors; }

    public double getEnginePower() { return enginePower; }

    protected void setEnginePower(double value) { enginePower = value; }

    public double getCurrentSpeed() { return currentSpeed; }

    protected void setCurrentSpeed(double speed) {
        currentSpeed = Math.min(speed, getEnginePower());
        currentSpeed = Math.max(currentSpeed, 0);
    }

    public void startEngine() { setCurrentSpeed(0.1); }

    public void stopEngine() { setCurrentSpeed(0); }

    abstract protected double getSpeedFactor();

    protected void incrementSpeed(double amount) {
        setCurrentSpeed(getCurrentSpeed() + getSpeedFactor() * amount);
    }

    protected void decrementSpeed(double amount) {
        setCurrentSpeed(getCurrentSpeed() - getSpeedFactor() * amount);
    }

    public void gas(double amount) {
        if (0 <= amount && amount <= 1) {
            incrementSpeed(amount);
        }
    }

    public void brake(double amount) {
        if (0 <= amount && amount <= 1) {
            decrementSpeed(amount);
        }
    }

}
