
// exp is balaced .but may be some pair 
// of brackets are extra or  needless, print true if don't 
// come across any such pair otherwise fale;

// ((a+b))+((c+d))   true;
// (a+b)+(((c+d)))    ture;



import java.util.*;
public class Duplicatebrackets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str= sc.nextLine();
        Stack<Character> st = new Stack <>();
        for(int i =0;i<str.length();i++){
            char ch = str.charAt(i);
            


            if( ch ==')'){
                if(st.peek()=='('){
                    System.out.println(true);
                    return;


                }
                else{
                    while(st.peek()!='('){
                        st.pop();

                    }
                    st.pop();
                }

            }
            else{
                st.push(ch);
                
            }
        }
        System.out.println(false);
        
    }
    
}

