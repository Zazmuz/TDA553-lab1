package src.CarModels;

import java.awt.*;

import src.Car.Car;


public class Saab95 extends Car {

    private boolean turboOn;
    
    public Saab95(){
        super("src.CarModels.Saab95", Color.red, 125, 2);
        this.turboOn = false;
    }

    public void setTurboOn(){
	    turboOn = true;
    }

    public void setTurboOff(){
	    turboOn = false;
    }

    protected double speedFactor(){
        double turbo = turboOn ? 1.3 : 1;
        return enginePower * 0.01 * turbo;
    }

    protected void incrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower());
    }

    protected void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }
}
