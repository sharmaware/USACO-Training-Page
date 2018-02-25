import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class rental {
    static int [] cows;
    static Integer [][] milk;
    static int [] rent;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("rental.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        cows = new int [n];
        milk = new Integer [m][2];
        rent = new int [r];

        for(int i = 0; i < n; i++){
            cows[i] = Integer.parseInt(br.readLine());
        }
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            milk[i][0] = Integer.parseInt(st.nextToken());
            milk[i][1] = Integer.parseInt(st.nextToken());
            //System.out.println(milk[i][0] + ", " + milk[i][1]);

        }
        for(int i = 0; i < r; i++){
            rent[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(cows);
        Arrays.sort(milk, new Comparator<Integer[]>(){
            @Override
            public int compare(Integer[] a1, Integer[] a2){
                Integer a11 = a1[1];
                Integer a22 = a2[1];
                return a11.compareTo(a22);
            }

        });

        Arrays.sort(rent);
        //finished taking input and sorting
        int cowsI = cows.length - 1;
        int rentI = rent.length - 1;
        int milkI = milk.length - 1;
        int cowsEnd = 0;
        BigInteger totalProfit = new BigInteger("0");
        //String [] milkOrRent = new String [n];

        while(cowsI >= cowsEnd){
            int profitMilk = 0;
            int totalMilk = 0;
            int finalMilkEntry = 0;
            int localMilkI = milkI;
            //calculating profitMilk
            while(totalMilk < cows[cowsI]){
                if(localMilkI >= 0 && (milk[localMilkI][0] + totalMilk <= cows[cowsI])){
                    totalMilk = milk[localMilkI][0] + totalMilk;

                    profitMilk += milk[localMilkI][0] * milk[localMilkI][1];
                    //System.out.println("Change Price: " + milk[localMilkI][0] * milk[localMilkI][1]);
                    localMilkI--;

                }
                //no more milk entries left?
                //case: more milk in entry
                else if (localMilkI >= 0 &&(milk[localMilkI][0] + totalMilk > cows[cowsI])){

                    int leftMilk = cows[cowsI] - totalMilk;
                    //System.out.println("Left Milk: " + leftMilk);
                    finalMilkEntry = milk[localMilkI][0] - leftMilk;
                    //System.out.println("Final Milk Entry: " + finalMilkEntry);
                    totalMilk = cows[cowsI];

                    profitMilk += milk[localMilkI][1] *  leftMilk;
                    //System.out.println("Milk Price: " + milk[localMilkI][1]);

                }
                else{

                    break;
                }

            }
            int profitRent;
            if(rentI >= 0){
                profitRent = rent[rentI];
            }
            else{
                profitRent = 0;
            }
            //rent
            if(profitRent > profitMilk){
                //System.out.println("Rent: " + profitRent);
                rentI--;
                //milkOrRent[cowsEnd] = "R";
                cowsEnd++;
                totalProfit = totalProfit.add( new BigInteger(Integer.toString(profitRent)));


            }
            //milk
            else{
                //System.out.println("Milk: " + profitMilk);
                milkI = localMilkI;
                milk[milkI][0] = finalMilkEntry;
                totalProfit = totalProfit.add( new BigInteger(Integer.toString(profitMilk)));
                //milkOrRent[cowsI] = "M";
                cowsI--;

            }

        }
        PrintWriter out = new PrintWriter(new FileWriter("rental.out"));
        out.println(totalProfit);
        out.close();

        System.out.println(totalProfit);
       //for(int i = 0; i < milkOrRent.length; i++){
           //System.out.println(milkOrRent[i]);
       //}
    }

}