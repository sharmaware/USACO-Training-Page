import java.util.*;
import java.io.*;

public class lifeguards {

    //static boolean [] intervals = new boolean[];
    static int [] intervals = new int[31250000];
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("lifeguards.in"));
        int n = Integer.parseInt(br.readLine());
        //take input
        int[][] times = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            times[i][0] = Integer.parseInt(st.nextToken());
            times[i][1] = Integer.parseInt(st.nextToken());
        }
        //int [] intervals = new int[100000000];
        int fullTime = 0;
        int maxJ = 0;
        int index = 0;
        int bitpos = 0;
        int mask = 0;
        for (int i = 0; i < times.length; i++) {
                for (int j = times[i][0]; j < times[i][1]; j++) {
                   
                    index = j%31250000;
                    bitpos = j/31250000;
                    mask = (1 << bitpos)-1;
                    
                    if ((intervals[index] & mask) != 0) {
                        fullTime++;
                    }
                    intervals[index] |= mask;
                        
                    
                    /*
                    if (intervals[j] != 1) {
                        fullTime++;
                    }
                    intervals[j] = 1;
                    if (j >= maxJ) maxJ = j;
                    */
                }
            }
        /*
        for(int i = 0; i < intervals.length; i++){
            if(intervals[i] == 1){
                fullTime++;
            }
        }*/
        
        for (int i = 0; i < maxJ; i++) {
            intervals[i] = false;
        }
            
        
        //System.out.println(fullTime);
        int leastDiff = Integer.MAX_VALUE;
        //removing each row (k)
        for (int k = 0; k < times.length; k++) {
            int count = 0;
            //up
            //intervals = new int[1000];
            for (int i = 0; i < k; i++) {
                for (int j = times[i][0]; j < times[i][1]; j++) {
                   
                    if (intervals[j] != true) {
                        count++;
                    }
                    intervals[j] = true;
                    if (j >= maxJ) maxJ = j;
                }
            }
            //down
            for (int i = k+1; i < times.length; i++) {
                for (int j = times[i][0]; j < times[i][1]; j++) {
                    
                    if (intervals[j] != true) {
                        count++;
                    }
                    intervals[j] = true;
                    if (j >= maxJ) maxJ = j;
                }
            }
            
            for (int i = 0; i < maxJ; i++) {
                intervals[i] = false;
            }
            
            //count 1s

            //int count = 0;
            /*for (int i = 0; i < intervals.length; i++) {
                if (intervals[i] == 1) {
                    count++;
                }
                
            }*/
            if((fullTime - count) < leastDiff){
                leastDiff = fullTime - count;
            }

        }
        PrintWriter out = new PrintWriter(new FileWriter("lifeguards.out"));
        out.println(fullTime - leastDiff + 1);
        out.close();
        
        System.out.println(fullTime - leastDiff + 1);
    }

}
