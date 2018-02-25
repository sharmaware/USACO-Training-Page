/*
ID: extreme3
LANG: JAVA
PROG: dualpal
*/
import java.util.*;
import java.io.*;

public class dualpal {
    static String [] characters = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", 
        "B", "C", "D", "E", "F", "G", "H", "I", "J" };
    
    public static void main(String[] args) throws IOException{
        //long startTime = System.currentTimeMillis();
        BufferedReader f = new BufferedReader(new FileReader("dualpal.in"));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = new Integer(st.nextToken());
        int s = new Integer(st.nextToken());
        
        ArrayList<Integer> palindromes = dualPal(n, s);
        
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("dualpal.out")));
        for(int i = 0 ; i < palindromes.size(); i++){
            out.println(palindromes.get(i));
        }
        out.close();
        //long endTime = System.currentTimeMillis();
        //System.out.println(endTime - startTime);
    }
    public static ArrayList<Integer> dualPal(int n, int s){
        int numPalindromes = 0;
        int count = 0;
        ArrayList<Integer> allPalindromes = new ArrayList<>();
        while(numPalindromes < n){
            int palindromes = 0;
            count++;
            for(int i = 2; i <= 10; i++){
                if(palindromeCheck(toBaseB(s+count, i))){
                    palindromes++;
                }
            }
            if(palindromes >= 2){
                numPalindromes++;
                allPalindromes.add(s+count);
                
            }
        }
        return allPalindromes;
    }
    public static String toBaseB(int decimal, int b){
        String baseB = "";
        while(decimal != 0){
            int remainder = decimal % b;
            int number = (int) decimal/b;
            decimal = number;
            //String character = characters[remainder];
            
            baseB = remainder + baseB;
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
