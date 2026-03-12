import java.util.HashMap;
import java.util.Map;
/**
 * A class containing the loaded pollution data in a nested hash map.
 *
 * @author Saanujanth Sivathasan
 * @version 12/03/2026
 */
public class PollutionData
{
    // instance variables - replace the example below with your own
    private Map<String, Map<Integer, DataSet> > completeData;

    /**
     * Constructor for objects of class PollutionData
     */
    public PollutionData()
    {
        // initialise instance variables
        completeData = new HashMap<>();
        loadAllFiles();
    }

    /**
     * Loads all the files in the UKAirPollutionData folder placing it into a nested hash map.
     * Each pollutant is the key, the value is a hashmap with key of years and value being the respective dataset objects.
     */
    private void loadAllFiles()
    {
        DataLoader loader = new DataLoader();
        
        int[] years = {2018, 2019, 2020, 2021, 2022, 2023};
        String[] pollutants = {"NO2", "pm10", "pm25"};
        
        for (String pollutant:pollutants){
            Map<Integer, DataSet> pollutantsByYear = new HashMap<>();
            
            for (int year:years){
                String filePath = "UKAirPollutionData/" +pollutant+ "/map"+ pollutant.toLowerCase()+year+".csv";
                
                DataSet dataset = loader.loadDataFile(filePath);
                
                if (dataset!=null){
                    pollutantsByYear.put(year, dataset);
                }
                
            }
            
            completeData.put(pollutant, pollutantsByYear);
        }
        
    }
}
