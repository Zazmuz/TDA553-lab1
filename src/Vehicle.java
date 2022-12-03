package src;

import java.awt.*;


public abstract class Vehicle implements Movable {

    private double xCoordinate = 0; // The x coordinate of the vehicle
    private double yCoordinate = 0; // The y coordinate of the vehicle
    private double direction = 0; // The angle of the vehicle

    private final String modelName; // The car model name
    private Color color; // Color of the vehicle
    private final int nrDoors; // Number of doors on the vehicle
    private double enginePower; // Engine power of the vehicle
    private double currentSpeed; // The current speed of the vehicle
    private final double turningRate; // How much the car turns in degrees

    public Vehicle(String modelName, Color color, int nrDoors, double enginePower, double turningRate) {
        this.modelName = modelName;
        this.color = color;
        this.nrDoors = nrDoors;
        setEnginePower(enginePower);
        this.turningRate = turningRate;
        stopEngine();
    }

    @Override
    public void move() {
        xCoordinate += Math.cos(direction) * getCurrentSpeed();
        yCoordinate += Math.sin(direction) * getCurrentSpeed();
    }

    @Override
    public void turnLeft() {
        direction += Math.toRadians(turningRate);
        direction %= 2 * Math.PI;
    }

    @Override
    public void turnRight() {
        direction -= Math.toRadians(turningRate);
        direction %= 2 * Math.PI;
    }

    public double getXCoordinate() { return xCoordinate; }

    public double getYCoordinate() { return yCoordinate; }

    public double getDirection() { return direction; }

    public String getModelName() { return modelName; }

    public Color getColor() { return color; }

    public void setColor(Color color) { this.color = color; }

    public int getNrDoors() { return nrDoors; }

    public double getEnginePower() { return enginePower; }

    protected void setEnginePower(double value) { enginePower = Math.max(value, 0); }

    public double getCurrentSpeed() { return currentSpeed; }

    protected void setCurrentSpeed(double speed) {
        currentSpeed = Math.min(speed, getEnginePower());
        currentSpeed = Math.max(currentSpeed, 0);
    }

    abstract protected double getSpeedFactor();

    public double getTurningRate() { return turningRate; }

    public void startEngine() { setCurrentSpeed(0.1); }

    public void stopEngine() { setCurrentSpeed(0); }

    protected void incrementSpeed(double amount) {
        setCurrentSpeed(getCurrentSpeed() + getSpeedFactor() * amount);
    }

    protected void decrementSpeed(double amount) {
        setCurrentSpeed(getCurrentSpeed() - getSpeedFactor() * amount);
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
