import javax.swing.*;
import java.util.List;

public class View extends JFrame implements Observer {
    World world;
    DrawPanel drawPanel;

    public View(DrawPanel panel, World world) {
        this.drawPanel = panel;
        this.world = world;
    }

    @Override
    public void notify(List<Vehicle> vehicles) {
        world.setVehicles(vehicles);
        drawPanel.repaint();
        this.drawPanel.repaint();
        this.drawPanel.revalidate();

    }

}