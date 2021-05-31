package Pep.Arrays;



import java.util.Scanner;

/**
 * FindElement
 */
public class FindElement {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];

        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int ele  = sc.nextInt();
        int eleIndex = searchForElement(arr,ele);
        System.out.println(eleIndex);
        sc.close();
    }

    private static int searchForElement(int[] arr, int ele) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == ele)
                return i;
        }
        return -1;
    }
}