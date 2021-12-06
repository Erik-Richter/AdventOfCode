import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        String str0;
        int no0O2, no1O2;
        int no0CO2, no1CO2;
        int result;
        String prefixO2 = "", prefixCO2 = "";
        List<String> codesToRemoveO2 = new ArrayList<>();
        List<String> codesToRemoveCO2 = new ArrayList<>();
        int checkerO2 = 0, checkerCO2 = 0;

        List<String> codesO2 = new ArrayList<>();
        List<String> codesCO2 = new ArrayList<>();
        try {
            BufferedReader fr = new BufferedReader(new FileReader("C:\\Users\\richt\\Desktop\\AdventOfCode2021\\Day3\\src\\main\\resources\\data\\diagnostic.txt"));
            while ((str0 = fr.readLine()) != null) {
                codesO2.add(str0);
                codesCO2.add(str0);
            }
            fr.close();
        } catch (Exception e) {
            System.out.println("EXCEPTION");
        }

        for (int i = 0; i < 12; i++) {
            no0O2 = 0;
            no1O2 = 0;
            no0CO2 = 0;
            no1CO2 = 0;

            for (String actO2 : codesO2) {

                result = gammaBit(actO2, i);
                if (result == 1) no1O2 += 1;
                if (result == 0) no0O2 += 1;
            }
            for (String actCO2 : codesCO2) {

                result = gammaBit(actCO2, i);
                if (result == 1) no1CO2 += 1;
                if (result == 0) no0CO2 += 1;
            }

            if (no0O2 != 0 && no1O2 != 0) {
                prefixO2 += addBit(no0O2, no1O2, true);

                for (String codeO2 : codesO2) {
                    if (!codeO2.startsWith(prefixO2)) {
                        codesToRemoveO2.add(codeO2);
                    }
                }
                codesO2.removeAll(codesToRemoveO2);
            } else {
                if (no0O2 == 0) prefixO2 += "1";
                if (no1O2 == 0) prefixO2 += "0";

                // nothing to remove
            }
            if (no0CO2 != 0 && no1CO2 != 0) {
                prefixCO2 += addBit(no0CO2, no1CO2, false);

                for (String codeCO2 : codesCO2) {
                    if (!codeCO2.startsWith(prefixCO2))
                        codesToRemoveCO2.add(codeCO2);
                }
                codesCO2.removeAll(codesToRemoveCO2);
            } else {
                if (no0CO2 == 0) prefixCO2 += "1";
                if (no1CO2 == 0) prefixCO2 += "0";

                // nothing to remove
            }
            codesToRemoveO2.clear();
            codesToRemoveCO2.clear();

            if (codesO2.size() == 1 && checkerO2 == 0) {
                System.out.println(codesO2.get(0));
                checkerO2++;
            }
            if (codesCO2.size() == 1 && checkerCO2 == 0) {
                System.out.println(codesCO2.get(0));
                checkerCO2++;
            }
        }
    }

    public static int gammaBit(String binary, int index) {
        char result = binary.charAt(index);
        return Character.getNumericValue(result);
    }

    // boolean type = true for O2
    // boolean type = false for CO2
    public static String addBit(int no0, int no1, boolean type) {
        String prefix = "";
        if (no1 >= no0) prefix += "1";
        if (no0 > no1) prefix += "0";
        if (!type && prefix.equals("1")) return "0";
        else if (!type) return "1";

        return prefix;
    }

}
