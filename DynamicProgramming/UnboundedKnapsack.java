import java.util.*;
// repetition allowed
public class UnboundedKnapsack {
    
    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       int wt[] = new int[n];
       int val[] = new int[n];
       
       for(int i = 0; i < n; i++)
           val[i] = sc.nextInt();
       
       for(int i = 0; i < n; i++) {
           wt[i] = sc.nextInt();
       }
       
       int cap = sc.nextInt();
       
       // int max = zeroOneKnap(wt,val,cap);
       int max = ubKnapsack(wt, val, cap);
       System.out.println(max);
   }
   

   // here both methods will work coz we have to take max profit and 2,3 and 3,2 gives same profit 
   // repetition allowed through comb
   static int ubKnapsack(int[] wt, int[] val, int cap) {
       
       int n = val.length;
       int dp[] = new int[cap+1];
       
       for(int i = 0; i < n; i++) {
           
           for(int j = wt[i]; j <= cap; j++) {
               
               dp[j] = Math.max(dp[j],dp[j-wt[i]] + val[i]);
           }
       }
       
       return dp[cap];
   }

   // perm 
   static int ubKnapsackP(int[] wt, int[] val, int cap) {
       
    int n = val.length;
    int dp[] = new int[cap+1];
    for(int j = 0; j <= cap; j++) {
        for(int i = 0; i < n; i++) {
            if(j >= wt[i])
            dp[j] = Math.max(dp[j],dp[j-wt[i]] + val[i]);
        }
    }
    
    return dp[cap];
}
}
