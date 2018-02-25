
import java.io.*;
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author saarthaksharma
 */
public class Moocast {
    static ArrayList<Integer> numCows = new ArrayList<>();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(new File("moocast.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("moocast.out")));
    
        int n = input.nextInt();
        int [][] cows = new int [4][n];
        
        for(int i = 0; i < n; i++){
            int x = input.nextInt();
            int y = input.nextInt();
            int p = input.nextInt();
            
            cows[0][i] = x;
            cows[1][i] = y;
            cows[2][i] = p;
            cows[3][i] = 0;
                
        }
        int [] newReachable = new int [cows[3].length];
        for(int i = 0; i< newReachable.length; i++){
            newReachable[i] = 1;
        }
        maxCows(cows, newReachable);
        /*
        for(int i = 0; i < numCows.size(); i++){
            System.out.println(numCows.get(i));
        } */
        //find highest in numCows
        int large = 0; 
        for(int i = 0; i < numCows.size(); i++){
            if(numCows.get(i) > large){
                large = numCows.get(i);
            }
        }
        System.out.print(large);
        //out.close();
    }
    public static void maxCows(int [][] cows, int [] newReachable){
        for(int k = 0; k < newReachable.length; k++){
            
        }
    }
    
}
