import java.util.Stack;

public class PostfixEval {
    private String infixString;
    private Stack s;

    public PostfixEval(String iString) {
        infixString = iString;
        s = new Stack<>();
        String outputString = "";
        boolean firstItem = false;

        for(int i = 0; i < infixString.length(); i++) {
            char currItem = infixString.charAt(i);

            if(!isOperator(currItem)) {
                outputString += Character.toString(currItem);

                if(i == (infixString.length() - 1)) {
                    while(!s.empty()) {
                        outputString += s.pop();
                    }
                } 

            } else{

                if(firstItem) {
                    if(plusMinus(currItem) && plusMinus((Character)s.peek())) {
                        outputString += s.pop();
                        s.push(currItem);

                        if(i == (infixString.length() - 1)) {
                            while(!s.empty()) {
                                outputString += s.pop();
                            }
                        }
                    }
                    else if(mulDiv(currItem) && mulDiv((Character)s.peek())) {
                        outputString += s.pop();
                        s.push(currItem);

                        if(i == (infixString.length() - 1)) {
                            while(!s.empty()) {
                                outputString += s.pop();
                            }
                        }
                    }
                    else if(plusMinus(currItem) && mulDiv((Character)s.peek())) {
                        outputString += s.pop();
                        s.push(currItem);

                        if(i == (infixString.length() - 1)) {
                            while(!s.empty()) {
                                outputString += s.pop();
                            }
                        }
                    }
                    else if(mulDiv(currItem) && plusMinus((Character)s.peek())) {
                        s.push(currItem);

                        if(i == (infixString.length() - 1)) {
                            while(!s.empty()) {
                                outputString += s.pop();
                            }
                        }
                    }
                    else {
                        outputString += Character.toString(currItem);

                        if(i == (infixString.length() - 1)) {
                            while(!s.empty()) {
                                outputString += s.pop();
                            }
                        }
                    }
                } else{
                    s.push(currItem);
                    firstItem = true;
                }
            }
        }
        System.out.println(outputString);
    }

    public boolean isOperator (char op) {
        switch(op) {
            case '+' :
                return true;
            case '-' :
                return true;
            case '*' :
                return true;
            case '/' :
                return true;
            case '^' :
                return true;
            default :
                return false;
        }
    }

    public boolean plusMinus (char op) {
        switch(op) {
            case '+' :
                return true;
            case '-' :
                return true;
            default :
                return false;
        }
    }

    public boolean mulDiv (char op) {
        switch(op) {
            case '*' :
                return true;
            case '/' :
                return true;
            default :
                return false;
        }
    }








    // public PostfixEval(String infixString) {
    //     this.infixString = infixString;
    //     this.s = s;
    // }

    
}
