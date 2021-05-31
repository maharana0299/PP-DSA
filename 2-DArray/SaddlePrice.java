import java.util.Scanner;

/**
 * SaddlePrice
 */
public class SaddlePrice {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = n;
        int arr[][] = new int[n][m];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        
        saddlePoint(arr);
        sc.close();
    }
    
    public static void saddlePoint(int arr[][]) {

       /**
        * Point where min of row and max of col
        */
        int m = arr[0].length; // m columns
        int n = arr.length; // n rows
        
        for (int r = 0; r < n; r ++) {
            
            int c = 0;
            int minEle = Integer.MAX_VALUE;

            // check for a row r
            for(int j = 0; j < m; j++) {
                
                if (arr[r][j] < minEle) {
                    minEle = arr[r][j];
                    c = j;
                }
            }

            boolean saddlePoint = true;

            // check for column c
            for (int i = 0; i < n; i++) {
                if (arr[i][c] > minEle) {
                    saddlePoint = false;
                    break;
                }

            }

            if ( saddlePoint ) {
                System.out.println(minEle);
                return ;
            }
        }
        System.out.println("Invalid input");
    }
}