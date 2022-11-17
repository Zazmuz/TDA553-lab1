import java.awt.*;

public class Volvo240 extends Car{

    protected double trimFactor;
    
    public Volvo240(double trimFactor){
        super(4, Color.black, 100, "Volvo240");
        this.trimFactor = trimFactor;
    }

    protected double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }

    protected void incrementSpeed(double amount){
	    currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    protected void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }
}
