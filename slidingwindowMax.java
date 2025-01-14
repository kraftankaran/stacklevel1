// import java.util.*;

// public class slidingwindowMax {
//     public static  void wndowmax(int arr[], int k){
//         int max []= new int[arr.length];
//         int ngr[] = new int[arr.length];
//         Stack<Integer> st = new Stack<>();
//         ngr[arr.length-1]=arr.length;
//         for(int i=0;i<arr.length;i++){
//             while(st.size()>0 && arr[i]> arr[st.peek()]){
//                 st.pop();

//             }
//             if(st.size()==0){
//                 ngr[i]= arr.length;
//             }
//             else{
//                 ngr[i]= st.peek();

//             }
//             st.push(i);
//         }


//         for(int i=0;i<=arr.length-k;i++){
//             int j =i;

//             while (j< i+k){
//                 j = ngr[j];


//             }
//                System.out.println(arr[j]);
//             }


//         }
           
        
//     }
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         int arr []= new int[n];
//         for(int i=0;i<arr.length;i++){
//             arr[i]=sc.nextInt();

//         }
//         System.out.println("please enter the size of window .it must be smaller then arr. size");
//         int k = sc.nextInt();
//         wndowmax(arr,k);

        
//     }
    

import java.util.*;

public class slidingwindowMax {
    public static void windowMax(int arr[], int k) {
        int ngr[] = new int[arr.length];
        Stack<Integer> st = new Stack<>();

        // Initializing the NGR (Next Greater Element index array)
        ngr[arr.length - 1] = arr.length;
        for (int i = arr.length - 2; i >= 0; i--) {
            while (st.size() > 0 && arr[i] >= arr[st.peek()]) {
                st.pop();
            }
            if (st.size() == 0) {
                ngr[i] = arr.length;
            } else {
                ngr[i] = st.peek();
            }
            st.push(i);
        }

        // Sliding window logic
        for (int i = 0; i <= arr.length - k; i++) {
            int j = i;

            // Find the next greater element in the window
            while (j < i + k) {
                j = ngr[j];
            }
            System.out.println(arr[j]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Please enter the size of the window (it must be smaller than the array size):");
        int k = sc.nextInt();
        
        // Call the correct method: windowMax
        windowMax(arr, k);
    }
}
