
import java.util.*;

public class Balancedbrackets {
    public static void balacned(String str){
        Stack<Character> st = new Stack<>();
        for(int i = 0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch=='('|| ch=='{'||ch=='[' ){
                st.push(ch);

            }
            if(ch==')'){
                if(st.size()==0 || st.peek()!='('){
                    System.out.println(false);
                    return;
                }
                if(st.peek()=='('){
                    st.pop();
                }

            }
            else if(ch=='}'){
                if(st.size()==0 || st.peek()!='{'){
                    System.out.println(false);
                    return;
                }
                if(st.peek()=='{'){
                    st.pop();
                }
                

            }else{
                if(st.size()==0 || st.peek()!='['){
                    System.out.println(false);
                    return;
                }
                if(st.peek()=='['){
                    st.pop();
                }

            }
        }
        if(st.size()==0){
            System.out.println(true);

        }
        else System.out.println(false);
        

        

        
    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the exp");
        String str = sc.nextLine();
        balacned(str);
      

    }
    
}
