package Pep.ArrayAndRecursion;

import java.util.Scanner;

/**
 * MaxArr
 */
public class MaxArr {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int max = maxOfArray(arr, 0);
        System.out.println(max);

        sc.close();
    }

    public static int maxOfArray(int[] arr, int idx){
        
        if(idx == arr.length)
            return Integer.MIN_VALUE;

        int max = maxOfArray(arr, idx+1);

        if(max < arr[idx]){
            max = arr[idx];
        }

        return max;
    }
}
