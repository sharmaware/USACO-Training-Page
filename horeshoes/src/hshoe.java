import java.io.*;
import java.util.*;

class hshoe {
    static int max = 0;
    
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("hshoe.in"));
        int n = Integer.parseInt(br.readLine());
        String [][] horseshoes = new String [n][n];
        for(int i = 0; i < n; i++){
            String st = br.readLine();
            for(int j = 0; j < st.length(); j++){
                horseshoes[i][j] = st.substring(j, j+1);
            }
        }
        solve(horseshoes, 0, 0, 0, 0, true);
        System.out.println(max);
    }
    public static void solve(String [][] horseshoes,int x, int y, int total, int absoluteTotal ,boolean open){
        if(x >= horseshoes.length || x < 0 || y >= horseshoes.length || y < 0 || horseshoes[x][y].equals("0")){
            System.out.println("end condition met");
            if(total == 0 && absoluteTotal > max){
                System.out.println("success: " + absoluteTotal);
                max = absoluteTotal;
            }
            return;
        }
        
        
        String temp = horseshoes[x][y];
        horseshoes[x][y] = "0";
        
        if(open){
            if(temp.equals("(")){
                total++;
                absoluteTotal++;
            }
            else{
                open = false;
                total--;
                absoluteTotal++;
                
            }
            
              
        }
        else{
            total--;
            absoluteTotal++;
        }
        System.out.println("Totals" + total + "  " + absoluteTotal);
        System.out.println("p 1");
        System.out.println("current pos: " + x + ", " + y);
        solve(horseshoes, x, y+1, total, absoluteTotal, open);
        System.out.println("Totals" + total + "  " + absoluteTotal);
        System.out.println("p 2");
        System.out.println("current pos: " + x + ", " + y);
        solve(horseshoes, x+1, y, total, absoluteTotal, open);
        System.out.println("Totals" + total + "  " + absoluteTotal);
        System.out.println("p 3");
        System.out.println("current pos: " + x + ", " + y);
        solve(horseshoes, x, y-1, total, absoluteTotal, open);
        System.out.println("Totals" + total + "  " + absoluteTotal);
        System.out.println("p 4");
        System.out.println("current pos: " + x + ", " + y);
        solve(horseshoes, x-1, y, total, absoluteTotal, open);
        
        
    }
}
