import java.io.*;
import java.util.*;

public class NEGLeftSpanOfArray {
    public static void display(int[] a) {
        StringBuilder sb = new StringBuilder();

        for (int val : a) {
            sb.append(val + "\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        int[] span = solve(a);
        display(span);
    }

    /**
     * Just have to find next greater element to left , and span will be , span[i] = i - indexOf(ngel) + 1
     * @param arr
     * @return
     */

    public static int[] solve(int[] arr) {

        int n = arr.length;
        int[] span = new int[n];

        // stack stores index
        Stack<Integer> st = new Stack<>();

        // span[0] = 1;
        // st.push(0); // index of 1st ele

        for (int i = 0; i < n; i++) {

            while (st.size() > 0 && arr[st.peek()] <= arr[i]) {
                st.pop();
            }

            if (st.size() == 0) {
                span[i] = i + 1; // it is the greatest element till i , hence span will be i+1
            } else {
                span[i] = i - st.peek();
            }

            st.push(i);
        }
        return span;
    }

}