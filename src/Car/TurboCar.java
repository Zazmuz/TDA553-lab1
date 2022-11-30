package src.Car;

import java.awt.*;

public abstract class TurboCar extends Car {

    private boolean turboOn;

    public TurboCar(String modelName, Color color, int nrDoors, double enginePower, double turningRate) {
        super(modelName, color, nrDoors, enginePower, turningRate);
    }

    public void setTurboOn(){
        turboOn = true;
    }

    public void setTurboOff(){
        turboOn = false;
    }

    public boolean getTurboOn() { return turboOn; }

}
