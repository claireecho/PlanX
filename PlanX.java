import java.io.*;
import java.util.*;

public class PlanX {

   ArrayList<String> circuit;
   int diff;
   int sets;
   int exercises;
   
   int index = 0;
   
   public PlanX() {
      
   }
   
   public PlanX(int d, int s, int ex) {
      diff = d;
      sets = s;
      exercises = ex;
   }
   
   public String format(String x) {
      return "";
   }
   
   public String random(String[] x) {
      return null;
   }
   
   public int getDifficulty() {
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
   
   public static void main(String[] arg) throws IOException {
      Abs circuit = new Abs (10); 
      for (String x : circuit.getCircuit()) {
         System.out.println(x);
      }
   }
   
}