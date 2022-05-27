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
   JPanel homePanel;
   JLabel background;
   JPanel title;
   JLabel titleLabel;
   JPanel start;
   JButton startButton;
   JPanel menu;
   JPanel mask;
   JSlider difficulty;
   JLabel difficultyLabel;
   JComboBox exerciseChoice;
   JPanel dropDownPanel;
   JLabel exerciseChoiceLabel;
   JPanel difficultyPanel;
   JPanel generatePanel;
   JButton generateButton;
   CardLayout c;
   JPanel main;
   JLabel optionLabel;
   
   public Window() throws IOException {
      // make window
      frame = new JFrame("PlanX");
      frame.setSize(800, 700);
      frame.setResizable(false);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setIconImage(new ImageIcon("icon.png").getImage());
      
      // create CardLayout Panel
      c = new CardLayout();
      main = new JPanel();
      main.setLayout(c);
      
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
      
      // adds the home screen to the main panel
      main.add(homePanel, "home");     
      
      // creating Start Button
      createStartButton();
      
      // shows the home screen
      c.show(main, "home");
      
      // creates option menu
      menu = new JPanel();
      mask = new JPanel();
      mask.setBackground(Color.WHITE);
      mask.setLayout(new FlowLayout(FlowLayout.CENTER));
      menu.setLayout(new BoxLayout (menu, BoxLayout.Y_AXIS));   
      menu.setBackground(Color.WHITE);
      mask.add(menu);
      
      // creates Option Label at top of screen
      optionLabel = new JLabel("Customize your Workout");
      optionLabel.setFont(new Font("Verdana", Font.PLAIN, 30));
      mask.add(optionLabel);
      createDifficultySlider(); 
      createWorkoutDropDown();
      mask.add(menu);
      createGenerateButton();
      main.add(mask, "option menu");
      
      // makes window visible
      frame.add(main);
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
   
   public ActionListener startButtonPressed() {
      ActionListener temp = 
         new ActionListener() {
         
            @Override
            public void actionPerformed(ActionEvent e) {
               startButton.setEnabled(false);
               c.show(main, "option menu");
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
      difficulty.setPreferredSize(new Dimension(difficulty.getPreferredSize().width + 150, difficulty.getPreferredSize().height + 10));
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
       generatePanel.setLayout(null);
       generatePanel.setBackground(Color.WHITE);
       generatePanel.setSize(700, 50);
       generatePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
       generateButton = new JButton("Generate");
       generateButton.setPreferredSize(new Dimension(170, 85));
       generateButton.setHorizontalAlignment(SwingConstants.CENTER);
       generateButton.setFont(new Font("Verdana", Font.PLAIN, 20));
      
//        generatePanel = new JPanel();
//        generatePanel.setLayout(null);
//        generatePanel.setSize(800, 700);
//        Icon icon = new ImageIcon("start-button.png");
//        generateButton = new JButton();
//        generateButton.setFont(registerFont("BebasNeue-Regular.ttf", 35f));
//        startButton.setBorderPainted(false);
//        generatePanel.setOpaque(false);
//        generateButton.setIcon(icon);
//        generateButton.setPreferredSize(new Dimension(170, 85));
//        generateButton.setHorizontalAlignment(SwingConstants.CENTER);
//        generateButton.setBounds(300, 525, 200, 100);
//        generatePanel.add(generateButton);
//        background.add(generatePanel);
//        generateButton.addActionListener(startButtonPressed());

      
      generatePanel.add(generateButton);
      mask.add(generatePanel);
      
      
      
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
