import java.util.*;
public class NextGreaterElementOnRight

{
    public static void display(int arr []){
        StringBuilder sb = new StringBuilder();
        for(int i =0;i<arr.length;i++){
            sb.append(arr[i]+"\t");

        }
        System.out.println(sb);
    }

    



// alternat appraoch from left -----------------> right

   public static int [] sovlelefttoright(int arr[]){
    int nextgreater[]=new int[arr.length];
    Stack<Integer> st = new Stack<>();
   st.push(0);
    for(int i =1;i<arr.length;i++){

        while(st.size()>0  && arr[i]> arr[st.peek()]){
            int pos = st.peek();
            nextgreater[pos]=arr[i];
            st.pop();
        }
        st.push(i);
       

    }
      
    while (st.size()>0) {
        int pos = st.peek();
        nextgreater[pos]=-1;
        st.pop();
        
    }
    
    return nextgreater;
   }





    public static int [] solverighttoleft(int arr[]){

        int arr2[]= new int[arr.length];
        Stack<Integer> st = new Stack<>();
        arr2[arr.length-1]=-1;
        st.push(arr[arr.length-1]);

        for(int i=arr.length-2;i>=0;i--){
            while (st.size()!=0 && arr[i]>=st.peek()) {
                st.pop();

                
            }


            if(st.size()==0){
                arr2[i]=-1;
                
            }else{
                arr2[i]=st.peek();
            }

            
            st.push(arr[i]);

            

           
        }





     return arr2;

    }
    
    // The Scanner code and loop must be inside a method like main 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int arr[]= new int[n];
        for(int i =0;i<arr.length;i++){
            arr[i]=sc.nextInt();
    
        }
         int arr2 []=solverighttoleft(arr);
        display(arr2);
        
        int arr3[]= sovlelefttoright(arr);
        display(arr3);
    
        
    }

   

    
}





        

    
    




































// ================================self logic poora galat socha thA


// public class NextGreaterElementOnRight {
//     public static void display(int []arr){
//         StringBuilder sb = new StringBuilder();
//         for(int i =0;i< arr.length;i++){
//             sb.append(arr[i] +"\t");

//         }
//     }

//     public static  int [] ngtr(int []arr){
//         int gtr=-1;
//         int arr2[]=new int[arr.length];
//        arr2[arr2.length-1] =gtr;
//        for(int i =arr2.length-2;i>=0;i--){
//         if(arr[i]>=arr[i+1]){
            
//             arr2[i]= gtr;
//         }
//         else{
//             gtr=arr[i+1];
//             arr2[i]=gtr;

//         }
//        }
//        return arr2;

//     }
//     public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        // int []arr = new int[n];
        // for(int i=0;i<arr.length;i++){
        //     arr[i]= sc.nextInt();


        // }

        
//         display(ngtr(arr));


        
//     }

    
// }
