package Pep.Arrays;



import java.util.Scanner;
/**
 * PrintAllSubArr
 */
public class PrintAllSubArr {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr =new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        subArray(arr);

        sc.close();
    }

    public static void subArray(int[] arr){
        int n=arr.length;
        for (int i=0; i <n; i++) //This loop will select start element
        {
            for (int j=i; j<n; j++)   //This loop will select end element
            {
                for (int k=i; k<=j; k++) //This loop will print element from start to end
                {
                    System.out.print( arr[k]+"	"); 
                }
                System.out.println();
            }
        }
    }

    public static void subArrayM2(int[] arr){
        int n=arr.length;
        for (int i=0; i <n; i++){
            StringBuilder s = new StringBuilder("");
            for (int j=i; j<n; j++){ 
                s.append(arr[j] + "\t");
                System.out.println(s.toString());
            }
        }
        
    }

}