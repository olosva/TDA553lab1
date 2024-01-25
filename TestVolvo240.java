import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class TestVolvo240 {


    @Test
    public void testVolvo240Initialization() {
        Volvo240 volvo240 = new Volvo240();
        assertEquals(4, volvo240.nrDoors);
        assertEquals(100, volvo240.enginePower, 0.01);
        assertEquals(Color.black, volvo240.color);
        assertEquals("Volvo240", volvo240.modelName);
        assertEquals(0, volvo240.xPos, 0.01);
        assertEquals(0, volvo240.yPos, 0.01);
        assertArrayEquals(new int[]{0, 1}, volvo240.direction);
        assertEquals(0, volvo240.currentSpeed, 0.01);
    }
    @Test
    public void testVolvo240StartAndStopEngine() {
        Volvo240 volvo240 = new Volvo240();
        volvo240.startEngine();
        assertEquals(0.1, volvo240.currentSpeed, 0.01);

        volvo240.stopEngine();
        assertEquals(0, volvo240.currentSpeed, 0.01);
    }

    @Test
    public void testVolvo240GasAndBrake() {
        Volvo240 volvo240 = new Volvo240();
        volvo240.startEngine();

        volvo240.gas(0.5);
        assertEquals(0.725, volvo240.currentSpeed, 0.01);

        volvo240.brake(0.3);
        assertEquals(0.35, volvo240.currentSpeed, 0.01);
    }

    @Test
    public void testVolvo240Move() {
        Volvo240 volvo240 = new Volvo240();
        volvo240.startEngine();

        volvo240.move();
        assertEquals(0, volvo240.xPos, 0.01);
        assertEquals(0.1, volvo240.yPos, 0.01);
    }

    @Test
    public void testVolvo240TurnLeft() {
        Volvo240 volvo240 = new Volvo240();
        volvo240.turnLeft();
        assertArrayEquals(new int[]{-1, 0}, volvo240.direction);
    }

    @Test
    public void testVolvo240TurnRight() {
        Volvo240 volvo240 = new Volvo240();
        volvo240.direction = new int[]{-1, 0};
        volvo240.turnRight();
        assertArrayEquals(new int[]{0, 1}, volvo240.direction);
    }

    @Test
    public void testVolvo240SpeedFactor() {
        Volvo240 volvo240 = new Volvo240();
        volvo240.startEngine();
        assertEquals(1.25, volvo240.speedFactor(), 0.01);
    }

    @Test
    public void testVolvo240Color(){
        Volvo240 volvo240 = new Volvo240();
        volvo240.color = Color.white;
        assertSame(volvo240.color, Color.white);

    }
    @Test
    public void testBrakeWithInvalidAmount() {
        Volvo240 volvo240 = new Volvo240();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            volvo240.brake(-1);
        });
        assertEquals("Amount out of range", exception.getMessage());
    }
    @Test
    public void testGasWithInvalidAmount() {
        Volvo240 volvo240 = new Volvo240();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            volvo240.gas(-1);
        });
        assertEquals("Amount out of range", exception.getMessage());
    }
}
