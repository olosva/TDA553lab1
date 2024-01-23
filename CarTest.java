import static org.junit.Assert.*;
import org.junit.Test;
import java.awt.*;

public class CarTest {

    @Test
    public void testCarInitialization() {
        Car car = new Car(4, 150, Color.blue, "TestCar", 0, 0, new int[]{0, 1});
        assertEquals(4, car.getNrDoors());
        assertEquals(150, car.getEnginePower(), 0.01);
        assertEquals(Color.blue, car.getColor());
        assertEquals("TestCar", car.modelName);
        assertEquals(0, car.xPos, 0.01);
        assertEquals(0, car.yPos, 0.01);
        assertArrayEquals(new int[]{0, 1}, car.direction);
        assertEquals(0, car.getCurrentSpeed(), 0.01);
    }

    @Test
    public void testCarStartAndStopEngine() {
        Car car = new Car(4, 150, Color.blue, "TestCar", 0, 0, new int[]{0, 1});
        car.startEngine();
        assertEquals(0.1, car.getCurrentSpeed(), 0.01);

        car.stopEngine();
        assertEquals(0, car.getCurrentSpeed(), 0.01);
    }

    @Test
    public void testCarGasAndBrake() {
        Car car = new Car(4, 150, Color.blue, "TestCar", 0, 0, new int[]{0, 1});
        car.startEngine();

        car.gas(0.5);
        assertEquals(0.85, car.getCurrentSpeed(), 0.01);

        car.brake(0.3);
        assertEquals(0.4, car.getCurrentSpeed(), 0.01);
    }

    @Test
    public void testCarMove() {
        Car car = new Car(4, 150, Color.blue, "TestCar", 0, 0, new int[]{0, 1});
        car.startEngine();
        car.move();
        assertEquals(0, car.xPos, 0.01);
        assertEquals(0.1, car.yPos, 0.01);
    }

    @Test
    public void testCarTurnLeft() {
        Car car = new Car(4, 150, Color.blue, "TestCar", 0, 0, new int[]{0, 1});
        car.turnLeft();
        assertArrayEquals(new int[]{-1, 0}, car.direction);
    }

    @Test
    public void testCarTurnRight() {
        Car car = new Car(4, 150, Color.blue, "TestCar", 0, 0, new int[]{0, 1});
        car.turnRight();
        assertArrayEquals(new int[]{1, 0}, car.direction);
    }
    @Test
    public void testSaab95Turbo() {
        Saab95 saab = new Saab95();
        saab.startEngine();
        saab.setTurboOn();
        assertEquals(1.625, saab.speedFactor(), 0.01);

        saab.setTurboOff();
        assertEquals(1.25, saab.speedFactor(), 0.01);
    }

    @Test
    public void testVolvo240SpeedFactor() {
        Volvo240 volvo = new Volvo240();
        volvo.startEngine();
        assertEquals(1.25, volvo.speedFactor(), 0.01);
    }
}
