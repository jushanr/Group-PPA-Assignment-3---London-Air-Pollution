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
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import java.util.List;

/**
 * Write a description of JavaFX class StatisticsPanel here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class StatisticsPanel extends VBox
{
    private VBox root;
    private ComboBox<String> pollutantSelector;  
    private ComboBox<Integer> yearSelector;
    private TextArea resultArea;
    private PollutionData pollutionData;
    private LineChart<Number, Number> lineChart;
    private int[] years;
    private String[] pollutants;
    
    public StatisticsPanel() {
        pollutionData = new PollutionData();
        
        Label title = new Label("Pollution Statistics");
        
        // Get years and pollutants from the data object
        years = pollutionData.getYears();
        pollutants = pollutionData.getPollutants();
        
        pollutantSelector = new ComboBox<>();
        for (String pollutant : pollutionData.getPollutants()) {
            pollutantSelector.getItems().add(pollutant);
        }
        pollutantSelector.setValue(pollutionData.getPollutants()[0]);
        
        yearSelector = new ComboBox<>();
        for (int year : pollutionData.getYears()) {
            yearSelector.getItems().add(year);
        }
        yearSelector.setValue(pollutionData.getYears()[0]);
        
        Button avgButton = new Button("Show Average");
        avgButton.setOnAction(this::showAverage);
        
        Button highestButton = new Button("Show Highest");
        Button trendButton = new Button("Show Trend");
        trendButton.setOnAction(this::showTrend);
        
        
        resultArea = new TextArea();
        resultArea.setPrefHeight(150);
        resultArea.setEditable(false);
        
        
        int minYear = years[0] - 1;      
        int maxYear = years[years.length - 1] + 1;
        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        
        xAxis.setLabel("Year");
        xAxis.setAutoRanging(false);
        xAxis.setLowerBound(minYear);
        xAxis.setUpperBound(maxYear);
        xAxis.setTickUnit(1);
        
        yAxis.setLabel("Concentration");
        yAxis.setAutoRanging(true);
        
        lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setPrefHeight(250);
        lineChart.setVisible(false);
        
        getChildren().addAll(
            title,
            new Label("Select Pollutant:"), pollutantSelector,
            new Label("Select Year:"), yearSelector,
            avgButton, highestButton, trendButton,
            resultArea, lineChart
        );
        
        
        

        
    }
    
    private void showAverage(ActionEvent event) {
        String pollutant = pollutantSelector.getValue();
        int year = yearSelector.getValue();
        
        DataSet data = pollutionData.getDataSet(pollutant,year);
        if (data ==null){
            resultArea.setText("No data available for " + pollutant + " " + year);
            lineChart.setVisible(false);
            resultArea.setVisible(true);
            return;
        }
        
        double average = calculateAverage(data.getData());
        String units = data.getUnits();
        
        resultArea.setText(String.format(
            "Average %s in %d: %.2f %s",
            pollutant, year, average, units
        ));
        
        lineChart.setVisible(false);
        resultArea.setVisible(true);
    
    }
    
    private double calculateAverage(List<DataPoint> points) {
        if (points.isEmpty()) return 0;
        double sum = 0;
        for (DataPoint point : points) {
            sum += point.value();
        }
        return sum / points.size();
    }
    
    private void showTrend(ActionEvent event) {
        String pollutant = pollutantSelector.getValue();
        
        lineChart.getData().clear();
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.setName(pollutant + " Trend");
        
        for (int year : years) {
            DataSet data = pollutionData.getDataSet(pollutant, year);
            if (data != null) {
                double average = calculateAverage(data.getData());
                series.getData().add(new XYChart.Data<>(year, average));
            }
        }
        
        lineChart.getData().add(series);
        resultArea.setVisible(false);
        lineChart.setVisible(true);
    }
    
    
        /**
     * COMMENT
     */
    public VBox getRoot()
    {
        return root;
    }
}