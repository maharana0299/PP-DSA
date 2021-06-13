
import java.util.*;

public class DuplicateBrackets {

    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        
        String s = sc.nextLine();
        boolean containsDuplicate = checkDuplicates(s);
        
        System.out.println(containsDuplicate);

    }
    
    /**
     * If ( or alphabet or operator -> push 
     * ) -> pop
     * if st.peek() is ( -> return 
     * */
    static boolean checkDuplicates(String str) {
        
        Stack<Character> s = new Stack<>();
        
        for(int i = 0; i < str.length(); i++) {
            
            char ch = str.charAt(i);
            if(ch == ')') {
                
                // if first element is stack is '(', then return true => duplicate bracket found 
                if(s.peek() == '(') {
                    return true;
                }
                
                // pop till not finding '('
                while(s.peek() != '(' )
                    s.pop();
                
                // pop '('
                s.pop();
            } else if(ch != ' '){
                // dont include space 
                s.push(ch);
            }
        }
        
        return false;
    }

}