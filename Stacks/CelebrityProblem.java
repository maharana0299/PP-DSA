import java.io.*;
import java.util.*;

public class CelebrityProblem {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            for (int k = 0; k < n; k++) {
                arr[j][k] = line.charAt(k) - '0';
            }
        }

        findCelebrity(arr);

    }

    // with two pointers
    public static void findCelebrity(int[][] arr) {
        
        // using two pointers
        int n = arr.length;
        int i = 0; 
        int j = n-1;
        
        while(i < j) {
            
            if(arr[i][j] == 0) {
                // if i doesnt know j
                // j cant be celeb
                j--;
            } else {
                // i cant be celeb
                i++;
            }
        }
        
        int pc = i;
        
        //column check
        // i know someone ?
        for( i=0; i < n;i++) {
            if(i != pc && arr[i][pc] == 0) {
                System.out.println("none");
                return;
            }
        }
        
        //row check
        // everyone knows me?
        for( i=0; i < n;i++) {
            if(i != pc && arr[pc][i] == 1) {
                System.out.println("none");
                return;
            }
        }
        
        
        System.out.println(pc);
    }

    public static void findCelebrityUsingStack(int[][] arr) {
        // if a celebrity is there print it's index (not position), if there is not then
        // print "none"
        
        Stack<Integer>st = new Stack<>();
        
        int n=arr.length;
        
        for(int i=0;i < n;i++) {
            st.push(i);
        }
        
        while(st.size() >= 2) {
            int a = st.pop();
            int b = st.pop();
            
            if(arr[a][b] == 1) {
                //a can't be a celebrity
                st.push(b);
            }
            else {
                //b can't be a celebrity
                st.push(a);
            }
        }
        
        int pc = st.peek();
        boolean ans = true;
        
        //column check
        for(int i=0; i < n;i++) {
            if(i != pc && arr[i][pc] == 0) {
                ans = false;
                break;
            }
        }
        
        //row check
        for(int i=0; i < n;i++) {
            if(i != pc && arr[pc][i] == 1) {
                ans = false;
                break;
            }
        }
        
        if(ans == true) {
            System.out.println(pc);
        }
        else {
            System.out.println("none");
        }
        
        
    }

}