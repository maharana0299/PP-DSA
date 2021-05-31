import java.util.*;

public class RingRotate {

    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int arr[][] = new int[n][m];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        int s = sc.nextInt();
        int r = sc.nextInt();
        
        ringRotate(arr,s,r);
        
        display(arr);
        sc.close();
   }
   
   public static void ringRotate(int[][] arr, int s, int r) {
       
       int oned[] = shellTo1d(arr, s);

        rotate(oned, r);
        
        onedToShell(oned,arr,s);
   }
   
   public static void rotate(int[] oned, int r){
        r = r % oned.length;
        if (r < 0) {
            r += oned.length;
        }
        
        reverseArray(oned, 0,oned.length - r - 1);
        reverseArray(oned, oned.length - r, oned.length - 1);
        reverseArray(oned, 0, oned.length - 1);

    }
    
    private static void onedToShell(int[] oned,int[][] arr, int shellNumber) {
        int rmin = shellNumber - 1;
        int rmax = arr.length - shellNumber;
        int cmin = shellNumber - 1;
        int cmax = arr[0].length - shellNumber;
        int indx = 0;

        for(int r =rmin; r <= rmax; r++) {
             (arr[r][cmin]) = oned[indx++];
           
        }
        cmin++;

        for(int r = cmin; r <= cmax; r++) {
            arr[rmax][r] = oned[indx++];
        }
        rmax--;

        for(int r = rmax; r >= rmin; r--) {
            arr[r][cmax] = oned[indx++];
        }
        cmax--;

        for(int r = cmax; r >= cmin; r--) {
            arr[rmin][r] = oned[indx++];
        }
        rmin++;

    }
    
    private static void reverseArray(int[] oned, int l, int r) {
        while(l < r) {
            int temp = oned[l];
            oned[l] = oned[r];
            oned[r] = temp;

            l++;
            r--;
        }
    }

    public static int[] shellTo1d(int arr[][], int shellNumber) {
        
        int rmin = shellNumber - 1;
        int rmax = arr.length - shellNumber;
        int cmin = shellNumber - 1;
        int cmax = arr[0].length - shellNumber;
        
        int count = 2 * (rmax - rmin + cmax - cmin);
        
        
        int indx = 0;
        int [] oned = new int[count];
        while (count > 0){

            for(int r =rmin; r <= rmax && count > 0; r++) {
                oned[indx++] = (arr[r][cmin]);
                count--;
            }
            cmin++;

            for(int r = cmin; r <= cmax && count > 0; r++) {
                oned[indx++] = (arr[rmax][r]);
                count--;
            }
            rmax--;

            for(int r = rmax; r >= rmin && count > 0; r--) {
                oned[indx++] = arr[r][cmax];
                count--;
            }
            cmax--;

            for(int r = cmax; r >= cmin && count > 0; r--) {
                oned[indx++] = arr[rmin][r];
                count--;
            }
            rmin++;
        }
        
        return oned;
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