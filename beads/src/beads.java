/*
ID: extreme3
LANG: JAVA
PROG: beads
*/
import java.util.*;
import java.io.*;

public class beads {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(new File("beads.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
        
        int n = input.nextInt();
        String bracelet = input.next();
        
        int maxBeads = 0; // or 1?
        for(int i = 0; i < n; i++){
            int leftI = i;
            int rightI = i+1;
            boolean leftSame = true;
            boolean rightSame = true;
            int sameBeads = 1; // 0 or 1 or 2?
            while(leftSame == true){
                
                if(substring(bracelet,leftI).equals(substring(bracelet, leftI - 1))){
                    leftI--;
                    sameBeads++;
                }
                else{
                    leftSame = false;
                }
                
            }
            while(rightSame == true){
                if(substring(bracelet,rightI).equals(substring(bracelet,rightI+1))){
                    rightI++;
                    sameBeads++;
                }
                else{
                    rightSame = false;
                }
                
            }
            if(maxBeads < sameBeads){
                maxBeads = sameBeads;
            }
                    
        }
        System.out.println(maxBeads);
        //out.close();
    }
    public static String substring(String str, int beginIndex){
        if(beginIndex > 0 && beginIndex+1 < str.length()){
            return str.substring(beginIndex, beginIndex+1);
        }
        else if(beginIndex < 0){
            return str.substring(str.length()+ beginIndex,str.length()+ beginIndex+1);
        }
        else{
            return str.substring(beginIndex % str.length(), beginIndex % str.length()+1);
        }
    }
    
}
