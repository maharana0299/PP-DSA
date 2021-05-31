package Pep.ArrayListAndRecursion;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * GetSubsequence
 */
public class GetSubsequence {
    
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        
        ArrayList<String> subsequeList = gss(new StringBuilder(s));

        System.out.println(subsequeList);
        sc.close();
    }

    public static ArrayList<String> gss(StringBuilder str) {

        if(str.toString().equals("")){
            ArrayList<String> ls =  new ArrayList<String>();
            ls.add("");
            return ls;
        }

        ArrayList<String> ls = gss(new StringBuilder(str.substring(1)));
        
        ArrayList<String> newList = new ArrayList<>();
        char ch = str.charAt(0);

        for (String s : ls) {
            newList.add(s);
        }

        for(String s : ls) {
            newList.add(ch+s);
        }
    
        return newList;
    }
}