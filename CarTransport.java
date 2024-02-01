import java.awt.*;

public class CarTransport extends Truck {

    private final CarPlatform platform;
    protected Car[] loadedCars;

    public CarTransport () {
        super(2, 800, Color.gray, "MAN",new CarPlatform());
        platform=new CarPlatform();
    }

    public void raisePlatform() {
        if (currentSpeed==0){
            platform.raisePlatform();
        } else {
            throw new IllegalArgumentException("Vehicle is not stationary");
        };
    }

    public void lowerPlatform() {
        if (currentSpeed == 0) {
            platform.lowerPlatform();
        } else {
            throw new IllegalArgumentException("Vehicle is not stationary");
        }
    }

    public void loadCar(Car car) {
        if (platform.platformInUse()) {
            if (car.xPos > this.xPos-2 && car.xPos < this.xPos+2 && car.yPos > this.yPos-2 && car.yPos < this.yPos+2) {
                Car[] tempArray = new Car[loadedCars.length + 1];
                for (int i = 0; i < loadedCars.length; i++)
                    tempArray[i] = loadedCars[i];
                tempArray[loadedCars.length] = car;
                loadedCars = tempArray;
            }
        }
    }

    public void unloadCar() {  // Unloads one car (the last one to be loaded)
        if (platform.platformInUse()) {
            Car unloadedCar = loadedCars[loadedCars.length-1];
            Car[] tempArray = new Car[loadedCars.length -1];
            for (int i = 0; i < loadedCars.length; i++)
                tempArray[i] = loadedCars[i];
            loadedCars = tempArray;
            unloadedCar.xPos = this.xPos+1;
            unloadedCar.yPos = this.yPos+1;
        }
    }

}
