import java.util.*;

public class TilingNM {

    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int ways = tileWithMN(n,m);
        System.out.println(ways);
    }
    
    static int tileWithMN(int n, int m) {
        
        // stores ways to tile i * m tile
        int dp[] = new int[n+1];
        
        for(int i = 0; i <= n; i++) {
            
            if(i < m) {
                dp[i] = 1;
            } else {
                dp[i] = dp[i-1] + dp[i-m];
            }
        }
        
        return dp[n];
    }
}