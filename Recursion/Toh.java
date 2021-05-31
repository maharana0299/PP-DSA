package Pep.Recursion;

import java.util.Scanner;

/**
 * toh
 */
public class Toh {

    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t1id = sc.nextInt();
        int t2id = sc.nextInt();
        int t3id = sc.nextInt();
        
        toh(n,t1id,t2id,t3id);
        sc.close();
    }

    public static void toh(int n, int t1id, int t2id, int t3id){
        
        if(n == 1){
            
            System.out.println(n+"["+t1id+" -> "+t2id+"]");
            return;
        }
        
        toh(n-1,t1id,t3id,t2id);
        System.out.println(n+"["+t1id+" -> "+t2id+"]");
        toh(n-1,t3id,t2id,t1id);
        // System.out.println(n+"["+t1id+"->"+t3id+"]");
        
    }
}