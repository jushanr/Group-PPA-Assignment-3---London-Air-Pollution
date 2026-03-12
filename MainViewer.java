
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Pane;

import javafx.stage.Stage;

/**
 * Write a description of JavaFX class MainViewer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MainViewer extends Application
{
    private BorderPane root;

    /**
     * The start method is the main entry point for every JavaFX application. 
     * It is called after the init() method has returned and after 
     * the system is ready for the application to begin running.
     *
     * @param  stage the primary stage for this application.
     */
    @Override
    public void start(Stage stage)
    {
        root = new BorderPane();
        
        VBox sidebar = new VBox(10);
    
        //make nav buttons
        Button statsBtn = createNavButton("Statistics", new StatisticsPanel());
        
        sidebar.getChildren().add(statsBtn);
        
        root.setLeft(sidebar);
        root.setCenter(new Label("coming soon..."));

        
        // JavaFX must have a Scene (window content) inside a Stage (window)
        Scene scene = new Scene(root, 900,700);
        stage.setTitle("London Air Pollution");
        stage.setScene(scene);
        
        // Show the Stage (window)
        stage.show();
    }
    
    private Button createNavButton(String name, Pane panel){
        Button btn = new Button(name);
        btn.setOnAction( e-> root.setCenter(panel));
        return btn;
        
    }
    

    


}