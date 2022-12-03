package src.VehicleMods;


public class TrimMod {

    private double trimFactor;

    public TrimMod(double trimFactor) {
        setTrimFactor(trimFactor);
    }

    public double getTrimFactor() { return trimFactor; }

    public void setTrimFactor(double value) { trimFactor = Math.max(value, 0); }

}
