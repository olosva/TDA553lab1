import javax.swing.*;
import javax.swing.event.ChangeEvent;

public class Controller {
    View view;
    World world;
    int gasAmount = 0;

    public Controller(View view, World world) {
        this.view = view;
        this.actionListeners();
        this.world = world;
    }

    private void actionListeners() {

        view.gasButton.addActionListener(e -> world.gas(getGasAmount()));
        view.brakeButton.addActionListener(e -> world.brake(getGasAmount()));
        view.turboOnButton.addActionListener(e -> world.turboOn());
        view.turboOffButton.addActionListener(e -> world.turboOff());
        view.startButton.addActionListener(e -> world.startAll());
        view.stopButton.addActionListener(e -> world.stopAll());
        view.liftBedButton.addActionListener(e -> world.liftBed());
        view.lowerBedButton.addActionListener(e -> world.lowerBed());
        view.addCarButton.addActionListener(e -> world.addRandomVehicle());
        view.removeCarButton.addActionListener(e -> world.removeCar());
        view.gasSpinner.addChangeListener(e -> stateChanged(e));

    }
    public void stateChanged(ChangeEvent e) {
        gasAmount = (int) ((JSpinner) e.getSource()).getValue();
    }

    public int getGasAmount() {
        return gasAmount;
    }


}


