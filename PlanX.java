import java.io.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;

public class PlanX {

   ArrayList<String> circuit;
   Queue<String> queue;
   int diff;
   int sets;
   int exercises;
   
   public PlanX(int d, int s, int ex) {
      diff = d;
      sets = s;
      exercises = ex;
      queue = new Queue<String>();
      circuit = new ArrayList<String>();
   }
   
   public String format(String x) {
      return "";
   }
   
   public int getDiff() {
      return diff;
   }
   
   public int getSets() {
      return sets;
   }
   
   public int getExercises() {
      return exercises;
   }
   
   public ArrayList<String> getCircuit() {
      return circuit;
   }
   
   public String toString() { // RES russian_twists 10
      String returnValue = "";
      for (String x : circuit) {
         String[] temp = x.split(" ", 3);
         returnValue += temp[2] + (temp[0].equals("S") ? " seconds of " : (temp[0].equals("R") ? " reps of " : " reps on each side of ")) + temp[1].replaceAll("_", " ") + "\n";
      }
      return returnValue;
   } 
   
   public String toStringWithHTML() {
      String returnValue = "";
      for (String x : circuit) {
         String[] temp = x.split(" ", 3);
         returnValue += "<html>" + temp[2] + (temp[0].equals("S") ? " seconds of " : temp[0].equals("R") ? " reps of " : " reps on each side of ") + temp[1].replaceAll("_", " ") + "<br/>";
      }
      returnValue += "<html>";
      return returnValue;
   }
   
   // Turns .txt files into ArrayLists
   public static int getFileSize(String fileName) throws IOException { // Borrowed from animalGuesserShell.java
      Scanner input = new Scanner(new FileReader(fileName));
      int size=0;
      while (input.hasNextLine()) {
         size++;									
         input.nextLine();							
      }
      input.close();								
      return size;
   }

   public static String[] readFile(String fileName)throws IOException {
      int size = getFileSize(fileName);	
      String[] list = new String[size];	
      Scanner input = new Scanner(new FileReader(fileName));
      int i=0;											
      String line;	
      while (input.hasNextLine()) {
         line=input.nextLine();				
         list[i]= line;								
         i++;										       
      }
      input.close();	
      return list;					
   }
   
   public static void sleep(String s) {
      try {
         Thread.sleep(Long.parseLong(s) * 1000 / 2);
      } catch (InterruptedException ex) {
         ex.printStackTrace();
      }
   }
   
   public static void timer(String s) {
      java.util.Timer t = new java.util.Timer();
      TimerTask task = new Helper(Integer.parseInt(s) / 2);
      t.schedule(task, 100, Long.parseLong(s) * 100 / 2);
      sleep(s);
   
   }
   
   public static void start(String x) {
      String[] temp = x.split(" ", 3);
      temp[1] = temp[1].replace("_", " ");
      System.out.println(temp[1]);
      if (temp[0].equals("S")) {
         timer(temp[2]);
      }
   
   }

}

class Helper extends TimerTask {
   private int i;
    
   public Helper(Integer g) {
      i = g;
   }
    
   public void run() {
      System.out.println("Timer ran " + i--);
      if (i == 0) {
         cancel();
      }
   }
}

