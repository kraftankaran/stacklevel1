import java.util.*;
import java.lang.*;



public class mergeOveralpingIntervals {
    public static class pair implements Comparable<pair>{
        int st;
        int et;


        pair(int st, int et){
            this.st = st;
            this.et =et;
        }
        

        

        
        @Override
        public int compareTo(pair obj2) {
            if (this.st != obj2.st) {
                // Compare based on start times
                return Integer.compare(this.st, obj2.st);
            } else {
                // Compare based on end times
                return Integer.compare(this.et, obj2.et);
            }
        }
        
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr  [][]= new int [n][2];
        for(int i =0;i<arr.length;i++){
            arr[i][0]=sc.nextInt();
            arr[i][1]=sc.nextInt();
        }

        pair pairs []= new pair[n];

        for(int i=0;i<arr.length;i++){
            pairs[i]=new pair(arr[i][0], arr[i][1]);

            
        }
        Arrays.sort(pairs);
        Stack<pair> st = new Stack<>();
        for(int i =0;i<pairs.length;i++){
            if(i==0){
                st.push(pairs[i]);

            }else if(pairs[i].st< st.peek().et){

                st.peek().et =Math.max(pairs[i].et, st.peek().et);

            }
            else{
                st.push(pairs[i]);
            }

        }

        Stack<pair> answer = new Stack<>();
        while(st.size()>0){
            answer.push(st.pop());

        }
        while (answer.size()>0) {

            pair obj = answer.pop();
            System.out.println( "st " + obj.st + "et "+ obj.et);
            
        }

        
        

    }
    
}
