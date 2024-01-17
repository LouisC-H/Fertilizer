import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MapMaster {

    private long[] seedNums;
    long smallestLocationNum = Integer.MAX_VALUE;

    private boolean newPara = true;

    private SingleMap[] mapList = new SingleMap[7];

    public MapMaster() {
        for (int i = 0; i < 7; i++) {
            this.mapList[i] = new SingleMap();
        }
    }

    public void newLineRead(String inputData, Integer paragraphNumber) {
        if (paragraphNumber == -1){
            firstLineInput(inputData);
        } else if (newPara){
            this.newPara = false;
        } else {
            mapList[paragraphNumber].newLine(inputData);
        }
    }

    public void setNewPara(boolean newPara) {
        this.newPara = newPara;
    }

    private void firstLineInput(String inputData) {
        String[] headerAndData = inputData.split(":");
        String[] seedNumStrings = headerAndData[1].split(" ");
        this.seedNums = new long[seedNumStrings.length-1];
        for (int i = 1; i < seedNumStrings.length; i++) {
            this.seedNums[i-1] = Long.parseLong(seedNumStrings[i]);
        }
    }
    public void sendSeeds(){
        for (int i = 0; i < seedNums.length; i+= 2) {
            System.out.println("New seed number pair :");
            System.out.println(seedNums[i]);
            System.out.println(seedNums[i+1]);
            for (long j = seedNums[i]; j < seedNums[i]+seedNums[i+1] ; j++) {
                long currentNum = j;
                for (SingleMap map : mapList) {
                    currentNum = map.mapNumber(currentNum);
                }
                if (currentNum < smallestLocationNum){
                    this.smallestLocationNum = currentNum;
                    System.out.println(smallestLocationNum);
                }
            }
        }
        System.out.println(smallestLocationNum);
    }
}
