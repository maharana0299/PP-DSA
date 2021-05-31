package  Patterns;

import java.util.Scanner;

/**
 * Pattern18
 */
public class Pattern18 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int mid = (n+1)/2;
        int os = 1;
        int is = n - 4;

        for(int i = 1; i <= n; i++){
            System.out.print("*\t");
        }
        
        System.out.println();
        
        for(int i = 1; i < mid; i++){
            for (int j = 0; j < os; j++){
                System.out.print("\t");
            }

            System.out.print("*\t");

            for(int j = 0; j <is; j++){
                System.out.print("\t");
            }
            if (is > 0) System.out.print("*\t");

            os++;
            is = is - 2;
            
            System.out.println();
        }
        
        os--;
        int ch =1;
        for(int i = 0; i <  mid-1; i++) {
            
            ch = ch + 2;
            os--;
            
            for(int j = 0; j < os; j++){
                System.out.print("\t");
            }
            for(int j = 0; j < ch; j++) {
                System.out.print("*\t");
            }
            
            System.out.println();
        }

        scn.close();
    
    }

    void goodTrick(int n){
        int sp = 0;
        int st = n;
        
        for(int i = 1; i <= n; i++){
            
            for(int j = 1; j <= sp; j++){
                System.out.print("\t");
            }
            
            for(int j = 1; j <= st; j++){
                if(i > 1 && i <=  n/2 && j > 1 && j < st){
                    System.out.print("\t");
                } else {
                    System.out.print("*\t");
                }
            }
            
            if (i <= n/2){
                sp++;
                st -= 2;
            } else {
                sp--;
                st+= 2;
            }
            
            System.out.println();
        }
    }
}