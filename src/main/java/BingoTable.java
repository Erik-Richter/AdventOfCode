import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class BingoTable {
    List<NumberMark> row1 = new ArrayList<>();
    List<NumberMark> row2 = new ArrayList<>();
    List<NumberMark> row3 = new ArrayList<>();
    List<NumberMark> row4 = new ArrayList<>();
    List<NumberMark> row5 = new ArrayList<>();

    public boolean isWinner() {
        int horizontal1 = 0;
        int horizontal2 = 0;
        int horizontal3 = 0;
        int horizontal4 = 0;
        int horizontal5 = 0;

        for(NumberMark numberMark:this.row1){
            if(numberMark.marked) {
                horizontal1++;
            }
        }
        for(NumberMark numberMark:this.row2){
            if(numberMark.marked) {
                horizontal2++;
            }
        }
        for(NumberMark numberMark:this.row3){
            if(numberMark.marked) {
                horizontal3++;
            }
        }
        for(NumberMark numberMark:this.row4){
            if(numberMark.marked) {
                horizontal4++;
            }
        }
        for(NumberMark numberMark:this.row5){
            if(numberMark.marked) {
                horizontal5++;
            }
        }

        for (int i=0; i<row1.size(); i++){
            if(
                    this.row1.get(i).isMarked() &&
                    this.row2.get(i).isMarked() &&
                    this.row3.get(i).isMarked() &&
                    this.row4.get(i).isMarked() &&
                    this.row5.get(i).isMarked()
            ){
                return true;
            }
        }

        return horizontal1 == 5 || horizontal2 == 5 || horizontal3 == 5 || horizontal4 == 5 || horizontal5 == 5;
    }

    public void unmarkAll(){
        for(NumberMark numberMark:this.row1){
            numberMark.setMarked(false);
        }
        for(NumberMark numberMark:this.row2){
            numberMark.setMarked(false);
        }
        for(NumberMark numberMark:this.row3){
            numberMark.setMarked(false);
        }
        for(NumberMark numberMark:this.row4){
            numberMark.setMarked(false);
        }
        for(NumberMark numberMark:this.row5){
            numberMark.setMarked(false);
        }
    }

    public void markNumberOnSheet(int number){
        for(NumberMark numberMark:this.row1){
            if(numberMark.getNumber() == number)
                numberMark.setMarked(true);
        }
        for(NumberMark numberMark:this.row2){
            if(numberMark.getNumber() == number)
                numberMark.setMarked(true);
        }
        for(NumberMark numberMark:this.row3){
            if(numberMark.getNumber() == number)
                numberMark.setMarked(true);
        }
        for(NumberMark numberMark:this.row4){
            if(numberMark.getNumber() == number)
                numberMark.setMarked(true);
        }
        for(NumberMark numberMark:this.row5){
            if(numberMark.getNumber() == number)
                numberMark.setMarked(true);
        }
    }

    @Override
    public String toString() {
        return
                        row1 + "\n" +
                        row2 + "\n" +
                        row3 + "\n" +
                        row4 + "\n" +
                        row5 + "\n"
                ;
    }

    public int countUnmarkedFields(){

        int umc = 0;

        for(NumberMark numberMark : row1){
            if(!numberMark.isMarked()){
                umc += numberMark.getNumber();
            }
        }
        for(NumberMark numberMark : row2){
            if(!numberMark.isMarked()){
                umc += numberMark.getNumber();
            }
        }
        for(NumberMark numberMark : row3){
            if(!numberMark.isMarked()){
                umc += numberMark.getNumber();
            }
        }
        for(NumberMark numberMark : row4){
            if(!numberMark.isMarked()){
                umc += numberMark.getNumber();
            }
        }
        for(NumberMark numberMark : row5){
            if(!numberMark.isMarked()){
                umc += numberMark.getNumber();
            }
        }
        return umc;
    }
}
