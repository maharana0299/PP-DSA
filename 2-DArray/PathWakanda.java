import java.util.Scanner;

/**
 * PathWakanda
 */
public class PathWakanda {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int m1 = sc.nextInt();

        int[][] arr = new int[n1][m1];
        for(int i = 0; i < n1; i++)
            for(int j = 0; j < m1; j++)
                arr[i][j] = sc.nextInt();
        
        moveToWakanda(arr);
        sc.close();
    }

    private static void moveToWakanda(int[][] arr) {

        boolean isUp = false;
        
        for(int i = 0; i < arr[0].length; i++){
            
            if(isUp){
                for(int j = arr.length-1; j >= 0; j--){
                    System.out.println(arr[j][i]);
                }
                
                isUp = false;
            } else {
                isUp = true;
                for(int j= 0; j < arr.length; j++){
                    System.out.println(arr[j][i]);
                }
            }
        }
    }
}