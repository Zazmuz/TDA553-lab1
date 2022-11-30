package src.CarModels;

import java.awt.*;

import src.Car.Car;


public class Saab95 extends Car {

    private boolean turboOn;
    
    public Saab95(){
        super("Saab95", Color.red, 2, 125);
        this.turboOn = false;
    }

    public void setTurboOn(){
	    turboOn = true;
    }

    public void setTurboOff(){
	    turboOn = false;
    }

    @Override
    protected double getSpeedFactor(){
        double turbo = turboOn ? 1.3 : 1;
        return getEnginePower() * 0.01 * turbo;
    }

}
