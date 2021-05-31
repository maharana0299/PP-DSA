package  NumberSystem;

import java.util.Scanner;

/**
 * AnyToAnyBase
 */
public class AnyToAnyBase {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int sourceBase = scn.nextInt();
        int  destBase= scn.nextInt();
       
        anyBaseToAnyBase(n,sourceBase,destBase);
        scn.close();
     }   
     public static void anyBaseToAnyBase(int num,int b, int d) {
          /**
           * We can change the base by 
           * First convert it into deicmal
           * then convert it into destination base
           */
          
          int val = 0;
          
          val = getValueIndecimal(num,b);
  
          System.out.println(getValueInBase(val,d));
  
      }
      
      public static int getValueIndecimal(int n, int b){
          int num = 0;
  
          int p = 0;
          while (n > 0) {
              int dig = n % 10;
              num += Math.pow(b,p) * dig; 
              p++;
              n /= 10;
              
          }
  
          return num;
      }
      
      public static int getValueInBase(int n, int b){
          int val = 0;
  
          int p =1;
          while(n > 0) {
              int dig = n%b;
              n /= b;
              val += dig * p;
              p = p * 10;
              
          }
  
          return val;
      }
}