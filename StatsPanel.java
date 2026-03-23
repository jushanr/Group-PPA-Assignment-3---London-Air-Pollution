import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
/**
 * Write a description of class StatisticsPanel here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class StatsPanel
{
    // instance variables - replace the example below with your own
    private VBox root;

    /**
     * Constructor for objects of class StatisticsPanel
     */
    public StatsPanel()
    {
        root = new VBox();

        Label label = new Label("Stats Panel");

        root.getChildren().add(label);
    }

    /**
     * COMMENT
     */
    public VBox getRoot()
    {
        return root;
    }
}
