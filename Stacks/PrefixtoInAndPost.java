import java.io.*;
import java.util.*;

public class PrefixtoInAndPost{
  

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();
    
        prefixConvert(exp);
    }
    
    static void prefixConvert(String exp){
        
        Stack<Integer> eval = new Stack<>();
        Stack<String> postfix = new Stack<>();
        Stack<String> infix = new Stack<>();
        
        // travel right to left
        for(int i = exp.length()-1; i >= 0;i--) {
            
            char ch = exp.charAt(i);
            
            if(ch >= '0' && ch <= '9') {
                eval.push(ch-'0');
                infix.push(ch+"");
                postfix.push(ch+"");
            } else {
                
                int a = eval.pop();
                int b = eval.pop();
                
                int val = calculate(a,b,ch);
                
                eval.push(val);
                
                // infix 
                String x = infix.pop();
                String y = infix.pop();
                
                infix.push("(" + x + ch + y + ")");
                
                // postfix 
                x = postfix.pop();
                y = postfix.pop();
                
                postfix.push(x + y + ch);
            }
        }
        
        System.out.println(eval.peek());
        System.out.println(infix.peek());
        System.out.println(postfix.peek());
    }
    
    static int calculate(int a, int b, char op){
        if(op == '+')   return a+b;
        else if(op == '-')  return a-b;
        else if(op == '*')  return a*b;
        else if(op == '/')  return a/b;
        else return -1;
    }
}