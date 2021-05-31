package  RecursionOnTheWayUp;

import java.util.Scanner;

/**
 * PrintKPC
 */
public class PrintKPC {

    static String [] keys = {".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        
        printKPC(s,"");
        
        sc.close();
    }

    private static void printKPC(String s, String asf) {

        if(s.length() == 0) {
            System.out.println(asf);
            return;
        }

        int key = s.charAt(0) - '0';

        for(int i = 0; i < keys[key].length(); i++) {

            char ch = keys[key].charAt(i);

            printKPC(s.substring(1), asf + ch);
        }
    }
}