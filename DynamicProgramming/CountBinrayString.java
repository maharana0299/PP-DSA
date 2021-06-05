import java.util.Scanner;

public class CountBinrayString {
    
    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int end0 = 1;
        int end1 = 1;
        
        for(int i = 2; i <= n; i++) {
            
            int t = end0;
            end0 = end1;
            end1 = end1 + t;
        }
        
        System.out.println(end1 + end0);
    }
}
