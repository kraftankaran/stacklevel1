// import java.util.*;

// public class prefixEvalAndConversion {

//     public static int Calculate(char ch , int v1, int v2){
//         if(ch=='+'){
//             return v1+v2;
//         }else if(ch =='-'){
//             return v1-v2;

//         }else if(ch=='/'){
//             return v1/v2;
//         }
//         else if(ch =='*'){
//             return v1*v2;
//         }
        
//         else
//         return 0;
//     }
//     public static void main(String[] args) {


        
//         Scanner sc = new Scanner(System.in);
//         String exp = sc.nextLine();
//         Stack<Integer>value = new Stack<>();
//         Stack<String> postfix = new Stack<>();
//         Stack<String> infix = new Stack<>();
//         for(int i=exp.length()-1 ;i>=0;i--){
//             char ch = exp.charAt(i);
//             if(Character.isDigit(ch)){
//                 value.push(ch-'0');
//                 postfix.push(ch+"");
//                 infix.push(ch+"");

//             }else{

//                 int val1= value.pop();
//                 int val2=value.pop();
//                 value.push(Calculate(ch, val1, val2));

//                 String post1 = postfix.pop();
//                 String post2 = postfix.pop();
//                 postfix.push(post1 + post2+ ch );

//                 String infi1 = infix.pop();
//                 String infi2 = infix.pop();
//                 infix.push("("+ infi1 + infi2+ ch + ")");

                
//             }

//         }

//         System.out.println("value is "+ value.pop());
//         System.out.println("infix is " + infix.pop());
//         System.out.println("postfix is"+ postfix.pop());

//     }
    
// }
import java.util.*;

public class prefixEvalAndConversion {

    public static int calculate(char operator, int v1, int v2) {
        switch (operator) {
            case '+':
                return v1 + v2;
            case '-':
                return v1 - v2;
            case '*':
                return v1 * v2;
            case '/':
                return v1 / v2;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a prefix expression: ");
        String exp = sc.nextLine();

        Stack<Integer> valueStack = new Stack<>();
        Stack<String> postfixStack = new Stack<>();
        Stack<String> infixStack = new Stack<>();

        // Loop from right to left
        for (int i = exp.length() - 1; i >= 0; i--) {
            char ch = exp.charAt(i);

            if (Character.isDigit(ch)) {
                // Push operands
                valueStack.push(ch - '0');
                postfixStack.push(ch + "");
                infixStack.push(ch + "");
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                // Pop values for calculation
                int v1 = valueStack.pop();
                int v2 = valueStack.pop();
                valueStack.push(calculate(ch, v1, v2));

                // Pop and combine for postfix
                String post1 = postfixStack.pop();
                String post2 = postfixStack.pop();
                postfixStack.push(post1 + post2 + ch);

                // Pop and combine for infix
                String infi1 = infixStack.pop();
                String infi2 = infixStack.pop();
                infixStack.push("(" + infi1 + ch + infi2 + ")");
            }
        }

        // Final results
        System.out.println("Evaluated value: " + valueStack.pop());
        System.out.println("Infix expression: " + infixStack.pop());
        System.out.println("Postfix expression: " + postfixStack.pop());
    }
}

