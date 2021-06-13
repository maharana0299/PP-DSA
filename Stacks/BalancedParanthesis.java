import java.util.*;

public class BalancedParanthesis {

    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        
        boolean isBalanced = balancedBrakets(s);
        System.out.println(isBalanced);
    }
    
    static boolean balancedBrakets(String s){
        
        Stack<Character> st = new Stack<>();
    
        for(int i = 0; i < s.length(); i++){
            
            char ch = s.charAt(i);
            
            // if opening, then push to stack
            if(ch == '(' || ch == '[' || ch == '{') {
                st.push(ch);
            } else if(ch == ')' || ch == ']' || ch == '}') {
                // if closing, then find its valid opening
                char op = findOpening(ch);
                
                // if size is greater than zero, and opening is at stack's peek
                // then pop
                if(st.size() > 0 && op == st.peek()) {
                    st.pop();
                } else {
                    // else return false
                    return false;
                }
            } else if(ch != ' ') {
                // do nothing 
            }
        }
        
        if(st.size() > 0)
                return false;
            else return true;
    }
    
    static char findOpening(char ch) {
        
        if(ch == ')')
            return '(';
        else if(ch == ']') 
            return '[';
        else return '{';
    }

}