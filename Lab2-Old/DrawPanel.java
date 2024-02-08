import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel {

    CarController carC;

    BufferedImage volvoWorkshopImage;
    Point volvoWorkshopPoint = new Point(300, 300);

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, CarController carC) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        this.carC = carC;
        try {
            this.volvoWorkshopImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(volvoWorkshopImage, volvoWorkshopPoint.x, volvoWorkshopPoint.y, null);

        for (Vehicle car : this.carC.cars) {
            // Print an error message in case file is not found with a try/catch block
            try {
                BufferedImage img = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/" + car.modelName + ".jpg"));
                g.drawImage(img, (int) car.xPos, (int) car.yPos, null); // see javadoc for more info on the parameters


            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}

