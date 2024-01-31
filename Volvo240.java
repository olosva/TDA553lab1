import java.awt.*;

public class Volvo240 extends Car {

    private final static double trimFactor = 1.25;

    /**
     * Constructor creating a subclass Volvo240 of th cars class with specific attributes, setting
     * the engine off.
     */
    protected Volvo240() {
        super(4, 100, Color.black, "Volvo240");
    }

    /**
     * Overrides the speedfactor method used in increasing and decresing the current speed of the car
     *
     * @return the new speedfactor
     */
    @Override
    public double speedFactor() {
        return enginePower * 0.01 * trimFactor;
    }

}
