import java.io.*;
import java.util.*;

public class NEGtoRight {
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

    int[] nge = nextGreaterToRight(a);
    display(nge);
  }

  public static int[] nextGreaterToRight(int[] arr) {

    int[] ngr = new int[arr.length];

    Stack<Integer> st = new Stack<>();

    for (int i = arr.length - 1; i >= 0; i--) {

      while (st.size() > 0 && st.peek() <= arr[i]) {
        st.pop();
      }

      if (st.size() == 0) {
        ngr[i] = -1;
      } else {
        ngr[i] = st.peek();
      }

      st.push(arr[i]);
    }
    return ngr;
  }

  public static int[] getNextSmallerOnLeft(int arr[]) {
    int nsol[] = new int[arr.length];
    Stack<Integer> st = new Stack<>();

    for (int i = 0; i < arr.length; i++) {

      while (st.size() > 0 && arr[st.peek()] >= arr[i]) {
        st.pop();
      }

      if (st.size() == 0) {
        nsol[i] = -1;
      } else {
        nsol[i] = st.peek();
      }
      st.push(i);
    }
    return nsol;
  }

  public static int[] getNextSmallerOnRight(int arr[]) {

    int nsor[] = new int[arr.length];
    Stack<Integer> st = new Stack<>();

    for (int i = arr.length - 1; i >= 0; i--) {

      while (st.size() > 0 && arr[st.peek()] >= arr[i]) {
        st.pop();
      }

      if (st.size() == 0) {
        nsor[i] = arr.length;
      } else
        nsor[i] = st.peek();

      st.push(i);
    }
    return nsor;
  }

}