package  _1GettingStarted;

import java.util.Scanner;

public class l01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        printFactors(n);
        sc.close();
    }

    private static void printFactors(int n) {

       // if not prime then print factors
       // else print  number itself

       for (int i = 2; i * i <= n; i++) {

        while (n % i == 0) {
            n /= i;
            System.out.println(i);
        }
       }

       if (n != 1) {
           System.out.println(n);
       }
    }

    public static void benjaminBulbs(int n) {

        for (int i = 1; i <= n; i++) {
            if (!isPrime(i))
                System.out.println(i);
                
        }
    }
     
    public static void printPrimes(int low,int high) {
      
        for (int i = low; i <= high; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }
     }
     
    public static boolean isPrime(int n) {
         
         if (n == 1)
          return false;
         for (int i = 2; i*i <= n; i++) {
             if ( n % i == 0)
              return false;
         }
         
         return true;
     }

}