import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Point {
    private int x;
    private int y;

    @Override
    public String toString() {
        return x + ", " + y;
    }
}
