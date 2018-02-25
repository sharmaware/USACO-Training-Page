/*
ID: extreme3
LANG: JAVA
PROG: combo
*/
import java.util.*;
import java.io.*;

public class combo {
    static ArrayList<String> allCombinations = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("combo.in"));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = new Integer(st.nextToken());
        st = new StringTokenizer(f.readLine());
        combinations(new Integer(st.nextToken()),new Integer(st.nextToken()),new Integer(st.nextToken()), n);
        st = new StringTokenizer(f.readLine());
        combinations(new Integer(st.nextToken()),new Integer(st.nextToken()),new Integer(st.nextToken()), n);
        //System.out.println(-2 % 3);
        ArrayList<String> combinations = new ArrayList<>();
        //System.out.println(combinations.size());
        for(int i = 0; i < allCombinations.size(); i++){
            boolean exists = false;
            for(int j = 0; j < combinations.size(); j++){
                if(allCombinations.get(i).equals(combinations.get(j))){
                    exists = true;
                    
                }                 
            }
            
            if(!exists){
                combinations.add(allCombinations.get(i));
            }
        }
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("combo.out")));
        //System.out.println(allCombinations.size());
        out.println(combinations.size());
        
        
        out.close();
    }
    public static void combinations(int a, int b, int c, int n){
        String number = "";
        a -= 1;
        b -= 1;
        c -= 1;
        
        for(int i = -2; i <= 2; i++){
          for(int j = -2; j <= 2; j++){
                for(int k = -2; k <= 2; k++){
                    
                    
                    number += (a+i +n) %n ;
                    number += (b+j +n) %n ;
                    number += (c+k +n) %n ;
                    
                    
                    
                    
                    
                    /*
                    if(a + i > n){
                        number += (a+i) % n + 1; //%n
                    }
                    else if(a+i <= 0){
                        number+= (a + i) % n + 1;   //%n
                    }
                    
                    else{
                        number += a+i;
                    }
                    
                    //
                    if(b + j > n){
                        number += (b+j) % n + 1; //%n
                    }
                    else if(b+j <= 0){
                        number+= (b + j) % n + 1;   //%n
                    }
                    
                    else{
                        number += b+j;
                    }
                    //
                    if(c + k > n){
                        number += (c+k) % n + 1; //%n
                    }
                    else if(c+k <= 0){
                        number+= (c + k) % n + 1;   //%n
                    }
                    
                    else{
                        number += c+k;
                    }
*/
                    
                   allCombinations.add(number);
                   number = "";
                    
                }
            }  
        }
    }
    
}
