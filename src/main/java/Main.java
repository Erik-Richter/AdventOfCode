import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> lanternfishes = loadData();

        for(int i=1; i<=80; i++){

            int len = lanternfishes.size();
            for(int iterator=0; iterator<len; iterator++){
                Integer actNo = lanternfishes.get(iterator);

                if(lanternfishes.get(iterator) == 0){
                    lanternfishes.set(iterator, 6);
                    lanternfishes.add(8);
                } else if(lanternfishes.get(iterator) > 0 && lanternfishes.get(iterator) <= 8){
                    lanternfishes.set(iterator, lanternfishes.get(iterator) -1);
                } else {
                    throw new RuntimeException("out of numbers: " + lanternfishes.get(iterator));
                }
            }
        }
        System.out.println(lanternfishes.size());
    }

    public static List<Integer> loadData(){
        String str0 = "";
        List<Integer> lanternfishes = new ArrayList<>();

        try {
            BufferedReader fr = new BufferedReader(new FileReader("src/main/resources/data/lanternfish.txt"));
            str0 = fr.readLine();
            fr.close();
        } catch (Exception e) {
            throw new RuntimeException("Failed to read file.");
        }

        String[] splitNumbers = str0.split(",");

        for(int i=0; i<splitNumbers.length; i++){
            lanternfishes.add(Integer.parseInt(splitNumbers[i]));
        }
        return lanternfishes;
    }
}
