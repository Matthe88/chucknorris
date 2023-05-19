package chucknorris;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class CheckEncodedString {

    public static ArrayList<Boolean> check(String encodedString) {

       ArrayList<Boolean> checks = new ArrayList<>();

        String[] splitCheck = encodedString.split(" ");
        String stringLength = "";

        for (int i = 0; i<splitCheck.length;i++) {
            stringLength+=splitCheck[i];
        }


        for (int i = 0; i < splitCheck.length; i++) {

            if (splitCheck[i].matches("[0]+")) {
               checks.add(true);
            } else {
                checks.add(false);
            }
          }



            for (int i = 0; i < splitCheck.length; i += 2) {
                if ((splitCheck[i].equals("0") || splitCheck[i].equals("00"))) {
                    checks.add(true);
                } else {
                    checks.add(false);
                }
            }


        if (splitCheck.length+1 % 2 != 0) {
            checks.add(true);
        } else {
            checks.add(false);
        }

        String text = Analyser.decoder(encodedString);
        int binary = Analyser.convertToBinary(text).length();


        if(binary %7 == 0 && !(text.equals(""))){
            checks.add(true);
        } else {
            checks.add(false);
        }

        return checks;

    }
}


