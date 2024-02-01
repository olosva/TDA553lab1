import java.awt.*;

public abstract class Vehicle implements Movable {
    protected int nrDoors;        // Number of doors on the vehicle
    protected double enginePower; // Engine power of the vehicle
    protected double currentSpeed; // The current speed of the vehicle
    protected Color color;        // Color of the vehicle
    protected String modelName;  // Vehicle model name
    protected double xPos;  // x-coordinate of vehicle
    protected double yPos;  // y-coordinate of vehicle
    protected int[] direction;  // Direction of vehicle, type array with two ints, e.g. {0, 1}

    public Vehicle(int nrDoors, double enginePower, Color color, String modelName) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        this.xPos = 0;
        this.yPos = 0;
        this.direction = new int[]{0,1};
        stopEngine();
    }

    /**
     * Starts the engine setting the car's current speed to 0.1
     */
    protected void startEngine() {
        currentSpeed = 0.1;
    }

    /**
     * Stops the engine setting the 's current speed to 0
     */
    protected void stopEngine() {
        currentSpeed = 0;
    }

    /**
     * Calculates a factor used when changing the speed of the car (will be overridden)
     *
     * @return the speedfactor
     */
    public abstract double speedFactor();

    /**
     * Increase the current speed of the car
     *
     * @param amount how much the speed should increase with
     */
    private void incrementSpeed(double amount) {
        currentSpeed = Math.min(currentSpeed + speedFactor() * amount, enginePower);
    }

    /**
     * Decrease the current speed of the car
     *
     * @param amount how much the speed should decrease with
     */
    private void decrementSpeed(double amount) {
        currentSpeed = Math.max(currentSpeed - speedFactor() * amount, 0);
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
            incrementSpeed(amount);}
        else {
            throw new IllegalArgumentException("Amount out of range");
        }
    }
    /**
     * Method that decreases the current speed
     * @param amount the amount which is between 0 and 1
     */
    protected void brake(double amount) {
        if (amount > 0 && amount < 1) {
            decrementSpeed(amount);}
        else {
            throw new IllegalArgumentException("Amount out of range");
        }
    }
}
