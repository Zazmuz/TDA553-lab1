package test.CarModels;

import org.junit.Test;
import src.VehicleModels.Scania;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertThrows;


public class ScaniaTest {

    @Test
    public void test_moveable_with_started_engine() {
        Scania truck = new Scania();
        double xBefore = truck.getXCoordinate();
        double yBefore = truck.getYCoordinate();

        truck.movePlatform(69);

        truck.startEngine();
        truck.gas(100);
        truck.move();

        assertTrue(truck.getXCoordinate() == xBefore && truck.getYCoordinate() == yBefore);
    }

    @Test
    public void test_not_drivable_while_lifted_platform() {
        Scania truck = new Scania();
        double xBefore = truck.getXCoordinate();
        double yBefore = truck.getYCoordinate();

        truck.movePlatform(69);

        truck.gas(100);
        truck.move();

        assertTrue(truck.getXCoordinate() == xBefore && truck.getYCoordinate() == yBefore);
    }

    @Test
    public void test_platform_angle_not_changeable_when_driving() {
        Scania truck = new Scania();
        double angleBefore = truck.getPlatformAngle();
        truck.startEngine();
        truck.gas(100);
        truck.move();

        truck.movePlatform(69);
        assertEquals(angleBefore, truck.getPlatformAngle(), 0.0);
    }

}
