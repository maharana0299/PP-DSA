package DynamicProgramming;

import java.util.Scanner;

public class ClimbStairs {
    
    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        // memoize it 
        // int[] mem = new int[n+1];
        // System.out.println(climbStair(n,mem));
        System.out.println(tabclim(n));
    }
    
    // using tabulation
    static int tabclim(int n) {
        
        // stores the ways to go to ith stair form 0th stair
        int dp[] = new int[n+1];
        
        // one way possible -> dont go
        dp[0] = 1;
        
        for(int i = 1; i <= n; i++) {
            
            if(i-1 >= 0){
                dp[i] += dp[i-1];
            } 
            if(i-2 >= 0) {
                dp[i] += dp[i-2];
            }
            if(i-3 >= 0){
                dp[i] += dp[i-3];
            }
        }
        
        return dp[n];
    }
    
    // memoization 
    static int climbStair(int n, int[] mem) {
        
        if(n == 0) {
            return 1;
        }
        
        if(mem[n] != 0)
            return mem[n];
            
        int ways = 0;
        
        if(n-1 >= 0) {
            ways += climbStair(n-1,mem);
        }
        
        if(n-2 >= 0) {
            ways += climbStair(n-2,mem);
        }
        
        if(n - 3 >= 0) {
            ways += climbStair(n-3,mem);
        }
        
        return mem[n] = ways;
    }

}
