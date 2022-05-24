import java.util.*;
import java.io.*;

public class Abs extends PlanX {

   public Abs(String n, int d) throws IOException {
      super(d, d % 2 == 0 ? d / 2 : d / 2 + 1, d % 2 == 0 ? 6 : 5);
      int diff = d;
      ArrayList<String> circuit = new ArrayList<String>();
      String[] temp = readFile("Abs.txt");
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


   
   // d  1  2  3  4  5  6  7  8  9  10
   // ex 5  6  5  6  5  6  5  6  5  6
   // s  1  1  2  2  3  3  4  4  5  5
   
}