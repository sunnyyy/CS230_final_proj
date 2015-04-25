/*******************************************************************
  * NimGame.java 
  * Authors: Lilian Ma (L02) & Sunnia Ye (L01)
  * 
  * Creates a NimGame between a queue of Players, using a CoinStack.
  ********************************************************************/

import java.util.*;
import javafoundations.*;
import javafoundations.exceptions.*;

public class NimGame {
  
  private CoinStack stackOfCoins;
  private PlayerQueue q;
  private int last;
  
  /**********************************************************************
    * Constructor: (Lilian)
    ********************************************************************/
  public NimGame(CoinStack stack, PlayerQueue players){
    stackOfCoins = stack;
    q = players;
  }
  
  /**********************************************************************
    * Returns the number of coins in the pile. (Sunnia)
    ********************************************************************/
  public int numCoins() {
    return stackOfCoins.numCoins();
  }
  
  /**********************************************************************
    * Returns the CoinStack being used in the game.
    * Mainly used to test NimGame in GamePanel class. (Lilian)
    ********************************************************************/
  public CoinStack getCoinStack() {
    return stackOfCoins;
  }
  
  /**********************************************************************
    * Creates a new CoinStack object, to facilitate starting a new round.
    * Mainly used to test NimGame in GamePanel class. (Sunnia)
    ********************************************************************/
  public void newCoinStack() {
    CoinStack cs = new CoinStack();
    stackOfCoins = cs;
  }
  
  /**********************************************************************
    * Returns the PlayerQueue being used in the game.
    * Mainly used to test NimGame in GamePanel class. (Lilian)
    ********************************************************************/
  public PlayerQueue getPlayerQueue() {
    return q;
  }
  
  /**********************************************************************
    * Creates a new PlayerQueue object, to facilitate starting a new round.
    * Mainly used to test NimGame in GamePanel class. (Sunnia)
    ********************************************************************/
  public void newPlayerQueue(Player ... adding) {
    PlayerQueue temp = new PlayerQueue();
    for (Player each: adding) {
      temp.addPlayer(each);
    }
    q = temp;
  }
  
  /**********************************************************************
    * Simulates one player playing their turn. (Sunnia)
    * 
    * First, the player whose turn it is takes the input number of coins
    * (the takeCoin() method in CoinStack class would catch bad inputs).
    * Also, takeCoin() in Player is also an integer, so we save that in
    * the private instance variable "last", to see how many coins were
    * taken during this turn. Finally, we update the PlayerQueue to
    * change turns, so that it's now the next person in line's turn.
    ********************************************************************/
  public void oneTurn(int n) {
    last = q.whoseTurn().takeCoin(n);
    q.changeTurns();
  }
  
  /**********************************************************************
    * Returns the number of coins taken during the last turn. (Sunnia)
    ********************************************************************/
  public int getLast() {
    return last;
  }
  
  
  /**********************************************************************
    * Returns a string representation of the game. (Sunnia)
    ********************************************************************/
  public String toString() {
    String s = stackOfCoins.toString();
    s += "\nIt is " + q.whoseTurn().getName() + "'s turn to go next.";
    return s;
  }
  
  public static void main(String args[]) {
    
    // Sunnia: all testing
    
    // testing new intermediate level game
    
    System.out.println("Welcome to Nim Game! Current level: Intermediate.\n");
    CoinStack st = new CoinStack();
    Player bob = new Player("Bob", st);
    ComputerInterPlayer comp = new ComputerInterPlayer(st);
    PlayerQueue p = new PlayerQueue();
    p.addPlayer(bob);
    p.addPlayer(comp);
    NimGame test = new NimGame(st, p);
    System.out.println(test);
    System.out.println("The current players are:\n" + test.getPlayerQueue());
    System.out.println("The current stack of coins is:\n" + test.getCoinStack());
    System.out.println("Currently, there are this many coins:\n" + test.numCoins());
    System.out.println();
    
    while (test.numCoins() > 4) {
      test.oneTurn(4); // Bob
      System.out.println("Bob took "+ test.getLast()+" coins. "+test);
      test.oneTurn(0);
      System.out.println("IComp took "+test.getLast()+" coins. "+test+"\n");
    }
    test.oneTurn(4); // Bob
    System.out.println("Bob took "+test.getLast()+" coins. "+test);
    
    System.out.println("\n****************************************\n");
    // testing new beginner level game
    
    System.out.println("Welcome to Nim Game! Current level: Beginner.\n");
    CoinStack sta = new CoinStack();
    Player amy = new Player("Amy", sta);
    ComputerBegPlayer compb = new ComputerBegPlayer(sta);
    PlayerQueue qq = new PlayerQueue();
    qq.addPlayer(amy);
    qq.addPlayer(compb);
    NimGame test2 = new NimGame(sta, qq);
    System.out.println(test2);
    
    while (test2.numCoins() > 4) {
      test2.oneTurn(4); // Amy
      System.out.println("Amy took "+test2.getLast()+" coins. "+test2);
      test2.oneTurn(0);
      System.out.println("BComp took "+test2.getLast()+" coins. "+test2+"\n");
    }
    test2.oneTurn(4); // Amy
    System.out.println("Amy took " + test2.getLast() + " coins. " + test2);
    
    System.out.println("\n****************************************\n");
    // testing advanced level game, via newPlayerQueue() & newCoinStack
    
    System.out.println("Welcome to Nim Game! Current level: Advanced.\n");
    test.newCoinStack();
    Player cat = new Player("Cat", test.getCoinStack());
    ComputerAdvPlayer compa = new ComputerAdvPlayer(test.getCoinStack());
    test.newPlayerQueue(cat, compa);
    System.out.println(test);
    
    while (test.numCoins() > 4) {
      test.oneTurn(4); // Cat
      System.out.println("Cat took "+test.getLast()+" coins. "+test);
      test.oneTurn(0);
      System.out.println("AComp took "+test.getLast()+" coins. "+test+"\n");
    }
    
    
    
  }
  
}
