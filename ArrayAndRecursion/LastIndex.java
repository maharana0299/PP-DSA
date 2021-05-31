package Pep.ArrayAndRecursion;

import java.util.Scanner;

/**
 * LastIndex
 */
public class LastIndex {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];

        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int x = sc.nextInt();

        int li = lastIndex(arr, n-1, x);

        System.out.println(li);

        sc.close();
    }

    public static int lastIndex(int[] arr, int idx, int x){
        
        if(idx < 0)
            return -1;
        if(arr[idx] == x)
            return idx;
        
        return lastIndex(arr, idx-1, x);
    }
}