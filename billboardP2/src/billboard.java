import java.util.*;
import java.io.*;

public class billboard {
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("billboard.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int Lx1 = Integer.parseInt(st.nextToken());
        int Ly1 = Integer.parseInt(st.nextToken());
        int Lx2 = Integer.parseInt(st.nextToken());
        int Ly2 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());
        
        int areaTarp = 0;
        boolean overlap = false;
        
         if(
                ((Lx1 > x1 && Lx1 < x2) && (Ly2 < y2 && Ly2 > y1)) ||
                ((Lx2 > x1 && Lx2 < x2) && (Ly2 < y2 && Ly2 > y1)) ||
                ((Lx2 > x1 && Lx2 < x2) && (Ly1 < y2 && Ly1 > y1)) ||
                ((Lx1 > x1 && Lx1 < x2) && (Ly1 < y2 && Ly1 > y1)) 
                ){
            overlap = true;
        }
        
        boolean inside = false;
        if( Lx1 >= x1 && Lx2 <= x2 && Ly1 >= y1 && Ly2 <= y2){
            inside = true;
        }
        
        //System.out.println(inside);
        //System.out.println(overlap);
        
        if(inside){
            areaTarp = 0;
        }   
        else if (overlap){
            areaTarp = areaTarp(Lx1, Ly1, Lx2, Ly2, x1, y1, x2, y2);
        }
        
        else{ //no overlap
            areaTarp = (Lx2 - Lx1) * (Ly2 - Ly1);
        }
        PrintWriter out = new PrintWriter(new FileWriter("billboard.out"));
        out.println(areaTarp);
        out.close();
        //System.out.println(areaTarp);
        
        
    }
    public static int areaTarp(int Lx1, int Ly1,int Lx2, int Ly2, int x1, int y1, int x2, int y2){
        if((Lx2 > x1 && Lx2 < x2) && (Ly1 > y1 && Ly2 < y2) && Lx1 < x1){
            
            //System.out.println(1);
            return (Ly2-Ly1) * (x1-Lx1);
            
        }
        if((Ly1 > y1 && Ly1 < y2) && (Lx1 > x1 && Lx2 < x2) && Ly1 > y2){
            //System.out.println(2);
            return (Lx2-Lx1) * (Ly2-y2);
        }
        if((Lx1 > x1 && Lx1 < x2) && (Ly1 > y1 && Ly2 < y2) && Lx2 > x2){
            //System.out.println(3);
            return (Ly2-Ly1) * (Lx2-x2);
        }
        if((Ly2 > y1 && Ly2 < y2) && (Lx1 > x1 && Lx2 < x2) && Ly1 < y1){
            //System.out.println(4);
            return (Lx2-Lx1) * (y1-Ly1);
        }
        //System.out.println(5);    
        return (Lx2 - Lx1) * (Ly2 - Ly1);


    }


}