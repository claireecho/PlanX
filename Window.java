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
   GridBagConstraints u;
   JLabel circuitLabel2;
   JLabel circuitList2;
   JLabel circuitDetails2;
   JLabel timerLabel;
   JLabel exerciseLabel;
   JButton continueButton;
   JLabel space;
   JLabel space2;
   Timer loadingTimer;
   int delay;
   Timer delayTimer;
   JPanel test;
   JLabel currentSetLabel;
   int currentSet;
   JPanel completePanel;
   String yay;

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
      titleLabel.setFont(registerFont("Suggested3D.ttf", 100f));
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
      optionLabel.setFont(registerFont("SansSerifBldFLF.otf", 30f));
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
      circuitLabel.setFont(registerFont("SansSerifBldFLF.otf", 20f));
      circuitDetails = new JLabel();
      circuitList = new JLabel();
      circuitPanel.add(circuitLabel, b);
      b.gridy++;
      circuitPanel.add(circuitDetails, b);
      b.gridy++;
      circuitPanel.add(circuitList, b);
      main.add(circuitPanel, "circuit");
      // Start Button
      b.gridy++;
      createStartWorkoutButton();
      
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
      workoutPanel.setBackground(Color.WHITE);
      u = new GridBagConstraints();
      workoutPanel.setLayout(new GridBagLayout());
      circuitLabel2 = new JLabel();
      circuitDetails2 = new JLabel();
      circuitList2 = new JLabel();
      
      // creates timer
      test = new JPanel();
      timerLabel = new JLabel("0:30");
      timerLabel.setFont(new Font("Verdana", Font.PLAIN, 30));
      test.setBackground(Color.RED);
      u.gridy = 5;
      u.gridx = 4;
      test.add(timerLabel);
      workoutPanel.add(test, u);
      space2 = new JLabel("\n");
      space2.setFont(registerFont("SansSerifFLF.otf", 20f));
      u.gridy++;
      workoutPanel.add(space2, u);
      exerciseLabel = new JLabel("UR MOM");
      u.gridy++;
      workoutPanel.add(exerciseLabel, u);
      u.gridy++;
      exerciseLabel.setFont(registerFont("SansSerifFLF.otf", 30f));
      currentSetLabel = new JLabel();
      currentSetLabel.setFont(registerFont("SansSerifFLF.otf", 20f));
      workoutPanel.add(currentSetLabel, u);
      continueButton = new JButton("Continue");
      continueButton.setPreferredSize(new Dimension(120, 50));
      continueButton.setFont(registerFont("SansSerifFLF.otf", 20f));
      space = new JLabel("\n");
      space.setFont(registerFont("SansSerifFLF.otf", 20f));
      u.gridy++;
      workoutPanel.add(space, u);
      u.gridy++;
      workoutPanel.add(continueButton, u);
      // adds workoutPanel to main
      main.add(workoutPanel, "workout");
      
      // completePanel implements
      yay = "yay" + ((int)(Math.random() * 11)) + ".gif";
      completePanel = new JPanel();
      completePanel.setBackground(Color.WHITE);
      completePanel.setLayout(new GridBagLayout());
      GridBagConstraints gh = new GridBagConstraints();
      gh.gridy = 0;
      gh.gridx = 0;
      URL url3 = Window.class.getResource(yay);
      ImageIcon imageIcon3 = new ImageIcon(url3);
      JLabel background3 = new JLabel(imageIcon3, JLabel.CENTER);
      completePanel.setBackground(Color.WHITE);
      completePanel.add(background3, gh);
      gh.gridy++;
      JLabel space3 = new JLabel("\n");
      space3.setFont(registerFont("SansSerifFLF.otf", 20f));
      completePanel.add(space3, gh);
      gh.gridy++;
      JLabel congrats = new JLabel("YOU FINISHED YOUR WORKOUT!!");
      congrats.setFont(registerFont("SansSerifFLF.otf", 30f));
      gh.gridy++;
      completePanel.add(congrats, gh);
      
/* restart button
      JButton restart = new JButton("Restart");
      restart.setFont(new Font("Verdana", Font.PLAIN, 20));
      restart.setPreferredSize(new Dimension(120, 50));
      restart.addActionListener(
         new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               c.show(main, "home");
               startButton.setEnabled(true);
               generateButton.setEnabled(true);
            }
         }
         );
      completePanel.add(restart, gh);
*/

      main.add(completePanel, "complete");     
      // makes window visible
      frame.add(main);
      frame.setVisible(true);
  

   }
  
   
   public ActionListener continuePressed() {
      ActionListener timerRun2 = 
         new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               if (delay == 0) {
                  delayTimer.stop();
                  workout.start(workout.getQueue().peek(), timerLabel, test, continueButton, workout, currentSetLabel, main, c, currentSet, exerciseLabel); // String x, JLabel label, JPanel j, JButton b, PlanX p, JLabel s, JPanel m, CardLayout c, int kl
               }
               delay--;
            }
         };
      ActionListener temp = 
         new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               continueButton.setEnabled(false);
               delay = 2;
               delayTimer = new Timer(500, timerRun2);
               delayTimer.start();
            }
         
         };
      return temp;
   
   
   }
   
   public String formatTime(int seconds) {
      
      int s = seconds % 60;
      int m = seconds / 60;
      return (m < 10 ? "0" : "") + m + ":" + (s < 10 ? "0" : "") + s;
      
   }

   
   public void createStartWorkoutButton() throws IOException {
      startWorkoutButton = new JButton("Start");
      startWorkoutButton.setPreferredSize(new Dimension(120, 50));
      startWorkoutButton.setFont(registerFont("SansSerifFLF.otf", 20f));
      startWorkoutButton.addActionListener(startWorkout());
      b.gridy = 4;
      circuitPanel.add(startWorkoutButton, b);
   }
   
   public ActionListener startWorkout() throws IOException {
      ActionListener timerRun = 
         new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               if (delay == 4) {
                  try {
                     circuitLabel2.setText(exerciseChoice.getSelectedItem().toString() + " Circuit");
                     circuitLabel2.setFont(registerFont("SansSerifBldFLF.otf", 20f));
                     circuitDetails2.setText("<html>Sets: " + workout.getSets() + "<br/>Difficulty: " + workout.getDiff() + "<br/><br/><html>");
                     circuitDetails2.setFont(registerFont("SansSerifFLF.otf", 15f));
                     circuitList2.setText(workout.toStringWithHTML() + "<html><br/><html>");
                     circuitList2.setFont(registerFont("SansSerifFLF.otf", 15f));
                     currentSet = 1;
                     currentSetLabel.setText("Current Set: " + currentSet);
                     u.gridy = 0;
                     u.gridx = 4;
                     workoutPanel.add(circuitLabel2, u);
                     u.gridy = 1;
                     workoutPanel.add(circuitDetails2, u);
                     u.gridy = 2;
                     workoutPanel.add(circuitList2, u);
                     exerciseLabel.setText(workout.getName());
                     
                     if (workout.getQueue().peek().substring(0, 1).equals("S")) {
                        timerLabel.setText(formatTime((int)(workout.getSeconds())));
                     } else {
                        timerLabel.setText("Finish Required Reps");
                     }
                     continueButton.addActionListener(continuePressed());
                   } catch (IOException f) {}
                } else if (delay == 0) {
                   c.show(main, "workout");
                   loadingTimer.stop();
                }
                delay--;
            }
         };
      ActionListener temp = 
         new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               c.show(main, "loading");
               int urmom = 1000;
               delay = 4;
               loadingTimer = new Timer(urmom, timerRun);
               loadingTimer.start();
               
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
            temp = new Cardio(difficulty.getValue());
            break;
         case "Upper Body":
            temp = new upperB(difficulty.getValue());
            break;
         case "Stretches":
            temp = new Stretches(difficulty.getValue());
            break;
         case "Lower Body":
            temp = new lowerB(difficulty.getValue());
            break;
         case "Full Body":
            temp = new FullBody(difficulty.getValue());
            break;
         default:
            temp = new Abs(difficulty.getValue());
            break;
      }
      circuitLabel.setText(exerciseChoice.getSelectedItem().toString() + " Circuit");
      return temp;
   }
   
   // makes start button
   public void createStartButton() throws IOException {
      start = new JPanel();
      start.setLayout(null);
      start.setSize(800, 700);
      Icon icon = new ImageIcon("start-button.png");
      startButton = new JButton();
      startButton.setFont(registerFont("SansSerifFLF.otf", 35f));
      startButton.setBorderPainted(false);
      start.setOpaque(false);
      startButton.setIcon(icon);
      startButton.setPreferredSize(new Dimension(150, 80));
      startButton.setBackground(Color.WHITE);
      startButton.setHorizontalAlignment(SwingConstants.CENTER);
      startButton.setBounds(350, 525, 100, 50);
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
                  circuitDetails.setText("<html>Sets: " + workout.getSets() + "<br/>Difficulty: " + workout.getDiff() + "<br/><br/><html>");
                  circuitDetails.setFont(registerFont("SansSerifFLF.otf", 15f));
                  circuitList.setText(workout.toStringWithHTML() + "<html><br/><html>");
                  circuitList.setFont(registerFont("SansSerifFLF.otf", 15f));
                  
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
      difficultyLabel.setFont(registerFont("SansSerifFLF.otf", 20f));
      difficulty.setFont(registerFont("SansSerifFLF.otf", 10f)); 
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
      exerciseChoice.setFont(registerFont("SansSerifFLF.otf", 15f));
      exerciseChoiceLabel = new JLabel("Workout Options");
      exerciseChoiceLabel.setFont(registerFont("SansSerifFLF.otf", 20f));
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
      generateButton.setPreferredSize(new Dimension(120, 50));
      generateButton.setHorizontalAlignment(SwingConstants.CENTER);
      generateButton.setFont(registerFont("SansSerifFLF.otf", 20f));
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
