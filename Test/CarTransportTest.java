import org.junit.Test;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;

public class CarTransportTest {

    @Test
    public void TestStaticErrorWhenLoadingCarTransportOnCarTransport() {
        CarTransport transport = new CarTransport(10);
        CarTransport secondTransport = new CarTransport(5);
        // transport.load(secondTransport);
    }

    @Test
    public void TestCarTransportPlatformRaisedAndLowered() {
        CarTransport transport = new CarTransport(10);
        assertEquals(1, transport.platform.rampState);
        transport.lowerPlatform();
        assertEquals(0, transport.platform.rampState);
    }

    @Test
    public void TestCarTransportCannotRaiseOrLowerPlatformWhenMoving() {
        CarTransport transport = new CarTransport(10);
        transport.gas(0.5);
        assertThrows(IllegalArgumentException.class, () -> {transport.raisePlatform();});
        assertThrows(IllegalArgumentException.class, () -> {transport.lowerPlatform();});
    }

    @Test
    public void TestCannotLoadOrUnloadWhenPlatformIsUp() {
        CarTransport transport = new CarTransport(10);
        Saab95 saab = new Saab95();
        Volvo240 volvo = new Volvo240();
        assertThrows(IllegalStateException.class, () -> {transport.load(saab);});
        transport.lowerPlatform();
        transport.load(saab);
        transport.load(volvo);
        transport.raisePlatform();
        assertThrows(IllegalStateException.class, () -> {transport.unload();});
        transport.lowerPlatform();
        transport.unload();
    }
}
