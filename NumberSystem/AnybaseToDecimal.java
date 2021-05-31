package  NumberSystem;

import java.util.Scanner;

/**
 * AnybaseToDecimal
 */
public class AnybaseToDecimal {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int b = scn.nextInt();
        int d = getValueIndecimal(n, b);
        System.out.println(d);
        scn.close();
     }
    
     public static int getValueIndecimal(int n, int b){
        // expand 
        
        int val = 0;
        int power = 1;
        while(n > 0) {
            int dig = n % 10;
            n /= 10;
            
            val += dig*power;
            power = power * b;
        }
        
        return val;
     }
}