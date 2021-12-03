import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try{

            String str;
            int no0 = 0;
            int no1 = 0;
            int result;
            String gamma = "";
            String epsilon = "";


            //int i = 1;
            for(int i=0; i<12; i++){
                no0 = 0;
                no1 = 0;

                BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\richt\\Desktop\\AdventOfCode2021\\Day3\\src\\main\\resources\\data\\diagnostic.txt"));
                while((str = br.readLine()) != null){

                    result = gammaBit(str, i);
                    if(result == 1) no1 += 1;
                    if(result == 0) no0 += 1;
                }

                if(no0 > no1){
                    gamma = gamma + "0";
                    epsilon = epsilon + "1";
                }
                if(no1 > no0){
                    gamma = gamma + "1";
                    epsilon = epsilon + "0";
                }
                br.close();
            }
            System.out.println("Gamma:   " + gamma);
            System.out.println("Epsilon: " + epsilon);


        }catch (Exception e){
            System.out.println("EXCEPTION");
        }
    }

    public static int gammaBit(String binary, int index){
        char result = binary.charAt(index);
        return Character.getNumericValue(result);
    }
}
