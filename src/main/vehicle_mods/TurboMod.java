package main.vehicle_mods;


public class TurboMod {

    private boolean turboOn;
    private double turbo;

    public TurboMod(double turbo) {
        this.setTurbo(turbo);
    }

    public boolean getTurboOn() { return this.turboOn; }

    public void setTurboOn(){
        this.turboOn = true;
    }

    public void setTurboOff(){
        this.turboOn = false;
    }

    public double getTurbo() {
        return this.getTurboOn() ? this.turbo : 1;
    }

    private void setTurbo(double value) {
        this.turbo = Math.max(value, 0);
    }

}
