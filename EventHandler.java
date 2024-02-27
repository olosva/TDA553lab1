public class EventHandler {

    Controller controller;
    World world;

    public EventHandler(Controller controller, World world) {
        this.controller = controller;
        this.actionListeners();
        this.world = world;
    }

    private void actionListeners() {

        controller.gasButton.addActionListener(e -> world.gas(controller.getGasAmount()));
        controller.brakeButton.addActionListener(e -> world.brake(controller.getGasAmount()));
        controller.turboOnButton.addActionListener(e -> world.turboOn());
        controller.turboOffButton.addActionListener(e -> world.turboOff());
        controller.startButton.addActionListener(e -> world.startAll());
        controller.stopButton.addActionListener(e -> world.stopAll());
        controller.liftBedButton.addActionListener(e -> world.liftBed());
        controller.lowerBedButton.addActionListener(e -> world.lowerBed());
        controller.addCarButton.addActionListener(e -> world.addRandomVehicle());
        controller.removeCarButton.addActionListener(e -> world.removeCar());

    }

}