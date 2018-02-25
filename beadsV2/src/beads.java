



/*
ID: extreme3
LANG: JAVA
PROG: beads
*/
import java.io.*;
import java.util.*;

public class beads {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(new File("beads.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
        int n = input.nextInt();
        String str = input.next();
        //System.out.println(str.length());
        boolean allSame = true;
        int originalLength = str.length();
        for(int i = 0; i < str.length()-1; i++){
            if(!(str.substring(i,i+1).equals(str.substring(i+1,i+2)))){
                allSame = false;
            }
        }
        //System.out.println
        
        /*
        for(int i = str.length()-2; i >= 0; i--){
            str += str.substring(i, i+1);
        }
        */
        str += str;
        //System.out.print(str);
    
        int maxBeads = 0;
        
        for(int i = 0; i < str.length()-1; i++){
            String leftLetter = str.substring(i,i+1);
            int tempI = i;
            while(leftLetter.equals("w")){
                tempI--;
                if(tempI<0){
                    tempI ++;
                    break;
                }
                leftLetter = str.substring(tempI,tempI+1);
            }
            String rightLetter = str.substring(i+1, i+2);
            tempI = i+1;
            while(leftLetter.equals("w")){
                tempI++;
                if(tempI >= str.length()){
                    tempI --;
                    break;
                }
                rightLetter = str.substring(tempI,tempI+1);
            }
            int leftI = i;
            int rightI = i+1;
            
            while(str.substring(leftI,leftI+1).equals(leftLetter) || str.substring(leftI,leftI+1).equals("w")){ 
                leftI--;
                if(leftI < 0){
                    leftI++;
                    break;
                }
                
            }
            while(str.substring(rightI,rightI+1).equals(rightLetter) || str.substring(rightI,rightI+1).equals("w")) {
                rightI++;
                if(rightI  >= str.length()){
                    rightI--;
                    break;
                }
            }
            int beads = rightI-leftI-2;
            
            
            if(beads + 1 > maxBeads){
                maxBeads = beads + 1;
            }
            
            
        }
        
        
        
        if(allSame || maxBeads > originalLength){
            out.println(originalLength);
        }
        
        else{
            out.println(maxBeads);
        }
        out.close();
}
}
