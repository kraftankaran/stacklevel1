import java.util .*;

public class smallestNumberPattern {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String exp = sc.nextLine();
        Stack<Integer> st = new Stack<>();
        int num =1;
    
        for(int i =0;i<exp.length();i++){
            char ch = exp.charAt(i);
            if(ch =='d'){
                st.push(num);
                num++;

    
            }
            else{
                st.push(num);
                num ++;
                while (st.size()>0) {
                    System.out.print(st.pop());
                    
                }

            }
          

        }
        st.push(num);
        while (st.size()>0) {
            System.out.print(st.pop());
            
        }
        
    }
  
    
}
