package src.VehicleMods;


public abstract class AngledPlatformMod {

    private double currentAngle;
    private final double maxAngle;

    public AngledPlatformMod(double maxAngle) {
        this.maxAngle = maxAngle;
    }

    protected abstract boolean canBeMoved();

    public boolean isElevated() { return currentAngle > 0; }

    public boolean isRaised() { return currentAngle == maxAngle; }

    public boolean isLowered() { return currentAngle == 0; }

    public double getAngle() { return currentAngle; }

    public double getMaxAngle() { return maxAngle; }

    public void setAngle(double angle) {
        if (canBeMoved()) {
            angle = Math.min(angle, maxAngle);
            angle = Math.max(angle, 0);
            currentAngle = angle;
        }
    }

}


