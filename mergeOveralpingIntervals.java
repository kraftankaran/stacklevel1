import java.util.*;
import java.lang.*;

import javax.print.attribute.standard.MediaSize.Other;

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

        pair intervals[]= new pair[n];

        for(int i=0;i<arr.length;i++){
            
        }

        
        

    }
    
}
