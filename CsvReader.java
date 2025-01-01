import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CsvReader {
    public ArrayList<ArrayList<String>> readCsvFile(String filePath) {
        String line;
        String delimiter = ","; 
        ArrayList<ArrayList<String>> data = new ArrayList<>();

        // Read the CSV file
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while ((line = br.readLine()) != null) {
                String[] values = line.split(delimiter); 
                ArrayList<String> row = new ArrayList<>();
                for (String value : values) {
                    row.add(value.trim()); 
                }
                data.add(row); 
            }
        } catch (IOException e) {
            e.printStackTrace(); 
        }

        return data; 
    }
}
