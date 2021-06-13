import java.io.*;
import java.util.*;

public class NGSlidingWindow {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }
        int k = Integer.parseInt(br.readLine());

        int[] sw = findSlidingWindows(a, k);

        for (int i = 0; i < sw.length; i++) {
            System.out.println(sw[i]);
        }
    }

    static int[] findSlidingWindows(int arr[], int k) {

        // small optimization is taking a j , and j stores max of sliding window
        // it will remain max till its nge comes or it goes out of window 
        int j  = 0;
        int sw[] = new int[arr.length - k + 1];
        int nger[] = findNextGreaterToRight(arr);

        for (int i = 0; i <= arr.length - k; i++) {

            j = j < i ? i : j; //  if j goes out of winow then make i as j 
            // int j = i; // not optimized

            //  check if ng of j is in the range or not 
            while (nger[j] < i + k)
                j = nger[j];
            sw[i] = arr[j];

        }
        return sw;
    }

    public static int[] findNextGreaterToRight(int[] arr) {
        Stack<Integer> s = new Stack<>();
        int[] sol = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {

            while (s.size() > 0 && arr[s.peek()] <= arr[i])
                s.pop();

            if (s.size() == 0) {
                sol[i] = arr.length;
            } else {
                sol[i] = s.peek();
            }

            s.push(i);
        }

        return sol;
    }
}