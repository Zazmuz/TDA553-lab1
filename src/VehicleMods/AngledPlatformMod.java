package src.VehicleMods;


public class AngledPlatformMod {

    private double currentAngle;
    private final double maxAngle;

    public AngledPlatformMod(double maxAngle) {
        this.maxAngle = maxAngle;
    }

    public boolean isElevated() { return currentAngle > 0; }

    public boolean isRaised() { return currentAngle == maxAngle; }

    public boolean isLowered() { return currentAngle == 0; }

    public double getAngle() { return currentAngle; }

    public void setAngle(double angle) {
        angle = Math.min(angle, maxAngle);
        angle = Math.max(angle, 0);
        currentAngle = angle;
    }

    public double getMaxAngle() { return maxAngle; }

}


