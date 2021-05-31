package Pep.Arrays;

import java.util.Scanner;

/**
 * MaxSubArray
 */
public class MaxSubArray {

    public static int maxSum(int[] arr) {
 	 	 
        int inc, max;
        int n = arr.length;
        inc = arr[0];
        max = arr[0];
        
        for(int i = 1; i < n; i++) {
            if(inc < 0){
                inc = 0;
            }
            
            inc += arr[i];
            if(max < inc){
                max = inc;
            }
        }
        
        return max;
 }

   public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < arr.length; i++) {
             arr[i] = sc.nextInt();
        }

        System.out.println(maxSum(arr));
        sc.close();
   }
}