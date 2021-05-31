package Pep.Arrays;



import java.util.Scanner;

/**
 * RotateArray
 */
public class RotateArray {

    public static void rotate(int[] a, int k) {

        k = k%a.length;
 	    reverseArray(a, a.length-k, a.length-1);
        reverseArray(a, 0, a.length-k-1);
        reverseArray(a,0,a.length-1);
    }

    public static void reverseArray(int[] arr, int start, int end) {

        // start index
        // end index

        while(start < end) {

            int t = arr[start];
            arr[start] = arr[end];
            arr[end] = t;
            start++;
            end--;
        }
    }
   
    public static void main(String[] args) {
         Scanner s = new Scanner(System.in);
         int n = s.nextInt();
         int k=s.nextInt();
         int[] ar = new int[n];
         for (int i = 0; i < n; i++) {
              ar[i] = s.nextInt();
         }
         rotate(ar, k);
         for (int v : ar)
              System.out.print(v + " ");
        s.close();
    }
}