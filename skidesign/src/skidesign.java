/*
ID: extreme3
LANG: JAVA
PROG: skidesign
 */
import java.util.*;
import java.io.*;

public class skidesign {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("skidesign.in"));
        int n = Integer.parseInt(br.readLine());
        int[] heights = new int[n];
        for (int i = 0; i < n; i++) {
            heights[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(heights);
        int leftI = 0;
        int rightI = heights.length - 1;
        int totalCost = 0;
        
        //for from left side
        while (leftI <= heights.length / 2) {
            if (heights[rightI] - heights[leftI] > 17) {

                int difference = heights[rightI] - heights[leftI];
                int x = (difference - 17) / 2;
                heights[rightI] -= x;
                totalCost += 2 * Math.pow(x, 2);
            }
            leftI++;
        }
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("skidesign.out")));
        out.println(totalCost);
        out.close();
    }

}
