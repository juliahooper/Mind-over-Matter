import java.util.ArrayList;
import java.util.Collections;


public class moodLists {
    public ArrayList<String> activityList;
    public int minIndex;
    public int maxIndex;

    public moodLists(ArrayList<String> activityList, int minIndex, int maxIndex){
        this.activityList=activityList;
        this.minIndex=minIndex;
        this.maxIndex=maxIndex;
        ArrayList<Integer> indexList = new ArrayList<>();
        int randomIndex = (int)(Math.random() * ((maxIndex - minIndex) + 1)) + minIndex;
        indexList.add(randomIndex);
        boolean validIndex=false;
        while (validIndex!=true){
            for (int i:indexList){
                if (Collections.frequency(indexList, randomIndex)>1){
                    randomIndex = (int)(Math.random() * ((maxIndex - minIndex) + 1)) + minIndex;
                }
                else{
                    validIndex=true;
                }
            }
        }
        String chosenValue=activityList.get(randomIndex);
        ArrayList<String> suggestionsList = new ArrayList<>();
        suggestionsList.add(chosenValue);
        Integer pointsValue=null;



        if (randomIndex-minIndex==0){
            pointsValue=1;
        }
        else if (randomIndex-minIndex<=2){
            pointsValue=3;
        }
        else{
            pointsValue=5;
        }
        ArrayList<Integer> pointsList = new ArrayList<>();
        pointsList.add(pointsValue);
    }



    }
