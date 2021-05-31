package  NumberSystem;

import java.util.Scanner;

/**
 * DecimalToAnyBase
 * b <= 10
 */
public class DecimalToAnyBase {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int b = scn.nextInt();
        int dn = getValueInBase(n, b);
        System.out.println(dn);
        scn.close();
     }
    
     public static int getValueInBase(int n, int b){
         
         int val = 0;
         int p = 1;
         while(n > 0){
             int dig = n%b;
             n /= b;
             val += dig*p;
             p = p*10;
         }
         
         return val;
     }
}