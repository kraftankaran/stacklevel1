
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class postfixevaluationAndconversion {
    public static int  calcuate(char ch, int v1, int v2){
        if(ch =='-'){
            return v1-v2;

        }
        else if(ch =='+'){
            return v1+v2;
        }
        else if(ch =='/'){
            return v1/v2;
        }else if( ch =='*'){
            return v1*v2;
        }
        else{
            return 0;
        }
    }
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        String exp = br.readLine();
        Stack<Integer> val = new Stack<>();
        Stack<String> prefix =new Stack<>();
        Stack <String> infix = new Stack<>();
        for (int i =0;i< exp.length();i++){

            char ch = exp.charAt(i);
            if(Character.isDigit(ch)){
                val.push(ch -'0');
                prefix.push(ch+"");
                infix.push(ch+"");


            }
            else if (ch=='+'||ch =='-' ||ch =='/' ||ch =='*'){
                int v2 =val.pop();
                int v1 = val.pop();
                val.push(calcuate(ch, v1, v2));

                String prefix2 = prefix.pop();
                String prefix1= prefix.pop();

                prefix.push(ch+prefix1+prefix2);

                String infix2 = infix.pop();
                String infix1= infix.pop();
                infix.push("("+ infix1 + ch+ infix2 +")");

                

            }
        }


        System.out.println("infix is" + infix.pop());
        System.out.println("prefix is "+ prefix.pop());
        System.out.println("value of exp is "+ val.pop());

        
    }
    
}
