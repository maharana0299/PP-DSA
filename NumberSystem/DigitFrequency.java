package  NumberSystem;

import java.util.Scanner;

/**
 * DigitFrequency
 */
public class DigitFrequency {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int d = scn.nextInt();
        int f = getDigitFrequency(n, d);
        System.out.println(f);
        scn.close();
    }

    public static int getDigitFrequency(int n, int d) {
        
        if(n == 0)
            return 0;
        if(n %10 == d){
            return 1 + getDigitFrequency(n/10,d);
        } 
        
        return getDigitFrequency(n/10,d);
    }
}