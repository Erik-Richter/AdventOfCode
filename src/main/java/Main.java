import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Population population = loadDta();
        System.out.println(population);

        for(int i=1; i<=256; i++){
            long new0, new1, new2, new3, new4, new5, new6, new7, new8;

            new8 = population.getDay0();
            new6 = population.getDay0();

            new0 = population.getDay1();
            new1 = population.getDay2();
            new2 = population.getDay3();
            new3 = population.getDay4();
            new4 = population.getDay5();
            new5 = population.getDay6();
            new6 = new6 + population.getDay7();
            new7 = population.getDay8();

            population = new Population(new0, new1, new2, new3, new4, new5, new6, new7, new8);
        }

        System.out.println(population.countPopulation());
    }

    public static List<Integer> readInput(){
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

    public static Population loadDta(){
        List<Integer> lanternfishes = readInput();
        Population population = new Population();

        System.out.println(population);


        for(Integer lantnerfish : lanternfishes){
            switch (lantnerfish){
                case 0: population.setDay0(population.getDay0() +1); break;
                case 1: population.setDay1(population.getDay1() +1); break;
                case 2: population.setDay2(population.getDay2() +1); break;
                case 3: population.setDay3(population.getDay3() +1); break;
                case 4: population.setDay4(population.getDay4() +1); break;
                case 5: population.setDay5(population.getDay5() +1); break;
                case 6: population.setDay6(population.getDay6() +1); break;
                case 7: population.setDay7(population.getDay7() +1); break;
                case 8: population.setDay8(population.getDay8() +1); break;
                default: throw new RuntimeException("Wrong number");
            }
        }
        return population;
    }
}
