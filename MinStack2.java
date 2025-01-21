import java.util.*;
public class MinStack2 {


    public static class minstack{

        private Stack<Integer> stack;
        public  int min=Integer.MIN_VALUE ;
        public minstack(){
            stack = new Stack<>();
        }

        public void push(int v){
            if(stack.isEmpty()){
                stack.push(v);
                min = v;
            }
            else if(!stack.isEmpty()){
                if(v>=min){
                    stack.push(v);

                }
                else 
                {
                    stack.push(v+v-min);
                    min =v;
                }
            }
        }
            
            public  int pop(){

                if(!stack.isEmpty()){
                    if(stack.peek()>=min){
                        return stack.pop();
                    }
                    else if (stack.peek()<min){
                        int temp = min;
                        
                        min =2*min-stack.pop();
                        return temp;
                    }
                }
                return -1;
                
            }
        

            public int peek(){
                if(stack.isEmpty()){
                    throw new IllegalStateException("stack is empty");

                }else if(stack.peek()>=min){
                    return stack.peek();
                }
                else if(stack.peek()<min){
                    return min;

                }
                else
                 throw new IllegalStateException("some error hapened");

            }
            
            public int min(){
                if(stack.size()==0){
                    return -1;

                }else{
                    return min;
                }
            }
            public int size(){
                return stack.size();
            }

        }
    
    public static void main(String[] args) {

        minstack minimustack =new minstack();
        for(int i=0;i<10;i++){
            minimustack.push(i);

        }
        while (minimustack.size()>0) {
            System.out.println("minimum value is"+ minimustack.min());
            System.out.println("current value is"+minimustack.pop());

            
        }
    
    }
    
}
