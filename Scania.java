import java.awt.*;

public class Scania extends Vehicle{

    protected double angleOfPlatform;
    public Scania() {
        super(2, 750, Color.red, "Scania");
        angleOfPlatform = 0;
    }
    public void changePlatformAngle(double degree){
        if (currentSpeed == 0) {
            if (angleOfPlatform + degree < 70 && angleOfPlatform + degree > 0) {
                angleOfPlatform += degree;
            } else {
                throw new IllegalArgumentException("Platform angle out of range");
            }
        } else {
            throw new IllegalArgumentException("Vehicle not stationary");
        }
    }

    @Override
    public double speedFactor() {
        return 0;
    }

    @Override
    public void gas (double amount){
        if (angleOfPlatform > 0){
            super.gas(amount);
        } else {
            throw new IllegalArgumentException("The platform is up");
        }
    }

}
