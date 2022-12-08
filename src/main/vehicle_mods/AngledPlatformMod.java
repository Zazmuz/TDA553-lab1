package main.vehicle_mods;


public class AngledPlatformMod {

    private double currentAngle;
    private final double maxAngle;

    public AngledPlatformMod(double maxAngle) {
        this.maxAngle = maxAngle;
    }

    public boolean isElevated() { return this.currentAngle > 0; }

    public boolean isRaised() { return this.currentAngle == this.maxAngle; }

    public boolean isLowered() { return this.currentAngle == 0; }

    public double getAngle() { return this.currentAngle; }

    public void setAngle(double angle) {
        angle = Math.min(angle, this.maxAngle);
        angle = Math.max(angle, 0);
        this.currentAngle = angle;
    }

    public double getMaxAngle() { return this.maxAngle; }

}


