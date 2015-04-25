/****************************************************************************
  * InstructionsPanel.java
  * Authors: Lilian Ma (L02) & Sunnia Ye(L01) 
  * May 3, 2014
  * 
  * The program creates an about panel for the about tab with instructions 
  * for the user on how to use the program.
  ***************************************************************************/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class InstructionsPanel extends JPanel {
  
  private JLabel label1;
  // private JTextArea description;
  private JButton backButton; 
  private JPanel mainPanel, switcher;
  private JTextArea description;
  
  public InstructionsPanel(JPanel cards) {
    //creates and adds a label with instructions
    label1 = new JLabel("Instructions");
    label1.setFont(new Font("Broadway", Font.PLAIN, 58));
    label1.setAlignmentX(Component.CENTER_ALIGNMENT);
    label1.setBackground(new Color(204, 204, 204));
    
    //Lilian: allows the user to switch between the different panels when 
    //clicking on the back button
    switcher = cards;
    
    String labelText = "Nim is a mathematical game, where two players try to take items from a pile, "
      +"with the goal of being the person to take the last item."
      + "\n\nFor our version of the game, you play with the following rules: "
      + "There is a stack of 49 coins -- 48 copper and 1 gold, with the gold at the bottom "
      +"of the stack. In order to win, you must get the gold coin at the bottom. However, you "
      +"can only take coins off the top of the coin pile - i.e. players will need to "
      +"remove all the copper coins before getting to the gold coin." 
      + "\n\nEach player is allowed to take 1 to 4 coins at a time and you will be, "
      +"playing against the computer. We have programmed the game such "
      +"that the human player (i.e. you) will always go first."
      +" \n\nGood luck!";
    
    description = new JTextArea(labelText);
    
    description.setLineWrap(true);
    description.setWrapStyleWord(true);
    description.setEditable(false);
    description.setSize(700,700);
    description.setFont(new Font("Garamond", Font.PLAIN, 24));
    description.setBackground(new Color(204, 204, 154));
    
    backButton = new JButton("Back");
    
    mainPanel = new JPanel();
    mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
    mainPanel.add(label1);
    mainPanel.add(description);
    mainPanel.add(backButton);
    mainPanel.setBackground(new Color(153, 153, 103));
    
    ButtonListener listener = new ButtonListener();
    backButton.addActionListener(listener);
    
    add(mainPanel);
  }
  
  private class ButtonListener implements ActionListener {
    
    public void actionPerformed (ActionEvent event) {
      Object source = event.getSource();
      //Lilian: if the user has clicked on the back button, 
      //we go back to the main homepage of the game
      if (source == backButton) {
        CardLayout cardLayout = (CardLayout) switcher.getLayout();
        cardLayout.show(switcher, "Home");
      }     
      
    }
  }
  
  
}