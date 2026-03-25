// using tabpane as matches tabs in brief and separates panels nicely

// Application is the superclass we extend when making JavaFX app
import javafx.application.Application; 
// Stage is the window for JavaFX. When JavaFx starts pap, it gives us a stage object.     
import javafx.stage.Stage;        
// Scene represents the contents inside the window. Holds layout and controls          
import javafx.scene.Scene;

// both used to create multiple tabs 
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;


/**
 * Write a description of class Viewer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Viewer extends Application
{
    /**
     * Constructor for objects of class Viewer
     */
    public Viewer()
    {
        // initialise instance variables
    }

    @Override
    public void start(Stage stage) 
    {
        // creating the TabPane which is a container holding several tabs (sections)
        TabPane tabPane = new TabPane();
        
        // WELCOME TAB
        // creating a tab for welcome panel
        Tab welcomeTab = new Tab("Welcome");
        // Content of this tab is set using the WelcomePanel class 
        welcomeTab.setContent(new WelcomePanel().getRoot());
        
        // MAP TAB
        Tab mapTab = new Tab("Map");
        // Map tab will contain map + markers
        mapTab.setContent(new MapPanel().getRoot());

        
        // STATS TAB
        Tab statsTab = new Tab("Statistics");
        // stats tab will show averages, trends and whatever oteher data necessary
        statsTab.setContent(new StatisticsPanel().getRoot());
        
        // DETAILS TAB
        Tab detailsTab = new Tab("Details");
        // shows selected data point information like x,y coordinate
        detailsTab.setContent(new DetailsPanel().getRoot());
        
        // ADD ALL TABS TO THE TAB PANE
        tabPane.getTabs().addAll(welcomeTab, mapTab, statsTab, detailsTab);
        
        // creating the scene (stuff inside the window)
        Scene scene = new Scene(tabPane, 1000, 1000);
        
        // setting up window
        stage.setTitle("London Air Pollution GUI");
        stage.setScene(scene);      // attaches the contents to window
        stage.show();               // used to display window
    }
    
    public static void main(String[] args)
    {
        launch(args);
    }
    
   
}