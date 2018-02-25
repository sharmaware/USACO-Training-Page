/*
ID: extreme3
LANG: JAVA
PROG: friday
*/
import java.util.*;
import java.io.*;

public class friday {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(new File("friday.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
        
        String [] week = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        
        int [] daysOfMonth = {31,28,31,30,31,30,31,31,30,31,30,31};
        int [] leapDaysOfMonth = {31,29,31,30,31,30,31,31,30,31,30,31};
        
        int n = input.nextInt();
        
        int [] dayOf13 = new int [7];
        int weekDay = 0;
        for(int i = 1900; i < n + 1900; i++){
            if((i%4 == 0 && i % 100 != 0 )|| i % 400 == 0){
                for(int numDays: leapDaysOfMonth){
                    for(int day = 1; day <= numDays; day++){
                        if(day == 13){
                           if(week[weekDay].equals("Saturday")){
                               dayOf13[0]++;
                           }
                           if(week[weekDay].equals("Sunday")){
                               dayOf13[1]++;
                           }
                           if(week[weekDay].equals("Monday")){
                               dayOf13[2]++;
                           }
                           if(week[weekDay].equals("Tuesday")){
                               dayOf13[3]++;
                           }
                           if(week[weekDay].equals("Wednesday")){
                               dayOf13[4]++;
                           }
                           if(week[weekDay].equals("Thursday")){
                               dayOf13[5]++;
                           }
                           if(week[weekDay].equals("Friday")){
                               dayOf13[6]++;
                           }
                        }
                        weekDay++;
                        if(weekDay == 7){
                            weekDay = 0;
                        }
                    }   
                }
            }
            else{
                for(int numDays: daysOfMonth){
                    for(int day = 1; day <= numDays; day++){
                        if( day == 13){
                           if(week[weekDay].equals("Saturday")){
                               dayOf13[0]++;
                           }
                           if(week[weekDay].equals("Sunday")){
                               dayOf13[1]++;
                           }
                           if(week[weekDay].equals("Monday")){
                               dayOf13[2]++;
                           }
                           if(week[weekDay].equals("Tuesday")){
                               dayOf13[3]++;
                           }
                           if(week[weekDay].equals("Wednesday")){
                               dayOf13[4]++;
                           }
                           if(week[weekDay].equals("Thursday")){
                               dayOf13[5]++;
                           }
                           if(week[weekDay].equals("Friday")){
                               dayOf13[6]++;
                           }
                        }
                        weekDay++;
                        if(weekDay == 7){
                            weekDay = 0;
                        } 
                    }   
                }
            }
        }
    
        for(int i = 0; i < 6; i++){
            out.print(dayOf13[i] + " ");
        }
        out.println(dayOf13[6]);
        out.close();
    }
    
}
