import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> crabs = readInput();
        int leastFuel = -1;

        for(int i=0; i<crabs.size(); i++){

            int costFuel = 0;
            for(Integer crab:crabs)
                costFuel += crabConsumption(crab, crabs.get(i));

            if(costFuel<leastFuel || leastFuel==-1)
                leastFuel = costFuel;
        }
        System.out.println(leastFuel);
    }

    public static List<Integer> readInput(){
        String str0 = "";
        List<Integer> crabs = new ArrayList<>();

        try {
            BufferedReader fr = new BufferedReader(new FileReader("src/main/resources/data/crabs.txt"));
            str0 = fr.readLine();
            fr.close();
        } catch (Exception e) {
            throw new RuntimeException("Failed to read file.");
        }
        String[] splitNumbers = str0.split(",");
        for (String splitNumber : splitNumbers) crabs.add(Integer.parseInt(splitNumber));

        return crabs;
    }

    public static int crabConsumption(int a, int b){
        int distance = Math.abs(a-b);
        int result = 0;
        while(distance != 0){
            result = result + distance;
            distance--;
        }
        return result;
    }
}
