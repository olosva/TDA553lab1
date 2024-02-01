import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorkShopTest {

    @Test
    public void TestStaticErrorWhenLoadingWrongCarInShop() {
        WorkShop<Volvo240> shop = new WorkShop<>(10, 0, 0);
        Saab95 saab = new Saab95();
        // shop.load(saab);
    }

    @Test
    public void TestUnload() {
        WorkShop<Car> shop = new WorkShop<>(10, 0, 0);
        Saab95 saab = new Saab95();
        Volvo240 volvo = new Volvo240();
        shop.load(saab);
        shop.load(volvo);
        assertEquals(saab, shop.nextCarToUnload());
        shop.unload();
        assertEquals(volvo, shop.nextCarToUnload());
        shop.unload();
    }

    @Test
    public void TestLoad() {
        WorkShop<Car> shop = new WorkShop<>(3, 0, 0);
        Saab95 saab = new Saab95();
        shop.load(saab);
        shop.load(saab);
        shop.load(saab);

        assertEquals(3, shop.getNrCars());

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            shop.load(saab);});
        assertEquals("Workshop is already full", exception.getMessage());
        shop.unload();

        Volvo240 volvo = new Volvo240();
        volvo.xPos = 15;
        volvo.yPos = 15;

        IllegalArgumentException exception1 = assertThrows(IllegalArgumentException.class, () -> {
            shop.load(volvo);});
        assertEquals("Vehicle is not close enough", exception1.getMessage());

        volvo.xPos = 0;
        volvo.yPos = 0;
        shop.load(volvo);
        shop.unload();
        shop.unload();

        assertEquals(volvo, shop.nextCarToUnload());


    }








}
