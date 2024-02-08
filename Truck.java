import java.awt.*;

public abstract class Truck extends Vehicle {

    protected final Platform platform;

    public Truck(int nrDoors, double enginePower, Color color, String modelName, Platform platform){
        super(nrDoors, enginePower, color, modelName);
        this.platform = platform;
    }
    @Override
    public void gas(double amount) {
        if (!(platform.platformInUse())) {
            super.gas(amount);
        } else {
            throw new IllegalArgumentException("The platform is up");
        }
    }

    @Override
    public void startEngine() {
        if (!(platform.platformInUse())) {
            super.startEngine();
        } else {
            throw new IllegalArgumentException("The platform is up");
        }
    }
    @Override
    public double speedFactor() {
        return enginePower*0.01;
    }

}
