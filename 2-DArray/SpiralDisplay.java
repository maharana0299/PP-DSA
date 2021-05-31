import java.util.Scanner;

/**
 * SpiralDisplay
 */
public class SpiralDisplay {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int m1 = sc.nextInt();

        int[][] arr = new int[n1][m1];
        for(int i = 0; i < n1; i++)
            for(int j = 0; j < m1; j++)
                arr[i][j] = sc.nextInt();
        
        spiral(arr);
        sc.close();
    }

    private static void spiral(int[][] arr) {

        int rmin = 0,rmax = arr.length-1,cmin = 0,cmax = arr[0].length-1;
        int paths = arr.length * arr[0].length;
        int i;
        while(paths > 0){
            
            if(paths>0)
            for(i = rmin; i <= rmax; i++){
                System.out.println(arr[i][cmin]);
                paths--;
            }

            cmin++;
            
            if(paths>0)
            for(i = cmin; i <= cmax; i++){
                System.out.println(arr[rmax][i]);
                paths--;
            }

            rmax--;
            
            if(paths>0)
            for(i = rmax; i >= rmin; i--){
                System.out.println(arr[i][cmax]);
                paths--;
            }

            cmax--;
            
            if(paths>0)
            for(i = cmax; i >= cmin; i--){
                System.out.println(arr[rmin][i]);
                paths--;
            }
            rmin++;
        }
    }
}