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

        if(x1<x2 && y1>y2){
            for(int i=x1; i<getAbsValue(x1, x2) + x1 +1; i++){
                for(int j=y1; j>getAbsValue(y1, y2) - y2; j--){
                    getPoints().add(new Point(i, j));
                }
            }
        }
    }

    public static int getAbsValue(int a, int b){
        return Math.abs(a-b);
    }

    @Override
    public String toString() {
        return points + "";
    }
}
