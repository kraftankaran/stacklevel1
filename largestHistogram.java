
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





// chatgpt optimsised code==============================


// import java.util.*;

// public class LargestHistogram {

//     public static int largestArea(int[] arr) {
//         int maxArea = 0;
//         int n = arr.length;

//         // Arrays for Next Smaller Right (NSR) and Next Smaller Left (NSL)
//         int[] nsr = new int[n];
//         int[] nsl = new int[n];

//         Stack<Integer> stack = new Stack<>();

//         // Calculate NSR
//         for (int i = n - 1; i >= 0; i--) {
//             while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
//                 stack.pop();
//             }
//             nsr[i] = stack.isEmpty() ? n : stack.peek();
//             stack.push(i);
//         }

//         // Clear the stack for NSL computation
//         stack.clear();

//         // Calculate NSL
//         for (int i = 0; i < n; i++) {
//             while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
//                 stack.pop();
//             }
//             nsl[i] = stack.isEmpty() ? -1 : stack.peek();
//             stack.push(i);
//         }

//         // Calculate maximum area
//         for (int i = 0; i < n; i++) {
//             int width = nsr[i] - nsl[i] - 1;
//             int area = width * arr[i];
//             maxArea = Math.max(maxArea, area);
//         }

//         return maxArea;
//     }

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         System.out.print("Enter number of bars in the histogram: ");
//         int n = sc.nextInt();
//         int[] arr = new int[n];
//         System.out.println("Enter heights of the histogram bars: ");
//         for (int i = 0; i < n; i++) {
//             arr[i] = sc.nextInt();
//         }

//         int largestArea = largestArea(arr);
//         System.out.println("The largest rectangle area in the histogram is: " + largestArea);
//     }
// }
