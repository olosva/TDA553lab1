import java.awt.*;

public class CarTransport extends Truck implements Loadable<Car> {


    protected final CarPlatform platform;
    protected int maxCars;
    protected Car[] loadedCars;

    public CarTransport (int maxAmountOfCars) {
        super(2, 800, Color.gray, "MAN", new CarPlatform());
        maxCars = maxAmountOfCars;
        platform=new CarPlatform();
        loadedCars = new Car[maxCars];
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
        if (platform.platformInUse()) {
            if (car.xPos > this.xPos - 2 && car.xPos < this.xPos + 2 && car.yPos > this.yPos - 2 && car.yPos < this.yPos + 2) {
                for (int i = 0; i < loadedCars.length - 1; i++) {
                    if (loadedCars[i] == null)
                        loadedCars[i] = car;
                }
            }
        } else {
            throw new IllegalStateException("First you need to lower the platform");
        }
    }

    public void unload() {  // Unloads one car (the last one to be loaded)
        if (platform.platformInUse()) {
            for (int i = 0; i < loadedCars.length - 1; i++) {
                if (loadedCars[i] == null) {
                    loadedCars[i - 1].xPos = this.xPos + 1;
                    loadedCars[i - 1].xPos = this.yPos + 1;
                    loadedCars[i - 1] = null;
                }
            }
        } else {
            throw new IllegalStateException("First you need to lower the platform");
        }
    }
}
