import java.awt.*;

public class Volvo240 extends Car {

    protected double trimFactor;
    
    public Volvo240(double trimFactor) {
        super("Volvo240", Color.black, 100, 4);
        if (trimFactor < 0) this.trimFactor = 0;
        else this.trimFactor = trimFactor;
    }

    protected double speedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }

    protected void incrementSpeed(double amount) {
	    currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower());
    }

    protected void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }
}
