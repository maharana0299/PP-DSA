import java.io.*;
import java.util.*;

public class MergeIntervals {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            arr[j][0] = Integer.parseInt(line.split(" ")[0]);
            arr[j][1] = Integer.parseInt(line.split(" ")[1]);
        }

        mergeOverlappingIntervals(arr);
    }

    public static void mergeOverlappingIntervals(int[][] arr) {
       
       int n = arr.length;
       Interval[] interval = new Interval[n];
       Stack<Interval> s = new Stack<>();
       
       for(int i = 0; i < n; i++){
           interval[i] = new Interval(arr[i][0],arr[i][1]);
       }
       
       Arrays.sort(interval);
       
       s.push(interval[0]);
       
       for(int i = 1; i < n; i++){
           
           Interval curr = interval[i];
           Interval top = s.peek();
           
           if(curr.sp <= top.ep){
               top.ep = Math.max(top.ep,curr.ep);
           } else {
               
               s.push(interval[i]);
           }
       }
       
       String op = "";
       // now we have merged intervals
       while(s.size() > 0){
           Interval i  = s.pop();
           op = i.sp + " " + i.ep + "\n" + op;
       }
       
       System.out.println(op);
    }
    
    static class Interval implements Comparable<Interval> {
        
        int sp;
        int ep;
        
        Interval(int sp, int ep){
            this.sp = sp;
            this.ep = ep;
        }
        
        public int compareTo(Interval o){
            return this.sp-o.sp; // + means greater, -ve means smaller
        }
    }

}