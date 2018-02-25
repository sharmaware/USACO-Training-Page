/*
ID: extreme3
LANG: JAVA
PROG: barn1
*/

import java.util.*;
import java.io.*;

public class barn1 {

    public static void main(String[] args) throws IOException{
        ArrayList<Integer> intervals = new ArrayList<>();
        BufferedReader f = new BufferedReader(new FileReader("barn1.in"));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int m = new Integer(st.nextToken());
        int s = new Integer(st.nextToken());
        int c = new Integer(st.nextToken());
        
        //st = new StringTokenizer(f.readLine());
        int prev = 10000;
        
        int highI = 0;
        int lowI = 10000;
        
        //taking input
        int [] filledStalls = new int [c];
        for(int i = 0; i < c; i++){
            st = new StringTokenizer(f.readLine());
            filledStalls[i] = new Integer(st.nextToken());
        }
        Arrays.sort(filledStalls);
        for(int i= 1; i< c; i++){
                intervals.add(filledStalls[i]-filledStalls[i-1]-1);
                
            }
        
        int maxDistance = filledStalls[c-1] - filledStalls[0];
        
        //System.out.println(maxDistance);
        
        for(int i = 1; i < m; i++){
            int highest = 0;
            int highestI = 0;
            for(int j = 0; j< intervals.size(); j++){
                if(intervals.get(j) > highest){
                    highest = intervals.get(j);
                    highestI = j;
                    //System.out.println(highest + "here");
                }
            }
            if(intervals.size() != 0)
                intervals.remove(highestI);
            //System.out.println(maxDistance);
            maxDistance -= highest;
            //System.out.println(maxDistance);
        }
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("barn1.out")));
        out.println(maxDistance + 1);
        out.close();
    }
    
}
