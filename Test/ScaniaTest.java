import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

class ScaniaTest {

    @Test
    void testIncreasePlatfromAngle() {
        Scania scania = new Scania();
        scania.raisePlatform(50);
        assertEquals(50,scania.getPlatformAngle());
    }
    @Test
    void testDecreasePlatfromAngle() {
        Scania scania = new Scania();
        scania.raisePlatform(50);
        scania.lowerPlatform(40);
        assertEquals(10,scania.getPlatformAngle());
    }
    @Test
    void testPlatfromAngleOutOfRange() {
        Scania scania = new Scania();
        assertThrows(IllegalArgumentException.class, () -> {
            scania.lowerPlatform(40);});
    }
    @Test
    void testChangePlatformAngleWhileMoving() {
        Scania scania = new Scania();
        scania.currentSpeed = 10;
        assertThrows(IllegalArgumentException.class, () -> {
            scania.raisePlatform(40);
        });
    }

}