import java.util.ArrayList;
import java.util.List;

public class WorkShop<T extends Car> implements Loadable<T> {
    protected int maxCars;
    int xPos;
    int yPos;

    protected List<T> carsInShop = new ArrayList<>();

    public void Workshop(int maxCars, int xPos, int yPos) {
        this.maxCars = maxCars;
        this.xPos = xPos;
        this.yPos = yPos;

    }

    public void load(T car) {
        if (carsInShop.size() <= maxCars -1) {
            if (car.xPos > this.xPos-2 && car.xPos < this.xPos+2 && car.yPos > this.yPos-2 && car.yPos < this.yPos+2) {
                carsInShop.add(car);
            }
        }
    }
    public void unload(){
        carsInShop.removeFirst();
    }

}
// Workshop <Volvo240> shop = new WorkShop();