import java.awt.*;

public class Scania extends Truck {

    public Scania() {
        super(2, 750, Color.red, "Scania", new StandardPlatform());
    }

    public void raisePlatform(double degree) {
        if (currentSpeed == 0) {
            for (int i = 0; i < degree; i++) {
                platform.raisePlatform();
            }
        } else {
            throw new IllegalArgumentException("Vehicle not stationary");
        }
    }

    public void lowerPlatform(double degree) {
        if (currentSpeed == 0) {
            for (int i = 0; i < degree; i++) {
                platform.lowerPlatform();
            }
        } else {
            throw new IllegalArgumentException("Vehicle not stationary");
        }
    }
    public double getPlatformAngle() {
        return platform.getPlatformLevel();
    }
}
