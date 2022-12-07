package src.VehicleMods;


public class TrimMod {

    private double trimFactor;

    public TrimMod(double trimFactor) {
        this.setTrimFactor(trimFactor);
    }

    public double getTrimFactor() { return this.trimFactor; }

    public void setTrimFactor(double value) { this.trimFactor = Math.max(value, 0); }

}
