import java.util.*;
import java.io.*;

public class Stretches extends PlanX {

   public Stretches(int d) throws IOException {
      super(d, 1, 10);
      int diff = d;
      String[] temp = readFile("Stretches.txt");
      initate(temp, d);
   }
   
   public void initate(String[] temp, int d) {
      ArrayList<String> c = new ArrayList<String>();
      w: while (c.size() < exercises) {
            int ranEx = (int)(Math.random() * (temp.length) - 1);
            for (int x = 0; x < c.size(); x++) {
               if (temp[ranEx].equals(c.get(x)))
                  continue w;
            }
         c.add(temp[ranEx]);
      }
      circuit = c;
      for (String x : c)
         queue.add(x);
   }
   
   
   
   // d  1  2  3  4  5  6  7  8  9  10
   // ex 10 10 10 10 10 10 10 10 10 10
   // s  1  1  1  1  1  1  1  1  1  1
   
}