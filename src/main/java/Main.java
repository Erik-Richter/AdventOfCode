import java.util.List;

public class Main {
    public static void main(String[] args) {

        Line line = new Line(5, 5, 8, 2);
        //System.out.println(line);
        for (Point lineElement:line.getPoints()){
            System.out.println(lineElement);
        }
    }
}
