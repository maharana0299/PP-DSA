package  Patterns;

import java.util.Scanner;

/**
 * Pattern17
 */
public class Pattern17 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int sp;
        int a;
        for(int i = 1; i <= n; i++){
            
            sp = i == n/2+1? 0 : n/2;
            for(int j = 1; j <= sp; j++){
                System.out.print("\t");
            }
            
            if(i <= n/2){
                a = i;
            } else if(i == n/2+1){
                a = n;
            } else {
                a = n - i + 1;
            }
            for(int j = 1; j <= a; j++){
                System.out.print("*\t");
            }
            
            System.out.println();
        }
        scn.close();
    }
}