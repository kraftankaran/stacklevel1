import java.util.*;

public class CelebrityProblem {

    public static void main (String [] args)throws Exception{
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();
        int arr[] [] = new int[n][n];
        System.out.println("please enter the o or 1 ");

        for(int i =0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                arr[i][j]=sc.nextInt();

            }
           
        }



        Stack<Integer> st = new Stack<>();
        for(int i =0;i<arr.length;i++){
            st.push(i);

        }
        while (st.size()>=2) {
            int i =st.pop();
            int j=st.pop();

            // if i knows j then i is not celebrity
            if(arr[i][j]==1){
                st.push(j);

            }else {
                st.push(i);
            }

            
        }
        int potential =st.pop();

        for(int i =0;i<arr.length;i++){
            if(i!=potential){
                if(arr[i][potential]==0 ||arr[potential][i]==0){
                    System.out.println("none");

                }
            }

        }
        System.out.println(potential);
    }
    
    
}
