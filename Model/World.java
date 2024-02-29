import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Timer;

public class World implements ActionListener {

    List<Vehicle> vehicles;
    ArrayList<WorkShop> workshops;
    private final List<Observer> observers = new ArrayList<>();
    private final int delay = 50;
    private Timer timer;

    public World() {
        this.setVehicles(new ArrayList<>());
        this.setWorkshops(new ArrayList<>());
    }

    public void actionPerformed(ActionEvent e) {

        for (Vehicle car : vehicles) {
            double xPos = car.xPos + car.currentSpeed * car.direction[0];
            double yPos = car.yPos + car.currentSpeed * car.direction[1];
            if (car instanceof Car) {
                if (checkLoadWorkshop((Car) car)) {
                    workshops.getFirst().load((Volvo240) car);
                    car.stopEngine();
                }
            }
            if (car.engineOn){
                if (0 <= xPos && xPos <= 800-110 && 0 <= yPos && yPos <= 800 - 300) {
                    car.move();
                } else {
                    car.turnLeft();
                    car.turnLeft();
                    car.stopEngine();
                    car.startEngine();
                    car.move();
                }
            }
            for (Observer observer : observers) {
                observer.notify(this.getDrawables());
            }
        }
    }

    public List<Vehicle> getVehicles()  {
        return vehicles;
    }

    public List<WorkShop> getWorkshops() {
        return workshops;
    }

    public void addVehicle(Vehicle vehicle) {
        this.vehicles.add(vehicle);
    }

    public void addWorkshop(WorkShop workshop) {
        this.workshops.add(workshop);
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public void setWorkshops(List<WorkShop> workshops) {
        this.workshops = (ArrayList<WorkShop>) workshops;
    }

    public void addObserver(Observer o) {
        observers.add(o);
    }

    public void startTimer() {
        timer = new Timer(delay, this);
        timer.start();
    }

    public void startAll() {
        for (Vehicle car : vehicles) {
            car.startEngine();
        }
    }

    public void stopAll() {
        for (Vehicle car : vehicles) {
            car.stopEngine();
        }
    }

    public void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : vehicles) {
            car.gas(gas);
        }
    }

    public void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle car : vehicles) {
            car.brake(brake);
        }
    }

    private boolean checkLoadWorkshop(Car car) {
        if (car instanceof Volvo240 && Math.abs(workshops.getFirst().xPos - (int) car.xPos) <= 10 && Math.abs(workshops.getFirst().yPos - (int) car.yPos) <= 10 && !workshops.get(0).carsInShop.contains(car)) {
            return true;
        } else {
            return false;
        }
    }

    public void turboOn() {
        for (Vehicle car : vehicles) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOn();
            }
        }
    }

    public void turboOff() {
        for (Vehicle car : vehicles) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOff();
            }
        }
    }

    public void liftBed() {
        for (Vehicle truck : vehicles) {
            if (truck instanceof Truck) {
                ((Truck) truck).platform.raisePlatform();
            }
        }
    }

    public void lowerBed() {
        for (Vehicle truck : vehicles) {
            if (truck instanceof Truck) {
                ((Truck) truck).platform.lowerPlatform();
            }
        }
    }

    public void addRandomVehicle() {
        if (vehicles.size() < 10) {
            int random = (int) (Math.random() * 3);
            Vehicle car = new Volvo240();
            switch (random) {
                case 0:
                    car = new Volvo240();;
                    break;
                case 1:
                    car = new Saab95();
                    break;
                case 2:
                    car = new Scania();
                    break;
                default:
                    break;
            }
            car.xPos = (int) ((Math.random() * (600 - 0)) + 0);
            addVehicle(car);
        }
    }

    public void removeCar() {
        if (vehicles.size() > 1) {
            vehicles.removeFirst();
        }
    }

    public List<Positionable> getDrawables(){
        List<Positionable> drawables = new ArrayList<>();
        drawables.addAll(workshops);
        drawables.addAll(vehicles);
        return drawables;
    }


}