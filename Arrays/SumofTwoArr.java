package Arrays;


import java.util.Scanner;

/**
 * SumofTwoArr
 */
public class SumofTwoArr {
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a1[] = getArr(n,sc);
        int n2 = sc.nextInt();
        int a2[] = getArr(n2, sc);
        int s[] = addTwoArray(a1,a2);
        printArray(s);
        sc.close();
    }
    private static void printArray(int[] s) {
        for (int i : s) {
            System.out.println(i);
        }

    }
    private static int[] addTwoArray(int[] a1, int[] a2) {
        int n = Math.max(a1.length, a2.length);
        int arr[] = new int[n];

        int i = a1.length-1;
        int j = a2.length-1;
        int k = arr.length-1;
        int c = 0; // initially carry is zero 
        
        while(k >= 0){
            
            arr[k] = c;

            if(i >= 0)
                arr[k] += a1[i];
            if(j >= 0)
                arr[k] += a2[j];
            
            c = arr[k]/10;
            arr[k] %= 10;

            k--;
            i--;
            j--;
        }
        return arr;
    }
    private static int[] getArr(int n,Scanner sc) {
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }
}