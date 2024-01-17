import java.util.ArrayList;
import java.util.Collections;

public class SingleMap {

    private ArrayList<SingleLine> dataList = new ArrayList<>();

    private boolean isOrdered = false;

    public void newLine(String inputData) {
        String[] numberSplit = inputData.split(" ");
        this.dataList.add(new SingleLine(numberSplit));
    }

    public long mapNumber(long input){
        if (!isOrdered){
            Collections.sort(this.dataList);
            isOrdered = true;
        }
        for (SingleLine potentialMapping: dataList) {
            if (input < potentialMapping.getSrcRangeStart()){
                return input;
            } else if (input < potentialMapping.getSrcRangeEnd()){
                return input + potentialMapping.getOffset();
            }
        }
        return input;
    }
}
