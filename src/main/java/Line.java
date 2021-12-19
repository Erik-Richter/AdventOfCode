import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Line {
    private List<Point> points = new ArrayList<>();

    public Line() {}

    public Line(int x1, int y1, int x2, int y2) {
        this.points = new ArrayList<>();

        if(x1 == x2 && y1 == y2) getPoints().add(new Point(x1, y1));

        if (x1 < x2 && y1 >= y2) {
            for (int i=0; i<getAbsValue(x1, x2) +1; i++) {
                for (int j=0; j<getAbsValue(y1, y2) +1; j++) {
                    getPoints().add(new Point(x1 +i, y2 +j));
                }
            }
        } else if (x1 <= x2 && y1 < y2) { // (x1 <= x2 && y1 < y2)
            for(int i=0; i<getAbsValue(x1, x2) +1; i++){
                for(int j=0; j<getAbsValue(y1, y2) +1; j++){
                    getPoints().add(new Point(x1 +i, y1 +j));
                }
            }
        } else if (x1 > x2 && y1 <= y2){
            for(int i=0; i<getAbsValue(x1, x2) +1; i++){
                for(int j=0; j<getAbsValue(y1, y2) +1; j++){
                    getPoints().add(new Point(x2 +i, y1 +j));
                }
            }
        } else if (x1 >= x2 && y1 > y2){
            for(int i=0; i<getAbsValue(x1, x2) +1; i++){
                for(int j=0; j<getAbsValue(y1, y2) +1; j++){
                    getPoints().add(new Point(x2 +i, y2 +j));
                }
            }
        } else {
            System.out.println("ELSE!");
            throw new IllegalStateException("ElSE");
        }
    }
    // TODO: getPoints().add(new Point(x2 +i, y2 +j));
    public static int getAbsValue(int a, int b){
        return Math.abs(a-b);
    }

    @Override
    public String toString() {
        return points + "";
    }
}
