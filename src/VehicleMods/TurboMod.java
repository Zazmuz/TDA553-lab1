package src.VehicleMods;


public class TurboMod {

    private boolean turboOn;
    private double turbo;

    public TurboMod(double turbo) {
        setTurbo(turbo);
    }

    public void setTurboOn(){
        turboOn = true;
    }

    public void setTurboOff(){
        turboOn = false;
    }

    public boolean getTurboOn() { return turboOn; }

    private void setTurbo(double value) {
        this.turbo = Math.max(value, 0);
    }

    public double getTurbo() {
        return getTurboOn() ? turbo : 1;
    }

}
