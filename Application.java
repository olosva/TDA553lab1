
public class Application {

    /**
     * Main method that starts the program
     */
    public static void main(String[] args) throws InterruptedException {

        World world = new World();


        Saab95 saab = new Saab95();
        saab.xPos = 100;
        saab.direction = new int[]{1,0};
        Scania scania = new Scania();
        scania.xPos = 200;
        Volvo240 volvo = new Volvo240();
        volvo.xPos = 300;
        world.addWorkshop(new WorkShop<Volvo240>(10, 300, 300));


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