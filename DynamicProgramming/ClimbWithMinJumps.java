import java.util.*;

public class ClimbWithMinJumps {

    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int jumps[] = new int[n];
        
        for(int i = 0; i < n; i++) {
            jumps[i] = sc.nextInt();
        }
        
        // we have to calculate jumps with min moves 
        // int minj = jumpsWithMinMove(0,jumps);
        // int minj = jumpsWithMinMove(0,jumps, new Integer[n+1]);
        // System.out.println(minj);
        
        jumpsWithMinMove(jumps);
    }
    
    // using dp 
    static void jumpsWithMinMove(int[] jumps){
        
        int n = jumps.length;
        // it stores the min move to travel from ith step to nth step 
        Integer dp[] = new Integer[n+1];
        dp[n] = 0; // min mive to move to nth stet to nth steo is zero 
        
        for(int i = n-1; i >= 0; i--) {
            
            int pj = jumps[i];
            
            int min = Integer.MAX_VALUE;
            for(int j = 1; j <= pj; j++) {
                if(i+j <= jumps.length){
                    if(dp[i+j] != null && dp[i+j] + 1 <  min)
                        min = 1+dp[i+j];
                }
            }
            
            if(min != Integer.MAX_VALUE){
                dp[i] = min;
            }
        }
        
        System.out.println(dp[0]);
    }
    
    // using recursion 
    // strting from 0th step and we have to move to the last step in min jumps
    static int jumpsWithMinMove(int n, int[] jumps) {
        
        if(n == jumps.length){
            // at last pos min jump will be to take jump of 0 
            return 0;
        }
        
        int pj = jumps[n];
        
        // if no jumps is possible at that position then we have to place the max int value 
        // it will represnt no jump is possible 
        int mj = Integer.MAX_VALUE;
        
        // we can jump from nth to n+pj
        for(int j = 1; j <= pj; j++) {
            
            // if jump is possible and not outside the range
            if(n+j <= jumps.length){
                int jump = jumpsWithMinMove(n+j,jumps);
                
                // if no jump is possible then simply skip it and if jump is possible then take min of all 
                if(jump != Integer.MAX_VALUE) {
                    if(jump +1 < mj) {
                        // then min jump will be 1 + jump
                        mj = jump+1;
                    }
                }
            }
        }
        
        return mj;
    }
    
    // lets try to solve it using memoization
    // we will be using Integer
    static int jumpsWithMinMove(int n, int[] jumps, Integer[] mem) {
        
        if(n == jumps.length){
            // at last pos min jump will be to take jump of 0 
            return mem[n] = 0;
        }
        
        if(mem[n] != null)
            return mem[n];
            
        int pj = jumps[n];
        
        // if no jumps is possible at that position then we have to place the max int value 
        // it will represnt no jump is possible 
        int mj = Integer.MAX_VALUE;
        
        // we can jump from nth to n+pj
        for(int j = 1; j <= pj; j++) {
            
            // if jump is possible and not outside the range
            if(n+j <= jumps.length){
                int jump = jumpsWithMinMove(n+j,jumps,mem);
                
                // if no jump is possible then simply skip it and if jump is possible then take min of all 
                if(jump != Integer.MAX_VALUE) {
                    if(jump +1 < mj) {
                        // then min jump will be 1 + jump
                        mj = jump+1;
                    }
                }
            }
        }
        
        return mem[n] = mj;
    }

}