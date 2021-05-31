package  Patterns;

import java.util.Scanner;

/**
 * Pattern16
 */
public class Pattern16 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
    
        int n = scn.nextInt();
        
        int sp = (n-1)*2  - 1;
        int nums = 1;
        
        for(int i = 1; i <= n; i++){
            
            for(int j = 1; j <= nums; j++){
                System.out.print(j + "\t");
            }
            
            for(int j = 1; j <= sp; j++){
                System.out.print("\t");
            }
            
            if (sp <= 0)
                nums--;
            for(int j = nums; j > 0; j--){
                System.out.print(j + "\t");
            }
            
            sp -= 2;
            nums++;
            System.out.println();
        }

        scn.close();
     }
}