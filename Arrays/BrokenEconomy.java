package Pep.Arrays;

import java.util.Scanner;
/**
 * BrokenEconomy
 */
public class BrokenEconomy {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int ele = sc.nextInt();

        printHighAndLow(arr,ele);
        sc.close();
    }

    private static void printHighAndLow(int[] arr, int ele) {

        int low = 0, high = arr.length-1;
        int lowEle = 0, highEle = 0;

        while(low <= high){

            int mid = low + (high-low)/2;
            if(arr[mid] == ele){
                lowEle = highEle = arr[mid];
                break;
            } else if(arr[mid] > ele){
                highEle = arr[mid];
                high = mid-1;
            } else {
                lowEle = arr[mid];
                low = mid+1;
            }
        }

        System.out.println(highEle);
        System.out.println(lowEle);
    }

}