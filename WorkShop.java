import java.util.ArrayList;
import java.util.List;

public class WorkShop<T extends Car> implements Loadable<T> {
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
    public void unload(){
        carsInShop.removeFirst();
    }

}
// Workshop <Volvo240> shop = new WorkShop();