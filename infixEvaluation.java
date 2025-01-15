// import java.io.BufferedReader;
// import java.io.InputStreamReader;
// import java.util.*;

// public class infixEvaluation {
//     public static int precedence(char ch){
//         if(ch=='+'){
//             return 1;


//         }else if(ch =='-'){
//             return 1;

//         }else if(ch =='*'){
//             return 2;

//         }else 
//             return 2;


//         }

//         public static int evluate(int  c1, int c2, char operator){
//             if(operator =='+'){
//                 return c1+c2;
//             }else if(operator =='-'){
//                 return c1-c2;
//             }else if(operator=='*'){
//                 return c1 *c2;
//             }else
//             return c1/c2;
//         }

    
//     public static void main(String[] args) throws Exception {
//         BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
//         String exp = br.readLine();
//         Stack <Integer> oprnds = new Stack<>();
//         Stack<Character> opertrs = new Stack<>();
//         for(int i=0;i<exp.length();i++){
//             char ch = exp.charAt(i);

//             if(ch =='('){
//                 opertrs.push(ch);
//             }
//             else if(ch ==')'){
//                 while (opertrs.peek()!='(') {
//                     char operator = opertrs.pop();
//                     int val2 = oprnds.pop();
//                     int val1 = oprnds.pop();
//                     oprnds.push(evluate(val1, val2, operator));

                    
//                 }
//                 opertrs.pop();

//             }
//             else if(Character.isDigit(ch)){
//                 oprnds.push(ch-'0');
//             }
//             else if(ch=='+' || ch=='-' ||ch=='*' || ch =='/'){
//                 while (opertrs.size()>0&& opertrs.peek()!='('&& precedence(opertrs.peek())>=precedence(ch)){
//                     char operator = ch;
//                     int val2 = oprnds.pop();
//                     int val1 = oprnds.pop();
//                     oprnds.push(evluate(val1, val2, operator));

                    


//                 }
//                opertrs.push(ch);

//             }


            

//     }
//     while (opertrs.size()>0){
//         char operator = opertrs.pop();
//         int val2 = oprnds.pop();
//         int val1 = oprnds.pop();
//         oprnds.push(evluate(val1, val2, operator));

        


//     }

//     System.out.println(oprnds.peek());
    
// }
    
// }


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class infixEvaluation {
    // Determine the precedence of operators
    public static int precedence(char ch) {
        if (ch == '+' || ch == '-') {
            return 1;
        } else if (ch == '*' || ch == '/') {
            return 2;
        } else {
            return 0; // For '(' or invalid characters
        }
    }

    // Evaluate an operation
    public static int evaluate(int val1, int val2, char operator) {
        if (operator == '+') {
            return val1 + val2;
        } else if (operator == '-') {
            return val1 - val2;
        } else if (operator == '*') {
            return val1 * val2;
        } else { // operator == '/'
            return val1 / val2;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter infix expression: ");
        String exp = br.readLine();

        Stack<Integer> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if (ch == '(') {
                operators.push(ch);
            } else if (Character.isDigit(ch)) {
                operands.push(ch - '0'); // Convert char digit to int
            } else if (ch == ')') {
                while (operators.peek() != '(') {
                    char operator = operators.pop();
                    int val2 = operands.pop();
                    int val1 = operands.pop();
                    operands.push(evaluate(val1, val2, operator));
                }
                operators.pop(); // Remove '('
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (!operators.isEmpty() && operators.peek() != '(' &&
                        precedence(operators.peek()) >= precedence(ch)) {
                    char operator = operators.pop();
                    int val2 = operands.pop();
                    int val1 = operands.pop();
                    operands.push(evaluate(val1, val2, operator));
                }
                operators.push(ch);
            }
        }

        // Process remaining operators
        while (!operators.isEmpty()) {
            char operator = operators.pop();
            int val2 = operands.pop();
            int val1 = operands.pop();
            operands.push(evaluate(val1, val2, operator));
        }

        // Final result
        System.out.println("Result: " + operands.peek());
    }
}
