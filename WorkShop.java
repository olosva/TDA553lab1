import java.util.ArrayList;
import java.util.List;

public class WorkShop<T extends Car> implements Loadable{
    protected int maxCars;

    protected List<T> carsInShop = new ArrayList<>();

    public void Workshop(int maxCars) {
        this.maxCars = maxCars;
    }

    public void load(T car) {
        if (carsInShop.size() <= maxCars -1){
            carsInShop.add(car);

        }


    }

}
Workshop <Car> shop = new WorkShop();