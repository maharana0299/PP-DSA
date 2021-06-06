import java.util.Scanner;

public class TilingSimilarFriendsPair {
    
    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int ways = findWays(n);
        System.out.println(ways);
    }
    
    static int findWays(int n){
        
        // a friend can either pair with n-1 freinds or can stays single
        // if choose to remain single then it has only way, to go with remaining ways
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1; // stay single 
        
        for(int i = 2; i <= n; i++) {
            
            // either stay sigle or pair
            dp[i] = dp[i-1] + (i-1)*dp[i-2];
        }
        
        return dp[n];
    }

}
