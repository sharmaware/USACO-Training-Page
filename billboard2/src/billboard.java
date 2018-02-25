import java.util.*;
import java.io.*;

public class billboard {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("billboard.in"));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int Ax1 = Integer.parseInt(st.nextToken());
        int Ay1  = Integer.parseInt(st.nextToken());
        int Ax2  = Integer.parseInt(st.nextToken());
        int Ay2 = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int Bx1  = Integer.parseInt(st.nextToken());
        int By1  = Integer.parseInt(st.nextToken());
        int Bx2 = Integer.parseInt(st.nextToken());
        int By2 = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int Tx1 = Integer.parseInt(st.nextToken());
        int Ty1 = Integer.parseInt(st.nextToken());
        int Tx2 = Integer.parseInt(st.nextToken());
        int Ty2 = Integer.parseInt(st.nextToken());
        
        int areaA = Math.abs((Ax2-Ax1) * (Ay2-Ay1));
        int areaB = Math.abs((Bx2-Bx1) * (By2-By1));
        
        areaA = areaA - intersect(Tx1, Ty1, Tx2, Ty2, Ax1, Ay1, Ax2, Ay2);
        areaB = areaB - intersect(Tx1, Ty1, Tx2, Ty2, Bx1, By1, Bx2, By2);
        
        PrintWriter out = new PrintWriter(new FileWriter("billboard.out"));
        out.println(areaA + areaB);
        out.close();
        
        
        
    }
    public static int intersect(int Tx1, int Ty1, int Tx2, int Ty2, int x1, int y1, int x2, int y2){
        boolean overlap = false;
        if(
                ((Tx1 > x1 && Tx1 < x2) && (Ty2 < y2 && Ty2 > y1)) ||
                ((Tx2 > x1 && Tx2 < x2) && (Ty2 < y2 && Ty2 > y1)) ||
                ((Tx2 > x1 && Tx2 < x2) && (Ty1 < y2 && Ty1 > y1)) ||
                ((Tx1 > x1 && Tx1 < x2) && (Ty1 < y2 && Ty1 > y1)) 
                ){
            overlap = true;
        }
        
        if(overlap){
            int [] x = {Tx1, Tx2, x1, x2};
            int [] y = {Ty1, Ty2, y1, y2};
            Arrays.sort(x);
            Arrays.sort(y);
            
            int diffX = x[2] -x[1];
            int diffY = y[2] - y[1];
            return Math.abs(diffX * diffY);
        }
        else{
            return 0;
        }
    }

    
}
