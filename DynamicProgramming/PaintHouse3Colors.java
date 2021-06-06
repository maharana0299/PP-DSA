import java.util.Scanner;

public class PaintHouse3Colors {
    
     // same as previous one 
     public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = 3; // 3 colors
        int costs[][] = new int[n][k];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < k; j++) {
                costs[i][j] = sc.nextInt();
            }
        }
        
        int cost = findMinCost(costs);
        System.out.println(cost);
    }
    
    /**
     * we have been provided cost matrix of size 3 
     * it stores the cost to paint the ith house with kth color 
     * 
     * @return return the fin cost to paint all houses such that no two house have same color
     */
    static int findMinCost(int[][] costs) {
        
        int n = costs.length;
        /**
         * 0 -> red color 
         * 1 -> blue color
         * 2 -> green color 
         * let dp[j] stores min cost painting the last house with jth color such that no two house are painted
         * same color 
         * It will depend of i-1 th house and dp[j] will be cost[i][j] 
         *  + min(all cost[i-1] houses) except cost[i-1][j] as it cant have same color 
         */
        int dp[] = new int[3]; // 3 colors poss
        // 0-> red, 1-> blue, 2 -> green
        
        for(int i = 0; i < n; i++) {
            
            int or = dp[0];
            int ob = dp[1];
            int og = dp[2];
            
            dp[0] = costs[i][0] +  Math.min(ob,og);
            dp[1] = costs[i][1] + Math.min(or,og);
            dp[2] = costs[i][2] + Math.min(or,ob);
        } 
        
        return Math.min(dp[0],Math.min(dp[1],dp[2]));
    }
}
