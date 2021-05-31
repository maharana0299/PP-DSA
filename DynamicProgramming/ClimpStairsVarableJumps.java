import java.io.*;
import java.util.*;

public class ClimpStairsVarableJumps {
    
    private static Integer[] mem;
    public static void main(String[] args) throws Exception {
        
        // we can have variable jumps
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int jumps[] = new int[n];
        for(int i = 0; i < n; i++)
            jumps[i] = sc.nextInt();
        
        mem = new Integer[n+1];
        // using dp
        totalPaths(jumps);
        
        // calling the function
        // totalPaths(0,jumps,mem);
        // System.out.println(mem[0]);
        
        // System.out.println(totalPaths(0,jumps));
    }
    
    // mow trying to solve it using dynamic programming 
    static void totalPaths(int[] jumps) {
        
        int n = jumps.length;
        // making a dp to store the jumps 
        // dp[i] stores the way by which we can move from ith pos to the last position
        int[] dp = new int[n+1];
        
        // base case : if we are at nth position, then only one way is possible, 
        // ie, to stay at that position itself
        dp[n] = 1;
        
        for(int i = n-1; i >= 0; i--) {
            // possible jumps 
            int pj = jumps[i];
            
            for(int m = 1; m <= pj; m++) {
                if(i+m <= n) {
                    dp[i] += dp[i+m];
                }
            }
        }
        
        // we have to find, possible ways from o to n, ie sotred in dp[0];
        // simply print it 
        System.out.println(dp[0]);
    }
    
    // starting from 0th step and moving forward 
    static int totalPaths(int n, int jumps[]) {
        
        // if we reached the last step there is only one way, ie, to stay on that position 
        if(n == jumps.length)
            return 1;
        
        // jumps possible 
        int moveP = jumps[n];
        
        // toptal moves/ paths from nth pos to last position
        int tMoves = 0;
        
        for(int i = 1; i <= moveP; i++) {
            
            // if the step is valid, ie it is not of out the box then take the step and move froward
            if(n + i <= jumps.length)
            tMoves += totalPaths(n+i,jumps);
        }
        
        return tMoves;
    }
    
    // now we want to momive it 
    static int totalPaths(int n, int jumps[], Integer[] mem ) {
        
        // if we reached the last step there is only one way, ie, to stay on that position 
        if(n == jumps.length)
            return mem[n] = 1;
        
        // if it is not null, ie, if the problem is already solved then return the solved problem 
        if(mem[n] != null)
            return mem[n];
            
        // jumps possible 
        int moveP = jumps[n];
        
        // toptal moves/ paths from nth pos to last position
        int tMoves = 0;
        
        for(int i = 1; i <= moveP; i++) {
            
            // if the step is valid, ie it is not of out the box then take the step and move froward
            if(n + i <= jumps.length)
            tMoves += totalPaths(n+i,jumps,mem);
        }
        // stroing and returning 
        return mem[n] = tMoves;
    }

}