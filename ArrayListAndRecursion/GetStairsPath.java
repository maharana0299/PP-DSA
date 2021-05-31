package Pep.ArrayListAndRecursion;

import java.util.ArrayList;
import java.util.Scanner;


/**
 * GetStairsPath
 */
public class GetStairsPath {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<String> paths = getStairPaths(n);
        System.out.println(paths);
        sc.close();
    }

    public static ArrayList<String> getStairPaths(int n) {
        
        if (n == 0) {
            ArrayList<String> ls = new ArrayList<>();
            ls.add("");
            return ls;
        }
        
        if (n < 0) {
             ArrayList<String> ls = new ArrayList<>();
            return ls;
        }
        
        ArrayList<String> getString = getStairPaths(n-1); 
        ArrayList<String> ns = new ArrayList<>();
        for (String i : getString) {
           ns.add("1" + i);
        }
        
        getString = getStairPaths(n-2);
        for (String i : getString) {
           ns.add("2" + i);
        }
        
        getString = getStairPaths(n-3);
        for (String i : getString) {
           ns.add("3" + i );
        }
        
        return ns;
    }

}