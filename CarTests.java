import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertThrows;


public class CarTests {

    @Test
    public void test_saab95_gas() {
        Saab95 saab1 = new Saab95();
        saab1.gas(0.01);
        saab1.gas(0.01);
        saab1.move(saab1.currentSpeed);

        Saab95 saab2 = new Saab95();
        saab2.gas(0.01);
        saab2.move(saab2.currentSpeed);
        assertTrue(saab1.xCoordinate >= saab2.xCoordinate);
    }

    @Test
    public void test_saab95_turbo() {
        Saab95 saab1 = new Saab95();
        saab1.setTurboOn();
        saab1.gas(0.01);
        saab1.move(saab1.currentSpeed);

        Saab95 saab2 = new Saab95();
        saab2.gas(0.01);
        saab2.move(saab2.currentSpeed);
        assertTrue(saab1.xCoordinate >= saab2.xCoordinate);
    }

    @Test
    public void test_saab95_turn() {
        Saab95 saab1 = new Saab95();
        saab1.turnLeft(90);
        saab1.gas(0.01);
        saab1.move(saab1.currentSpeed);

        assertEquals(0, saab1.xCoordinate, 0.00001);
        assertTrue(saab1.yCoordinate > 0);
    }

    @Test
    public void test_saab95_forward() {
        Saab95 saab1 = new Saab95();
        saab1.gas(0.01);
        saab1.move(saab1.currentSpeed);

        assertEquals(0, saab1.yCoordinate, 0.0);
        assertTrue(saab1.xCoordinate > 0);
    }

    @Test
    public void test_saab95_turn_full_circle() {
        Saab95 saab1 = new Saab95();
        saab1.turnLeft(360);
        saab1.gas(0.01);
        saab1.move(saab1.currentSpeed);

        assertEquals(0.0, saab1.yCoordinate, 0.000001);
        assertTrue(saab1.xCoordinate > 0);
    }

    @Test
    public void test_volvo240_trimFactor() {
        Volvo240 volvo1 = new Volvo240(1.25);
        volvo1.gas(0.01);
        volvo1.move(volvo1.currentSpeed);

        Volvo240 volvo2 = new Volvo240(1.4);
        volvo2.gas(0.01);
        volvo2.move(volvo2.currentSpeed);
        assertTrue(volvo2.xCoordinate >= volvo1.xCoordinate);
    }

    @Test
    public void test_negative_brake_car() {
        Volvo240 volvo = new Volvo240(1.25);
        volvo.brake(-1);
        volvo.move(volvo.currentSpeed);

        assertEquals(0, volvo.xCoordinate, 0.0);
    }

    @Test
    public void test_negative_gas_car() {
        Volvo240 volvo = new Volvo240(1.25);
        volvo.gas(-1.0);
        volvo.move(volvo.currentSpeed);

        assertEquals(0, volvo.xCoordinate, 0.0);
    }

    @Test
    public void test_too_much_gas_car() {
        Volvo240 volvo = new Volvo240(1.25);
        volvo.gas(1.1);

        assertEquals(0, volvo.currentSpeed, 0.0);
    }


    @Test
    public void test_too_much_brake_car() {
        Volvo240 volvo = new Volvo240(1.25);
        volvo.brake(1.1);

        assertEquals(0, volvo.currentSpeed, 0.0);
    }

    @Test
    public void test_volvo_valid_speed() {
        Volvo240 volvo1 = new Volvo240(100);
        for (int i = 0; i < 100; i++) volvo1.gas(1);

        assertTrue(volvo1.currentSpeed <= volvo1.enginePower);
    }

    @Test
    public void test_saab_valid_speed() {
        Saab95 saab = new Saab95();
        for (int i = 0; i < 1000; i++) saab.gas(1);

        assertTrue(saab.currentSpeed <= saab.enginePower);
    }
}
