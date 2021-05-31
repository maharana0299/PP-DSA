package Pep.ArrayListAndRecursion;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * GetMazePathsWithJumps
 */
public class GetMazePathsWithJumps {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        System.out.println(getMazePath(1, 1, n, m));
        sc.close();
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList<String> getMazePath(int sr, int sc, int dr, int dc) {
        
        if (sr == dr && sc == dc) {
            ArrayList<String> ls = new ArrayList<>();
            ls.add("");
            return ls;
        } 
        
        ArrayList<String> horizontal = new ArrayList<>();
        ArrayList<String> vertical = new ArrayList<>();
        ArrayList<String> diagonal = new ArrayList<>();
        ArrayList<String> solution = new ArrayList<>();
         
        if (sc < dc) {
            int m = dc - sc;
            for (int i = 1; i <= m; i++) {
                horizontal = getMazePath(sr,sc + i,dr,dc);
                for (String in : horizontal) {
                    solution.add("h" + i + in);
                }
            }
        }
        
        if (sr < dr){
            
            int n = dr - sr;
            
            for(int i = 1; i <= n; i++) {
                
                vertical = getMazePath(sr+i,sc,dr,dc);
                for (String in : vertical) {
                    solution.add("v" + i + in);
                }
            }
        }
        
        int d = Math.min(dr - sr,dc - sc);
        
        if (d > 0) {
            for (int i = 1; i <= d; i++) {
                diagonal = getMazePath(sr + i,sc + i,dr,dc);
                for(String in : diagonal) {
                    solution.add("d" + i + in);
                }
            }
            
        }
        
        return solution; 
    }
}