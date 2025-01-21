import java.util.*;
public class QtoS_PushEffi {

    public static class QtoStack{
        private  Queue<Integer> mainQ;
        private Queue<Integer> helperQ;

        public QtoStack(){
            mainQ = new ArrayDeque<>();
            helperQ = new ArrayDeque<>();
        }
        public void push(int v){
            mainQ.add(v);

        }

        public int pop(){
            while (mainQ.size()>1) {
                helperQ.add(mainQ.remove());

                
            }
            int val = mainQ.remove();
            while (helperQ.size()>0) {
                mainQ.add(helperQ.remove());
                
            }
            return val;

        }

        public int size(){
            return mainQ.size();
        }

        public int peek(){
            while (mainQ.size()>1) {
                helperQ.add(mainQ.remove());
                

                
            }
            int val = mainQ.remove();
            helperQ.add(val);
            
            while (helperQ.size()>0) {
                mainQ.add(helperQ.remove());
                
            }
            return val;
        }

    }

    public static void main(String []args){
        QtoStack st = new QtoStack();
        for( int i =0;i<=10;i++){
            st.push(i);
        }
        while (st.size()>0) {
            System.out.println("stack top is "+st.pop());
            
        }
    }
    
}
