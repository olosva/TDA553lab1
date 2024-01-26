import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

class ScaniaTest {

    @Test
    void testIncreasePlatfromAngle() {
        Scania scania = new Scania();
        scania.changePlatformAngle(50);
        assertEquals(50,scania.angleOfPlatform);
    }
    @Test
    void testDecreasePlatfromAngle() {
        Scania scania = new Scania();
        scania.angleOfPlatform = 50;
        scania.changePlatformAngle(-40);
        assertEquals(10,scania.angleOfPlatform);
    }
    @Test
    void testPlatfromAngleOutOfRange() {
        Scania scania = new Scania();
        assertThrows(IllegalArgumentException.class, () -> {
            scania.changePlatformAngle(-40);});
    }
    @Test
    void testChangePlatformAngleWhileMoving() {
        Scania scania = new Scania();
        scania.currentSpeed = 10;
        assertThrows(IllegalArgumentException.class, () -> {
            scania.changePlatformAngle(-40);
        });
    }


    @Test
    void testGasWhenPlatformUp() {
        Scania scania = new Scania();
        scania.angleOfPlatform = 20;
        assertThrows(IllegalArgumentException.class, () -> {
            scania.gas(20);
        });
    }
}