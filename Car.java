import java.awt.*;

public abstract class Car implements Movable {
    protected int nrDoors;        // Number of doors on the car
    protected double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    protected Color color;        // Color of the car
    protected String modelName;  // Car model name
    protected double xPos;  // x-coordinate of car
    protected double yPos;  // y-coordinate of car
    protected int[] direction;  // Direction of car, type array with two ints, e.g. {0, 1}

    /**
     * The constructor for the class car
     *
     * @param nrDoors     Number of doors on the car
     * @param enginePower Engine power of the car
     * @param color       Color of the car
     * @param modelName   Car model name
     */
    public Car(int nrDoors, double enginePower, Color color, String modelName) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        this.xPos = 0;
        this.yPos = 0;
        this.direction = new int[] {0, 1};
        stopEngine();
    }

    /**
     * Return the number of doors of the car
     *
     * @return number of doors
     */
    protected int getNrDoors() {
        return nrDoors;
    }

    /**
     * Returns the current engine power of the car
     *
     * @return the engine power
     */
    protected double getEnginePower() {
        return enginePower;
    }

    /**
     * Returns the current speed of the car
     *
     * @return the current speed
     */
    protected double getCurrentSpeed() {
        return currentSpeed;
    }

    /**
     * Returns the color of the car
     *
     * @return the color
     */
    protected Color getColor() {
        return color;
    }

    /**
     * Sets the color of the car
     *
     * @param clr the color
     */
    protected void setColor(Color clr) {
        color = clr;
    }

    /**
     * Starts the engine setting the car's current speed to 0.1
     */
    protected void startEngine() {
        currentSpeed = 0.1;
    }

    /**
     * Stops the engine setting the car's current speed to 0
     */
    protected void stopEngine() {
        currentSpeed = 0;
    }

    /**
     * Calculates a factor used when changing the speed of the car (will be overridden)
     *
     * @return the speedfactor
     */
    protected double speedFactor() {
        return enginePower * 0.01;
    }

    /**
     * Increase the current speed of the car
     *
     * @param amount how much the speed should increase with
     */
    protected void incrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
    }

    /**
     * Decrease the current speed of the car
     *
     * @param amount how much the speed should decrease with
     */
    protected void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }

    public void move() {
        this.xPos = this.xPos + currentSpeed * this.direction[0];
        this.yPos = this.yPos + currentSpeed * this.direction[1];
    }

    public void turnLeft() {
        if (this.direction[0] == 0 && this.direction[1] == 1) {  // North to West
            this.direction[0] = -1;
            this.direction[1] = 0;
        } else if (this.direction[0] == -1 && this.direction[1] == 0) {  // West to South
            this.direction[0] = 0;
            this.direction[1] = -1;
        } else if (this.direction[0] == 0 && this.direction[1] == -1) {  // South to East
            this.direction[0] = 1;
            this.direction[1] = 0;
        } else {  // East to North
            this.direction[0] = 0;
            this.direction[1] = 1;
        }
    }

    public void turnRight() {
        if (this.direction[0] == 0 && this.direction[1] == 1) {  // North to East
            this.direction[0] = 1;
            this.direction[1] = 0;
        } else if (this.direction[0] == 1 && this.direction[1] == 0) {  // East to South
            this.direction[0] = 0;
            this.direction[1] = -1;
        } else if (this.direction[0] == 0 && this.direction[1] == -1) {  // South to West
            this.direction[0] = -1;
            this.direction[1] = 0;
        } else {  // West to North
            this.direction[0] = 0;
            this.direction[1] = 1;
        }
    }

    /**
     * Method that increases the current speed
     * @param amount the amount which is between 0 and 1
     */
    protected void gas(double amount) {
        if (amount > 0 && amount < 1) {
            incrementSpeed(amount);
        }
    }
    /**
     * Method that decreases the current speed
     * @param amount the amount which is between 0 and 1
     */
    protected void brake(double amount) {
        if (amount > 0 && amount < 1) {
            decrementSpeed(amount);
        }
    }
}

