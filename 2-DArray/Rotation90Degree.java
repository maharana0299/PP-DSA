import java.util.Scanner;

/**
 * Rotation90Degree
 */
public class Rotation90Degree {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = n;

        int arr[][] = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        
        rotateBy90(arr);
        display(arr);
        sc.close();
    }

    private static void rotateBy90(int[][] arr) {
        transpose(arr);
        
        for(int j = 0; j < arr.length/2; j++){
            for(int i = 0; i < arr.length; i++){
                int t = arr[i][j];
                arr[i][j] = arr[i][arr.length-1-j];
                arr[i][arr.length-1-j] = t;
            }
        }
    }

    private static void transpose(int[][] arr) {

        for(int  i =0; i < arr.length; i++){
            for(int j = 0; j < i; j++){
                int t = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = t;
            }
        }
    }

    public static void display(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}