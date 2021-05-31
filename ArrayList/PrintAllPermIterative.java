package Pep.ArrayList;

import java.util.Scanner;

/**
 * PrintAllPermIterative
 */
public class PrintAllPermIterative {

    public static void solution(String str){
		
		int per = fact(str.length());
		int n = str.length();
		
		for(int num = 0; num < per; num++) {
		    
		    StringBuilder sb = new StringBuilder(str);
		    int t = num;
		    for(int div = n; div >= 1; div--) {
		        
		        int r = t%div;
		        t /= div;
		        
		        System.out.print(sb.charAt(r));
		        sb.deleteCharAt(r);
		    }
		    
		    System.out.println();
		}
	}
	public static void main(String[] args) {
		
        Scanner scn = new Scanner(System.in);
		String str = scn.next();
		solution(str);
        scn.close();
	}

    public static int fact(int n) {
	    
	    if(n == 1 || n == 0)
	        return 1;
	    return n * fact(n-1);
	   
	}
}