package test.CarModels;

import org.junit.Test;
import src.VehicleModels.Scania;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertThrows;


public class ScaniaTest {
    @Test
    public void test_not_drivable_while_lifted_platform() {
        Scania truck = new Scania();
        double xBefore = truck.getXCoordinate();
        double yBefore = truck.getYCoordinate();

        truck.getPlatformMod().setAngle(69);

        truck.gas(100);
        truck.move();

        assertTrue(truck.getXCoordinate() == xBefore && truck.getYCoordinate() == yBefore);
    }

    @Test
    public void test_platform_angle_not_changeable_when_driving() {
        Scania truck = new Scania();
        double angleBefore = truck.getPlatformMod().getAngle();

        truck.gas(100);
        truck.move();

        truck.getPlatformMod().setAngle(69);

        assertEquals(angleBefore, truck.getPlatformMod().getAngle(), 0.0);
    }

}
