import java.util.*;

/**
 * This problem is similar to fibonacci (same way ), but not completly similar 
 */
public class Tiling2n {

    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ways = waysToTile2n(n);
        System.out.println(ways);
    }
    
    static int waysToTile2n(int n) {
        
        // length is only varying 
        // two ways possible, either place horizontally or else place vertically then calculate the left ways 
        // for placing horizontally, then left will be two areas, but upper left area will only have 1 way ans (n-2)*2 are will have k ways => k*1 ways 
        int[] dp = new int[n+1];
        dp[0] = dp[1] = 1; // base case
        
        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        
        return dp[n];
    }
}