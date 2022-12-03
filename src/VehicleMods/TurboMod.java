package src.VehicleMods;


public class TurboMod {

    private boolean turboOn;
    private double turbo;

    public TurboMod(double turbo) {
        setTurbo(turbo);
    }

    public boolean getTurboOn() { return turboOn; }

    public void setTurboOn(){
        turboOn = true;
    }

    public void setTurboOff(){
        turboOn = false;
    }

    public double getTurbo() {
        return getTurboOn() ? turbo : 1;
    }

    private void setTurbo(double value) {
        this.turbo = Math.max(value, 0);
    }

}
