package Arrays;

import java.util.Scanner;

/**
 * firstAndLastIndex
 */
public class firstAndLastIndex {

    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int ele = sc.nextInt();
        findIndexAndPrint(arr,ele);
        sc.close();
        
    }
    
    public static void findIndexAndPrint(int arr[], int ele){
        int n = arr.length;
        int first = -1;
        int last = -1;
        boolean isFound = false;
        for(int i = 0; i < n; i++) {
            if(arr[i] == ele){
              if(!isFound){
                isFound = true;
                first = i;
                last = i;
              } else {
                last = i;
              }  
            } 
        }
        
        System.out.println(first);
        System.out.println(last);
    }

    public int firstIndex(int arr[], int data){
        int fi = -1;
        int lo = 0;
        int hi = arr.length;

        while(lo<=hi){

            int mid = (lo+hi)/2;

            if(arr[mid] == data){
                fi = mid;
                hi = mid - 1;
            } else if(arr[mid] < data){
                lo = mid + 1;
            } else {
                hi = mid-1;
            }
        }
        return fi;
    }

    public int lastIndex(int arr[], int data){
        int li = -1;
        int lo = 0;
        int hi = arr.length;

        while(lo<=hi){

            int mid = (lo+hi)/2;

            if(arr[mid] == data){
                li = mid;
                lo = mid + 1;
            } else if(arr[mid] < data){
                lo = mid + 1;
            } else {
                hi = mid-1;
            }
        }
        return li;
    }
}