package test;

import org.junit.Test;

import src.CarRepairShop;
import src.Vector2D;
import src.VehicleModels.Saab95;

import static org.junit.Assert.*;

public class CarRepairShopTest {

    @Test
    public void test_repairshop_load_unload() {
        try {
            CarRepairShop repairShop = new CarRepairShop("Biltema", new Vector2D(0,0), 1);

            Saab95 saab = new Saab95();
            repairShop.addToStorage(saab);
            repairShop.removeFromStorage(saab);

        } catch (IllegalStateException expectedException)
        {
            fail("Should not throw exeption - Standard usage!");
        }
    }

    @Test
    public void test_repairshop_full_capacity() {
        try {
            CarRepairShop repairShop = new CarRepairShop("Biltema", new Vector2D(0,0), 1);
            repairShop.addToStorage(new Saab95());
            repairShop.addToStorage(new Saab95());

            fail("Should throw exception - Can't load cars when max capacity is reached!");
        } catch (IllegalStateException expectedException) { }
    }

    @Test
    public void test_repairshop_load_close_enough() {
        try {
            CarRepairShop repairShop = new CarRepairShop("Biltema", new Vector2D(0,0), 1);

            Saab95 v = new Saab95();

            for (int i = 0; i < 1000; i++) v.gas(1);
            for (int i = 0; i < 10000; i++) v.move();

            repairShop.addToStorage(v);

            fail("Should throw exception - Car is too far away to load!");
        } catch (IllegalStateException expectedException) { }
    }

    @Test
    public void test_repairshop_not_in() {
        try {
            CarRepairShop repairShop = new CarRepairShop("Biltema", new Vector2D(0,0), 1);
            Saab95 saab = new Saab95();
            repairShop.removeFromStorage(saab);

            fail("Should throw exception - Can't remove a car that isn't stored!");
        } catch (IllegalStateException expectedException) { }
    }

    @Test
    public void test_repairshop_eject_reasonable_distance() {
        CarRepairShop repairShop = new CarRepairShop("Biltema", new Vector2D(0,0), 1);

        Saab95 v = new Saab95();
        repairShop.addToStorage(v);

        assertTrue(repairShop.removeFromStorage(v).getPosition().distanceTo(repairShop.getPosition()) <= repairShop.loadDistance);
    }

}
