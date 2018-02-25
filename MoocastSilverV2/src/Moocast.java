/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
import java.io.*;
/**
 *
 * @author saarthaksharma
 */
public class Moocast {
    private static ArrayList<Integer> numCows = new ArrayList<>();
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
        maxCows(cows);
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
    public static void maxCows(int [][] cows ){
        for(int i = 0; i < cows[1].length; i++){
            //if (cows[3][i] == 0){
                int newReachable = 0;
                for(int j = 0; j < cows[3].length; j++){
                    if(cows[2][i] >= Math.sqrt( Math.pow(cows[0][j] - cows[0][i], 2) + Math.pow(cows[1][j] - cows[1][i], 2))){
                        cows[3][j] = 1;
                        newReachable += 1;
                    }
                }

                if(newReachable == 0){
                    int totalCows = 0;
                    for(int j = 0; j< cows[3].length; j++){
                        if(cows[3][j] == 1){
                            totalCows += 1;
                        }
                    }
                    numCows.add(totalCows);
                }
                else{
                    maxCows(cows);
                }
                    
            //}
        }
    }
    
}
