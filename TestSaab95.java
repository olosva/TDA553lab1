import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class TestSaab95 {


    @Test
    public void testSaab95Initialization() {
        Saab95 saab95 = new Saab95();
        assertEquals(2, saab95.nrDoors);
        assertEquals(125, saab95.enginePower, 0.01);
        assertEquals(Color.red, saab95.color);
        assertEquals("Saab95", saab95.modelName);
        assertEquals(0, saab95.xPos, 0.01);
        assertEquals(0, saab95.yPos, 0.01);
        assertArrayEquals(new int[]{0, 1}, saab95.direction);
        assertEquals(0, saab95.currentSpeed, 0.01);
    }
    @Test
    public void testSaab95StartAndStopEngine() {
        Saab95 saab95 = new Saab95();
        saab95.startEngine();
        assertEquals(0.1, saab95.currentSpeed, 0.01);

        saab95.stopEngine();
        assertEquals(0, saab95.currentSpeed, 0.01);
    }

    @Test
    public void testSaab95GasAndBrake() {
        Saab95 saab95 = new Saab95();
        saab95.startEngine();

        saab95.gas(0.5);
        assertEquals(0.725, saab95.currentSpeed, 0.01);

        saab95.brake(0.3);
        assertEquals(0.35, saab95.currentSpeed, 0.01);
    }

    @Test
    public void testSaab95Move() {
        Saab95 saab95 = new Saab95();
        saab95.startEngine();

        saab95.move();
        assertEquals(0, saab95.xPos, 0.01);
        assertEquals(0.1, saab95.yPos, 0.01);
    }

    @Test
    public void testSaab95TurnLeft() {
        Saab95 saab95 = new Saab95();
        saab95.turnLeft();
        assertArrayEquals(new int[]{-1, 0}, saab95.direction);
    }

    @Test
    public void testSaab95TurnRight() {
        Saab95 saab95 = new Saab95();
        saab95.direction = new int[]{-1, 0};
        saab95.turnRight();
        assertArrayEquals(new int[]{0, 1}, saab95.direction);
    }

    @Test
    public void testSaab95Turbo() {
        Saab95 saab95 = new Saab95();
        saab95.startEngine();
        saab95.setTurboOn();
        assertEquals(1.625, saab95.speedFactor(), 0.01);

        saab95.setTurboOff();
        assertEquals(1.25, saab95.speedFactor(), 0.01);
    }

    @Test
    public void testSaab95Color(){
        Saab95 saab95 = new Saab95();
        saab95.color = Color.white;
        assertSame(saab95.color, Color.white);

    }


}
