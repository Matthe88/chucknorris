package chucknorris;

import com.sun.jdi.Value;

import java.util.ArrayList;

public class Analyser {

    private String text;
    private String returnwert;

    public String getReturnwert() {
        return returnwert;
    }

    public void analysedText(String text) {
        for (int i = 0; i < text.length(); i++) {
            System.out.println(text.charAt(i));

        }
    }

    public static String convertToBinary(String text) {

        String binary = "";
        for (int i = 0; i < text.length(); i++) {
            binary += String.format("%7s", Integer.toBinaryString(text.charAt(i))).replace(" ", "0");

        }

        return binary;
    }


    public static String zeroEncryption(String binary) {

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < binary.length(); i++) {

            int count = 1;
            while (i + 1 < binary.length()
                    && binary.charAt(i)
                    == binary.charAt(i + 1)) {
                i++;
                count++;
            }

            if (binary.charAt(i) == '0') {
                builder.append("00 ");


                for (int j = 1; j <= count; j++) {
                    builder.append("0");


                    if (j == count) {
                        builder.append(" ");

                    }
                }
            }

            if (binary.charAt(i) == '1') {
                builder.append("0 ");


                for (int j = 1; j <= count; j++) {
                    builder.append("0");


                    if (j == count) {
                        builder.append(" ");

                    }

                }

            }

        }
        String returnWert = String.valueOf(builder);

        return returnWert;
    }

    public static String decoder(String code) {

        String binary = "";

        String[] split = code.split(" ");

        for (int i = 0; i < split.length; i++) {

            int countOne = 0;

            if (split[i].equals("0")) {

                if (i + 1 > split.length) {
                    countOne = 0;
                }

                if (i + 1 < split.length) {
                    countOne = split[i + 1].length();

                }

                for (int j = 0; j < countOne; j++) {
                    binary += "1";
                }
            }

            int countZero = 0;

            if (split[i].equals("00")) {

                if (i + 1 > split.length) {
                    countZero = 0;

                }

                if (i + 1 < split.length) {
                    countZero = split[i + 1].length();
                }

                for (int j = 0; j < countZero; j++) {
                    binary += "0";
                }
            }
            i++;
        }
        return binary;
    }

    public static String makePlainText(String binary) {

        ArrayList<String> list = new ArrayList<>();
        String returnString = "";

        int start = 0;
        int end = 7;

        while (end <= binary.length()) {
            list.add(binary.substring(start, end));
            start = end;
            end = start + 7;
        }

        StringBuilder str = new StringBuilder();

        for (int i = 0; i < list.size(); i++) {
            str.append(list.get(i));
            int charCode = Integer.parseInt(list.get(i), 2);
            char asciiToChar = (char) charCode;
            returnString += asciiToChar;
        }
        return returnString;
    }
}



