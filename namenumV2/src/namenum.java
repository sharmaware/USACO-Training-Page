/*
ID: extreme3
LANG: JAVA
PROG: namenum
*/


import java.util.*;
import java.io.*;

public class namenum {
    static String [] lettersMap  = {"2","2","2","3","3","3","4","4","4","5","5","5",
        "6","6","6","7","0","7","7","8","8","8","9","9","9", "0"};
    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(new File("namenum.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));
        
        String brandNumber = input.next();
        //Scanner readName = new Scanner(new File("dict.txt"));
        BufferedReader f = new BufferedReader (new FileReader ("dict.txt"));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int count = 0;
        while(true){
            String name = st.nextToken();
            String number = "";
            for(int i = 0; i < name.length(); i++){
                number += lettersMap[name.substring(i, i+1).compareTo("A")];
            }
            //System.out.println(number);
            if(number.equals(brandNumber)){
                out.println(name);
                count++;
            }
            String nextLine = f.readLine();
            if(nextLine != null)
            st = new StringTokenizer(nextLine);
            else{
                break;
            }
        }
        if(count == 0){
            out.println("NONE");
        }
        out.close();
        
        
        
    }
    
}
