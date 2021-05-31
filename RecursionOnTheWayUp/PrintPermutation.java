package RecursionOnTheWayUp;

import java.util.Scanner;

/**
 * PrintPermutation
 */
public class PrintPermutation {

    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        
        StringBuilder  s = new StringBuilder(sc.nextLine());
        printPermutations(s,new StringBuilder(""));
        sc.close();
    }

    public static void printPermutations(StringBuilder str, StringBuilder ans) {
        
        if (str.length() == 0 ) {
            System.out.println(ans.toString());
            return ;
        }

        for(int i = 0; i < str.length(); i++) {
            ans.append(str.charAt(i));
            printPermutations(new StringBuilder(str.substring(0, i) + str.substring(i+1)),ans);
            ans.deleteCharAt(ans.length()-1);
        }
    }

}