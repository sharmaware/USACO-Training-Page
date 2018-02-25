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
public class CowSignal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        Scanner input  = new Scanner(new File("cowsignal.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowsignal.out")));
        
        int m = input.nextInt();
        int n = input.nextInt();
        int k = input.nextInt();
        
        out.print("hello");
        
        for(int i = 0; i < m; i++){
            String line = input.next();
            for(int j = 0; j < k; j++){
                for(int p = 0; p < line.length(); p++){
                    for(int l = 0; n < l; l++){
                        out.print(line.substring(p, p+1));
                    }
                }
                out.println("");
            }
        }    
    }
    
}
