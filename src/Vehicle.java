package src;

import java.awt.*;


public abstract class Vehicle implements Movable {

    private final Vector2D position; // The position of the vehicle
    private double direction = 0; // The angle of the vehicle

    private final String modelName; // The car model name
    private Color color; // Color of the vehicle
    private final int nrDoors; // Number of doors on the vehicle
    private boolean motorOn; // If the engine is powered on or not
    private double enginePower; // Engine power of the vehicle
    private double currentSpeed; // The current speed of the vehicle
    private final double turningRate; // How much the car turns in degrees

    public Vehicle(String modelName, Color color, int nrDoors, double enginePower, double turningRate) {
        this.modelName = modelName;
        this.color = color;
        this.nrDoors = nrDoors;
        setEnginePower(enginePower);
        this.turningRate = turningRate;
        this.position = new Vector2D(0,0);
        stopEngine();
    }

    @Override
    public void move() {
        position.x += Math.cos(direction) * getCurrentSpeed();
        position.y += Math.sin(direction) * getCurrentSpeed();
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

    public double getXCoordinate() { return position.x; }

    public double getYCoordinate() { return position.y; }

    public Vector2D getPosition() { return position; }

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

    public boolean getMotorOn() { return motorOn; }

    public void setMotorOn(boolean state) { motorOn = state; }

    public void startEngine() { setMotorOn(true); }

    public void stopEngine() { setMotorOn(false); }

    protected void incrementSpeed(double amount) {
        if (getMotorOn()) setCurrentSpeed(getCurrentSpeed() + getSpeedFactor() * amount);
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
