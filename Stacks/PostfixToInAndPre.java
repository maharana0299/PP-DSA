import java.io.*;
import java.util.*;

public class PostfixToInAndPre{
  

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();
    
        evalPostfix(exp);
    }
    
    static void evalPostfix(String exp) {
        Stack<Integer> eval = new Stack<>();
        Stack<String> infix = new Stack<>();
        Stack<String> prefix = new Stack<>();
        
        for(int i = 0; i < exp.length() ; i++) {
            
            char ch = exp.charAt(i);
            
            if(ch >= '0' && ch <= '9') {
                
                eval.push(ch-'0');
                infix.push(ch+"");
                prefix.push(ch+"");
            } else {
                // operator
                
                // value stack
                int vy = eval.pop();
                int vx = eval.pop();
                
                int val = calculate(vx,vy,ch);
                eval.push(val);
                
                // infix stack
                String y = infix.pop();
                String x = infix.pop();
                infix.push("(" +  x + ch + y +")");
                
                // prefix stack
                y = prefix.pop();
                x = prefix.pop();
                prefix.push(ch+x+y);
            }
        }
        
        System.out.println(eval.pop());
        System.out.println(infix.pop());
        System.out.println(prefix.pop());
    }
    
    static int calculate(int a, int b, char op){
        
        if(op == '+')   return a+b;
        else if(op == '-')  return a-b;
        else if(op == '*')  return a*b;
        else if(op == '/')  return a/b;
        else return -1;
    }
}