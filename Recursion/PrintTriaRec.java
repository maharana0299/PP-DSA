package Pep.Recursion;

import java.util.Scanner;

/**
 * PrintTriaRec
 */
public class PrintTriaRec {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();
        // write ur code here
        printPattern(n,"");
    }
    
    public static String printPattern(int n,String s){
        
        if(n == 0)
            return "";
        
        String st = printPattern(n-1,s);
        System.out.println(st+"*\t");
        return st+"*\t";
    }
    
}