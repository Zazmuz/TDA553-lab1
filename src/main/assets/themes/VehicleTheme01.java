package main.assets.themes;

import main.assets.ImagePathHandler;
import main.vehicle_models.Saab95;
import main.vehicle_models.Volvo240;


public class VehicleTheme01 implements ImagePathHandler {
    public static String getImagePath(Object vehicle) {
        if (vehicle instanceof Volvo240) return "/main/pics/Volvo240.jpg";
        if (vehicle instanceof Saab95) return "/main/pics/Saab95.jpg";

        throw new IllegalArgumentException("Object is not a vehicle!");
    }
}
