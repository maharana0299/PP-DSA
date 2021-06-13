import java.io.*;
import java.util.*;

public class NELargestAreaHistogram{
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
           a[i] = Integer.parseInt(br.readLine());
        }
    
        int max = largestAreaHistogram(a);
        System.out.println(max);
    }
    
    private static int largestAreaHistogram(int[] arr) {
        //next smaller on left
        int[] nsol = getNextSmallerOnLeft(arr);
        int[] nsor = getNextSmallerOnRight(arr);
        
        int maxArea = 0;
        for(int i = 0; i < arr.length; i++) {
            
            int h = arr[i];
            int wdth = nsor[i] - nsol[i] - 1;
            int area = h * wdth;
            
            if(area > maxArea){
                maxArea = area;
            }
        }
        
        return maxArea;
    }
    
    private static int[] getNextSmallerOnLeft(int arr[]) {
        int nsol[] = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < arr.length; i++) {
            
            while(st.size() > 0 && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            
            if(st.size() == 0) {
                nsol[i] = -1;
            } else {
                nsol[i] = st.peek();
            }
            st.push(i);
        }
        return nsol;
    }
    
    private static int[] getNextSmallerOnRight(int arr[]) {
        
        int nsor[] = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        
        for(int i = arr.length-1; i >= 0; i--) {
            
            while(st.size() > 0 && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            
            if(st.size() == 0) {
                nsor[i] = arr.length;
            } else nsor[i] = st.peek();
            
            st.push(i);
        }
        return nsor;
    }
    
}