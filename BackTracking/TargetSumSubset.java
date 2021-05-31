package  BackTracking;

import java.util.Scanner;

public class TargetSumSubset {
   
    public static void main(String[] args) throws Exception {

        Scanner sc =  new Scanner(System.in);

        int n = sc.nextInt();

        int values[] = new int[n];

        for(int i = 0; i < n; i++)
            values[i] = sc.nextInt();
        int tar = sc.nextInt();
        printTargetSumSubsets(values, 0, "", 0, tar);
    }

    // set is the subset
    // sos is sum of subset
    // tar is target
    public static void printTargetSumSubsets(int[] arr, int idx, String set, int sos, int tar) {

        if(sos == tar) {
            set += ".";
            System.out.println(set);
            return;
        }

        if(idx >= arr.length || sos > tar){
            return;
        }

        printTargetSumSubsets(arr, idx+1, set + arr[idx] + ", ", sos+arr[idx], tar);
        printTargetSumSubsets(arr, idx+1, set, sos, tar);
    }
}
