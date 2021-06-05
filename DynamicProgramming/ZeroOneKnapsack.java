import java.io.*;
import java.util.*;

public class ZeroOneKnapsack {

    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int wt[] = new int[n];
        int val[] = new int[n];
        
        for(int i = 0; i < n; i++)
            val[i] = sc.nextInt();
        
        for(int i = 0; i < n; i++) {
            wt[i] = sc.nextInt();
        }
        
        int cap = sc.nextInt();
        
        // int max = zeroOneKnap(wt,val,cap);
        int max = zeroOneMem(wt, val, cap, 0, new Integer[n][cap+1]);
        System.out.println(max);
    }
    
    static int zeroOneKnap(int[] wt, int val[] , int cap) {
        
        int dp[][] = new int[wt.length][cap+1];
        
        for(int i = 0; i < val.length; i++ ) {
            
            for(int j = 0; j < cap+1; j++) {
                
                if(i == 0) {
                    if(j >= wt[i]) {
                        dp[i][j] = val[i];
                    } else {
                        dp[i][j] = 0;
                    }
                } else if(j == 0) {
                    dp[i][j] = 0;
                } else {
                    // either include or exclude 
                    int inc = 0;
                    int xcl = dp[i-1][j];
                    
                    if(j >= wt[i])
                        inc = dp[i-1][j-wt[i]] + val[i];
                    dp[i][j] = Math.max(inc,xcl);
                }
            }
        }
        
        return dp[val.length-1][cap];
    }

    // meaning is from down to top
    static int zeroOneMem(int[] wt, int val[], int cap, int i, Integer[][] mem){

        if(cap == 0 || i >= wt.length)
            return 0;

        if(mem[i][cap] != null)
            return mem[i][cap];
        int inc = 0;

        if(cap >= wt[i])
        inc = zeroOneMem(wt,val,cap-wt[i],i+1,mem) + val[i];
        int xcl = zeroOneMem(wt, val, cap,i+1,mem);
        return mem[i][cap] = Math.max(inc, xcl);
    }
}