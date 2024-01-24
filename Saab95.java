import java.awt.*;



public class Saab95 extends Car{

    private boolean turboOn;

    /**
     * Constructor creating a subclass Saab95 of th cars class with specific attributes, setting
     * the engine and turbo off.
     */
    protected Saab95(){
        super(2,125,Color.red, "Saab95", 0,0,new int[]{0,1});
        turboOn = false;
        stopEngine();
    }

    /**
     * Turn on the turbo
     */
    protected void setTurboOn(){
	    turboOn = true;
    }

    /**
     * Turn off the turbo
     */
    protected void setTurboOff(){
	    turboOn = false;
    }

    /**
     * Overrides the speedfactor method used in increasing and decresing the current speed of the car
     * @return the new speedfactor
     */
    @Override
    protected double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }
}
