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

        if(x1 == x2 || y1 == y2) {
            if (x1 < x2 && y1 >= y2) {
                for (int i = 0; i < getAbsValue(x1, x2) + 1; i++) {
                    for (int j = 0; j < getAbsValue(y1, y2) + 1; j++) {
                        getPoints().add(new Point(x1 + i, y2 + j));
                    }
                }
            } else if (x1 <= x2 && y1 < y2) { // (x1 <= x2 && y1 < y2)
                for (int i = 0; i < getAbsValue(x1, x2) + 1; i++) {
                    for (int j = 0; j < getAbsValue(y1, y2) + 1; j++) {
                        getPoints().add(new Point(x1 + i, y1 + j));
                    }
                }
            } else if (x1 > x2 && y1 <= y2) {
                for (int i = 0; i < getAbsValue(x1, x2) + 1; i++) {
                    for (int j = 0; j < getAbsValue(y1, y2) + 1; j++) {
                        getPoints().add(new Point(x2 + i, y1 + j));
                    }
                }
            } else if (x1 >= x2 && y1 > y2) {
                for (int i = 0; i < getAbsValue(x1, x2) + 1; i++) {
                    for (int j = 0; j < getAbsValue(y1, y2) + 1; j++) {
                        getPoints().add(new Point(x2 + i, y2 + j));
                    }
                }
            } else {
                System.out.println("ELSE!");
                throw new IllegalStateException("ElSE");
            }
        } else if(getAbsValue(x1, x2) == getAbsValue(y1, y2)) { // 45 degree line

            int a = 0;
            int b = 0;

            if(x1 < x2 && y1 > y2){         // up-right
                a = x1 -1;
                b = y1 +1;
                while (a!=x2 && b!=y2){
                    a += 1;
                    b -= 1;
                    getPoints().add(new Point(a, b));
                }
            } else if(x1 > x2 && y1 < y2) { // down-left
                a = x1 +1;
                b = y1 -1;
                while (a!=x2 && b!=y2){
                    a -= 1;
                    b += 1;
                    getPoints().add(new Point(a, b));
                }
            } else if(x1 < x2 && y1 < y2) { // down-right
                a = x1 -1;
                b = y1 -1;
                while (a!=x2 && b!=y2){
                    a += 1;
                    b += 1;
                    getPoints().add(new Point(a, b));
                }
            } else if(x1 > x2 && y1 > y2) { // up-left
                a = x1 +1;
                b = y1 +1;
                while (a!=x2 && b!=y2){
                    a -= 1;
                    b -= 1;
                    getPoints().add(new Point(a, b));
                }
            } else {
                throw new IllegalStateException("this line should not exist");
            }
        } else {
            throw new RuntimeException("found non horizontal, vertical or diagonal line");
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
