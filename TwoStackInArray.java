import java.nio.channels.IllegalSelectorException;
import java.util.*;
public class TwoStackInArray {
    public static class TwoStack{
        private int arr [];
        private int tos1;
        private int tos2;
        private int count;

        public TwoStack(){

        }

        public TwoStack(int cap){
            arr = new int[cap];
            tos1 =-1;
            tos2 = arr.length;
            count =0;
        }

        public void push1(int v){
            if(tos1<tos2){
                tos1++;
                arr[tos1]=v;
                count++;

            }
            else throw new IllegalStateException("stack is empty");
        }
        public void push2(int v){
            if(tos1<tos2){
                tos2--;
                arr[tos2]=v;
                count++;
            }
            else throw new IllegalStateException("stack is empty");
        }
        public int pop1(){
            if(tos1>=0){
                count--;
                int res= arr[tos1];
                tos1--;
                return res;
                
            }else throw new IllegalStateException("stack is empty");
        }
        public int pop2(){
            if(tos2<=arr.length-1){
                count--;
                int res =arr[tos2];
                tos2++;
                return res;
                
            }else throw new IllegalStateException("stack is empty");
        }

        public int peek1(){
            if(tos1 >=0){
                
                int res= arr[tos1];
                
                return res;
            }else throw new IllegalStateException("emptyy");
        }
        public int peek2(){
            if(tos2 <=arr.length-1){
                
                int res =arr[tos2];
            
                return res;
            }else throw new IllegalStateException("emptyy");
        }

        public int size(){
            return count;
        }


    }

    public static void main(String[] args) {
        TwoStack stack = new TwoStack(10);

        stack.push1(1);
        stack.push1(2);
        stack.push2(3);
        System.out.println(stack.size());
       System.out.println( stack.pop1());
       

    }
    
}
