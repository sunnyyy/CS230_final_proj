/****************************************************************************
  * ResultsPanel.java
  * Authors: Lilian Ma (L02) Sunnia Ye (L02)
  * Date: May 3, 2014
  * 
  * The program displays the 
  ***************************************************************************/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class WinResultsPanel extends JPanel {
  //Lilian: instance variables
  private JButton yesButton, noButton;
  private JLabel resultsLabel, playAgainLabel, smileyFaceLabel;
  private JPanel buttonsPanel, mainPanel, switcher;
  
  public WinResultsPanel(JPanel cards) {
    //Lilian: creates and adds a label with instructions
    resultsLabel = new JLabel("You Win!");
    resultsLabel.setFont(new Font("Helvetica", Font.BOLD, 48));
    playAgainLabel = new JLabel("Play again?");
    
    //Lilian: creates the buttons to play again or not
    yesButton = new JButton("Yes");
    noButton = new JButton("No");
    
    //Lilian: creates the happy GIF image
    ImageIcon smiley = new ImageIcon("animated-smiley-face-winking.gif");
    smileyFaceLabel = new JLabel(smiley);
    
    //Lilian: allows the user to either exit the game or go back to the 
    //LevelPanel to play again
    switcher = cards;
    
    //Lilian: assembles all the components in an orderly manner
    buttonsPanel = new JPanel();
    buttonsPanel.add(playAgainLabel);
    buttonsPanel.add(yesButton);
    buttonsPanel.add(noButton);
    
    mainPanel = new JPanel();
    BoxLayout layout = new BoxLayout(mainPanel, BoxLayout.Y_AXIS);
    mainPanel.setLayout(layout);
    mainPanel.add(resultsLabel);
    mainPanel.add(smileyFaceLabel);
    mainPanel.add(buttonsPanel);
    
    ButtonListener listener = new ButtonListener();
    yesButton.addActionListener(listener);
    noButton.addActionListener(listener);
    
    add(mainPanel);
  }
  
  private class ButtonListener implements ActionListener {
    
    public void actionPerformed (ActionEvent event) {
      Object source = event.getSource();
      //Lilian: if the user has clicked the yes buton, brings them
      //back to the home menu
      if (source == yesButton) {
        CardLayout cardLayout = (CardLayout) switcher.getLayout();
        cardLayout.show(switcher, "Home");
      }     
      
      //Lilian: if the user no longer wishes to play the game and clicks no,
      //we confirm this with the user using a pop up window and then
      //we exit the application
      if (source == noButton) {
        int again;
        again = JOptionPane.showConfirmDialog(null,"Are you sure you want exit the game?");
        if (again==JOptionPane.YES_OPTION) {
          System.exit(0);
        }
        
      }
      
    }
  }
  
  
  
}