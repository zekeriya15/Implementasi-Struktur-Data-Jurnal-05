import java.util.Scanner;
import java.util.Stack;

public class InfixToPostfix {

    public static String infixToPostfix(String infix) {     // a*(b+c)
        String postfix = "";        // abc+*
        Stack<Character> operatorStack = new Stack<>();     // 

        for(int i = 0; i < infix.length(); i++) {       //7
            char current = infix.charAt(i);     // )

            if(isOperator(current)) {
                while(!operatorStack.empty() && hasLowerPrecedence(current, operatorStack.peek()) && operatorStack.peek() != '(') {
                    postfix += operatorStack.pop();
                }

                operatorStack.push(current);  // 
            }
            else if(current == '(') {
                operatorStack.push(current);
            }
            else if(current == ')') {
                while(!operatorStack.empty() && operatorStack.peek() != '(') {
                    postfix += operatorStack.pop();     // we pop the top of the stack out and put it to the postfix NOT the current
                }
                operatorStack.pop();  // to remove opening parenthesis, there is a chance that the top of the stack is '(' so we pop the '(' out
            }
            else{
                postfix += current;
            }
        }

        while(!operatorStack.empty()) {
            postfix += operatorStack.pop();
        }

        return postfix;
    }

    public static boolean isOperator(char operator) {
        if(operator == '+' || operator == '-' || operator == '*' || operator == '/' || operator == '%') {
            return true;
        } else{
            return false;
        }
    }

    public static int precedence(char operator) {
        int precedence = 0;

        switch (operator) {
            case '+':
            case '-':
                precedence = 1;    
                break;
            case '*' :
            case '/' :
                precedence = 2;
                break;
            case '^' :
                precedence = 3;
                break;
            // default:
            //     precedence = 4;
            //     break;
        }
        return precedence;
    }

    public static boolean hasLowerPrecedence(char op1, char op2) {
        return precedence(op1) < precedence(op2);
    }



    public static void main(String[] args) {
        Scanner s = new Scanner (System.in);

        System.out.print("insert infix expression: ");
        String infix = s.nextLine();

        String result = infixToPostfix(infix);
        System.out.println("postfix: " + result);
    }
    //test
}


