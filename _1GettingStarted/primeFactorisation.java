package  _1GettingStarted;
import java.util.*;

public class primeFactorisation{

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
            System.out.print(i + " ");
        }
       }

       if (n != 1) {
           System.out.println(n);
       }
    }
}