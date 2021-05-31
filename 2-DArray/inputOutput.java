import java.util.Scanner;

/**
 * inputOutput
 */
public class inputOutput {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int arr[][] = new int[n][m];

        for(int i = 0; i < n; i++) 
            for(int j = 0; j < m; j++)
                arr[i][j] = sc.nextInt();
        
        showArray(arr);
        
        sc.close();
    }

    private static void showArray(int[][] arr) {
        for(int [] a : arr) {
            for(int ele : a){
                System.out.print(ele + "\t");
            }
            System.out.println();
        }
    }
}