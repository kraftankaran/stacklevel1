import java.util.*;




// public class MinStack1 {

   


//     public static void main(String[] args) {
        
//         MinStack minStack = new MinStack();

//     for(int i=0;i<10;i++){
//         minStack.push(i);
//     }

//     while (minStack.size()>0) {

//         System.out.println("min value is" + minStack.getMin());
//         System.out.println(minStack.pop());
        
//     }

        
//     }





//     public static class  MinStack{
//         private Stack<Integer> stack;
//         private Stack<Integer> minstack;
    
//         public MinStack(){
//             stack = new Stack<>();
//             minstack =new Stack<>();
    
//         }
//         public void push(int val){
//             stack.push(val);
//             if(minstack.size()==0 || minstack.peek()>=val){
//                 minstack.push(val);
//             }
//         }
    
//         public int pop() {
//             int retunval;
//             if(stack.size()>0){
//                 retunval= stack.pop();
//                 if(minstack.size()>0 && minstack.peek()==retunval){
//                     minstack.pop();
//                 }
//                 return retunval;
    
    
                
//             }
//             throw new IllegalStateException("stack is empty");
//         }
    
//         public int top(){
    
//             if(stack.size()>0 ){
//                 return stack.peek();
//             }
//             throw new IllegalStateException("stack is empty");
    
    
    
    
//         }
    
//         public int getMin(){
//             if(minstack.size()>0){
//                 return minstack.pop();
//             }
//             throw new IllegalStateException("stack is empty");
//         }
    
//         public int size(){
            
//                 return stack.size();
            
            
//         }
    
//     }
    
// }import java.util.*;

public class MinStack1 {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();

        for (int i = 0; i < 10; i++) {
            minStack.push(i);
        }

        while (minStack.size() > 0) {
            System.out.println("Min value is: " + minStack.getMin());  // Get the current minimum value
            System.out.println("Popped value: " + minStack.pop());      // Pop the value and print it
        }
    }

    public static class MinStack {
        private Stack<Integer> stack;
        private Stack<Integer> minstack;

        public MinStack() {
            stack = new Stack<>();
            minstack = new Stack<>();
        }

        public void push(int val) {
            stack.push(val);
            // Push the new minimum to minstack
            if (minstack.isEmpty() || minstack.peek() >= val) {
                minstack.push(val);
            }
        }

        public int pop() {
            if (stack.isEmpty()) {
                throw new IllegalStateException("Stack is empty");
            }
            int returnValue = stack.pop(); // Pop the value from the stack
            // If the popped value is the current minimum, pop it from minstack as well
            if (!minstack.isEmpty() && minstack.peek() == returnValue) {
                minstack.pop();
            }
            return returnValue; // Return the popped value
        }

        public int top() {
            if (stack.isEmpty()) {
                throw new IllegalStateException("Stack is empty");
            }
            return stack.peek(); // Return the top element of the stack
        }

        public int getMin() {
            if (minstack.isEmpty()) {
                throw new IllegalStateException("Stack is empty");
            }
            return minstack.peek(); // Return the current minimum value from minstack
        }

        public int size() {
            return stack.size(); // Return the size of the stack
        }
    }
}

