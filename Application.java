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


        View view = new View(800, 800 - 240, world.getVehicles(), world.getWorkshops(), world.getDrawables(), "CarSim 1.0");
        new Controller(view, world);

        world.addObserver(view);
        world.startTimer();
    }
}