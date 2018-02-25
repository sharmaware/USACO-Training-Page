import java.util.*;
import java.io.*;

public class outofplace {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("outofplace.in"));
        int n = Integer.parseInt(br.readLine());
        int [] cows = new int [n];
        for(int i = 0; i < n; i++){
            cows[i] = Integer.parseInt(br.readLine());
        }
        //find bessie
        int bPos = 0;
        int bMovedLeft = 0;
        for(int i = 1; i < cows.length; i++){
            if(cows[i] < cows[i-1]){
                bPos = i;
                if (i-1 == 0) {
                bMovedLeft = 1;
                } else {
                    if (i-2 >= 0 && cows[i-2] <= cows[i]) {
                        bMovedLeft = 1;
                    }
                }
                if (bPos != cows.length-1 && cows[bPos] < cows[bPos-1]) {
                //bMovedLeft = 1;
                }
            }
                //needSwap = 1;
            }
        
       // System.out.println(cows.length);
        //System.out.println(bPos);
        //check if moved right or left
        
        
        boolean correctPos = false;
        int totalSwaps = 0;
        
        if (bMovedLeft == 1) {
        
        System.out.println("B moved left");
        bPos--;
//movedLeft
        while(!correctPos){
            
            int pos = bPos + 1;
            while(pos < cows.length -1){
                if(cows[pos] == cows[pos + 1]){
                    pos++;
                }
                else{
                    break;
                }    
            }
            cows = swap(cows, bPos, pos);
            totalSwaps++;
            if (pos == cows.length-1) {
                correctPos = true;
            }
            //else if((pos > 0 && cows[pos] > cows[pos-1])){
            else if(cows[pos] <= cows[pos+1]){
                correctPos = true;
            }
            else {
                bPos = pos;
            }
        
        }
        } else if (bPos != 0) { //BMovedRight
        
            while(!correctPos){
            int pos = bPos - 1;
            while(pos > 0){
                if(cows[pos] == cows[pos - 1]){
                    pos--;
                }
                else{
                    break;
                }    
            }
            cows = swap(cows, bPos, pos);
            totalSwaps++;
            if (pos == 0) {
                correctPos = true;
            }
            //else if((pos > 0 && cows[pos] > cows[pos-1])){
            else if(cows[pos] >= cows[pos-1]){
                correctPos = true;
            }
            else {
                bPos = pos;
            }
        }
        } else {
            // Case where we have to swap right
        }
        //System.out.println(totalSwaps);
        PrintWriter out = new PrintWriter(new FileWriter("outofplace.out"));
        
        out.println(totalSwaps);
        out.close();
    }
    public static int [] swap(int [] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        return a;
    }
    
}