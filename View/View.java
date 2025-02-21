import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;


public class View extends JPanel implements Observer{


    List<Positionable> drawables;

    JPanel controlPanel = new JPanel();
    private static final int X = 800;
    private static final int Y = 800;

    private JFrame frame = new JFrame();
    public JButton gasButton = new JButton("Gas");
    public JButton brakeButton = new JButton("Brake");
    public JButton turboOnButton = new JButton("Turbo on");
    public JButton turboOffButton = new JButton("Turbo off");
    public JButton liftBedButton = new JButton("Lift Bed");
    public JButton lowerBedButton = new JButton("Lower Bed");
    public JButton addCarButton = new JButton("Add car");
    public JButton removeCarButton = new JButton("Remove car");
    public JButton startButton = new JButton("Start cars");
    public JButton stopButton = new JButton("Stop cars");
    JPanel gasPanel = new JPanel();
    JSpinner gasSpinner = new JSpinner();
    JLabel gasLabel = new JLabel("Amount of gas");


    // Initializes the panel and reads the images
    public View(int x, int y, List<Vehicle> vehicles, List<WorkShop> workshops,List<Positionable> drawables, String title) {

        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        this.drawables = drawables;


        frame.add(controlPanel);
        frame.add(this);


        frame.setTitle(title);
        frame.setPreferredSize(new Dimension(X, Y));
        frame.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        SpinnerModel spinnerModel = new SpinnerNumberModel(0, 0, 100, 1);
        gasSpinner = new JSpinner(spinnerModel);

        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);

        frame.add(gasPanel);

        controlPanel.setLayout(new GridLayout(2, 4));

        controlPanel.add(gasButton, 0);
        controlPanel.add(turboOnButton, 1);
        controlPanel.add(liftBedButton, 2);
        controlPanel.add(brakeButton, 3);
        controlPanel.add(turboOffButton, 4);
        controlPanel.add(lowerBedButton, 5);
        controlPanel.add(addCarButton, 6);
        controlPanel.add(removeCarButton, 7);
        controlPanel.setPreferredSize(new Dimension((X / 2) + 4, 200));
        frame.add(controlPanel);
        controlPanel.setBackground(Color.CYAN);

        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        startButton.setPreferredSize(new Dimension(X / 5 - 15, 200));
        frame.add(startButton);

        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension(X / 5 - 15, 200));
        frame.add(stopButton);

        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);

        frame.add(gasPanel);

        // Make the frame pack all it's components by respecting the sizes if possible.
        frame.pack();

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
        // Make the frame visible
        frame.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    @Override
    public void notify(List<Positionable> drawables) {
        this.drawables = drawables;
        this.repaint();

    }


@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Positionable car : drawables) {
            // Print an error message in case file is not found with a try/catch block
            try {
                BufferedImage img = ImageIO.read(View.class.getResourceAsStream("pics/" + car.getName() + ".jpg"));
                g.drawImage(img, (int) car.getXPos(), (int) car.getYPos(), null); // see javadoc for more info on the parameters

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}

