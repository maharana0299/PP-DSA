package  NumberSystem;

import java.util.Scanner;

/**
 * AnyBaseMult
 */
public class AnyBaseMult {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int b = scn.nextInt();
        int n1 = scn.nextInt();
        int n2 = scn.nextInt();
    
        int d = getProduct(b, n1, n2);
        System.out.println(d);
        scn.close();
     }
    
     public static int getProduct(int b, int n1, int n2){
        
        int ms = 0;
        int p = 1;
        while(n2 > 0){
            int d = n2%10;
            n2 /= 10;
            int multWithn2 = getSingleMultiplication(n1,d,b);
            ms = getSum(ms,multWithn2*p,b);
            p *= 10;
        }


        return ms;
     }

     private static int getSingleMultiplication(int n1, int d, int b) {
        int ans = 0;
        int c = 0;
        int p = 1;

        while(n1 > 0 || c > 0){
            int dig = n1 % 10;
            n1 /= 10;
            int mtl = d * dig + c;
            c = mtl/b;
            mtl %= b;

            ans += mtl*p;
            p *= 10;
        }

        return ans;
    }

    public static int getSum(int n1, int n2, int b){
          
          int rv = 0;
          int c = 0;
          int p = 1;
          
          while(n1 > 0 || n2 > 0 || c > 0){
              int d1 = n1 % 10;
              int d2 = n2 % 10;
              n1 /= 10;
              n2 /= 10;
              
              int d = d1 + d2 + c;
              
              c = d/b;
              d = d%b;
              
              rv += d * p;
              p = p * 10;
          }
          
          return rv;
      }

}