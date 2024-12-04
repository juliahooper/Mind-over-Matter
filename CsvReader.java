import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CsvReader {
    public ArrayList<ArrayList<String>> readCsvFile(String filePath) {
        String line; // Stores each line of the CSV file
        String delimiter = ","; // Specifies the delimiter used in the CSV file
        ArrayList<ArrayList<String>> data = new ArrayList<>();

        // Read the CSV file
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while ((line = br.readLine()) != null) {
                String[] values = line.split(delimiter); // Split the line into values
                ArrayList<String> row = new ArrayList<>();
                for (String value : values) {
                    row.add(value.trim()); // Trim whitespace and add to the row
                }
                data.add(row); // Add the row to the data list
            }
        } catch (IOException e) {
            e.printStackTrace(); // Print stack trace if an error occurs
        }

        return data; // Return the parsed data
    }
}
