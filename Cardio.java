import java.util.*;

public class Cardio extends PlanX
{
   
   public Cardio(int d) throws IOException 
   {
      super(d, d % 2 == 0 ? d / 2 : d / 2 + 1, d % 2 == 0 ? 3 : 4);
      int diff = d;
      ArrayList<String> circuit = new ArrayList<String>();
      String[] temp = readFile("Cardio.txt");
      start(temp, d);
   }
   
    public void start(String[] temp, int d) {
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
   }
   
   //    d = 1  2  3  4  5  6  7  8  9  10
   //  exs = 3  4  3  4  3  4  3  4  3  4
   // sets = 1  1  2  2  3  3  4  4  5  5 
   
}//end class