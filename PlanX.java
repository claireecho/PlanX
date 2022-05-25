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
   
   
   public static void main(String[] arg) throws IOException {
      Abs circuit = new Abs (1); 
      System.out.println("YOUR ABDOMINAL CIRCUIT\nsets: " + circuit.getSets());
      
      // make window
      JFrame frame = new JFrame("PlanX");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(500, 300);
      frame.setVisible(true);
      frame.setIconImage(new ImageIcon("icon.png").getImage());
      

   }
   
}

class Helper extends TimerTask
{
   private int i;
    
   public Helper(Integer g) {
      i = g;
   }
    
   public void run()
   {
      System.out.println("Timer ran " + i--);
      if (i == 0) {
         cancel();
      }
   }
}
class Animator extends TimerTask {
   private int i = 0;
   private BufferedImage image;
   private JFrame jframe;
   private JLabel jlabel;
   private String[] imageList;
   
   public Animator(BufferedImage o, JFrame jf, JLabel jl, String[] il) {
      image = o;
      jframe = jf;
      jlabel = jl;
      imageList = il;
   }
   
   public void run() {
      createBackground(imageList[i], jframe, image, jlabel);
      i++;
   }
   
   public static void createBackground(String x, JFrame jframe, BufferedImage image, JLabel imageLabel) { // generates image
      try {
         image = ImageIO.read(new File(x));
      } catch (IOException e) {
         System.out.print("your mom");
      }
      imageLabel = new JLabel(new ImageIcon(image));
      jframe.add(imageLabel);
   }
}
