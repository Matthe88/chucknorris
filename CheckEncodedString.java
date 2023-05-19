package chucknorris;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class CheckEncodedString {

    public static ArrayList<Boolean> check(String encodedString) {

       ArrayList<Boolean> checks = new ArrayList<>();

        String[] splitCheck = encodedString.split(" ");
        String stringLength = "";

        //Checks, if the array only consists of "0"
        for (int i = 0; i < splitCheck.length; i++) {
            if (!splitCheck[i].matches("[0]+")) {
                checks.add(false);
            }
          }

        //Checks, if every second index of Array is "0", or "00"
            for (int i = 0; i < splitCheck.length; i += 2) {
                if (!(splitCheck[i].equals("0") || splitCheck[i].equals("00"))) {
                    checks.add(false);
                }
            }

        //Check, if array is not equal
        if (splitCheck.length % 2 != 0) {
            checks.add(false);
        }

        int binary = Analyser.decoder(encodedString).length();

        //Checks, if the length of the decoded binary string is a multiple of 7.
        if(binary %7 != 0){
            checks.add(false);
        }

        return checks;
    }
}


