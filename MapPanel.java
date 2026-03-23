import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
/**
 * Write a description of class MapPanel here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MapPanel
{
    private BorderPane root;
    
    /**
     * Constructor for objects of class MapPanel
     */
    public MapPanel()
    {
        root = new BorderPane();
        
        // load london map
        Image mapImage = new Image("file:London.png");
        ImageView mapView = new ImageView(mapImage);
        
        StackPane mapContainer = new StackPane();
        mapContainer.getChildren().add(mapView);
        
        //map in centre of panel
        root.setCenter(mapContainer);
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public BorderPane getRoot()
    {
        return root;
    }
}