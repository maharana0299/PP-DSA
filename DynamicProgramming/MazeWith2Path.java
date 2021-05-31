
import java.util.*;

public class MazeWith2Path {

    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int maze[][] = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++) {
                maze[i][j] = sc.nextInt();
            }
        }
        
        // int minCost = minCost(maze,0,0,n-1,m-1, new Integer[n][m]);
        System.out.println(minCost(maze));
    }
    
    
    // here we are not backtracking as it cant form a cycle(coz of 2 moves only)
    static int minCost(int[][] maze, int si, int sj, int di, int dj, Integer mem[][]) {
        
        
        if(si == di && sj == dj) {
            return mem[si][sj] = maze[si][sj];
        }
        
        if(mem[si][sj] != null)
            return mem[si][sj];
            
        // for every spot we have two option, either to move right or to move down 
        int a = Integer.MAX_VALUE,b = Integer.MAX_VALUE;
        
        // is si + i is a valid choice 
        if(si+1 <= di)
            a = minCost(maze,si+1,sj,di,dj,mem);

        // if sj+1 is a valid choice or not 
        if(sj + 1 <= dj)
            b = minCost(maze,si,sj+1,di,dj,mem);
        
        // comparing and returning (and saving also in mem array)
        return mem[si][sj] = maze[si][sj] + Math.min(a,b);

    }

    // uning tabulation
    static int minCost(int[][] maze) {

        int n = maze.length;
        int m = maze[0].length;

        // stores the min cost to move from (i,j) to destination (di,dj)
        int dp[][] = new int[n][m];
        
        // for last, its cost will be equal to min cost
        dp[n-1][m-1] = maze[n-1][m-1];

        // solving top down, here smnaller problem is to solve from detination 

        for(int i = n-1; i >= 0; i--) {
            for(int j = m-1; j >= 0; j--) {

                /// if both are equal, ie. the base case, min cost is maze[i][j] itself 
                if(i == n-1 && j == m-1){
                    dp[i][j] = maze[i][j];
                } else if(i == n-1) {
                    // standing at edge
                    dp[i][j] = maze[i][j] + dp[i][j+1]; // only one choice as other choice will make us move out of box
                } else if(j == m-1) {
                    dp[i][j] = maze[i][j] + dp[i+1][j]; // only one move possibe same as above 
                } else {
                    // here we are somewhere but not at corner so we can move in two directions
                    dp[i][j] = maze[i][j] + Math.min(dp[i+1][j], dp[i][j+1]);
                }
            }
        }

        // 0,0 will store the min cost to move from o,0 to n-1,m-1 which is the required soltion 
        return dp[0][0];
    }

}






