import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NumberMark {

    Integer number;
    boolean marked;

    @Override
    public String toString() {
        return number + "" + marked;
    }
}
