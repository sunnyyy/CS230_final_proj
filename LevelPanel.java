/****************************************************************************
  * LevelPanel.java
  * Authors: Lilian Ma (L02) Sunnia Ye (L02)
  * Date: May 3, 2014
  * 
  * Lilian: The program creates the homepage for which the user can choose 
  * which level to play at. It also asks the user to provide their name to 
  * create a personalized game environment
  * (5/17)Lilian: Fully updated with all the communications working (hopefully!)
  ***************************************************************************/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LevelPanel extends JPanel {
  
  private JButton backButton, submitButton;
  private ButtonGroup levelButtonGroup;
  private JLabel welcomeLabel, nameLabel, levelLabel;
  private JTextField nameText;
  private JRadioButton begiRank, interRank, advRank; 
  private JPanel messagePanel, namePanel, selectLevelPanel, buttonsPanel, mainPanel, switcher;
  private NimGame game;
  
  public LevelPanel(JPanel cards, NimGame current) {
    game = current;
    
    //Lilian: creates and adds a label with instructions
    welcomeLabel = new JLabel("Please provide your name and select the level you would like to play at.");
    nameLabel = new JLabel("Name:");
    levelLabel = new JLabel("Level:");
    
    //Lilian: creates the TextField where the user inputs their name
    nameText = new JTextField(20);
    
    //Lilian: creates the buttons
    backButton = new JButton("Back");
    submitButton = new JButton("Submit");
    
    //Lilian: creates the radio buttons to select the levels
    begiRank = new JRadioButton("Beginner");
    interRank = new JRadioButton("Intermediate");
    advRank = new JRadioButton("Advanced");
    
    //Lilian: instantiates the JPanel that allows to move from one screen to the next
    switcher = cards;
    
    //Lilian: creates the radio button group so that the user can only select one
    //RadioButton at a time
    levelButtonGroup = new ButtonGroup();
    levelButtonGroup.add(begiRank);
    levelButtonGroup.add(interRank);
    levelButtonGroup.add(advRank);
    
    //Lilian: puts all the components together in a orderly manner
    messagePanel = new JPanel();
    messagePanel.add(welcomeLabel);
    
    namePanel = new JPanel();
    namePanel.add(nameLabel);
    namePanel.add(nameText);
    
    selectLevelPanel = new JPanel();
    //selectLevelPanel.setBackground(new Color(93,156,201));
    selectLevelPanel.add(levelLabel);
    selectLevelPanel.add(begiRank);
    selectLevelPanel.add(interRank);
    selectLevelPanel.add(advRank);
    
    buttonsPanel = new JPanel();
    buttonsPanel.add(submitButton);
    buttonsPanel.add(backButton);
    
    mainPanel = new JPanel();
    BoxLayout layout = new BoxLayout(mainPanel, BoxLayout.Y_AXIS);
    mainPanel.setLayout(layout);
    mainPanel.add(messagePanel);
    mainPanel.add(namePanel);
    mainPanel.add(selectLevelPanel);
    mainPanel.add(buttonsPanel);
    
    add(mainPanel);
    
    //Lilian: creates the button listeners
    ButtonListener listener = new ButtonListener();
    backButton.addActionListener(listener);
    submitButton.addActionListener(listener);
  }
  
  private class ButtonListener implements ActionListener {
    
    public void actionPerformed (ActionEvent event) {
      Object source = event.getSource();
      //Lilian: if the back button is clicked, brings the user back 
      //to the main menu
      if (source == backButton) {
        CardLayout cardLayout = (CardLayout) switcher.getLayout();
        cardLayout.show(switcher, "Home");
      }  
      
      //Lilian: if the submit button is clicked, the program takes the 
      //name and level selected and creates a new player queue with the 
      //required level of the computer. Then, this information is used
      //to create a new updated NimGame. The old NimGame will now point
      //towards this updated version.
      if (source == submitButton) {
        
        CoinStack stack = game.getCoinStack();
        // Lilian: creating the new PlayerQueue
        Player human = new Player(nameText.getText(),stack);
//        System.out.println("new human created");
        
        
        // Lilian: creating a game with a computer level of beginner
        if (begiRank.isSelected()) {
          game.newPlayerQueue(human, new ComputerBegPlayer(stack));
//           System.out.println("Beginner computer added");
//          System.out.println(game.getPlayerQueue());
        }
        
        // Lilian: creating a game with a computer level of intermediate
        if (interRank.isSelected()) {
          game.newPlayerQueue(human, new ComputerInterPlayer(stack)); 
//          System.out.println("Intermediate computer created");
//          System.out.println(game.getPlayerQueue());
        }
        
        //Lilian: creating a game with a computer level of advanced
        if (advRank.isSelected()) {
          game.newPlayerQueue(human, new ComputerAdvPlayer(stack));  
//          System.out.println("Advanced computer created");
//          System.out.println(game.getPlayerQueue());
        }
        
        // Lilian: this advances the player to the gamePanel where the game is played
        // when the submit button is clicked
        // also clears the JTextField and the level selected
        levelButtonGroup.clearSelection();
        nameText.setText("");
        
        CardLayout cardLayout = (CardLayout) switcher.getLayout();
        cardLayout.show(switcher, "MainGame");
      }     
      
    }
  }
  
}