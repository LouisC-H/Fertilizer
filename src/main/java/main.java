import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;

public class main {

        public static void main(String[] args)
    {
        MapMaster mapModel = new MapMaster();
        Integer paragraphNumber = -1;
        try {
//            File myObj = new File("src/main/resources/test.txt");
            File myObj = new File("src/main/resources/input.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String wholeData = myReader.nextLine();
                if (Objects.equals(wholeData, "")){
                    paragraphNumber++;
                    mapModel.setNewPara(true);
                } else {
                    mapModel.newLineRead(wholeData, paragraphNumber);
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        mapModel.sendSeeds();
    }
}
