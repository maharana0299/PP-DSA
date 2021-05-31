package  NumberSystem;

import java.util.Scanner;

/**
 * AnyBaseSub
 */
public class AnyBaseSub {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int b = scn.nextInt();
        int n1 = scn.nextInt();
        int n2 = scn.nextInt();
    
        int d = getDifference(b, n1, n2);
        System.out.println(d);

        scn.close();
     }
    
    public static int getDifference(int b, int n1, int n2){
        
        int rv = 0;
        int bo = 0;
        int p = 1;
        
        while(n1 > 0 || n2 > 0) {
            
            int d1 = n1 % 10;
            int d2 = n2 % 10;
            n1 /= 10;
            n2 /= 10;
            
            int diff = d2 - d1  - bo;
            
            if(diff < 0) {
                bo = 1;
                diff += b;
            }else{
                bo = 0;
            }
            
            rv += diff*p;
            p *= 10;
        }
        
        return rv;
    }
}