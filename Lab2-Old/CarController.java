import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.lang.Math;

/*
 * This class represents the Controller part in the MVC pattern.
 * It's responsibilities is to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    public ArrayList<Vehicle> cars = new ArrayList<>();
    public ArrayList<WorkShop> workshops = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        Saab95 saab = new Saab95();
        saab.xPos = 100;
        Scania scania = new Scania();
        scania.xPos = 200;
        Volvo240 volvo = new Volvo240();
        volvo.xPos = 300;

        cc.cars.add(volvo);
        cc.cars.add(saab);
        cc.cars.add(scania);
        cc.workshops.add(new WorkShop<Volvo240>(10, 300, 300));

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle car : cars) {
                double xPos = car.xPos + car.currentSpeed * car.direction[0];
                double yPos = car.yPos + car.currentSpeed * car.direction[1];
                if (car instanceof Car) {
                    if (checkLoadWorkshop((Car) car)) {
                        workshops.getFirst().load((Volvo240) car);
                        car.stopEngine();
                    }
                }
                if (car.engineOn){
                    if (0 <= xPos && xPos <= frame.X && 0 <= yPos && yPos <= frame.Y - 300) {
                        car.move();
                    } else {
                    car.turnLeft();
                    car.turnLeft();
                    car.stopEngine();
                    car.startEngine();
                    car.move();
                    }
             }
                frame.drawPanel.repaint();
            }
        }
    }

    private boolean checkLoadWorkshop(Car car) {
        if (car instanceof Volvo240 && Math.abs(workshops.getFirst().xPos - (int) car.xPos) <= 10 && Math.abs(workshops.getFirst().yPos - (int) car.yPos) <= 10 && !workshops.get(0).carsInShop.contains(car)) {
            return true;
        } else {
            return false;
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : cars)
        {car.gas(gas);
        }
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle car : cars) {
            car.brake(brake);
        }
    }
}
