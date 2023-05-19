package chucknorris;

import java.util.ArrayList;
import java.util.Scanner;

public class GUI {

    public static void start() {


        while (true) {

            System.out.println("Please input operation (encode/decode/exit):");
            Scanner reader = new Scanner(System.in);
            String eingabe = reader.nextLine();

            //Encodes your text into a series of 0 and " "
            if (eingabe.equals("encode")) {
                System.out.println("Input string:");
                String stringEncode = reader.nextLine();
                String binary = Analyser.convertToBinary(stringEncode);
                String encodedString = Analyser.zeroEncryption(binary);
                System.out.println("Encoded string: \n" + encodedString);
                System.out.println();
            }

            //Decodes the series of "0" and " " in plain text, if it passes some conditions
            if (eingabe.equals("decode")) {
                System.out.println("Input encoded string:");
                String decodedString = reader.nextLine();
                ArrayList<Boolean> CheckEncodedString = chucknorris.CheckEncodedString.check(decodedString); //Check conditions

                if (CheckEncodedString.contains(false)) {
                    System.out.println("Encoded string is not valid");
                } else {
                    String binary = Analyser.decoder(decodedString); //Decode binary into plain text
                    String plainText = Analyser.makePlainText(binary);
                    System.out.println("Decoded string:");
                    System.out.println(plainText);
                    System.out.println();
                }
            }

            if (!(eingabe.equals("encode") || eingabe.equals("decode") || eingabe.equals("exit"))) { //Input NOT "encode", NOT "decode" and NOT exit
                System.out.println("There is no " + "'" + eingabe + "'" + " operation.");
                System.out.println();
            }

            if (eingabe.equals("exit")) {
                System.out.println("Bye!");
                break;
            }
        }
    }
}

