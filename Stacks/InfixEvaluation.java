import java.io.*;
import java.util.*;

public class InfixEvaluation{

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();
    
        int ans = evaluateInfix(exp);
        System.out.println(ans);
    }
    
    static int evaluateInfix(String exp) {
        
        Stack<Integer> operand = new Stack<>();
        Stack<Character> operator = new Stack<>();
        
        for(int i = 0; i < exp.length() ; i++) {
            
            char ch = exp.charAt(i);
            
            if(ch == '(') {
                operator.push(ch);
            } else if(ch >= '0' && ch <= '9') {
                operand.push(ch-'0');
            } else if(ch == ')') {
                // evaluate till an opening comes 
                while(operator.peek() != '(') {
                    // do evaluation 
                    char opr = operator.pop();
                    int b = operand.pop();
                    int a = operand.pop();
                    int val = calculate(opr,a,b);
                    operand.push(val);
                }
                operator.pop(); // pop (
                
            } else if(ch == '+' || ch == '/' || ch == '-' || ch == '*'){
                
                // higher priority operators are evaluated first 
                while(operator.size() > 0 &&
                    operator.peek() != '(' &&
                    priority(ch) <= priority(operator.peek())
                )   {
                    char opr = operator.pop();
                    int b = operand.pop();
                    int a = operand.pop();
                    int val = calculate(opr,a,b);
                    operand.push(val);
                }
                
                // all higher priority are evalued 
                // now add it 
                operator.push(ch);
            }
        }
        
        while(operator.size() > 0) {
            char opr = operator.pop();
            int b = operand.pop();
            int a = operand.pop();
            int val = calculate(opr,a,b);
            operand.push(val);
        }
        
        return operand.peek();
    }
    
    static int calculate(char opr, int a, int b) {

        if(opr == '+')
            return a+b;
        else if(opr == '-')
            return a-b;
        else if(opr == '*')
            return b*a;
        else if(opr == '/')
            return a/b;
        else return -1;
    }
    
    static int priority(char c) {
        
       if(c == '*' || c == '/'){
            return 2;
        }else if(c == '+' || c == '-') {
            return 1;
        } else return 0;
    }
}