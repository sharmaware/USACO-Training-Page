/*
ID: extreme3
LANG: JAVA
PROG: palsquare
*/
import java.util.*;
import java.io.*;

public class palsquare {
    static String [] characters = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", 
        "B", "C", "D", "E", "F", "G", "H", "I", "J" };
    
    public static void main(String[] args) throws IOException{
        long time1Start = System.currentTimeMillis();
        BufferedReader f = new BufferedReader(new FileReader("palsquare.in"));
        String B  = f.readLine();
        int b = new Integer(B);
        
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("palsquare.out")));
        
        int [] squares = new int [300];
        for(int i =1; i <= 300; i++){
            squares[i-1] = i*i;
            //System.out.println(squares[i-1]);
        }
        String [] baseBSquares = new String [300];
        
        for(int i = 0; i < baseBSquares.length; i++){
            //System.out.println("here");
            baseBSquares[i] = toBaseB(squares[i], b);
            //System.out.println(baseBSquares[i]);
        }
        
        
        ArrayList<String> palindromes = new ArrayList<>();
        ArrayList<String> originalNumbers = new ArrayList<>();
        for(int i = 0; i< baseBSquares.length; i++){
            if(palindromeCheck(baseBSquares[i])){
                palindromes.add(baseBSquares[i]);
                String number = toBaseB(i+1, b);
                originalNumbers.add(number);
            }
        }
        //System.out.println(originalNumbers.size() + "  " + palindromes.size());
        for(int i = 0; i < originalNumbers.size(); i++){
            out.println(originalNumbers.get(i) + " " + palindromes.get(i));
        }
        out.close();
        long time1end = System.currentTimeMillis();
        //System.out.println(time1end-time1Start);
    }
    public static String toBaseB(int decimal, int b){
        String baseB = "";
        while(decimal != 0){
            int remainder = decimal % b;
            int number = (int) decimal/b;
            decimal = number;
            String character = characters[remainder];
            
            baseB = character + baseB;
        }
        return baseB;
    }
    public static boolean palindromeCheck(String possible){
        boolean palindrome = true;
        for(int i = 0; i < possible.length()/2; i++){
            if(possible.charAt(i) != possible.charAt(possible.length()-1-i)){
                palindrome = false;
                break;
            }
        }
        return palindrome;
    }
    
}
