package Arrays;


import java.util.Scanner;

/**
 * PrintAllSubsets
 */
public class PrintAllSubsets {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        printAllSubsets(arr,0,"");
        sc.close();
    }

    private static void printAllSubsets(int[] arr, int i, String string) {

        if(i == arr.length){
            System.out.println(string);
            return;
        }

        printAllSubsets(arr,i+1,string + "\t" + "-");
        printAllSubsets(arr, i+1, string + "\t" + arr[i]);

    }

    public static void printSubset(int arr[]){
        // total subset ?
        int n = arr.length;
        int totalSubset = (int) Math.pow(2,n);

        for(int i = 0; i < totalSubset; i++) {
            int binary[] = getBinary(i,n);

            for(int j = 0; j < n; j++) {
                if(binary[j] == 0) {
                    System.out.print("-\t");
                } else {
                    System.out.print(arr[j] + "\t");
                }
            }

            System.out.println();
        }
    }

    private static int[] getBinary(int i, int n) {
        int binary[] = new int[n];

        int len = n;

        while(i > 0) {
            int rem = i %2;
            if(rem == 1){
                binary[--len] = 1;
            } else {
                binary[--len] = 0;
            }
            i /= 2;
        }
        return binary;
    }

}