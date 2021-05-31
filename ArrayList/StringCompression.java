package ArrayList;

import java.util.Scanner;

/**
 * StringCompression
 */
public class StringCompression {

    public static String compression1(String str){
		// write your code here
        StringBuilder sb = new StringBuilder();

        int i = 0;

        while(i < str.length()) {

            char ch = str.charAt(i++);
            sb.append(ch);

            while(i < str.length()) {
                if(str.charAt(i) != ch)
                    break;
                else {
                    i++;
                }
            }
        }
		return sb.toString();
	}

	public static String compression2(String str){
		
        StringBuilder sb = new StringBuilder("");

        int i = 0;
    
        while(i < str.length()) {

            char ch = str.charAt(i++);
            int count = 1;
            sb.append(ch + "");

            while(i < str.length()) {
                if(str.charAt(i) != ch)
                    break;
                else {
                    i++;
                    count++;
                }
            }

            if(count > 1)
                sb.append(count);
        }
		return sb.toString();
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(compression1(str));
		System.out.println(compression2(str));

        scn.close();
	}
}