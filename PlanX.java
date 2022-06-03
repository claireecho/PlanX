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
   int currentSet = 0;
   
   public PlanX(int d, int s, int ex) {
      diff = d;
      sets = s;
      exercises = ex;
      queue = new Queue<String>();
      circuit = new ArrayList<String>();
   }
   
   public String getName() {
      String[] p = queue.peek().split(" ", 3);
      return (p[1].replaceAll("_", " "));
   }
   
   public Integer getSeconds() {
      String[] p = queue.peek().split(" ", 3);
      return (Integer.parseInt(p[2]));
   }
   
   public int getDiff() {
      return diff;
   }
   
   public void resetQueue() {
      queue = new Queue<String>();
      for (String x : circuit) {
         queue.add(x);
      }
   }
   
   public Queue<String> getQueue() {
      return queue;
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
   
   public void timer(String s, JLabel label, JPanel j, JButton b, PlanX p, JLabel k, JPanel m, CardLayout c, int kl, JLabel i) {
      java.util.Timer t = new java.util.Timer();
      label.setText(formatTime((int)(Integer.parseInt(s))));
      TimerTask task = new Helper(Integer.parseInt(s), label, j, b, this, k, m, c, kl, i);
      t.schedule(task, 0, 1100);
   
   }
   
   public void start(String x, JLabel label, JPanel j, JButton b, PlanX p, JLabel s, JPanel m, CardLayout c, int kl, JLabel i) {
      String[] temp = x.split(" ", 3);
      temp[1] = temp[1].replace("_", " ");
      if (temp[0].equals("S")) {
         timer(temp[2], label, j, b, this, s, m, c, kl, i);
      } else {
         label.setText("Finish Required Reps");
         b.setEnabled(true);
         p.getQueue().remove();
         kl = Integer.parseInt(s.getText().substring(13));
         if (p.getQueue().isEmpty()) {
            p.resetQueue();
            // if sets are completed switch to different panel in card layout
            kl++;
            if (kl > p.getSets()) {
               c.show(m, "complete");
            }
            s.setText("Current Set: " + kl);
         }
         i.setText(p.getName());
         if (!p.getQueue().peek().substring(0, 1).equals("S"))
            label.setText("Finish Required Reps");
         else 
            label.setText(formatTime(p.getSeconds()));

      }
   
   }
   public static String formatTime(int seconds) {
      
      int s = seconds % 60;
      int m = seconds / 60;
      return (m < 10 ? "0" : "") + m + ":" + (s < 10 ? "0" : "") + s;
      
   }

}

class Helper extends TimerTask {
   private int i;
   JLabel label;
   JPanel panel;
   JButton button;
   PlanX plan;
   JLabel sets;
   JPanel main;
   CardLayout card;
   int n;
   JLabel exercise;
    
   public Helper(Integer g, JLabel l, JPanel j, JButton b, PlanX p, JLabel s, JPanel m, CardLayout c, int kl, JLabel v) {
      i = g;
      label = l;
      panel = j;
      button = b;
      panel.setBackground(Color.GREEN);
      plan = p;
      sets = s;
      main = m;
      card = c;
      n = Integer.parseInt(sets.getText().substring(13));
      exercise = v;
   }
    
   public void run() {
      panel.revalidate();
      label.setText(formatTime(i));
      i--;
      if (i == -1) {
         cancel();
         button.setEnabled(true);
         panel.setBackground(Color.RED);
         plan.getQueue().remove();
         if (plan.getQueue().isEmpty()) {
            plan.resetQueue();
            // if sets are completed switch to different panel in card layout
            n++;
            if (n > plan.getSets()) {
               card.show(main, "complete");
            }
            sets.setText("Current Set: " + n);
         }
         exercise.setText(plan.getName());
         if (!plan.getQueue().peek().substring(0, 1).equals("S"))
            label.setText("Finish Required Reps");
         else 
            label.setText(formatTime(plan.getSeconds()));
      }
   }
   
   public String formatTime(int seconds) {
      
      int s = seconds % 60;
      int m = seconds / 60;
      return (m < 10 ? "0" : "") + m + ":" + (s < 10 ? "0" : "") + s;
      
   }
   
}

