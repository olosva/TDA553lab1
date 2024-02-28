
public class Application {

    /**
     * Main method that starts the program
     */
    public static void main(String[] args) {

        World world = new World();

        Saab95 saab = Factory.createSaab95();
        saab.xPos = 100;
        Scania scania = Factory.createScania();
        scania.xPos = 200;
        Volvo240 volvo = Factory.createVolvo240();
        volvo.xPos = 300;
        world.addWorkshop(Factory.createVolvoWorkShop(10, 300, 300));


        world.addVehicle(volvo);
        world.addVehicle(saab);
        world.addVehicle(scania);

        DrawPanel drawPanel = new DrawPanel(800, 800 - 240, world.getVehicles(), world.getWorkshops());
        View view = new View(drawPanel, world);
        Controller controller = new Controller(drawPanel, "CarSim 1.0");

        world.addObserver(view);
        EventHandler eventHandler = new EventHandler(controller, world);
        world.startTimer();
    }
}