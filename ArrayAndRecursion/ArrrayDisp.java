package ArrayAndRecursion;


import java.util.Scanner;

/**
 * ArrrayDisp
 */
public class ArrrayDisp {
    
    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        displayArr(arr, 0);

        sc.close();
    }

    public static void displayArr(int[] arr, int idx){

        if(idx == arr.length)
            return;
        System.out.println(arr[idx]);

        displayArr(arr, idx+1);
    }

    public static void displayArrRev(int[] arr, int idx){

        if(idx == -1)
            return;
        System.out.println(arr[idx]);

        displayArr(arr, idx-1);
    }
}