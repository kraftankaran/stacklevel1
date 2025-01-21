import java.util.*;

public class StoQ_addEffi {

    public static class stacktoQueue{
        private Stack<Integer> mainst;
        private Stack<Integer> helperst;

        public stacktoQueue(){
            mainst = new Stack<>();
            helperst = new Stack<>();




        }
        public void add(int v){
            mainst.push(v);
        }
        public int remove(){
            if(mainst.size()>0){
                while (mainst.size()>0) {
                    helperst.add(mainst.pop());
                    
                }
                int result = helperst.pop();
                while (helperst.size()>0) {
                    mainst.push(helperst.pop());

                    
                }
                return result;

            }
            else throw new IllegalStateException("queue is empty");
        }

        public int size(){
            return mainst.size();
        }

        public int peek(){
            if(mainst.size()>0){
                while (mainst.size()>0) {
                    helperst.push(mainst.pop());
                   
                    
                }
                int result = helperst.pop();
                while ( helperst.size()>0) {
                    mainst.push(helperst.pop());

                    
                }
                return result;

            }
            else throw new IllegalStateException("queue is empty");
        
        }
    }


    public static void main(String[] args) {
        stacktoQueue queue = new stacktoQueue();
        for(int i =0;i<10;i++){
            queue.add(i);
        }
        while ( queue.size()>0) {
            System.out.println(queue.remove());
            
        }
    }
    
}
