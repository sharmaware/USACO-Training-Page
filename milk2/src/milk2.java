/*
ID: extreme3
LANG: JAVA
PROG: milk2
*/
import java.util.*;
import java.io.*;
/**
 *
 * @author saarthaksharma
 */
public class milk2 {

    
    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(new File("milk2.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));
        
        int n = input.nextInt();
        int [][] milkingTimes = new int [2][n];
        //taking input
        int largest = 0;
        int smallest = 100000000;
        for(int i=0; i<n; i++){
            int startTime = input.nextInt();
            int endTime = input.nextInt();
            
            milkingTimes[0][i] = startTime;
            milkingTimes[1][i] = endTime;
            if(endTime > largest){
                largest = endTime;
            }
            if(startTime < smallest){
                smallest = startTime;
            }
        }
        int [] time = new int [largest+1];
        for(int i = smallest; i<time.length; i++){ //
            for(int j = 0; j < milkingTimes[0].length; j++){
                if(i >= milkingTimes[0][j] && i < milkingTimes[1][j]){
                    time[i] = 1;
                }
            }
        }
        /*
        for(int second: time){
            System.out.print(second + ", ");
        }
        System.out.println();
        */
        int noneMilk = 0;
        int atLeastOneMilk = 0;
        for(int i = smallest; i< time.length; i++){
            if(time[i] == 0){
                int count = 0;
                while(time[i] == 0){
                   if(i < time.length - 1){
                        count++;
                        i++;
                    }
                    else{
                        break;
                    }        
                }
                if(count > noneMilk){
                    noneMilk = count;
                }
                
            }
        }
        
        for(int i = smallest; i< time.length; i++){
            if(time[i] == 1){
                int count = 0;
                while(time[i] == 1){
                    if(i < time.length - 1){
                        count++;
                        i++;
                    }
                    else{
                        break;
                    }                
                }
                if(count > atLeastOneMilk){
                    atLeastOneMilk = count;
                }
                
            }
        } 
        
        out.println(atLeastOneMilk + " " + noneMilk);
        out.close();
    }
    
}
