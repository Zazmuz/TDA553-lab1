package test.CarModels;

import org.junit.Test;
import src.CarModels.Volvo240;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertThrows;


public class Volvo240Test {

    @Test
    public void test_volvo240_trimFactor() {
        Volvo240 volvo1 = new Volvo240(1.25);
        volvo1.gas(0.01);
        volvo1.move();

        Volvo240 volvo2 = new Volvo240(1.4);
        volvo2.gas(0.01);
        volvo2.move();
        assertTrue(volvo2.getXCoordinate() >= volvo1.getXCoordinate());
    }

    @Test
    public void test_volvo240_valid_speed() {
        Volvo240 volvo1 = new Volvo240(100);
        for (int i = 0; i < 100; i++) volvo1.gas(1);

        assertTrue(volvo1.getCurrentSpeed() <= volvo1.getEnginePower());
    }
}
