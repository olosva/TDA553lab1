import java.util.ArrayList;
import java.util.List;

public class WorkShop<T extends Car> implements Loadable<T>, Positionable {

    protected int maxCars;
    protected int xPos;
    protected int yPos;
    public List<T> carsInShop = new ArrayList<>();

    public WorkShop(int maxCars, int xPos, int yPos) {
        this.maxCars = maxCars;
        this.xPos = xPos;
        this.yPos = yPos;

    }
        // regnummer
    public void load(T car) {
        if (carsInShop.size() <= maxCars -1) {
            if (car.xPos > this.xPos-10 && car.xPos < this.xPos+10 && car.yPos > this.yPos-10 && car.yPos < this.yPos+10) {
                carsInShop.add(car);
            } else {
                throw new IllegalArgumentException("Vehicle is not close enough");
            }
        } else {
            throw new IllegalArgumentException("Workshop is already full");
        };
    }

    public void unload(){
        if (!carsInShop.isEmpty()){
            carsInShop.removeFirst();
        }
    }

    public int getNrCars(){
        return carsInShop.size();
    }

    public T nextCarToUnload(){
        return carsInShop.getFirst();
    }

    public double getXPos(){
        return  xPos;
    }
    public double getYPos(){
        return  yPos;
    }
    public String getName(){
        return "VolvoBrand";
    }


}
