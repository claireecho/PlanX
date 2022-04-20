import java.io.*;
import java.util.*;

public class PlanX {

   ArrayList<String> circuit;
   int diff;
   int sets;
   
   int index = 0;
   
   public PlanX() {
      
   }
   
   public PlanX(int d, int s) {
      diff = d;
      sets = s;
   }
   
   public String format(String x) {
      
   }
   
   public String random(String[]
   
   
   // Turns .txt files into ArrayLists
   public static int getFileSize(String fileName)throws IOException { // Borrowed from animalGuesserShell.java
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
   
}