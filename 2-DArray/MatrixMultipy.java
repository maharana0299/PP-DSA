import java.util.Scanner;

/**
 * MatrixMultipy
 */
public class MatrixMultipy {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int m1 = sc.nextInt();

        int[][] arr = new int[n1][m1];
        for(int i = 0; i < n1; i++)
            for(int j = 0; j < m1; j++)
                arr[i][j] = sc.nextInt();
        
        int n2 = sc.nextInt();
        int m2 = sc.nextInt();

        int[][] arr2 = new int[n2][m2];
        for(int i = 0; i < n2; i++)
            for(int j = 0; j < m2; j++)
                arr2[i][j] = sc.nextInt();
        multiply(arr,arr2);

        sc.close();
    }

    private static void multiply(int[][] a1, int[][] a2) {

        if(a1[0].length != a2.length){
            System.out.println("Invalid input");
            return;
        } 

        int res[][] = new int[a1.length][a2[0].length];

        for(int i = 0; i < a1.length; i++){
            for(int j = 0; j < a2[0].length; j++){
                res[i][j] = 0;
                for(int k = 0; k < a2.length; k++){
                    res[i][j] += a1[i][k] * a2[k][j];
                }
            }
        }

        print(res);
    }

    private static void print(int[][] res) {
        for(int a[] : res){
            for(int ele : a){
                System.out.print(ele+" ");
            }
            System.out.println();
        }
    }
}