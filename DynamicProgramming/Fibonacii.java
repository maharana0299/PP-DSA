package DynamicProgramming;

import java.util.Scanner;

public class Fibonacii {
    
    static Integer qb[]; //  size n+1
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        qb = new Integer[n+1];
        int f = fib(n,qb);
        System.out.println(f);
        sc.close();
    }

    // dp using memoization
    static int fib(int n, Integer[] qb) {
     
        if(n == 0 || n == 1) 
           return qb[n] = n;
        
        if(qb[n] != null)
           return qb[n];
        return qb[n] = fib(n-1,qb) + fib(n-2,qb);
    }

    // using tabulation
    static void fibTab(int n) {

        // meaning -> stores the fib (i)
        int dp[] = new int[n+1];

        dp[0] = 0; // fib(0) is 0
        dp[1] = 1; // fub(1) is 1
        for(int i = 2; i <= n; i++) {
            // fib(i) = fib(i-1) + fib(i-2);
            dp[i] = dp[i-1] + dp[i-2];
        }
    }
   
}
