package Pep.Arrays;



import java.util.Scanner;
public class BinarySearch {

    public static int search(int[] arr, int key) {

        int low = 0;
        int high = arr.length;

        while(low <= high) {
            int mid= (low+high)/2;
            if(arr[mid]==key)
                return mid;
            else if(arr[mid] > key){
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return -1;
    }
 
 	 public static void main(String[] args) {
 
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < ar.length; i++) {
            ar[i] = s.nextInt();
        }
        int key = s.nextInt();
        System.out.println(search(ar, key));
        s.close();
    }
}

 	