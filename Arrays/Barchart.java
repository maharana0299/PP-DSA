package Pep.Arrays;



import java.util.Scanner;

/**
 * Barchart
 */
public class Barchart {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        
        plotChart(arr);
        sc.close();
    }
    
    private static void plotChart(int[] arr) {

        int highest = getHighest(arr);
        while(highest > 0){
            for (int i = 0; i < arr.length; i++) {
                if(arr[i] == highest){
                    System.out.print("*\t");
                    arr[i] -= 1;
                } else {
                    System.out.print("\t");
                }
            }
            highest--;
            System.out.println();
        }
    }

    private static int getHighest(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if(max < arr[i])
                max = arr[i];
        }
        return max;
    }
}