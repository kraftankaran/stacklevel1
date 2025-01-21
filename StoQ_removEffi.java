import java.util.*;
import java.util.Stack;
public class StoQ_removEffi {
    public static class queueFromStack{
        private  Stack<Integer> mainst ;
        private Stack<Integer> helperst;
        public queueFromStack(){
            mainst= new Stack<>();
            helperst = new Stack<>();

        }

        public void add(int v){
            
            while (mainst.size()>0) {
                helperst.push(mainst.pop());

                
            }
            mainst.push(v);
            while (helperst.size()>0) {
                mainst.push(helperst.pop());
                
            }
        }
        public int remove(){
            if(mainst.size()>0){
                return mainst.pop();

            }
            else throw new IllegalStateException("stack is empty");
        }
        public int peek(){
            if(mainst.size()>0){
                return mainst.peek();

            }
            else throw new IllegalStateException("stack is empty");
        }
        public int size(){
            return mainst.size();
        }
    }

    public static void main (String []args) throws Exception{
        queueFromStack queue = new queueFromStack();
        for(int i =0;i<10;i++){
            queue.add(i);

        }
        while (queue.size()>0) {
            System.out.println("element is "+ queue.remove());
            
        }
        
    }
    
}
