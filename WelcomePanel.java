import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
/**
 * Write a description of class WelcomePanel here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class WelcomePanel
{
    // instance variables - replace the example below with your own
    private VBox root;

    /**
     * Constructor for objects of class WelcomePanel
     */
    public WelcomePanel()
    {
        root = new VBox();

        Label title = new Label("Welcome to the London Pollution Viewer");

        Label instructions = new Label(
            "Use the Map tab to view pollution data.\n" +
            "Use the Statistics tab to view averages and trends.\n" +
            "Use the Detail tab to view specific data points."
        );

        root.getChildren().addAll(title, instructions);
    }

    /**
     * COMMENT
     */
    public VBox getRoot()
    {
        return root;
    }
    
}