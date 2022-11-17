
public class Movable {

    protected double xCoordinate; // The x coordinate of the car
    protected double yCoordinate;
    protected double direction;


    protected void move(double currentSpeed){
        xCoordinate += Math.cos(direction)*currentSpeed;
        yCoordinate += Math.sin(direction)*currentSpeed;
    }

    protected void turnLeft(double angle){
        direction += Math.toRadians(angle);
        direction %= Math.PI;
    }

    protected void turnRight(double angle){
        direction -= Math.toRadians(angle);
        direction %= Math.PI;
    }
}
