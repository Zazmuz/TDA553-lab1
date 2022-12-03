package test.CarModels;

import org.junit.Test;
import src.VehicleModels.Saab95;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertThrows;


public class Saab95Test {

    @Test
    public void test_saab95_turbo() {
        Saab95 saab1 = new Saab95();
        saab1.getTurboMod().setTurboOn();
        saab1.gas(0.01);
        saab1.move();

        Saab95 saab2 = new Saab95();
        saab2.gas(0.01);
        saab2.move();
        assertTrue(saab1.getXCoordinate() >= saab2.getXCoordinate());
    }
}
