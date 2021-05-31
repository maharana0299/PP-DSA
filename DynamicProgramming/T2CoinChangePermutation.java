import java.util.Scanner;

/**
 * T2CoinChangePermutation
 */
public class T2CoinChangePermutation {

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

    private static int coinsPermutations(int[] coins, int amount) {
        
        // how many ways to store ith amount using coins
        // here only one paramenter is needed as we have to store the ways to make amt only
        // using recursion, it makes question so easy to convert it into tabulation or memoization 
        // just find out which problem is  repeating and direction of flow 
        int dp[] = new int[amount+1];

        dp[0] = 1; // one ways, ie not use 

        for(int amt = 1; amt <= amount; amt++) {
            // for every amt count ways 

            for(int j = 0; j < coins.length; j++) {
                if(coins[j] <= amt) {   // if amt is greater or equal to coin then we cann add the coin
                    dp[amt] += dp[amt-coins[j]]; // plus the waus to make amt-coins[j] coins, which is already solved
                }
            }
        }
        return dp[amount];
    }

    // here we are using 1-d array as only one parameter amt is needed 
    // mem[i] -> ways to pay ith amount
    public static int coinsPermutationMem(int[] coins, int amt, Integer[] mem) {
        
        // repetition is allowed 
        if(amt == 0) {
            // one way 
            return mem[amt] = 1;
        }
        
        // if already solved
        if(mem[amt] != null)
            return mem[amt];

        int ways = 0;
        // for every coins
        // sum of all ways possible as rep is allowed 
        for(int i = 0; i < coins.length; i++) {
            if(coins[i] <= amt)
                ways += coinsPermutationMem(coins, amt-coins[i],mem);
        }
        return mem[amt] = ways;
    }
}