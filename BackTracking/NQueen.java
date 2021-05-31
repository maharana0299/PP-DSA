package  BackTracking;

import java.util.Scanner;

public class NQueen {
    
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [][] chess = new int[n][n];
        printNQueens(chess,"",0);
        sc.close();
        
    }

    public static void printNQueens(int[][] chess, String qsf, int row) {
       
        if (row == chess.length) {
            System.out.println(qsf + ".");
            return;
        }
        for (int i = 0; i < chess.length; i++) 
            if(isSafePos(chess,row,i) == true){
                chess[row][i] = 1;
                printNQueens(chess,qsf + row + "-" + i + ", ",row+1 );
                chess[row][i] = 0;
            }
    }
    
    public static boolean isSafePos(int[][] chess,int row, int col ) {
        
        for (int i = row -  1, j = col; i >= 0; i--)
            if (chess[i][j] == 1)
                return false;
                
        for (int i = row-1, j = col-1; i >= 0 && j >= 0; j--, i--)
            if (chess[i][j] == 1 )
            return false;
        
        for (int i = row-1, j = col+1; i >= 0 && j < chess.length; j++, i--)
            if (chess[i][j] == 1 )
            return false;
            
        return true;
    }
}


class DifApp {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        placeQueen(0,"",0,n);
        sc.close();
        
    }

    /*
    ________________________Step 1__________________________________
    private static void placeQueen(int b, String psf, int qsf, int n) {

        if(b == n * n) {
            if(qsf == 2)
            System.out.println(psf + "->" + qsf);
            return;
        }
        // yes
        placeQueen(b + 1, psf + b + " ", qsf+1, n);
        placeQueen(b + 1, psf, qsf, n);
    }
    */

    // next task to print option when one queen is place in one row

    /*
    ________________________Step 2__________________________________
    private static void placeQueen(int r, String psf, int qsf, int n) {

        if(r == n) {
            System.out.println(psf + "->" + qsf);
            return;
        }
        
        for(int i = 0; i < n; i++) {
            // placeQueen(r + 1, psf + "[" + r + "," + i + "" , qsf + 1, n);
            placeQueen(r+1, psf + (r * n + i) + " ", qsf+1, n); // here we are calculating box number using the formula
        }
    }
    */

    /*
    ________________________Final Step__________________________________
    public static void printNQueens(int[][] chess, String qsf, int row) {
       
        if (row == chess.length) {
            System.out.println(qsf + ".");
            return;
        }
        for (int i = 0; i < chess.length; i++) 
            if(isSafePos(chess,row,i) == true){
                chess[row][i] = 1;
                printNQueens(chess,qsf + row + "-" + i + ", ",row+1 );
                chess[row][i] = 0;
            }
    }
    
    public static boolean isSafePos(int[][] chess,int row, int col ) {
        
        for (int i = row -  1, j = col; i >= 0; i--)
            if (chess[i][j] == 1)
                return false;
                
        for (int i = row-1, j = col-1; i >= 0 && j >= 0; j--, i--)
            if (chess[i][j] == 1 )
            return false;
        
        for (int i = row-1, j = col+1; i >= 0 && j < chess.length; j++, i--)
            if (chess[i][j] == 1 )
            return false;
            
        return true;
    }
    */

}