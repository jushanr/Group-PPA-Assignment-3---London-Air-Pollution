

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

/**
 * Write a description of JavaFX class StatisticsPanel here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class StatisticsPanel extends VBox
{
    private ComboBox<String> pollutantSelector;  // Your own controls
    private ComboBox<Integer> yearSelector;
    private TextArea resultArea;
    private PollutionData data;
    
    public StatisticsPanel() {
        data = new PollutionData();
        
        Label title = new Label("Pollution Statistics");
        
        // Get years and pollutants from the data object
        int[] years = data.getYears();
        String[] pollutants = data.getPollutants();
        
        // Use them everywhere
        pollutantSelector = new ComboBox<>();
        for (String p : data.getPollutants()) {
            pollutantSelector.getItems().add(p);
        }
        pollutantSelector.setValue(data.getPollutants()[0]);
        
        yearSelector = new ComboBox<>();
        for (int y : data.getYears()) {
            yearSelector.getItems().add(y);
        }
        yearSelector.setValue(data.getYears()[0]);
        
        Button avgButton = new Button("Show Average");
        //avgButton.setOnAction(this::showAverage);
        
        Button highestButton = new Button("Show Highest");
        Button trendButton = new Button("Show Trend");
        
        // Result area
        resultArea = new TextArea();
        resultArea.setPrefHeight(150);
        resultArea.setEditable(false);
        
        getChildren().addAll(
            title,
            new Label("Select Pollutant:"), pollutantSelector,
            new Label("Select Year:"), yearSelector,
            avgButton, highestButton, trendButton
        );
        

        
    }
    
    
    
}