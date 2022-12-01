package src.Car;

import java.awt.*;

public abstract class TurboCar extends Car {

    private boolean turboOn;
    private double turbo;

    public TurboCar(String modelName, Color color, int nrDoors, double enginePower, double turningRate, double turbo) {
        super(modelName, color, nrDoors, enginePower, turningRate);
        setTurbo(turbo);
    }

    public void setTurboOn(){
        turboOn = true;
    }

    public void setTurboOff(){
        turboOn = false;
    }

    public boolean getTurboOn() { return turboOn; }

    private void setTurbo(double value) {
        this.turbo = Math.max(value, 0);
    }

    public double getTurbo() {
        return getTurboOn() ? turbo : 1;
    }
}
