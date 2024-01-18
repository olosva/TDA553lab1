import java.awt.*;

public class Car {
    protected boolean turboOn;    // If the car has a turbo
    protected int nrDoors;        // Number of doors on the car
    protected double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    protected Color color;        // Color of the car
    protected String modelName;  // Car model name

    /**
     * The constructor for the class car
     * @param turboOn If the car has a turbo
     * @param nrDoors Number of doors on the car
     * @param enginePower Engine power of the car
     * @param color Color of the car
     * @param modelName Car model name
     */
    protected Car(boolean turboOn, int nrDoors,double enginePower,Color color, String modelName) {
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.turboOn = turboOn;
        this.modelName = modelName;
        //stopEngine();
    }

}
