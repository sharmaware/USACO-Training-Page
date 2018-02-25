/*
ID: extreme3
LANG: JAVA
PROG: wormhole
*/
import java.util.*;
import java.io.*;

public class wormhole {
    public static int [] []wormholePos;
    public static int cycles = 0;
    public static int [] nextOnRight;
  
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("wormhole.in"));
        int n = Integer.parseInt(br.readLine());
        
        wormholePos = new int [n+1][2];
        for(int i = 1; i< wormholePos.length; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            wormholePos[i][0] = Integer.parseInt(st.nextToken());
            wormholePos[i][1] = Integer.parseInt(st.nextToken());
        }
        nextOnRight = new int [n+1];
        for(int i = 1; i < nextOnRight.length; i++){
            for(int j = 1; j < wormholePos.length; j++){
                if(wormholePos[j][0] > wormholePos[i][0] && wormholePos[j][1] == wormholePos[i][1]){
                    if(wormholePos[j][0] - wormholePos[i][0] < nextOnRight[i] - wormholePos[i][0] || nextOnRight[i] == 0){
                        nextOnRight[i] = j;
                    }
                }
            }
        }
        
        
        
        
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("wormhole.out")));
        System.out.println(solve(new int [n+1]));
        out.close();
    }
    //check for index starting at 1
    public static  int solve(int [] wormholePairing){
        int i = 1;
        int total = 0;
        while(i < wormholePairing.length){
            if(wormholePairing[i] != 0){
                i++;
            }
            else{
                break;
            }
        }   
        if (i == wormholePairing.length){
            if(cycleExists(wormholePairing)){
                for(int k = 1; k <wormholePairing.length; k++){
                    System.out.print(wormholePairing[k] + " ");
                }
                System.out.println( "  returning 1 ");
                return 1;
            }
            for(int k = 1; k <wormholePairing.length; k++){
                    System.out.print(wormholePairing[k] + " ");
                }
                System.out.println( "  returning 0 ");
            return 0;
        }
        for(int j = i+1; j < wormholePairing.length; j++){ //j starts at i+1 or 0?
            
            if(wormholePairing[j] == 0){
                wormholePairing[i] = j;
                wormholePairing[j] = i;
                
                
                total += solve(wormholePairing);
                
                wormholePairing[j] = 0;
                wormholePairing[i] = 0;
                
            }
           
        }
        return total;
        
    }
    public static boolean cycleExists(int [] wormholePairing){
        for(int i = 1; i < wormholePairing.length; i++){
            int position = i;
            for(int j = 1; j < wormholePairing.length; j++){
                position = nextOnRight[wormholePairing[position]];
            }
            if(position != 0){
                return true;
            }
        }
        return false;
    }
    
}
