import java.awt.*;

public abstract class Truck extends Vehicle {

    protected boolean hasPlatform;

    public Truck(int nrDoors, double enginePower, Color color, String modelName, boolean hasPlatform) {
        super(nrDoors, enginePower, color, modelName);
        this.hasPlatform = hasPlatform;
    }

    @Override
    public double speedFactor() {
        return enginePower*0.01;
    }

}
