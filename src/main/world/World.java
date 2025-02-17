package main.world;

import main.events.EventManager;
import main.events.WorldUpdateEvent;
import main.vehicle_mods.TurboMod;
import main.vehicles.Vehicle;
import main.vehicles.cars.TurboCar;
import main.vehicles.trucks.TruckWithAngledPlatform;

import java.util.ArrayList;
import java.util.List;


public class World {

    private EventManager eventManager;
    public List<Vehicle> vehicles;

    public World() {
        this.eventManager = new EventManager();
        this.vehicles = new ArrayList<>();
    }

    public EventManager getEventManager() { return this.eventManager; }

    public List<Vehicle> getVehicles() { return vehicles; }

    private void setVehicles(ArrayList<Vehicle> vehicles) { this.vehicles = vehicles; }

    public void spawnVehicle(Vehicle vehicle) {
        this.vehicles.add(vehicle);
    }

    public void update() {
        for (Vehicle vehicle : this.vehicles) {
            vehicle.move();
        }

        eventManager.publish(new WorldUpdateEvent(this));
    }

    // Calls the gas method for each car once
    public void gas(int amount) {
        double gas = ((double) amount) / 100;

        for (Vehicle vehicle : this.vehicles) {
            vehicle.gas(gas);
        }
    }

    // Calls the brake method for each car once
    public void brake(int amount) {
        double brake_amount = ((double) amount) / 100;

        for (Vehicle vehicle : this.vehicles) {
            vehicle.brake(brake_amount);
        }
    }

    // Sets the engine on each car
    public void setAllEngines(boolean on) {
        for (Vehicle vehicle : this.vehicles) {
            vehicle.setMotorOn(on);
        }
    }


    // Sets the turbo on all turbo-cars
    public void setTurbo(boolean on) {
        for (Vehicle vehicle : this.vehicles) {
            if (vehicle instanceof TurboCar) {
                TurboCar car = (TurboCar) vehicle;
                TurboMod carTurboMod = car.getTurboMod();

                if (on) {
                    carTurboMod.setTurboOn();
                }
                else {
                    carTurboMod.setTurboOff();
                }
            }
        }
    }

    // Moves the platform on all vehicles with angled platform, one degree
    public  void moveBed(boolean up) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof TruckWithAngledPlatform) {
                TruckWithAngledPlatform truck = (TruckWithAngledPlatform)vehicle;
                double amount = up ? 1 : -1;
                truck.movePlatform(truck.getPlatformAngle() + amount);
            }
        }
    }

}
