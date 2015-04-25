/****************************************************************************
  * NimGameGUI.java
  * Authors: Lilian Ma (L02) & Sunnia Ye(L01) 
  * May 3, 2014
  * 
  * This program creates the main interface of the whole program. It has set
  * minimum dimensions such that all of the information can be seen at all
  * times.
  ***************************************************************************/

import javax.swing.*;
import java.awt.Dimension;
import java.awt.CardLayout;
public class NimGameGUI {
  
  
  public static void main (String [] args)  {
    JFrame frame = new JFrame("Nim Game!");
    frame.setPreferredSize(new Dimension(900, 400));
    frame.setMinimumSize(new Dimension(900, 400));
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    JPanel cards = new JPanel(new CardLayout());

    
    CoinStack cs = new CoinStack();
    NimGame game = new NimGame(cs, new PlayerQueue());
    
    HomePanel home = new HomePanel(cards);
    InstructionsPanel instructions = new InstructionsPanel(cards);
    LevelPanel level = new LevelPanel(cards, game);
    GamePanel mainGame = new GamePanel(cards, game);
    WinResultsPanel win = new WinResultsPanel(cards);
    LoseResultsPanel lose = new LoseResultsPanel(cards);
    
    cards.add(home, "Home");
    cards.add(instructions, "Instructions");
    cards.add(level, "Level");
    cards.add(new GamePanel(cards, game), "MainGame");
    cards.add(win, "Win");
    cards.add(lose, "Lose");
    
   
    frame.getContentPane().add(cards);
    frame.pack();
    frame.setVisible(true);
    
  }
}