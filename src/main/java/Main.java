import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Point> board = new ArrayList<>();
        List<Line> mainList = loadData();
        drawLinesToBoard(mainList, board);

        int counter = 0;
        for (Point point:board)
            if(point.getOccurrence() > 1)
                counter += 1;

        System.out.println(counter);
    }

    public static void drawLinesToBoard(List<Line> lines, List<Point> board){
        for(Line line:lines){
            for(int i = 0; i < line.getPoints().size(); i++){
                Point actualPoint = line.getPoints().get(i);
                if(board.contains(actualPoint)){
                    int newOccurrence = actualPoint.getOccurrence() +1;
                    int idxBoard = board.indexOf(actualPoint);
                    if(idxBoard != -1)
                        board.get(idxBoard).setOccurrence(newOccurrence);
                } else {
                    actualPoint.setOccurrence(1);
                    board.add(actualPoint);
                }
            }
        }
    }

    public static List<Line> loadData(){

        String str1;
        int x1, x2, y1, y2;
        List<Line> mainList = new ArrayList<>();

        try{
            BufferedReader br = new BufferedReader(new FileReader("src/main/resources/data/coordinates.txt"));
            while ((str1 = br.readLine()) != null){
                //System.out.println(str1);
                String[] parsedStrings = str1.split("->");
                String[] a = parsedStrings[0].trim().split(",");
                String[] b = parsedStrings[1].trim().split(",");

                x1 = Integer.parseInt(a[0]);
                y1 = Integer.parseInt(a[1]);
                x2 = Integer.parseInt(b[0]);
                y2 = Integer.parseInt(b[1]);

                if(x1 == x2 || y1 == y2)
                    mainList.add(new Line(x1, y1, x2, y2));
            }
            br.close();
        }catch (Exception e){
            System.out.println("My Main() exception");
        }
        return mainList;
    }
}
