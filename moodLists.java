import java.util.ArrayList;



public class moodLists {
    protected ArrayList<String> activityList;
    protected int minIndex;
    protected int maxIndex;
    protected ArrayList<Integer> indexList;
    private String chosenValue;
    private Integer pointsValue;

    public moodLists(ArrayList<String> activityList, int minIndex, int maxIndex, ArrayList<Integer> indexList){
        this.activityList=activityList;
        this.minIndex=minIndex;
        this.maxIndex=maxIndex;
        this.indexList=indexList;
        int randomIndex = (int)(Math.random() * ((maxIndex - minIndex) + 1)) + minIndex;
        indexList.add(randomIndex);
        this.chosenValue=activityList.get(randomIndex);
        Integer pointsValue=null;
        if (randomIndex-minIndex==0){
            this.pointsValue=1;
        }
        else if (randomIndex-minIndex==1){
            this.pointsValue=3;
        }
        else{
            this.pointsValue=5;
        }

    }
    public ArrayList<Integer> getIndexList() {
        return indexList;
    }

    public String getChosenValue() {
        return chosenValue;
    }

    public Integer getPointsValue() {
        return pointsValue;
    }
    }
