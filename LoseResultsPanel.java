/****************************************************************************
  * LoseResultsPanel.java
  * Authors: Lilian Ma (L02) Sunnia Ye (L02)
  * Date: May 3, 2014
  * 
  * The program displays the 
  ***************************************************************************/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoseResultsPanel extends JPanel {
  
  private JButton yesButton, noButton;
  private JLabel resultsLabel, playAgainLabel, smileyFaceLabel;
  private JPanel buttonsPanel, mainPanel, switcher;
  
  public LoseResultsPanel(JPanel cards) {
    //creates and adds a label with instructions
    resultsLabel = new JLabel("You Lose :(");
    resultsLabel.setFont(new Font("Helvetica", Font.BOLD, 48));
    playAgainLabel = new JLabel("Play again?");
    
    yesButton = new JButton("Yes");
    noButton = new JButton("No");
    
    ImageIcon smiley = new ImageIcon("KijGeKziq.gif", "Gold Coin");
    smileyFaceLabel = new JLabel(smiley);
    
    switcher = cards;
    
    
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