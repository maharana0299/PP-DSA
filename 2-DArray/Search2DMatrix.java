import java.util.Scanner;

public class Search2DMatrix {

    /*your task is to complete this function which returns true if target exists in the matrix
    else return false*/
    public static boolean search(int[][]matrix,int target) {
        
        int low=0;
        int high=matrix.length-1;
        
        // 2 binary search
        // find potential row
        // find element in that row
        // if found, return tru else in end return false
        while(low<=high){
            
            int mid=(low+high)/2;
            if(matrix[mid][0]<=target && matrix[mid][matrix[0].length-1]>target){
               int i=0;
              int j=matrix[0].length-1;
             while(i<=j){
                int k=(i+j)/2;
                if(matrix[mid][k]==target){
                  return true;
                }else if(target<matrix[mid][k]){
                  j=k-1;
                }else{
                  i=k+1;
                }
                }
                }else if(target<matrix[mid][0]){
                  high=mid-1;
                }else{
                  low=mid+1;
                }
        }
        return false;
    }

    public static void main(String[]args) {
        //input work
        Scanner scn = new Scanner(System.in);
        int m = scn.nextInt();
        int n = scn.nextInt();

        int[][]matrix = new int[m][n];

        for(int i=0; i < m;i++) {
            for(int j=0; j < n;j++) {
                matrix[i][j] = scn.nextInt();
            }
        }

        int target = scn.nextInt();

        boolean isFound = search(matrix,target);
        System.out.println(isFound);
        scn.close();
    }
}