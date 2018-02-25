/*
ID: extreme3
LANG: JAVA
PROG: milk
*/
import java.util.*;
import java.io.*;
       
public class milk {
    

    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("milk.in"));
        StringTokenizer st = new StringTokenizer(f.readLine());
        
        int n = new Integer(st.nextToken());
        int m = new Integer(st.nextToken());
        
        
        int [] [] farmersPrices = new int [m][3]; 
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(f.readLine());
            farmersPrices[i][0] = new Integer(st.nextToken());
            farmersPrices[i][1] = new Integer(st.nextToken());
        }
        int currentPrice = 0;
        int currentFarmer = 0;
        int totalUnits = 0;
        int totalPrice = 0;
        while(totalUnits < n){
            int lowest  = 100000000;
            int lowestI = 0;
            for(int i = 0; i < m; i++){
                if(farmersPrices[i][2] == 0){
                    if(farmersPrices[i][0] < lowest){
                        lowest = farmersPrices[i][0];
                        lowestI = i;
                    }
                }
            }
            if(n - totalUnits > farmersPrices[lowestI][1]){
                totalUnits+= farmersPrices[lowestI][1];
                totalPrice += farmersPrices[lowestI][0] * farmersPrices[lowestI][1];
                farmersPrices[lowestI][2] = 1;
            }
            else{
                totalPrice += (n - totalUnits) * farmersPrices[lowestI][0];
                totalUnits  = n;
            }
        }
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk.out")));
        
        out.println(totalPrice);
        out.close();
    }
    
}
