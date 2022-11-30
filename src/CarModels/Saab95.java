package src.CarModels;

import java.awt.*;

import src.Car.Car;
import src.Car.TurboCar;


public class Saab95 extends TurboCar {

    public Saab95(){
        super("Saab95", Color.red, 2, 125, 5);
        this.setTurboOn();
    }

    @Override
    protected double getSpeedFactor(){
        double turbo = getTurboOn() ? 1.3 : 1;
        return getEnginePower() * 0.01 * turbo;
    }

}
