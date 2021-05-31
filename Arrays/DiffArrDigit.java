package Pep.Arrays;



import java.util.Scanner;

/**
 * DiffArrDigit
 */
public class DiffArrDigit {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a1[] = getArr(n,sc);
        int n2 = sc.nextInt();
        int a2[] = getArr(n2, sc);
        int s[] = diifOfArray(a1,a2);
        printArray(s);
        sc.close();
    }
    private static void printArray(int[] s) {
        int i = 0;

        while(i < s.length){
            if(s[i] != 0)
                break;
            i++;
        }

        while(i < s.length)
            System.out.println(s[i++]);
    }
    private static int[] diifOfArray(int[] a1, int[] a2) {
        int n = a2.length;
        int arr[] = new int[n];
        // assuming a2 is greater than a1
        int i = a1.length-1;
        int j = a2.length-1;
        int k = arr.length-1;
        int b = 0; // initially carry is zero 
        while(k >= 0){
            arr[k] = -b;

            if(j >= 0)
                arr[k] += a2[j];

            if(i >= 0)
            arr[k] -= a1[i];
            
            if(arr[k] < 0){
                arr[k] += 10;
                b = 1;
            } else {
                b = 0;
            }
        
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