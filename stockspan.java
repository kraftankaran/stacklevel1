import java.util.*; 
public class stockspan {

    public static void display(int arr []){
        StringBuilder sb = new StringBuilder();
        for(int i =0;i<arr.length;i++){
            sb.append(arr[i]+"\t");

        }
        System.out.println(sb);
    }
    public static int [] stockspan(int arr[]){
        int span[]= new int[arr.length];
       

        Stack<Integer> st = new Stack<>();
        st.push(0);

        span[0]=1;

        for(int i =1;i<arr.length;i++){
            while (st.size()>0 && arr[i]>arr[st.peek()]) {
                st.pop();
                
            }
            if(st.size()==0){
                span[i]=i+1;
            }
            else{
                span[i]=i-st.peek();

            }

            st.push(i);
        }




        return span;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int arr[]= new int[n];
        for(int i =0;i<arr.length;i++){
            arr[i]=sc.nextInt();
    
        }

        int arr2[]= stockspan(arr);
        display(arr2);
    }

    
}
