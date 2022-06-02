import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import javax.swing.*;

public class Window extends JPanel {
   JFrame frame;
   JPanel homePanel;
   JLabel background;
   JPanel title;
   JLabel titleLabel;
   JPanel start;
   JButton startButton;
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
   JPanel gridBagPanel;
   JPanel circuitPanel;
   JLabel circuitLabel;
   JLabel circuitList;
   PlanX workout; // THE WORKOUT 
   JButton startWorkoutButton;
   GridBagConstraints b;
   JLabel circuitDetails;
   JPanel LoadingPanel;
   GridBagConstraints h;
   JLabel background2;
   Component video;
   JPanel workoutPanel;

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
   
      // setting up Grid Bag Layout
      gridBagPanel = new JPanel();
      gridBagPanel.setLayout(new GridBagLayout());
      GridBagConstraints g = new GridBagConstraints();
      gridBagPanel.setBackground(Color.WHITE);
      g.gridx = 0;
      g.gridy = 0;
   
      // creates Option Label at top of screen
      optionLabel = new JLabel("Customize your Workout");
      optionLabel.setFont(new Font("Verdana", Font.PLAIN, 30));
      gridBagPanel.add(optionLabel, g);
      g.gridy = 1;
      createDifficultySlider(); 
      gridBagPanel.add(difficultyPanel, g);
      createWorkoutDropDown();
      g.gridy = 2;
      gridBagPanel.add(dropDownPanel, g);
      createGenerateButton();
      g.gridy = 3;
      gridBagPanel.add(generatePanel, g);
      main.add(gridBagPanel, "option menu");
      
      // Generate Workout
      circuitPanel = new JPanel();
      circuitPanel.setLayout(new GridBagLayout());
      b = new GridBagConstraints();
      b.gridx = 0;
      b.gridy = 0;
      circuitPanel.setBackground(Color.WHITE);
      circuitLabel = new JLabel(exerciseChoice.getSelectedItem().toString() + " Circuit");
      circuitLabel.setFont(new Font("Verdana", Font.PLAIN, 20));
      circuitPanel.add(circuitLabel, b);
      b.gridy = 1;
      
      // Loading Window
      LoadingPanel = new JPanel();
      LoadingPanel.setLayout(new GridBagLayout());
      LoadingPanel.setBackground(Color.WHITE);
      h = new GridBagConstraints();
      h.gridx = 0;
      h.gridy = 0;
      
      // adds loading gif
      URL mediaURL = Window.class.getResource("loading.gif");
      ImageIcon imageIcon2 = new ImageIcon(mediaURL);
      background2 = new JLabel(imageIcon2, JLabel.CENTER);
      background2.setBounds(background.getLocation().x, 0, 800, 700);
      LoadingPanel.add(background2, h);
      main.add(LoadingPanel, "loading"); // adds LoadingPanel to the CardLayout
      
      // workout panel
      workoutPanel = new JPanel();
      
      main.add(workoutPanel, "workout");
      
      // makes window visible
      frame.add(main);
      frame.setVisible(true);
          
   }
   
   public void createStartWorkoutButton() {
      startWorkoutButton = new JButton("Start");
      startWorkoutButton.setPreferredSize(new Dimension(170, 85));
      startWorkoutButton.setFont(new Font("Verdana", Font.PLAIN, 20));
      startWorkoutButton.addActionListener(startWorkout());
      b.gridy = 4;
      circuitPanel.add(startWorkoutButton, b);
   }
   
   public ActionListener startWorkout() {
      ActionListener timerRun = 
         new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               c.show(main, "workout");
            }
         };
      ActionListener temp = 
         new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               c.show(main, "loading");
               int delay = 4000;
               new Timer(delay, timerRun).start();
            
            }
         
         };
      return temp;
   
   
   }
 
   
   public PlanX generateWorkout() throws IOException { // {"Abs", "Cardio", "Full Body", "Upper Body", "Stretches", "Lower Body"}
      PlanX temp;
      switch(exerciseChoice.getSelectedItem().toString()) {
         case "Abs":
            temp = new Abs(difficulty.getValue());
            break;
         case "Cardio":
            temp = new Abs(difficulty.getValue());
            break;
         default:
            temp = new Abs(difficulty.getValue());
            break;
      }
      System.out.print(temp);
      return temp;
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
      startButton.setPreferredSize(new Dimension(150, 80));
      startButton.setBackground(Color.WHITE);
      startButton.setHorizontalAlignment(SwingConstants.CENTER);
      startButton.setBounds(300, 525, 200, 100);
      start.add(startButton);
      background.add(start);
      startButton.addActionListener(startButtonPressed());
         
   }

   public ActionListener generatePressed() throws IOException {
      ActionListener temp = 
         new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               try {
                  generateButton.setEnabled(false);
                  workout = generateWorkout();
                  circuitDetails = new JLabel("<html>Sets: " + workout.getSets() + "<br/>Difficulty: " + workout.getDiff() + "<br/><br/><html>");
                  circuitDetails.setFont(new Font("Verdana", Font.PLAIN, 15));
                  circuitList = new JLabel(workout.toStringWithHTML() + "<html><br/><html>");
                  circuitList.setFont(new Font("Verdana", Font.PLAIN, 15));
                  circuitPanel.add(circuitDetails, b);
                  b.gridy++;
                  circuitPanel.add(circuitList, b);
                  main.add(circuitPanel, "circuit");
                  // Start Button
                  b.gridy = 2;
                  createStartWorkoutButton();
                  c.show(main, "circuit");
               } catch (IOException o) {}
            }
         
         };
      return temp;
   
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
   
   public void createDifficultySlider() throws IOException {
      difficultyPanel = new JPanel();
      difficultyPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
      difficultyPanel.setBackground(Color.WHITE);
      difficulty = new JSlider(JSlider.HORIZONTAL, 1, 10, 5);
      difficulty.setBackground(Color.WHITE);
      difficulty.setPreferredSize(new Dimension(difficulty.getPreferredSize().width + 150, difficulty.getPreferredSize().height + 25));
      difficultyLabel = new JLabel("Difficulty Level (Easy 1- Hard 10)");  
      difficultyLabel.setFont(new Font("Verdana", Font.PLAIN, 20));
      difficulty.setFont(new Font("Verdana", Font.PLAIN, 10)); 
      difficulty.setMajorTickSpacing(1);
      difficulty.setPaintLabels(true);
      difficulty.setPaintTicks(true);
      difficulty.setSnapToTicks(true);
      difficultyPanel.add(difficultyLabel, BorderLayout.PAGE_START);
      difficultyPanel.add(difficulty, BorderLayout.LINE_START);
   
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
      generateButton.addActionListener(generatePressed());
   
      generatePanel.add(generateButton);      
      
      
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
