import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Population {

    private long day0;
    private long day1;
    private long day2;
    private long day3;
    private long day4;
    private long day5;
    private long day6;
    private long day7;
    private long day8;

    public Population() {
        this.day0 = 0;
        this.day1 = 0;
        this.day2 = 0;
        this.day3 = 0;
        this.day4 = 0;
        this.day5 = 0;
        this.day6 = 0;
        this.day7 = 0;
        this.day8 = 0;
    }

    public long countPopulation(){
        return day0 + day1 + day2 + day3 + day4 + day5 + day6 + day7 + day8;
    }
}
