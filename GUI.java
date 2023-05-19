package chucknorris;

import java.util.ArrayList;
import java.util.Scanner;

public class GUI {

    public static void start() {



        while (true) {

            System.out.println("Please input operation (encode/decode/exit):");
            Scanner reader = new Scanner(System.in);
            String eingabe = reader.nextLine();

            if (eingabe.equals("encode")) {
                System.out.println("Input string:");
                String stringEncode = reader.nextLine();
                String binary = Analyser.convertToBinary(stringEncode);
                String encodedString = Analyser.zeroEncryption(binary);
                System.out.println("Encoded string: \n" + encodedString);
                System.out.println();

            }

            if (eingabe.equals("decode")) {
                System.out.println("Input encoded string:");
                String decodedString = reader.nextLine();

                ArrayList<Boolean> okNotOk = CheckEncodedString.check(decodedString);

                if (okNotOk.contains(false)){
                    System.out.println("Encoded string is not valid.");
                    System.out.println();
                } else {
                    String decoded = Analyser.decoder(decodedString);
                    System.out.println("Decoded string: \n" + decoded);
                    System.out.println();
                }
            }

            if (eingabe.equals("exit")) {
                System.out.println("Bye!");
                break;
            }

            if (!(eingabe.equals("encode")||eingabe.equals("decode")|| eingabe.equals("exit"))) {
                System.out.println("There is no " + "'" + eingabe + "'" + " operation.");
                System.out.println();

            }


        }


    }


}
