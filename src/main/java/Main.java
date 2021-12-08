import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        List<Integer> tips = readTips();
        List<BingoTable> sheets = readBingoSheets();
        List<BingoTable> winners = new ArrayList<>();
        Set<Integer> winnerIndexes = new LinkedHashSet<>();
        int index = 0;
        int lastTip = -1;
        int winnerUnmarkedCount;

        for (Integer tip : tips) {
            for (BingoTable sheet : sheets){ // mark number on all sheet
                sheet.markNumberOnSheet(tip);
            }
            for(int i=0; i<sheets.size(); i++){
                if(sheets.get(i).isWinner()){
                    if(!winnerIndexes.contains(i)) {
                        winnerIndexes.add(i);
                        winners.add(sheets.get(i));
                        lastTip = tip;
                        index = i;
                    }
                }
            }
            if(winners.size() == sheets.size()){
                System.out.println("WIN");
                break;
            }

        }

        winnerUnmarkedCount = sheets.get(index).countUnmarkedFields();

        System.out.println("Player: " + index);
        System.out.println("with last marked number: " + lastTip);
        System.out.println("Player's Bingo sheet:\n" + winners.get(winners.size() -1));
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
