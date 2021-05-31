import java.util.Scanner;


/**
 * ExitPointOfMatrix
 */
public class ExitPointOfMatrix {

    public static final int EAST=0,SOUTH=1,WEST=2,NORTH=3;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int arr[][] = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        
        findExitPointOfMatrix(arr);

        sc.close();
    }

    private static void findExitPointOfMatrix(int[][] arr) {
        int dir = 0;
        int i = 0;
        int j = 0;

        while (true) {
            dir = (dir + arr[i][j]) %4;
            
            if (dir == EAST) {
                // east
                j++;
            } else if (dir == SOUTH){
                //south
                i++;
            } else if (dir == WEST) {
                j--;
            } else if (dir == NORTH) {
                i--;
            }
            
            if ( i< 0) {
                i++ ;
                break;
            } else if (j < 0){
                j++;
                break;
            } else if (i == arr.length){
                i--;
                break;
            } else if (j == arr.length){
                j--;
                break;
            }
        }
        
        System.out.println(i + "\n" + j);
        
    }
}