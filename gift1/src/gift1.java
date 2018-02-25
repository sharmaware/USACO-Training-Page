/*
ID: extreme3
LANG: JAVA
PROG: gift1
*/


import java.util.*;
import java.io.*;

public class gift1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
        Scanner input = new Scanner(new File("gift1.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
        
        int n = input.nextInt();
        String [] people = new String [n];
        int [] balances  = new int [n];
        
        for(int i = 0; i < n; i++){
            people[i] = input.next();
        }
        
        while(input.hasNext()) {
            String person = input.next();
            int amount = input.nextInt();
            int divisor = input.nextInt();
            String[] chosenPeople = new String[divisor];
            if (divisor != 0) {
                for (int l = 0; l < chosenPeople.length; l++) {
                    chosenPeople[l] = input.next();
                }

                for (int j = 0; j < chosenPeople.length; j++) {
                    for (int k = 0; k < people.length; k++) {
                        if (chosenPeople[j].equals(people[k])) {
                            balances[k] += (int) (amount / divisor);
                        }
                    }
                }
                for (int j = 0; j < people.length; j++) {
                    if (people[j].equals(person)) {
                        balances[j] += amount % divisor;
                        balances[j] -= amount; //divisor * ((int) amount / divisor);
                    }
                }
            }
        }
        
        for(int i = 0; i < people.length; i++){
            out.println(people[i] + " " + balances[i]);
        }
        out.close();
    }
    
}
