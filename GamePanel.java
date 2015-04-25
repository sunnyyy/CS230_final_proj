/****************************************************************************
  * GamePanel.java
  * Authors: Lilian Ma (L02) Sunnia Ye (L02)
  * Date: May 3, 2014
  * 
  * Lilian: created the basic interface with all the components
  ***************************************************************************/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.ImageIcon;

public class GamePanel extends JPanel {
  
  //Lilian: instance variables
  private JButton backButton, submitButton;
  private JLabel messageLabel, goldLabel, goldPicLabel, copperLabel, 
    copperPicLabel, totalCoinsLabel, computerResultLabel, humanResultLabel;
  private JRadioButton oneCoin, twoCoin, threeCoin, fourCoin; 
  private ButtonGroup group;
  private JPanel selectCoinPanel, goldCoinPanel, copperCoinPanel, 
    coinsPanel, messagePanel, mainPanel, rightPanel, switcher;
  private CoinStack stack;
  private NimGame game;
  
  public GamePanel(JPanel cards, NimGame current) {
    game = current;
    
    //Lilian: creates and adds a label with instructions
    messageLabel = new JLabel("Hi XYZ! How many coins would you like to take?");
    copperLabel = new JLabel("  x  " + Integer.toString(game.numCoins()-1));
    goldLabel = new JLabel("  x  1");
    totalCoinsLabel = new JLabel("Total: " + Integer.toString(game.numCoins()));
    computerResultLabel = new JLabel("");
    humanResultLabel = new JLabel("");
    
    backButton = new JButton("Back");
    submitButton = new JButton("Submit");
    
    oneCoin = new JRadioButton("One");
    twoCoin = new JRadioButton("Two");
    threeCoin = new JRadioButton("Three");
    fourCoin = new JRadioButton("Four");
    
    group = new ButtonGroup();
    group.add(oneCoin);
    group.add(twoCoin);
    group.add(threeCoin);
    group.add(fourCoin);
    
    switcher = cards;
    
    ImageIcon goldCoin = new ImageIcon("0coin-gold.jpg", "Gold Coin");
    goldPicLabel = new JLabel(goldCoin);
    ImageIcon copperCoin = new ImageIcon("0coin-copper.jpg", "Copper Coin");
    copperPicLabel = new JLabel(copperCoin);
    
    selectCoinPanel = new JPanel();
    GridLayout layout1 = new GridLayout(4,1);
    selectCoinPanel.setLayout(layout1);
    selectCoinPanel.add(oneCoin);
    selectCoinPanel.add(twoCoin);
    selectCoinPanel.add(threeCoin);
    selectCoinPanel.add(fourCoin);
    
    coinsPanel = new JPanel();
    GridLayout layout2 = new GridLayout(2,2);
    coinsPanel.setLayout(layout2);
    coinsPanel.add(copperPicLabel);
    coinsPanel.add(copperLabel);
    coinsPanel.add(goldPicLabel);
    coinsPanel.add(goldLabel);
    
    messagePanel = new JPanel();
    GridLayout layout3 = new GridLayout(2,1);
    messagePanel.setLayout(layout3);
    messagePanel.add(humanResultLabel);
    messagePanel.add(computerResultLabel);
    
    rightPanel = new JPanel();
    BoxLayout layout = new BoxLayout(rightPanel, BoxLayout.Y_AXIS);
    rightPanel.setLayout(layout);
    rightPanel.add(totalCoinsLabel);
    rightPanel.add(submitButton);
    rightPanel.add(backButton);
    rightPanel.add(messagePanel);
    
    mainPanel = new JPanel();
    mainPanel.add(selectCoinPanel);
    mainPanel.add(coinsPanel);
    mainPanel.add(rightPanel);
    
    
    
    
    
    ButtonListener listener = new ButtonListener();
    backButton.addActionListener(listener);
    submitButton.addActionListener(listener);
    
    add(mainPanel);
  }
  
  private class ButtonListener implements ActionListener {
    
    public void actionPerformed (ActionEvent event) {
      Object source = event.getSource();
      
      // Lilian: gives the pop up message for the user to confirm that
      // they want to go back to the home menu
      if (source == backButton) {
        int again;
        again = JOptionPane.showConfirmDialog(null,"Are you sure you want to "
                                                +"end the current game and "
                                                +"return to the home menu?");
        if (again==JOptionPane.YES_OPTION) {
          game.newCoinStack(); // sets up for next game
          CardLayout cardLayout = (CardLayout) switcher.getLayout();
          cardLayout.show(switcher, "Home");
        }
      }     
      
      // Sunnia: the selected JRadioButton is linked to an integer
      if (source == submitButton) {
        int numChosen = 0;
        
        if (oneCoin.isSelected()) numChosen = 1;
        if (twoCoin.isSelected()) numChosen = 2;
        if (threeCoin.isSelected()) numChosen = 3;
        if (fourCoin.isSelected()) numChosen = 4;
        
        System.out.println(game.getPlayerQueue());
        System.out.println("After the last play, there are " + game.getCoinStack());
        //System.out.println(numChosen);
        
        if (numChosen == 0) {
          
          // Lilian
          System.out.println("Error...player hasn't made a selection");
          JOptionPane.showMessageDialog(null,"Error: Please select the number of "
                                          +"coins you wish to remove!");
        } else if (numChosen > game.numCoins()) {
          
          // Sunnia
          System.out.println("Error...exceeds coins in pile");
          JOptionPane.showMessageDialog(null, "Error: You are attempting to take "
                                          +"more coins than there are in the pile.");
        } else {
          
          // human plays
          game.oneTurn(numChosen);
          System.out.println("You took " + game.getLast() + " coins.");
          
          // Lilian: updates the JLabels for the number of copper coins left
          // and also total number of coins left and tells the user what
          // they did
          copperLabel.setText("x"+Integer.toString(game.numCoins()-1));
          totalCoinsLabel.setText("Total: " + Integer.toString(game.numCoins()));
          humanResultLabel.setText("You took " + game.getLast() + " coins.");
          
          // Sunnia: if at this point the coin stack is empty, they won
          if (game.numCoins() == 0) {
            System.out.println("You won!");
            game.newCoinStack(); // sets up for next game
            group.clearSelection();// clears the button group selection
            
            // Lilian: resets the number of total copper coins
            copperLabel.setText("x"+Integer.toString(game.numCoins()-1));
            totalCoinsLabel.setText("Total: " + Integer.toString(game.numCoins()));
            computerResultLabel.setText("");
            humanResultLabel.setText("");
            CardLayout cardLayout = (CardLayout) switcher.getLayout();
            cardLayout.show(switcher, "Win");
            
            // Sunnia: if coin stack isn't empty computer plays
          } else {
            game.oneTurn(0);
            System.out.println("Computer took " + game.getLast() + " coins.");
            
            // Lilian: updates the JLabels for the number of copper coins left
            // and also total number of coins left
            copperLabel.setText("x"+Integer.toString(game.numCoins()-1));
            totalCoinsLabel.setText("Total: " + Integer.toString(game.numCoins()));
            computerResultLabel.setText("Computer took " + game.getLast() + " coins.");
            
            if (game.numCoins() == 0) {
              
              // Sunnia: if at this point the coin stack is empty, you lost
              System.out.println("You lost!");
              game.newCoinStack(); // sets up for next game
              group.clearSelection();// clears the button group selection
              
              // Lilian: resets the number of total copper coins
              copperLabel.setText("x"+Integer.toString(game.numCoins()-1));
              totalCoinsLabel.setText("Total: " + Integer.toString(game.numCoins()));
              computerResultLabel.setText("");
              humanResultLabel.setText("");
              
              CardLayout cardLayout = (CardLayout) switcher.getLayout();
              cardLayout.show(switcher, "Lose");
            }
          }
        } // end of "if selected number works"
        
      } // end of "if source is submit button"
    } // end actionPerformed
  } // end button listener class
  
} // end GamePanel