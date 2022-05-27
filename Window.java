import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Window extends JPanel {
   JFrame frame;
   JPanel main;
   JPanel homePanel;
   JLabel background;
   JPanel title;
   JLabel titleLabel;
   JPanel start;
   JButton startButton;
   JPanel menu;
   JSlider difficulty;
   JLabel difficultyLabel;
   JComboBox exerciseChoice;
   JPanel dropDownPanel;
   JLabel exerciseChoiceLabel;
   JPanel difficultyPanel;
   JPanel generatePanel;
   JButton generateButton;
   
   public Window() throws IOException {
      // make window
      frame = new JFrame("PlanX");
      frame.setSize(800, 700);
      frame.setResizable(false);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setIconImage(new ImageIcon("icon.png").getImage());
      frame.setLayout(null);
      
      // create CardLayout Panel
      
      // setup background
      homePanel = new JPanel();
      homePanel.setSize(800,700);
      homePanel.setLayout(null);
      URL url = Window.class.getResource("flex.gif");
      ImageIcon imageIcon = new ImageIcon(url);
      background = new JLabel(imageIcon, JLabel.CENTER);
      homePanel.setBackground(Color.WHITE);
      background.setBounds(background.getLocation().x, 0, 800, 700);
      homePanel.add(background);
      frame.add(homePanel);
      
      // creating Title Label
      title = new JPanel();
      title.setSize(800, 700);
      titleLabel = new JLabel("PLAN X", JLabel.CENTER);
      title.setLocation(titleLabel.getLocation().x, 100);
      titleLabel.setFont(registerFont("Suggested3D.TTF", 100f));
      titleLabel.setForeground(Color.RED);
      title.setOpaque(false);
      title.add(titleLabel);
      background.add(title);      
      
      // creating Start Button
      createStartButton();
      // makes window visible
      frame.setVisible(true);
          
   }
   // makes start button
   public void createStartButton() throws IOException {
      start = new JPanel();
      start.setLayout(null);
      start.setSize(800, 700);
      Icon icon = new ImageIcon("start-button.png");
      startButton = new JButton();
      startButton.setFont(registerFont("BebasNeue-Regular.ttf", 35f));
      startButton.setBorderPainted(false);
      start.setOpaque(false);
      startButton.setIcon(icon);
      startButton.setPreferredSize(new Dimension(170, 85));
      startButton.setHorizontalAlignment(SwingConstants.CENTER);
      startButton.setBounds(300, 525, 200, 100);
      start.add(startButton);
      background.add(start);
      startButton.addActionListener(startButtonPressed());
         
   }
   
   public ActionListener startButtonPressed() throws IOException {
      ActionListener temp = 
         new ActionListener() {
         
            @Override
            public void actionPerformed(ActionEvent e) {
               try {
                  background.setVisible(false);
                  menu = new JPanel();
                  menu.setLayout(new BoxLayout (menu, BoxLayout.Y_AXIS));   
                  menu.setBounds(menu.getLocation().x+50, 50, 700, 100);
                  menu.setBackground(Color.WHITE);
                  startButton.setEnabled(false);
                  createDifficultySlider(); 
                  createWorkoutDropDown();
                  
                  frame.add(menu);
                  frame.setVisible(true);
               
               } catch (IOException r) {
                  System.out.print("your mom");
               }
            }
         
         };
      return temp;
   
   }
   
   public void createWorkoutDropDown() throws IOException {
      dropDownPanel = new JPanel();
      dropDownPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
      dropDownPanel.setBackground(Color.WHITE);
      String[] choices = {"Abs", "Cardio", "Full Body", "Upper Body", "Stretches", "Lower Body"};
      exerciseChoice = new JComboBox(choices);
      exerciseChoice.setFont(new Font("Verdana", Font.PLAIN, 15));
      exerciseChoiceLabel = new JLabel("Workout Options");
      exerciseChoiceLabel.setFont(new Font("Verdana", Font.PLAIN, 20));
      dropDownPanel.add(exerciseChoiceLabel);
      dropDownPanel.add(exerciseChoice);
      menu.add(dropDownPanel);
      
      
   }
   
   public void createDifficultySlider() throws IOException {
      difficultyPanel = new JPanel();
      difficultyPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
      difficultyPanel.setBackground(Color.WHITE);
      difficulty = new JSlider(JSlider.HORIZONTAL, 1, 10, 5);
      difficulty.setPreferredSize(new Dimension(difficulty.getPreferredSize().width + 60, difficulty.getPreferredSize().height + 10));
      difficultyLabel = new JLabel("Difficulty Level (Easy 1- Hard 10)");  
      difficultyLabel.setFont(new Font("Verdana", Font.PLAIN, 20));
      difficulty.setFont(new Font("Verdana", Font.PLAIN, 10)); 
      difficulty.setMajorTickSpacing(1);
      difficulty.setPaintLabels(true);
      difficulty.setPaintTicks(true);
      difficulty.setSnapToTicks(true);
      difficultyPanel.add(difficultyLabel, BorderLayout.PAGE_START);
      difficultyPanel.add(difficulty, BorderLayout.LINE_START);
      menu.add(difficultyPanel); 
   
   }
   
   public void createGenerateButton() throws IOException {
      generatePanel = new JPanel();
      generatePanel.setBackground(Color.WHITE);
      generatePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
      generateButton = new JButton("Generate");
      generateButton.setFont(new Font("Verdana", Font.PLAIN, 20));
      generateButton.setBounds(0, 0, 100, 100);
      
      generatePanel.add(generateButton);
      menu.add(generatePanel);
      
      
      
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
