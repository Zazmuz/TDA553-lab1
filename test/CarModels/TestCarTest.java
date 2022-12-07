package test.CarModels;

import org.junit.Test;
import src.VehicleModels.TestCar;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertThrows;


public class TestCarTest {

    @Test
    public void test_car_gas() {
        TestCar car1 = new TestCar();
        car1.gas(0.01);
        car1.gas(0.01);
        car1.move();

        TestCar car2 = new TestCar();
        car2.gas(0.01);
        car2.move();
        assertTrue(car1.getXCoordinate() >= car2.getXCoordinate());
    }



    @Test
    public void test_car_turn_left() {
        TestCar car = new TestCar();
        car.startEngine();
        car.turnLeft();
        car.gas(0.01);
        car.move();

        assertTrue(car.getYCoordinate() > 0);
    }

    @Test
    public void test_car_turn_right() {
        TestCar car = new TestCar();
        car.startEngine();
        car.turnRight();
        car.gas(0.01);
        car.move();

        assertTrue(car.getYCoordinate() < 0);
    }

    @Test
    public void test_car_forward() {
        TestCar car = new TestCar();
        car.startEngine();
        car.gas(0.01);
        car.move();

        assertEquals(0, car.getYCoordinate(), 0.0);
        assertTrue(car.getXCoordinate() > 0);
    }

    @Test
    public void test_car_turn_full_circle() {
        TestCar car = new TestCar();
        car.startEngine();
        for (int i = 0; i < 360/car.getTurningRate(); i++) car.turnLeft();
        car.gas(0.01);
        car.move();

        assertEquals(0.0, car.getYCoordinate(), 0.000001);
        assertTrue(car.getXCoordinate() > 0);
    }

    @Test
    public void test_negative_brake_car() {
        TestCar car = new TestCar(1.25);
        car.startEngine();
        car.brake(-1);
        car.move();

        assertEquals(0, car.getXCoordinate(), 0.0);
    }

    @Test
    public void test_negative_gas_car() {
        TestCar car = new TestCar();
        car.gas(-1.0);
        car.move();

        assertEquals(0, car.getXCoordinate(), 0.0);
    }

    @Test
    public void test_too_much_gas_car() {
        TestCar car = new TestCar(1.25);
        car.gas(1.1);
        car.move();

        TestCar car2 = new TestCar(1.25);
        car2.gas(1);
        car2.move();

        assertEquals(car2.getCurrentSpeed(), car.getCurrentSpeed(), 0.0);
    }


    @Test
    public void test_too_much_brake_car() {
        TestCar car = new TestCar(1.25);
        car.brake(1.1);

        assertEquals(0, car.getCurrentSpeed(), 0.0);
    }


    @Test
    public void test_car_valid_speed() {
        TestCar car = new TestCar();
        for (int i = 0; i < 1000; i++) car.gas(1);

        assertTrue(car.getCurrentSpeed() <= car.getEnginePower());
    }

}
