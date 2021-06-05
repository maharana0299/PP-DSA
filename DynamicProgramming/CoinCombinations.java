import java.io.*;
import java.util.*;

public class CoinCombinations {

    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int coins[] = new int[n];
        for(int i = 0; i < n; i++){
            coins[i] = sc.nextInt();
        }
        int amt = sc.nextInt();
        // int[] ways = new int[amt+1];
        // ways[0] = 0;
        // int way = coinsComb_mem(coins,0,amt, ways);
        int way = coinsComb_dp(coins,amt);
        System.out.println(way);
    }
    
    static int coinsComb_dp(int[] coins, int t) {
      
      int dp[] = new int[t+1];
      
      dp[0] = 1;
      for(int i = 0; i < coins.length; i++) {
          for(int j = 1; j <= t; j++) {
              if(j-coins[i] >= 0)
                dp[j] += dp[j-coins[i]];
          }
      }
      return dp[t];
    }
    
    static void coinsComb(int[] coins, int i, int amt, Integer[] ways) {
        
        
        if(amt == 0) {
            ways[0]++;
            return;
        }
        
        if(i == coins.length)
            return;
            
        if(amt-coins[i] >= 0) {
            coinsComb(coins,i,amt-coins[i],ways);
        }
        coinsComb(coins,i+1,amt,ways);
        
    }
    
    // please try to understand this once again
    static int coinsComb_mem(int[] coins, int i, int amt, int[] dp) {
        
        if(amt == 0) {
            dp[0] = 1;
            return dp[0];
        }
        
        if(i == coins.length)
            return 0;
        
        // if(dp[amt] == null)
            dp[amt] = 0;
        if(amt-coins[i] >= 0) {
            dp[amt] += coinsComb_mem(coins,i,amt-coins[i],dp);
        }
        // int t = 
        dp[amt] += coinsComb_mem(coins,i+1,amt,dp);
        return dp[amt];
    }
}