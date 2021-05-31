import java.util.Scanner;

/**
 * SearchInSortedArray
 */
public class SearchInSortedArray {
    
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = n;
        int arr[][] = new int[n][m];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        int s = sc.nextInt();
        
        searchInSortedMatrix(arr,s);

        sc.close();
    }
    
    public static void searchInSortedMatrix(int[][] arr, int data) {
        /**
         * start from arr[0][length-1]
         * if data is greater then move down
         * else data is smaller move left
         * else if equal then print and return
         */
        int i = 0, j = arr[0].length - 1;

        while (i < arr.length && j >= 0) {
            if (arr[i][j] == data) {
                System.out.println(i + "\n" + j);
                return;
            } else if (arr[i][j] < data) i++;
            else 
                j--;
        }
        System.out.println("Not Found");
    }

    
}