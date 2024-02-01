import java.awt.*;

public class Scania extends Truck {

    private final StandardPlatform platform;

    public Scania() {
        super(2, 750, Color.red, "Scania", new StandardPlatform());
        platform = new StandardPlatform();
    }

    public void raisePlatform(double degree) {
        if (currentSpeed == 0) {
            platform.raisePlatform();
        } else {
            throw new IllegalArgumentException("Vehicle not stationary");
        }
    }

    public void lowerPlatform(double degree) {
        if (currentSpeed == 0) {
            platform.lowerPlatform();
        } else {
            throw new IllegalArgumentException("Vehicle not stationary");
        }
    }
}
