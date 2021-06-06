
import java.util.*;

public class BuySellSeries {

    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        int max = buyAndSellWithSignleTransaction(arr);
        System.out.println(max);
    }
    
    static int buyAndSellWithSignleTransaction(int[] prices){
        
        int n = prices.length;
        
        int omax = Integer.MIN_VALUE;
        int cp;
        int lmin = Integer.MAX_VALUE;
        
        for(int i = 0; i < n; i++) {
            
            if(prices[i] < lmin) {
                lmin = prices[i];
            }
            
            cp = prices[i] - lmin;
            
            if(omax < cp){
                omax = cp;
            }
        }
        
        return omax;
    }

    static int buySellWithInfiniteTransaction(int[] prices) {
        
        // day starting from 0 to n-1
        int day = prices.length;
        int totalProfit = 0;
        
        // if current day price is greater than that of previous day, then make a transaction
        for(int currentDay = 1; currentDay < day; currentDay++) {
            
            if(prices[currentDay] > prices[currentDay-1]) {
                totalProfit += prices[currentDay] - prices[currentDay-1];
            }
        }
        
        // return total profit 
        return totalProfit;
    }

}