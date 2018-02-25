/*
ID: extreme3
LANG: JAVA
PROG: namenum
*/
import java.util.*;
import java.io.*;
public class namenum {
    
    static ArrayList<String> names = new ArrayList<>();
    static String [] [] lettersMap  = {{"A", "B", "C"}, {"D", "E", "F"}, {"G", "H", "I"} , {"J", "K", "L"}, {"M", "N", "O"},
        {"P", "R", "S"} ,{"T", "U", "V"}, {"W", "X", "Y"}};
    //static ArrayList<String> nameList = new ArrayList<>();
    static ArrayList<String> validNames = new ArrayList<>();
    static String [] nameList  = new String [5000];    
    public static void main(String[] args) throws IOException{
        
        
        Scanner input = new Scanner(new File("namenum.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));
        
        //Scanner readName = new Scanner(new File("dict.txt"));
        BufferedReader f = new BufferedReader (new FileReader ("dict.txt"));
        
        String serialNum = input.next();
        
        final long startTime0 = System.currentTimeMillis();
        possibleNames(serialNum, "");
        final long endTime0 = System.currentTimeMillis();
        int count = 0;
        
        final long startTime1 = System.currentTimeMillis();
        //while(readName.hasNext()){
        //    nameList[count] = readName.next();
        //    count++;
        //}
               
        while ((nameList[count++] = f.readLine()) != null) {
        }  
        
       
        final long endTime1 = System.currentTimeMillis();
        
        final long startTime2 = System.currentTimeMillis();
        matchNames();
        final long endTime2 = System.currentTimeMillis();
        /*
        for(int i = 0; i < names.size(); i++){
            System.out.println(names.get(i) + " " + i);
        }
        */
        
        
        
        /*
        for(int i = 0; i < names.size(); i++){
            matchNames(names.get(i), 0, 0);
        }
        */
        final long startTime3 = System.currentTimeMillis();
        if(validNames.size() == 0){
            out.println("NONE");
        }
        else{
            //Collections.sort(validNames);
            for(String a: validNames){
                out.println(a);
            }
        }    
        out.close();
        
        final long endTime3 = System.currentTimeMillis();
        
        //System.out.println(endTime0 - startTime0);
        //System.out.println(endTime1 - startTime1);
        //System.out.println(endTime2 - startTime2);
        //System.out.println(endTime3 - startTime3);
        //System.out.println("Total: " + (endTime0 - startTime0 + endTime3 - startTime3 + endTime2 - startTime2 + endTime1 - startTime1));
        
    }
    public static void possibleNames(int left, String made){
        if(left <= 0){
           names.add(made);
           return;
        }
        for(int i = 0; i < lettersMap[i].length; i++){
            String newMade = lettersMap[left % 10 - 2][i] + made;
            possibleNames((int) left / 10, newMade);
        }
    }
    /*
    public static void possibleNames(String left, String made){
        if(left.length() <= 0){
           names.add(made);
           return;
        }
        for(int i = 0; i < lettersMap[i].length; i++){
            String newMade = lettersMap[new Integer(left.substring(left.length()-1, left.length()))-2][i] + made;
            possibleNames( left.substring(0,left.length()-1), newMade);
        }
    }
    */
    public static void possibleNames(String left, String made){
        if(left.length() == 0){
           names.add(made);
           return;
        }
        for(int i = 0; i < lettersMap[0].length; i++){
            String newMade = made + lettersMap[new Integer(left.substring(0,1))-2][i] ;
            possibleNames( left.substring(1,left.length()), newMade);
        }
    }
    
    /*
    public static void matchNames(){
        int namesI = 0;
        int nameListI = 0;
        
        
        while(namesI < names.size() && nameListI < nameList.length){
            int compare = matchLetters(names.get(namesI), nameList[nameListI], 0); //, 0
            if(compare > 0){
                nameListI++;
            }
            else if(compare < 0){
                namesI++;
            }
            else if (compare == 0){
                validNames.add(nameList[nameListI]);
                //System.out.println(validNames.size());
                namesI++;
                nameListI++;
            }
            
        }
        
        
    } */
    
    /*
      public static void matchNames(){
        int namesI = 0;
        int nameListI = 0;
        int remaining = 0;
        int i = 0;
        int pos = 0;
        int len = 0;
        
        while (nameListI < nameList.length) {
            
            while (pos < nameList[nameListI].length() && namesI < names.size()) {
                    
                //while (namesI < names.size()) {
                    
                    if(names.get(namesI).charAt(pos) == nameList[nameListI].charAt(pos)) {
                        
                        if (pos == nameList[nameListI].length ()) { //-1
                            System.out.println(nameList[nameListI]);
                        }
                        
                        pos++;
                        break;
                    } else {
                        namesI++;
                    }
                //}
            }
            nameListI++;
            namesI = 0;
            pos = 0;
        }
      } */
                
          
public static void matchNames(){
        int namesI = 0;
        int nameListI = 0;
         
        while (nameListI < nameList.length) {
            //System.out.println(nameList[nameListI]);
            while (namesI < names.size()) {
                //System.out.println(names.get(namesI));
                if(names.get(namesI).equals(nameList[nameListI])) {
                    System.out.println(nameList[nameListI]);
  
                }
                namesI++;
            }
               
            nameListI++;
            namesI = 0;
        }
      }
    
      /*
    public static int matchLetters(String trial, String name, int i){
        
        //?
            if(i >= trial.length() || i >= name.length()){
                if(trial.length() > name.length()){
                    return 1;
                }
                if(trial.length() < name.length()){
                    return -1;
                }
                else{
                //if(trial.length() == name.length())
                return 0;
                }
            
            }
            if(trial.charAt(i) == name.charAt(i)){
                //System.out.println("here2");
                return(matchLetters(trial, name, i+1));
                
            }
            else{
            return trial.substring(i,i+1).compareTo(name.substring(i,i+1));
            }
        
    }
      */
    
  
    /*
    public static void matchNames(String possibleName, int i, int count){
        if(i >= possibleName.length()){    
               validNames.add( nameList.get(count) );
               return;
        }
        if(i >= nameList.get(count).length()){
                return;
        }
        
        while(nameList.get(count).substring(i, i+1).compareTo(possibleName.substring(i,i+1))< 0){
            //System.out.println(nameList.get(count));
            if(i >= nameList.get(count).length()){
                return;
            }
            count++;
            
            
        }
        if(nameList.get(count).substring(i, i+1).compareTo(possibleName.substring(i,i+1)) == 0){
            matchNames(possibleName, i+1, count);
        }
        // else return
    }
    
    */

    }
