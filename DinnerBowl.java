import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class DinnerBowl {

 public static void main(String[] args) {
   
   try {
     BufferedReader bfr = new BufferedReader(new FileReader ("PracticeInput.txt"));
     ArrayList<String> records = new ArrayList<String>();
     String line;
     ArrayList<String> result = new ArrayList<String>();
   
     while ((line = bfr.readLine()) != null) {
       records.add(line);
     }
     
     int sizeOfList = records.size(); 
     int noOfWeeks = Integer.parseInt(records.get(0));  // no of weeks being calculated
     int [] timeAtDinner = new int[noOfWeeks]; // time spent at dinner for each of the weeks
     int timeAtDinnerIndex = 0;
     
     int tempMaxTime = 0;   // a variable used to store each of the maximum times per week
     
     for  (int i = 1; i<sizeOfList; i++) {
       String item = records.get(i);
       
       if (item.indexOf(" ") == -1 && i == 1) { // do nothing
       }
       
       else if (item.indexOf(" ") == -1 && i > 1) {   // single number
         // populate current value in timeAtDinner array with maximum value
         // shift pointer in timeAtDinner array to next
         //reinitialize maximum value
         
         timeAtDinner[timeAtDinnerIndex] = tempMaxTime;
         System.out.println(i);
         timeAtDinnerIndex++;
         tempMaxTime = 0;
       }
       
       else {   // double number
         // split into two numbers
         // add them
         // compare to max and update max if need be
         
         String[] nos = item.split(" ");
         int totalTime = Integer.parseInt(nos[0]) + Integer.parseInt(nos[1]);
         //System.out.println("Total time is " + totalTime);
         //System.out.println("Index is " + i);
         
         if (totalTime > tempMaxTime) {
           tempMaxTime = totalTime;
         }
         
       }
     }
     
     for (int x: timeAtDinner) {
       //System.out.println(x);
     }
     //System.out.println(timeAtDinner.length);
   }
  
   catch (Exception e) {
    System.err.format("Exception occurred trying to read file");
    e.printStackTrace();
   }
 }
 
}