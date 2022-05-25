import java.io.*;
import java.util.*;
import java.awt.*;
import java.net.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Window extends JPanel {
   JFrame frame;
   JLabel background;
   JPanel title;
   JLabel titleLabel;
   JPanel start;
   JButton startButton;
   
   public Window() throws IOException {
      // make window
      frame = new JFrame("PlanX");
      frame.setSize(800, 700);
      frame.setResizable(false);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setIconImage(new ImageIcon("icon.png").getImage());
      frame.setLayout(null);
      
      // setup background
      URL url = Window.class.getResource("home-screen.gif");
      ImageIcon imageIcon = new ImageIcon(url);
      background = new JLabel(imageIcon);
      background.setBounds(0, 0, 800, 700);
      frame.add(background);
      
      // creating Title Label
      title = new JPanel();
      title.setSize(800, 700);
      titleLabel = new JLabel("PLAN X", JLabel.CENTER);
      title.setLocation(titleLabel.getLocation().x, 200);
      titleLabel.setFont(registerFont("FFFFORWA.TTF", 50f));
      titleLabel.setForeground(Color.WHITE);
      title.setOpaque(false);
      title.add(titleLabel);
      background.add(title);      
      
      // creating Start Button
      start = new JPanel();
      start.setSize(800, 700);
      Icon icon = new ImageIcon("start-button.png");
      startButton = new JButton("START");
      startButton.setFont(registerFont("FFFFORWA.TTF", 20f));
      startButton.setBounds(0, 0, 100, 50);
      start.setOpaque(false);
      startButton.setPreferredSize(new Dimension(170, 85));
      start.setLocation(startButton.getLocation().x, 400);
      startButton.setHorizontalAlignment(SwingConstants.CENTER);
      start.add(startButton);
      background.add(start);
      
      frame.setVisible(true);
          
   }
   
   public static void main(String[] args) throws MalformedURLException, IOException {
      Window window = new Window();
   
   }
   
   public Font registerFont(String x, float size) throws IOException { // sets font for JLabels
      try {
         InputStream in = PlanX.class.getClassLoader().getResourceAsStream(x);
         Font font = Font.createFont(Font.TRUETYPE_FONT, in);
         font = font.deriveFont(size);
         return font;
      } catch (FontFormatException e) {
         System.out.print("your mom");
      }
      return null;
   }

}
