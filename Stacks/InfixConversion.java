import java.io.*;
import java.util.*;

public class InfixConversion {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        convertInfix(exp);
    }

    static void convertInfix(String exp) {

        Stack<Character> operator = new Stack<>();
        Stack<String> postfix, prefix;
        postfix = new Stack<>();
        prefix = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {

            char ch = exp.charAt(i);

            if (ch == '(') {
                operator.push(ch);
            } else if (ch == ')') {

                while (operator.peek() != '(') {

                    evalute(operator, prefix, postfix);
                }

                operator.pop(); // popping '('

            } else if (ch == '+' || ch == '-' || ch == '/' || ch == '*') {

                while (operator.size() > 0 && operator.peek() != '(' && priority(ch) <= priority(operator.peek())) {

                    evalute(operator, prefix, postfix);
                }

                operator.push(ch);
            } else {
                prefix.push(ch + "");
                postfix.push(ch + "");
            }
        }

        while (operator.size() > 0) {
            evalute(operator, prefix, postfix);
        }

        System.out.println(postfix.peek());
        System.out.println(prefix.peek());
    }

    private static void evalute(Stack<Character> operator, Stack<String> prefix, Stack<String> postfix) {
        String b = prefix.pop();
        String a = prefix.pop();
        char op = operator.pop();
        prefix.push(op + a + b);

        b = postfix.pop();
        a = postfix.pop();

        postfix.push(a + b + op);
    }

    static int priority(char c) {

        if (c == '*' || c == '/') {
            return 2;
        } else if (c == '+' || c == '-') {
            return 1;
        } else
            return 0;
    }
}