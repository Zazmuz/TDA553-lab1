package test.CarModels;

import org.junit.Test;


import src.VehicleModels.CarTransport;
import src.VehicleModels.Saab95;

import static org.junit.Assert.*;

public class CarTransportTest {

    @Test
    public void test_cartransport_load_unload() {
        try {
            CarTransport transport = new CarTransport(1);
            transport.openRamp();
            Saab95 saab = new Saab95();
            transport.addToStorage(saab);

            transport.closeRamp();
            transport.gas(0.1);
            transport.brake(1);
            transport.brake(1);
            transport.brake(1);
            transport.openRamp();

            transport.removeFromStorage();

        } catch (IllegalStateException expectedException)
        {
            fail("Should not throw error during normal use");
        }
    }

    @Test
    public void test_cartransport_full_capacity() {
        try {
            CarTransport transport = new CarTransport(1);
            transport.addToStorage(new Saab95());
            transport.addToStorage(new Saab95());

            fail("Should throw exception - Can't load cars when max capacity is reached!");
        } catch (IllegalStateException expectedException) { }
    }

    @Test
    public void test_cartransport_load_car_when_in_motion() {
        try {
            CarTransport transport = new CarTransport(1);
            transport.gas(1);
            transport.move();
            transport.addToStorage(new Saab95());

            fail("Should throw exception - Car transport should be stationary when loading cars!");
        } catch (IllegalStateException expectedException) { }
    }

    @Test
    public void test_cartransport_load_close_enough() {
        try {
            CarTransport transport = new CarTransport(1);
            transport.openRamp();

            Saab95 v = new Saab95();
            v.startEngine();
            for (int i = 0; i < 1000; i++) v.gas(1);
            for (int i = 0; i < 10000; i++) v.move();
            for (int i = 0; i < 2000; i++) v.brake(1);

            transport.addToStorage(v);

            fail("Should throw exception - Car is too far away to load");
        } catch (IllegalStateException expectedException) { }
    }

    @Test
    public void test_cartransport_load_close_enough_transport() {
        try {
            CarTransport transport = new CarTransport(1);
            transport.startEngine();
            for (int i = 0; i < 1000; i++) transport.gas(1);
            for (int i = 0; i < 10000; i++) transport.move();
            for (int i = 0; i < 10000; i++) transport.brake(1);
            transport.openRamp();

            Saab95 v = new Saab95();
            v.startEngine();


            transport.addToStorage(v);

            fail("Should throw exception - Car is too far away to load");
        } catch (IllegalStateException expectedException) { }
    }

    @Test
    public void test_cartransport_no_cars() {
        try {
            CarTransport transport = new CarTransport(6);
            transport.removeFromStorage();

            fail("Should throw exception - Can't remove cars when there are none stored!");
        } catch (IllegalStateException expectedException) { }
    }

    @Test
    public void test_cartransport_ramp_closed_try_remove() {
        try {
            CarTransport transport = new CarTransport(6);
            transport.closeRamp();
            transport.removeFromStorage();

            fail("Should throw exception - Can't remove cars when ramp is closed!");
        } catch (IllegalStateException expectedException) { }
    }

    @Test
    public void test_car_transport_moving_try_remove() {
        try {
            CarTransport transport = new CarTransport(6);
            transport.gas(1);
            transport.removeFromStorage();

            fail("Should throw exception - Can't remove cars when truck is moving!");
        } catch (IllegalStateException expectedException) { }
    }

    @Test
    public void test_cartransport_eject_reasonable_distance() {
        CarTransport transport = new CarTransport(6);
        transport.openRamp();

        Saab95 v = new Saab95();
        transport.addToStorage(v);

        assertTrue(transport.removeFromStorage().getPosition().distanceTo(transport.getPosition()) <= transport.getLoadDistance());
    }

    @Test
    public void test_loading_with_closed_ramp() {
        try {
            CarTransport transport = new CarTransport(6);
            transport.closeRamp();
            transport.addToStorage(new Saab95());

            fail("Should throw exception - Can't load cars when ramp is closed!");
        } catch (IllegalStateException expectedException) { }
    }

    @Test
    public void test_load_moving_car() {
        try {
            CarTransport transport = new CarTransport(6);
            transport.openRamp();
            Saab95 car = new Saab95();
            car.startEngine();
            car.gas(1);
            car.move();
            transport.addToStorage(car);

            fail("Should throw exception - Can't load moving cars!!");
        } catch (IllegalArgumentException expectedException){ }
    }

}
