/*
ID: extreme3
LANG: JAVA
PROG: milk2
*/
import java.util.*;
import java.io.*;


public class milk2 {

    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("milk2.in"));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.valueOf(st.nextToken());
        int [][] milkingTimes = new int [n][2];
        int max = 0;
        int min = 1000000000;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(f.readLine());
            int startTime = Integer.valueOf(st.nextToken());
            milkingTimes[i][0] = startTime;
            int endTime = Integer.valueOf(st.nextToken());
            milkingTimes[i][1] = endTime;
            if(endTime > max){
                max = endTime;
            }
            if(startTime < min){
                min = startTime;
            }
        }
        int [] intervals = new int [max];
        for(int i = 0; i < milkingTimes.length; i++){
            for(int j = milkingTimes[i][0]; j <milkingTimes[i][1]; j++){
                intervals[j] = 1;
            }
        }
        
        int maxMilk = 0;
        int maxNoMilk = 0;
        int count1 = 0;
        int count0 = 0;
        for(int i = min; i < intervals.length; i++){
            if(intervals[i] == 1){
                count1++;
                if(count1 > maxMilk){
                    maxMilk = count1;
                }            
            }
            else{
                count1 = 0;
            }
            if(intervals[i] == 0){
                count0++;
                if(count0 > maxNoMilk){
                    maxNoMilk = count0;
                }            
            }
            else{
                count0 = 0;
            }
        }
    
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));
    out.println(maxMilk + " " +  maxNoMilk);
    out.close();
    }
    
}
