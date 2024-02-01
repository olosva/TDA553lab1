import org.junit.Test;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;

public class WorkShopTest {

    @Test
    public void TestStaticErrorWhenLoadingWrongCarInShop() {
        WorkShop<Volvo240> shop = new WorkShop<>(10, 0, 0);
        Saab95 saab = new Saab95();
        // shop.load(saab);
    }



}
