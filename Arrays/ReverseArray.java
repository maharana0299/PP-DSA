package Pep.Arrays;



import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * ReverseArray
 */
public class ReverseArray {

    public static void display(int[] a){
        StringBuilder sb = new StringBuilder();
        
        for(int val: a){
          sb.append(val + " ");
        }
        System.out.println(sb);
    }
        
    public static void reverse(int[] a){
        for (int i = 0; i < a.length/2; i++) {
            int t = a[i];
            a[i] = a[a.length-i-1];
            a[a.length-1-i] = t;
        }
    }
        
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
           a[i] = Integer.parseInt(br.readLine());
    }
        
        reverse(a);
        display(a);
    }
}