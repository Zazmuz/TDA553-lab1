package src.VehicleModels;

import src.Trucks.TruckWithAngledPlatform;

import java.awt.*;

public class CarTransport extends TruckWithAngledPlatform {


    public CarTransport(String modelName, Color color, int nrDoors, double enginePower, double turningRate, double maxAngle) {
        super(modelName, color, nrDoors, enginePower, turningRate, maxAngle);
        super("CarTransportomatic 2000", Color.BLACK, 2, 1.1, );
    }

    @Override
    protected double getSpeedFactor() {
        return 0;
    }
}
