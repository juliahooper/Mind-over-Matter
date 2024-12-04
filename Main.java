
import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static void main(String args[]) {
        ArrayList<String> physicalActivity = new ArrayList<String>();
        ArrayList<String> mentalActivity = new ArrayList<String>();
        ArrayList<String> personalGrowth = new ArrayList<String>();
        ArrayList<String> socialActivity = new ArrayList<String>();
        ArrayList<String> creativePursuit = new ArrayList<String>();
        ArrayList<String> selfCare = new ArrayList<String>();
        inputVerification inputchecker = new inputVerification();
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Rate how you feel today on a scale of 1-10");
        int moodRating = myScanner.nextInt();
        inputchecker.mood(moodRating);
        CsvReader csvReader = new CsvReader(); // Create an instance of CsvReader
        String filePath = "BetterDays.csv"; // Path to your CSV file

        // Call the readCsvFile method
        ArrayList<ArrayList<String>> data = csvReader.readCsvFile(filePath);

        // Print the data to verify
        int counter=0;
        while (counter<6){
            for (ArrayList<String> row : data) {
                switch (counter) {
                    case 0:
                        physicalActivity = row;
                        counter += 1;
                        break;
                    case 1:
                        mentalActivity = row;
                        counter += 1;
                        break;
                    case 2:
                        personalGrowth = row;
                        counter += 1;
                        break;
                    case 3:
                        socialActivity = row;
                        counter += 1;
                        break;
                    case 4:
                        creativePursuit = row;
                        counter += 1;
                        break;
                    case 5:
                        selfCare = row;
                        counter += 1;
                        break;

                }
            }
        }
        physicalActivity.remove(0);
        mentalActivity.remove(0);
        personalGrowth.remove(0);
        socialActivity.remove(0);
        creativePursuit.remove(0);
        selfCare.remove(0);


    }
}