import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int coins[] = new int[n];
        for(int i = 0; i < n; i++){
            coins[i] = sc.nextInt();
        }
        int amt = sc.nextInt();
        // int ways = coinsPermutationMem(coins,amt, new Integer[amt+1]);
        int ways = coinsPermutations(coins,amt);
        System.out.println(ways);
    }

    private static int coinsPermutations(int[] coins, int amt) {
        
        // how many ways to store ith amount using coins 
        int dp[] = new int[amt+1];

        dp[0] = 1; // one ways, ie not use 

        for(int at = 1; at <= amt; at++) {
            // for every amt count ways 

            for(int j = 0; j < coins.length; j++) {
                if(coins[j] <= at) {
                    dp[at] += dp[at-coins[j]];
                }
            }
        }
        return dp[amt];
    }

    // here we are using 1-d array as only one parameter amt is needed 
    // mem[i] -> ways to pay ith amount
    private static int coinsPermutationMem(int[] coins, int amt, Integer[] mem) {
        
        // repetition is allowed 
        if(amt == 0) {
            // one way 
            return mem[amt] = 1;
        }
        int ways = 0;
        if(mem[amt] != null)
            return mem[amt];
        // for every coins 
        for(int i = 0; i < coins.length; i++) {
            if(coins[i] <= amt)
                ways += coinsPermutationMem(coins, amt-coins[i],mem);
        }
        return mem[amt] = ways;
    }
}