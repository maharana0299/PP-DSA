package  RecursionOnTheWayUp;

import java.util.Scanner;

/**
 * PrintSubsequence
 */
public class PrintSubsequence {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        
        printSS(s,"");
        
        sc.close();
    }

    public static void printSS(String str, String ans) {
        
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        } 
        String a = ans + str.charAt(0);
        String b = ans;
        printSS(str.substring(1),a );
        printSS(str.substring(1),b);
        
        // System.out.println(a);
        
    }

}