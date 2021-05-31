package Pep.ArrayListAndRecursion;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * GetKpc
 */
public class GetKpc {

    static String [] keys = {".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
    
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        String code = sc.nextLine();

        System.out.println(getKPC(code));

        sc.close();
    }

    public static ArrayList<String> getKPC(String str) {
        
        if(str.length() == 0){
            ArrayList<String> ls  = new ArrayList<>();
            ls.add("");
            return ls;
        }

        ArrayList<String> ls = getKPC(str.substring(1));
       
        int code = str.charAt(0) - '0';
        
        String codeString = keys[code];
        ArrayList<String> newList = new ArrayList<>();

        for(int i = 0; i < codeString.length(); i++) {
            char c = codeString.charAt(i);

            for(String ele : ls) {
                newList.add(c+ele);
            }
        }

        return newList;
    }
}