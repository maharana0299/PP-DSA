package Pep.ArrayListAndRecursion;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * GetMazePaths
 */
public class GetMazePath {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        System.out.println(getMazePath(0, 0, n, m));
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
        
        ArrayList<String> path1 = new ArrayList<>();
        ArrayList<String> path2 = new ArrayList<>();
        
        if (sc < dc ){
            path1 = getMazePath(sr,sc+1,dr,dc);
        }
        
        if (sr < dr){
            path2 = getMazePath(sr+1,sc,dr,dc);
        }
        
        ArrayList<String> paths = new ArrayList<>();
        
        for (String i : path1) {
            paths.add("h" + i);
        }
        
        for (String i : path2) {
            paths.add("v" + i);
        }
        
        return paths; 
    }

}