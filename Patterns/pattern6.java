package  Patterns;

import java.util.Scanner;

/**
 * pattern6
 */

public class pattern6 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        
        int sp = 1;
        int stl = (n+1)/2;
        int slr = (n+1)/2;
        for(int i = 0; i < n; i++) {
            
            for(int j = 0; j < stl; j++) {
                System.out.print("*\t");
            }
            
            for(int  j = 0; j < sp; j++){
                System.out.print("\t");
            }
            
            for(int j = 0; j < slr; j++){
                System.out.print("*\t");
            }
            System.out.println();
            
            if( i >= n/2){
                sp -= 2;
                stl++;
                slr++;
            } else {
                sp += 2;
                stl --;
                slr--;
            }
        }

        scn.close();
    }
}