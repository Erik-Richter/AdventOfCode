import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> tips = readTips();
        List<BingoTable> sheets = readBingoSheets();
        //System.out.println(tips);
        //System.out.println(sheets);
        int index = 0;
        int lastTip = -1;
        int winnerUnmarkedCount;

        boolean win = false;

        for (Integer tip : tips) {
            for (BingoTable sheet : sheets){
                sheet.markNumberOnSheet(tip);
            }
            for (int i=0; i<sheets.size(); i++){
                if(sheets.get(i).isWinner()){
                    win = true;
                    index = i;
                    lastTip = tip;
                }
            }
            if(win){
                System.out.println("win");
                break;
            }
        }

        winnerUnmarkedCount = sheets.get(index).countUnmarkedFields();

        System.out.println("Player: " + index);
        System.out.println("with last marked number: " + lastTip);
        System.out.println("Player's Bingo sheet:\n" + sheets.get(index));
        System.out.println("AoC result: " + (winnerUnmarkedCount * lastTip));
    }

    public static List<Integer> readTips(){
        List<Integer> numbers = new ArrayList<>();
        String str0 = "";
        try {
            BufferedReader fr = new BufferedReader(new FileReader("src/main/resources/data/bingo.txt"));
            str0 = fr.readLine();
            fr.close();
        } catch (Exception e) {
            System.out.println("CAN NOT READ THE FIRST ROW\n");
        }

        // save the numbers
        String[] tokens = str0.split(",");
        for (String token : tokens) {
            numbers.add(Integer.parseInt(token));
        }
        return numbers;
    }

    public static List<BingoTable> readBingoSheets(){
        String str1;
        try {
            int cnt = 0;
            List<BingoTable> sheets = new ArrayList<>();
            BingoTable bingoTable = new BingoTable();
            BufferedReader br = new BufferedReader(new FileReader("src/main/resources/data/bingo.txt"));
            while ((str1 = br.readLine()) != null) {
                if(!str1.contains(",")){
                    if(str1.trim().equals("")){
                        bingoTable = new BingoTable();
                        cnt = 0;
                    }

                    String[] parsedStrings = str1.split("\\s+");
                    if(cnt == 0 && parsedStrings.length>1){
                        for (String parsedString : parsedStrings) {
                            if(!parsedString.equals(""))
                                bingoTable.getRow1().add(new NumberMark(Integer.parseInt(parsedString), false));
                        }
                    }
                    if(cnt == 1 && parsedStrings.length>1){
                        for (String parsedString : parsedStrings) {
                            if(!parsedString.equals(""))
                                bingoTable.getRow2().add(new NumberMark(Integer.parseInt(parsedString), false));
                        }
                    }
                    if(cnt == 2 && parsedStrings.length>1){
                        for (String parsedString : parsedStrings) {
                            if(!parsedString.equals(""))
                                bingoTable.getRow3().add(new NumberMark(Integer.parseInt(parsedString), false));
                        }
                    }
                    if(cnt == 3){
                        for (String parsedString : parsedStrings) {
                            if(!parsedString.equals(""))
                                bingoTable.getRow4().add(new NumberMark(Integer.parseInt(parsedString), false));
                        }
                    }
                    if(cnt == 4){
                        for (String parsedString : parsedStrings)
                            if(!parsedString.equals("")){
                                bingoTable.getRow5().add(new NumberMark(Integer.parseInt(parsedString), false));
                            }
                    }

                    if(parsedStrings.length>1){
                        cnt++;
                    }
                    if(cnt == 5){
                        sheets.add(bingoTable);
                    }

                }
            }
            br.close();
            return sheets;
        } catch (Exception e) {
            System.out.println("CAN NOT READ THE BINGO TABLES\n");
            return null;
        }
    }

}
