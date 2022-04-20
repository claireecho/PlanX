import java.util.*;

public class Abs extends PlanX {

   public Abs(String n, int d) {
      super(d, d % 2 == 0 ? d / 2 : d / 2 + 1);
      int diff = d;
      ArrayList<String> circuit = new ArrayList<String>();
      String[] temp = readFile(n);
   }
   
   public ArrayList<String> start(String temp, int d) {
      int exs = d % 2 == 0 ? 6 : 5;
      ArrayList<Integer> circuit = new ArrayList<Integer>();;
      w: while (circuit.length() != exs) {
         int temp = (int)(Math.random() * (temp.length - 1));
         for (int x = 0; x < circuit.length(); x++) {
            if (temp == circuit[x])
               continue w;
         }
         circuit.add(temp);
      }
      
   }


   
   // d  1  2  3  4  5  6  7  8  9  10
   // ex 5  6  5  6  5  6  5  6  5  6
   // s  1  1  2  2  3  3  4  4  5  5
   
}