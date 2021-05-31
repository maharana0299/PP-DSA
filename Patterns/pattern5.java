package  Patterns;

import java.util.Scanner;

/**
 * pattern5
 */
public class pattern5 {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int sp = n/2;
        int st = 1;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < sp; j++) {
                System.out.print("\t");
            }
            for(int j = 0; j < st; j++) {
                System.out.print("*\t");
            }
            
            if (i >= n/2) {
                sp += 1;
                st -= 2;
            } else {
                sp -= 1;
                st += 2;
            }

            System.out.println();
        }

        scn.close();
    }

    public static void methodtwo(){
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
    
        
        for(int r = 1; r <= n; r++) {
            for(int c = 1; c <= n; c++) {
                
                if(r + c < (n + 3)/2){
                    System.out.print("\t");
                } else if((c-r) > (n-1)/2 ){
                    System.out.print("\t");
                } else if((r+c) > (3*n + 1)/2){
                    System.out.print("\t");
                } else if((r-c) > (n-1) /2){
                    System.out.print("\t");
                } else {
                    System.out.print("*\t");
                }
            }
            System.out.print("\n");
        }
        scn.close();
    }
}