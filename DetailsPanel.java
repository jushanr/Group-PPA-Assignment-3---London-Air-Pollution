import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
/**
 * Write a description of class DetailsPanel here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DetailsPanel
{
    // instance variables - replace the example below with your own
    private VBox root;

    /**
     * Constructor for objects of class DetailPanel
     */
    public DetailsPanel()
    {
        root = new VBox();

        Label label = new Label("Details Panel");

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