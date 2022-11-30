package test.Car;

import org.junit.Test;
import src.CarModels.Saab95;
import src.CarModels.Volvo240;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertThrows;


public class CarTest {

    @Test
    public void test_saab95_gas() {
        Saab95 saab1 = new Saab95();
        saab1.gas(0.01);
        saab1.gas(0.01);
        saab1.move(saab1.getCurrentSpeed());

        Saab95 saab2 = new Saab95();
        saab2.gas(0.01);
        saab2.move(saab2.getCurrentSpeed());
        assertTrue(saab1.getXCoordinate() >= saab2.getXCoordinate());
    }

    @Test
    public void test_saab95_turbo() {
        Saab95 saab1 = new Saab95();
        saab1.setTurboOn();
        saab1.gas(0.01);
        saab1.move(saab1.getCurrentSpeed());

        Saab95 saab2 = new Saab95();
        saab2.gas(0.01);
        saab2.move(saab2.getCurrentSpeed());
        assertTrue(saab1.getXCoordinate() >= saab2.getXCoordinate());
    }

    @Test
    public void test_saab95_turn_left() {
        Saab95 saab1 = new Saab95();
        saab1.turnLeft(90);
        saab1.gas(0.01);
        saab1.move(saab1.getCurrentSpeed());

        assertEquals(0, saab1.getXCoordinate(), 0.00001);
        assertTrue(saab1.getYCoordinate() > 0);
    }

    @Test
    public void test_saab95_turn_right() {
        Saab95 saab1 = new Saab95();
        saab1.turnRight(90);
        saab1.gas(0.01);
        saab1.move(saab1.getCurrentSpeed());

        assertEquals(0, saab1.getXCoordinate(), 0.00001);
        assertTrue(saab1.getYCoordinate() < 0);
    }

    @Test
    public void test_saab95_forward() {
        Saab95 saab1 = new Saab95();
        saab1.gas(0.01);
        saab1.move(saab1.getCurrentSpeed());

        assertEquals(0, saab1.getYCoordinate(), 0.0);
        assertTrue(saab1.getXCoordinate() > 0);
    }

    @Test
    public void test_saab95_turn_full_circle() {
        Saab95 saab1 = new Saab95();
        saab1.turnLeft(360);
        saab1.gas(0.01);
        saab1.move(saab1.getCurrentSpeed());

        assertEquals(0.0, saab1.getYCoordinate(), 0.000001);
        assertTrue(saab1.getXCoordinate() > 0);
    }

    @Test
    public void test_volvo240_trimFactor() {
        Volvo240 volvo1 = new Volvo240(1.25);
        volvo1.gas(0.01);
        volvo1.move(volvo1.getCurrentSpeed());

        Volvo240 volvo2 = new Volvo240(1.4);
        volvo2.gas(0.01);
        volvo2.move(volvo2.getCurrentSpeed());
        assertTrue(volvo2.getXCoordinate() >= volvo1.getXCoordinate());
    }

    @Test
    public void test_negative_brake_car() {
        Volvo240 volvo = new Volvo240(1.25);
        volvo.brake(-1);
        volvo.move(volvo.getCurrentSpeed());

        assertEquals(0, volvo.getXCoordinate(), 0.0);
    }

    @Test
    public void test_negative_gas_car() {
        Volvo240 volvo = new Volvo240(1.25);
        volvo.gas(-1.0);
        volvo.move(volvo.getCurrentSpeed());

        assertEquals(0, volvo.getXCoordinate(), 0.0);
    }

    @Test
    public void test_too_much_gas_car() {
        Volvo240 volvo = new Volvo240(1.25);
        volvo.gas(1.1);

        assertEquals(0, volvo.getCurrentSpeed(), 0.0);
    }


    @Test
    public void test_too_much_brake_car() {
        Volvo240 volvo = new Volvo240(1.25);
        volvo.brake(1.1);

        assertEquals(0, volvo.getCurrentSpeed(), 0.0);
    }

    @Test
    public void test_volvo_valid_speed() {
        Volvo240 volvo1 = new Volvo240(100);
        for (int i = 0; i < 100; i++) volvo1.gas(1);

        assertTrue(volvo1.getCurrentSpeed() <= volvo1.getEnginePower());
    }

    @Test
    public void test_saab_valid_speed() {
        Saab95 saab = new Saab95();
        for (int i = 0; i < 1000; i++) saab.gas(1);

        assertTrue(saab.getCurrentSpeed() <= saab.getEnginePower());
    }

}
