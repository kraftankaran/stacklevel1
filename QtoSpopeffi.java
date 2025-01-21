import java.util.*;


public class QtoSpopeffi {

    public  static class QueueToStack{
        private  Queue<Integer> mainQ;
        private Queue<Integer> helperQ;


        public QueueToStack(){
            mainQ = new ArrayDeque<>();
            helperQ = new ArrayDeque<>();
    
        }
        public void add(int v){

            if(mainQ.isEmpty()){
                mainQ.add(v);

            }
            else{
                while (mainQ.size()>0) {
                    helperQ.add(mainQ.remove());

                    
                }
                mainQ.add(v);
                while (helperQ.size()>0) {
                    mainQ.add(helperQ.remove());

                    
                }
            }



        }

        public int remove(){
            if(mainQ.size()==0){
                return -1;
            }else{
                int temp = mainQ.remove();
                return temp;
            }
        }

        public int size(){
            if(mainQ.size()>0){
                return mainQ.size();
            }else throw new IllegalStateException("queue is empty");
        }

        public int top(){
            if(mainQ.size()>0){
                return mainQ.peek();
            }
            else throw new IllegalStateException("empty hai queue");
        }
        









    }

    public static void main(String[] args) {
        QueueToStack quewe = new QueueToStack();

        for(int i =0;i<10;i++){
            quewe.add(i);
        }
        while (quewe.size()>0) {
            System.out.println(quewe.remove());
            
        }
    }

    
}
