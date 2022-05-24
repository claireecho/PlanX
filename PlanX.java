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
   
   public ArrayList<String> start(String[] temp, int d) {
      ArrayList<String> circuit = new ArrayList<String>();
      w: while (circuit.size() < exercises) {
            int ranEx = (int)(Math.random() * (temp.length) - 1);
            for (int x = 0; x < circuit.size(); x++) {
               if (temp[ranEx].equals(circuit.get(x)))
                  continue w;
            }
         circuit.add(temp[ranEx]);
      }
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
      Abs circuit = new Abs ("Abs.txt", 3); 
      
   }
   
}