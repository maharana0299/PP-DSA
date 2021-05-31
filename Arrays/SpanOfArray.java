package Arrays;


import java.util.Scanner;

/**
 * SpanOfArray
 */
public class SpanOfArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] mm = calulateSpan(arr);
        System.out.println(mm[0] - mm[1]);
        sc.close();
    }

    private static int[] calulateSpan(int[] arr) {
        int mm[] = new int[2];
        mm[0] = Integer.MIN_VALUE;
        mm[1] = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if(mm[0] < arr[i])
                mm[0] = arr[i];
            if(mm[1] > arr[i])
                mm[1] = arr[i];
        }
        return mm;
    }
}