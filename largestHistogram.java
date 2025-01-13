
import java.util.*;

public class largestHistogram {

    public static int largestArea(int arr[]){


        int maxarea =0;
       

        // first make a nsr array
        Stack<Integer> st = new Stack<>();
        int nsr[] = new int[arr.length];
        st.push(arr.length-1);
        nsr[arr.length-1]=arr.length;

        for(int i =arr.length-2;i>=0;i--){
            while (st.size()>0 && arr[i]<arr[st.peek()] ) {
                st.pop();

                
            }
            if(st.size()==0){
                nsr[i]= arr.length;
            }
            else{
                nsr[i]= st.peek();

            }
            st.push(i);

        }

        //  do the same for left boudry arry

        Stack<Integer> stack = new Stack<>();

        int nsl[] = new int[arr.length];
        nsl[0]=-1;
        stack.push(arr[0]);
        for(int i=1;i<arr.length;i++){
            while (stack.size()>0 && arr[i]<arr[stack.peek()]) {
                stack.pop();

                
            }
            if(stack.size()==0){
                nsl[i]=-1;
            }
            else{
                nsl[i]=stack.peek();
            }

            stack.push(i);

        }

        for(int i =0;i<arr.length;i++){
            int width =nsr[i]- nsl[i]-1;
            int area = width* arr[i];
            if(maxarea<area){
                maxarea = area;

            }
        }







        return maxarea;

       

         }

      
      

     
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int arr[]= new int[n];
        for(int i =0;i<arr.length;i++){
            arr[i]=sc.nextInt();
    
        }

        int largestarea = largestArea(arr);
        System.out.println( largestarea);
    }
    
}
