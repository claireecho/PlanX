import java.util.*;
import java.io.*;

public class FullBody extends PlanX {

   public FullBody(int d) throws IOException {
      
      super(d, d % 2 == 0 ? d / 2 : d / 2 + 1, 4);
      int diff = d;
      String[] temp = new String[4];
      String[] list = {"Abs.txt", "Cardio.txt", "upperB.txt", "lowerB.txt"};
      int i = 0;
      while (i < 4) {
         String[] x = readFile(list[i]);
         int random = (int)(Math.random() * (x.length));
         for (String y : temp) {
            if (y == null)
               break;
            else if (y.equals(x[random]))
               continue;
         }
         temp[i] = x[random];
         i++;
      }
      initate(temp, d);
  
   }
   
   public void initate(String[] temp, int d) {
      ArrayList<String> c = new ArrayList<String>();
      for (String y : temp)
         c.add(y);
      circuit = c;
      for (String x : c) {
         queue.add(x);
      }
   }

   // d  1  2  3  4  5  6  7  8  9  10
   // ex 4  4  4  4  4  4  4  4  4  4
   // s  1  1  2  2  3  3  4  4  5  5

}