package  RecursionOnTheWayUp;

import java.util.Scanner;

/**
 * PrintMazePathMull
 */
public class PrintMazePathMull {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        printMazePaths(0,0,n-1,m-1,"");
        sc.close();
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {
        
        if(sr == dr && sc == dc) {
            
            System.out.println(psf);
            
            return;
        }
        
        int n = dc-sc;
        for(int i = 1; i <= n; i++) {
            printMazePaths(sr,sc+i,dr,dc,psf + "h" + i);
        }
        
        int m = dr-sr;
        for(int i = 1; i <= m; i++) {
            printMazePaths(sr+i,sc,dr,dc,psf + "v" + i);
        }
        
        int d = Math.min(n,m);
        
        for(int i = 1; i <= d; i++) {
            printMazePaths(sr+i,sc+i,dr,dc,psf + "d" + i);
        }
    
    }
}