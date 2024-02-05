import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CarTransport extends Truck implements Loadable<Car> {

    protected int maxCars;
    protected List<Car> loadedCars;

    public CarTransport (int maxAmountOfCars) {
        super(2, 800, Color.gray, "MAN", new CarPlatform());
        maxCars = maxAmountOfCars;
        loadedCars = new ArrayList<>();
    }

    @Override
    public void move() {
        super.move();
        for (Car car : loadedCars) {
            car.xPos = this.xPos;
            car.yPos = this.yPos;
        }
    }

    public void raisePlatform() {
        if (currentSpeed==0){
            platform.raisePlatform();
        } else {
            throw new IllegalArgumentException("Vehicle is not stationary");
        }
    }

    public void lowerPlatform() {
        if (currentSpeed == 0) {
            platform.lowerPlatform();
        } else {
            throw new IllegalArgumentException("Vehicle is not stationary");
        }
    }

    public void load(Car car) {
        if (platform.platformInUse() && currentSpeed == 0) {
            if (car.xPos > this.xPos - 2 && car.xPos < this.xPos + 2 && car.yPos > this.yPos - 2 && car.yPos < this.yPos + 2) {
                if (loadedCars.size() < maxCars) {
                    loadedCars.add(car);
                } else {
                    throw new IllegalStateException("Car transport is full");
                }
            } else {
                throw new IllegalArgumentException("Car is in wrong position");
            }
        } else {
            throw new IllegalStateException("First you need to lower the platform");
        }
    }

    public void unload() {  // Unloads one car (the last one to be loaded)
        if (platform.platformInUse() && currentSpeed == 0) {
            if (!loadedCars.isEmpty()) {
                loadedCars.getLast().xPos = this.xPos + 0.5;
                loadedCars.getLast().yPos = this.yPos + 0.5;
                loadedCars.remove(loadedCars.size() - 1);
            } else {
                throw new IllegalStateException("The car transport is already empty");
            }
        } else {
            throw new IllegalStateException("First you need to lower the platform");
        }
    }
}
