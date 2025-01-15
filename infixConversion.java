import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class infixConversion {

    public static int precedence(char ch){
        if(ch =='+'){
            return 1;

        }
        else if(ch =='-'){
            return 1;

        }else if(ch=='*'){
            return 2;

        }
        else if(ch =='/'){
            return 2;

        }
        else 
        return 0;
    }

    public static void calculate(Stack<Character> oprt, Stack<String> prefix , Stack<String> postfix){

        char op = oprt.pop();
        String pre2 =prefix.pop();
        String pre1 =prefix.pop();
        prefix.push(  op+ pre1 + pre2 );

        String post2 = postfix.pop();
        String post1 =postfix.pop();
        postfix.push(post1+ post2 + op);

    }
    public static void main(String[] args) throws Exception {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();
        Stack<String> prefix = new Stack<>();
        Stack<String> postfix= new Stack<>();
        Stack<Character> oprt= new Stack<>();

        for(int i=0;i<exp.length();i++){

            char ch = exp.charAt(i);

            if(ch=='('){
                oprt.push(ch);

            }
            else if ((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                prefix.push(ch + "");
                postfix.push(ch + "");
            }
            else if(ch==')'){
                while (oprt.peek()!='(') {
                    calculate(oprt, prefix, postfix);
                    
                }
                oprt.pop();

            }else if(ch =='+'|| ch=='-'|| ch=='*'|| ch=='/'){
                while (oprt.size()>0 && oprt.peek()!='(' && precedence(ch)<= precedence(oprt.peek()) ) {
                    calculate(oprt, prefix, postfix);

                    
                }
                oprt.push(ch);


            }
            System.out.println("Operator stack: " + oprt);
            System.out.println("Prefix stack: " + prefix);
            System.out.println("Postfix stack: " + postfix);
        }

        while(oprt.size()>0){
            calculate(oprt, prefix, postfix);
            
        }

        System.out.println("prefix is "+ prefix.peek());
        System.out.println("postfix is "+ postfix.peek());
        
    }
    
}
