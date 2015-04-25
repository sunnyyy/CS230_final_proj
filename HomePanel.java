/****************************************************************************
  * HomePanel.java
  * Authors: Lilian Ma (L02) Sunnia Ye (L02)
  * Date: May 3, 2014
  * 
  * The program creates the homepage for which the user can choose 
  ***************************************************************************/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.CardLayout;

public class HomePanel extends JPanel {
  
  private JButton startButton, instructionsButton;
  private JLabel welcomeLabel, gifLabel, instructionsLabel1, instructionsLabel2;
  private JPanel buttonsPanel, mainPanel, switcher;
  
  
  public HomePanel(JPanel cards) {
    //Lilian: creates and adds a label with instructions
    welcomeLabel = new JLabel("Welcome to the Nim Game! ");
   welcomeLabel.setFont(new Font("Broadway", Font.PLAIN, 58));
    welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
    welcomeLabel.setOpaque(true);
    welcomeLabel.setBackground(new Color(204, 204, 204));
    
     instructionsLabel1 = new JLabel("Please press start to start "
                                + "playing.");
      instructionsLabel1.setAlignmentX(Component.CENTER_ALIGNMENT);
         instructionsLabel1.setFont(new Font("Garamond", Font.PLAIN, 18));
     instructionsLabel2 = new JLabel("Or press Instructions if you want to know "
                                       + "how to play!");
      instructionsLabel2.setAlignmentX(Component.CENTER_ALIGNMENT);
         instructionsLabel2.setFont(new Font("Garamond", Font.PLAIN, 18));
        
    //Lilian: creates the JButtons
    startButton = new JButton("Start");
    instructionsButton = new JButton("Instructions");
    
    //Lilian: creates the JPanel that allows the user to advance from one frame to the next 
    switcher = cards;
    
    //Lilian: creates the GIF welcome image
    ImageIcon welcome = new ImageIcon("welcome01.gif");
    gifLabel = new JLabel(welcome, JLabel.CENTER);
        gifLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
    
    //Lilian: assembles all the components together in an orderly manner
    buttonsPanel = new JPanel();
    buttonsPanel.add(startButton);
    buttonsPanel.add(instructionsButton);
    
    mainPanel = new JPanel();
    BoxLayout layout = new BoxLayout(mainPanel, BoxLayout.Y_AXIS);
    mainPanel.setLayout(layout);
    mainPanel.add(welcomeLabel);
    mainPanel.add(instructionsLabel1);
     mainPanel.add(instructionsLabel2);
    mainPanel.add(buttonsPanel);
    mainPanel.add(gifLabel);
    
    //Lilian: adds everything so that they can be seen
    add(mainPanel);
    
    ButtonListener listener = new ButtonListener();  
    instructionsButton.addActionListener(listener);
    startButton.addActionListener(listener);
  }
  
  private class ButtonListener implements ActionListener {
    
    public void actionPerformed (ActionEvent event) {
      Object source = event.getSource();
      //Lilian: if the user has clicked on the Instructions button, 
      //we advance to the Instructions menu pane
      if (source == instructionsButton) {
        CardLayout cardLayout = (CardLayout) switcher.getLayout();
        cardLayout.show(switcher, "Instructions");
      }     
      //Lilian: if the user has clicked on the Start button, 
      //we advance to the LevelPanel where the user can choose what
      //level they want to play at and input their name
      if (source == startButton) {
        CardLayout cardLayout = (CardLayout) switcher.getLayout();
        cardLayout.show(switcher, "Level");
      }     
    }
  }
  
}