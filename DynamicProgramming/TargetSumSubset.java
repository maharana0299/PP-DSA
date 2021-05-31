import java.util.Scanner;

public class TargetSumSubset {
    
    // to check if target exists or not 

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int tar = sc.nextInt();

        // boolean isPoss = targetSum(arr,0,tar,new Boolean[n][tar+1]);
        boolean isPoss = targetSum(arr, tar);
        System.out.println(isPoss);
    }

    // mem[i][j] -> from ith index can we get a target of j ?
    private static boolean targetSum(int[] arr, int idx, int tar, Boolean[][] mem) {
        
        if(tar == 0){
            return true;
        }

        // if reached end and still not got answer or our target is negative then simply return false
        if(idx >= arr.length || tar < 0)
            return false;

        // if already solved them simply return it
        if(mem[idx][tar] != null)
            return mem[idx][tar];
        // two options either to include or exclude 
        return mem[idx][tar] = targetSum(arr, idx+1, tar-arr[idx], mem) || targetSum(arr, idx+1, tar, mem);
    }

    // usung tabulation and using same logic a of memoization
    private static boolean targetSum(int[] arr, int tar) {

        // its storing -> for ith value, can we reach the target j
        boolean dp[][] = new boolean[arr.length][tar+1];
        
        for(int i = arr.length-1; i >= 0; i--) {

            for(int j = 0; j <= tar; j++) {
                if(j == 0 ) {
                    // for 0 it will always be true 
                    dp[i][j] = true;
                } else if(i == arr.length-1) {
                    if(j == arr[i])
                        dp[i][j] = true;
                } else {

                    dp[i][j] = dp[i+1][j]; // exclusion 
                    if(j >= arr[i]) {   // if arr[i] is smaller then target then only go to the inclusion case 
                        dp[i][j] |= dp[i+1][j-arr[i]];
                    }
                }
            }
        }

        return dp[0][tar];
    }
}
