
import java.util.Scanner;
import java.util.ArrayList;
public class Main implements CsvReader{
    public static int getMinimumOrMaximumIndex(int moodRate, int value){
        if (moodRate<=2){
            return value;
        }
        else if(moodRate<=4){
            return value+3;
        }
        else if(moodRate<=6){
            return value+6;
        }
        else if(moodRate<=8){
            return value+9;
        }
        else{
            return value+12;
        }
    }

    public static void main(String args[]) {

        ArrayList<String> physicalActivity = new ArrayList<String>();
        ArrayList<String> mentalActivity = new ArrayList<String>();
        ArrayList<String> personalGrowth = new ArrayList<String>();
        ArrayList<String> socialActivity = new ArrayList<String>();
        ArrayList<String> creativePursuit = new ArrayList<String>();
        ArrayList<String> selfCare = new ArrayList<String>();
        inputVerification inputchecker = new inputVerification();
        ArrayList<Integer> indexes = new ArrayList<>();
        Scanner myScanner = new Scanner(System.in);
        System.out.println(
                "_ _ _                                 _ _ _                  \n" +
                        "( / ) )o          /                   ( / ) )     _/__/_      \n" +
                        " / / /,  _ _   __/    __ _  ,__  _     / / / __,  /  /  _  _  \n" +
                        "/ / (_(_/ / /_(_/_   (_)/ |/ (/_/ (_  / / (_(_/(_(__(__(/_/ (_\n" +
                        "                                                              "
        );
        System.out.println("Rate how you feel today on a scale of 1-10");
        int moodRating = myScanner.nextInt();
        inputchecker.mood(moodRating);
        int minimum = getMinimumOrMaximumIndex(moodRating, 1);
        int maximum = getMinimumOrMaximumIndex(moodRating, 3);

        String filePath = "BetterDays.csv"; // Path to your CSV file
        // Call the readCsvFile method
        ArrayList<ArrayList<String>> data = CsvReader.readCsvFile(filePath);
        int counter = 0;
        while (counter < 6) {
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
        moodLists physicalActivities=new moodLists(physicalActivity, minimum, maximum, indexes);
        moodLists mentalActivities=new moodLists(mentalActivity, minimum, maximum, physicalActivities.indexList);
        moodLists growthActivities=new moodLists(personalGrowth, minimum, maximum, mentalActivities.indexList);
        moodLists socialActivities=new moodLists(socialActivity, minimum, maximum, growthActivities.indexList);
        moodLists creativeActivities=new moodLists(creativePursuit, minimum, maximum, socialActivities.indexList);
        moodLists careActivities=new moodLists(selfCare, minimum, maximum, creativeActivities.indexList);

        ArrayList<Integer> points=new ArrayList<>();
        points.add(physicalActivities.getPointsValue());
        points.add(mentalActivities.getPointsValue());
        points.add(growthActivities.getPointsValue());
        points.add(socialActivities.getPointsValue());
        points.add(creativeActivities.getPointsValue());
        points.add(careActivities.getPointsValue());
        int maximumPointsValue=physicalActivities.getPointsValue()+mentalActivities.getPointsValue()+growthActivities.getPointsValue()+socialActivities.getPointsValue()+creativeActivities.getPointsValue()+careActivities.getPointsValue();
        System.out.println("Please enter your points goal for today (maximum "+maximumPointsValue+")");
        int pointsGoal= myScanner.nextInt();
        int userPoints=0;

        System.out.println(String.format("Your Suggested Activities:\n ********************** \n1. Physical Health\n%s\nPoints Value: %d\n\n2. Mental Health\n%s\nPoints Value: %d\n\n3. Self Growth\n%s\nPoints Value: %d\n\n4. Social\n%s\nPoints Value: %d\n\n5. Creativity\n%s\nPoints Value: %d\n\n6. Self Care\n%s\nPoints Value: %d\n\n",physicalActivities.getChosenValue(), physicalActivities.getPointsValue(), mentalActivities.getChosenValue(), mentalActivities.getPointsValue(), growthActivities.getChosenValue(), growthActivities.getPointsValue(), socialActivities.getChosenValue(), socialActivities.getPointsValue(), creativeActivities.getChosenValue(), creativeActivities.getPointsValue(), careActivities.getChosenValue(), careActivities.getPointsValue()));

        while(userPoints<pointsGoal){
            System.out.println("Please enter the activity number that you have completed");
            int activityIndex=myScanner.nextInt();
            userPoints+=points.get(activityIndex-1);
        }
        System.out.print("Congratulations! You have reached your goal! ");



    }


    }
