/*
ID: extreme3
LANG: JAVA
PROG: transform
*/
import java.util.*;
import java.io.*;

public class transform {

    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(new File("transform.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));
        int n = input.nextInt();
        
        //taking input
        char [][] originalBlocks = new char [n][n];
        for(int i = 0; i < originalBlocks.length; i++){
            String line = input.next();
            for(int j = 0; j < originalBlocks.length; j++){
                originalBlocks[i][j] = line.charAt(j);
            }
        }
        char [][] newBlocks = new char [n][n];
        for(int i = 0; i < newBlocks.length; i++){
            String line = input.next();
            for(int j = 0; j < newBlocks.length; j++){
                newBlocks[i][j] = line.charAt(j);
            }
        }
        
        
        /*for(int i = 0; i < rotation90.length; i++){
            for(int j = 0; j < rotation90[i].length; j++){
                System.out.print(rotation90[i][j] + ", ");
            }
            System.out.println("");
        }
        
        for(int i = 0; i < newBlocks.length; i++){
            for(int j = 0; j < newBlocks[i].length; j++){
                System.out.print(newBlocks[i][j] + ", ");
            }
            System.out.println("");
        }
        */
        
        
        
        char [][] rotation90 = degrees90Rotation(originalBlocks);
        boolean same = true;
        for(int i =0; i< originalBlocks.length; i++){
            for(int j = 0; j < originalBlocks[0].length; j++){
                if(newBlocks[i][j] != rotation90[i][j]){
                    same = false;
                    //System.out.println("fail 1");
                    break;
                }
            }
        }
        if(same){
            out.println(1);
            out.close();
            System.exit(0);
        }
        
            
        
        
        char [][] rotation180 = degrees90Rotation(rotation90);
        same = true;
        for(int i =0; i< originalBlocks.length; i++){
            for(int j = 0; j < originalBlocks[0].length; j++){
                if(newBlocks[i][j] != rotation180[i][j]){
                    
                    same = false;
                    //System.out.println("fail 2");
                    break;
                }
            }
        }
        if(same){
            out.println(2);
            out.close();
            System.exit(0);
        }
        
        char [][] rotation270 = degrees90Rotation(rotation180);
        same = true;
        for(int i =0; i< originalBlocks.length; i++){
            for(int j = 0; j < originalBlocks[0].length; j++){
                if(newBlocks[i][j] != rotation270[i][j]){
                    same = false;
                    //System.out.println("fail 3");
                    break;
                }
            }
        }
        if(same){
            out.println(3);
            out.close();
            System.exit(0);
        }
        
        char [][] mirror = mirror(originalBlocks);
        same = true;
        for(int i =0; i< originalBlocks.length; i++){
            for(int j = 0; j < originalBlocks[0].length; j++){
                if(newBlocks[i][j] != mirror[i][j]){
                    same = false;
                    //System.out.println("fail 4");
                    break;
                }
            }
        }
        if(same){
            out.println(4);
            out.close();
            System.exit(0);
        }
        char [][] mirrorRotation90 = degrees90Rotation(mirror);
        char [][] mirrorRotation180 = degrees90Rotation(mirrorRotation90);
        char [][] mirrorRotation270 = degrees90Rotation(mirrorRotation180);
        
        same = true;
        for(int i =0; i< originalBlocks.length; i++){
            for(int j = 0; j < originalBlocks[0].length; j++){
                if(newBlocks[i][j] != mirrorRotation90[i][j]){
                    same = false;
                    //System.out.println("fail 5.1");
                    break;
                }
            }
        }
        if(same){
            out.println(5);
            out.close();
            System.exit(0);
        }
        same = true;
        for(int i =0; i< originalBlocks.length; i++){
            for(int j = 0; j < originalBlocks[0].length; j++){
                if(newBlocks[i][j] != mirrorRotation180[i][j]){
                    same = false;
                    System.out.println("fail 5.2");
                    break;
                }
            }
        }
        if(same){
            out.println(5);
            out.close();
            System.exit(0);
        }
        same = true;
        for(int i =0; i< originalBlocks.length; i++){
            for(int j = 0; j < originalBlocks[0].length; j++){
                if(newBlocks[i][j] != mirrorRotation270[i][j]){
                    same = false;
                    //System.out.println("fail 5.3");
                    break;
                }
            }
        }
        if(same){
            out.println(5);
            out.close();
            System.exit(0);
        }
        same = true;
        for(int i =0; i< originalBlocks.length; i++){
            for(int j = 0; j < originalBlocks[0].length; j++){
                if(originalBlocks[i][j] != newBlocks[i][j]){
                    same = false;
                    break;
                }
            }
        }
        if(same){
            out.println(6);
            out.close();
            System.exit(0);
        }
        out.println(7);
        out.close();
        
    }
    
    public static char[][] degrees90Rotation(char [][] blocks){
            char [][] newBlocks = new char [blocks.length][blocks.length];
            for(int i = 0; i < blocks.length; i++){
                for(int j = 0; j<blocks[0].length;j++){
                    newBlocks[j][blocks.length-1-i] = blocks[i][j];
                }
            }
            return newBlocks;
    }
    public static char [][] mirror(char [][] blocks){
        char [][] mirror = new char [blocks.length][blocks.length];
        for(int i = 0; i < blocks.length; i++){
            for(int j = 0; j < blocks.length; j++){
                mirror[i][blocks.length - 1 - j] = blocks[i][j];
            }
        }
        return mirror;
    }
    
            
    

}
