import java.awt.*;


abstract public class Car implements Movable {

    protected double xCoordinate = 0; // The x coordinate of the car
    protected double yCoordinate = 0; // The y coordinate of the car
    protected double direction = 0; // The angle of the car

    protected String modelName; // The car model name
    protected Color color; // Color of the car
    protected double enginePower; // Engine power of the car
    protected int nrDoors; // Number of doors on the car
    protected double currentSpeed; // The current speed of the car

    public Car(String modelName, Color color, double enginePower, int nrDoors) {
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
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

    public int getNrDoors() { return nrDoors; }

    public double getEnginePower() { return enginePower; }

    public double getCurrentSpeed() { return currentSpeed; }

    public Color getColor() { return color; }

    public void setColor(Color clr) { color = clr; }

    public void startEngine() { currentSpeed = 0.1; }

    public void stopEngine() { currentSpeed = 0; }

    abstract protected void incrementSpeed(double amount);

    abstract protected void decrementSpeed(double amount);

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
