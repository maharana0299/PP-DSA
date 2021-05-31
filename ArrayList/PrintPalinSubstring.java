package Pep.ArrayList;

import java.util.Scanner;

/**
 * PrintPalinSubstring
 */
public class PrintPalinSubstring {

    public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		printAllPalendromicString(str);
        scn.close();
	}
	
	public static void printAllPalendromicString(String s){

        int n = s.length();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                isPalindrome(s.substring(i,j + 1));
            }
        }
    }

    private static void isPalindrome(String substring) {
        
        int n = substring.length();

        boolean isPalim = true;
        for (int i = 0; i < n/2; i++){
            if (substring.charAt(i) != substring.charAt(n - i - 1)) {
                isPalim = false;
                break;
            }
        }
        if (isPalim)
            System.out.println(substring);
    }

}