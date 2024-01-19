import java.awt.*;

public class Car implements Movable {
    protected boolean turboOn;    // If the car has a turbo
    protected int nrDoors;        // Number of doors on the car
    protected double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    protected Color color;        // Color of the car
    protected String modelName;  // Car model name
    protected int xPos;  // x-coordinate of car
    protected int yPos;  // y-coordinate of car
    protected int[] direction;  // Direction of car, type array with two ints, e.g. {0, 1}

    /**
     * The constructor for the class car
     * @param turboOn If the car has a turbo
     * @param nrDoors Number of doors on the car
     * @param enginePower Engine power of the car
     * @param color Color of the car
     * @param modelName Car model name
     */
    protected Car(boolean turboOn, int nrDoors,double enginePower,Color color, String modelName, int xPos, int yPos, int[] direction) {
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.turboOn = turboOn;
        this.modelName = modelName;
        this.xPos = xPos;
        this.yPos = yPos;
        this.direction = direction;
        //stopEngine();
    }

    public void move() {
        this.xPos = this.xPos + currentSpeed * this.direction[0];
        this.yPos = this.yPos + currentSpeed * this.direction[1];
    }

    public void turnLeft() {
        if this.xPos == 0 && this.yPos == 1 {  // North to West
            this.xPos = -1;
            this.yPos = 0;
        } else if this.xPos == -1 && this.yPos == 0 {  // West to South
            this.xPos = 0;
            this.yPos = -1;
        } else if this.xPos == 0 && this.yPos == -1 {  // South to East
            this.xPos = 1;
            this.yPos = 0;
        } else {  // East to North
            this.xPos = 0;
            this.yPos = 1;
        }
    }

    public void turnRight() {
        if this.xPos == 0 && this.yPos == 1 {  // North to East
            this.xPos = 1;
            this.yPos = 0;
        } else if this.xPos == 1 && this.yPos == 0 {  // East to South
            this.xPos = 0;
            this.yPos = -1;
        } else if this.xPos == 0 && this.yPos == -1 {  // South to West
            this.xPos = -1;
            this.yPos = 0;
        } else {  // West to North
            this.xPos = 0;
            this.yPos = 1;
        }
    }

}
