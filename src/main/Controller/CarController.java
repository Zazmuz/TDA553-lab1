package main.Controller;

import main.events.Event;
import main.events.SpinnerChangedEvent;

public class CarController extends Controller {

    private int gasSpinnerValue = 0;
    public CarController() {
        super();
    }

    public void setGasSpinnerValue(int value) { this.gasSpinnerValue = value; }
    public int getGasSpinnerValue() { return this.gasSpinnerValue; }

    @Override
    protected void onGasPress(Event e) { this.world.gas(gasSpinnerValue); }

    @Override
    protected void onBrakePress(Event e) { this.world.brake(gasSpinnerValue); }

    @Override
    protected void onStartCarsPress(Event e) { this.world.setAllEngines(true); }

    @Override
    protected void onStopCarsPress(Event e) { this.world.setAllEngines(false); }

    @Override
    protected void onTurboOnCarsPress(Event e) { this.world.setTurbo(true); }

    @Override
    protected void onTurboOffPress(Event e) { this.world.setTurbo(false); }

    @Override
    protected void onRaiseLiftBedPress(Event e) { this.world.moveBed(true); }

    @Override
    protected void onLowerLiftBedPress(Event e) { this.world.moveBed(false); }

    @Override
    protected void onGasSpinnerChanged(Event e) { setGasSpinnerValue(((SpinnerChangedEvent)e).getValue()); }
}
