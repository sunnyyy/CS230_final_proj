/********************************************************************
  * Player.java 
  * Authors: Lilian Ma (L02) & Sunnia Ye (L01)
  * Creates a basic player. Takes in the name of the player and a stack
  * of coins.
  ********************************************************************/

public class Player {
  //Lilian: instance variables
  private String playerName;
  private CoinStack stack;
  private int last;
  
  //Lilian: constructor
  public Player(String name, CoinStack stackOfCoins) { 
    playerName = name;
    stack = stackOfCoins;
  }
  
  /** Returns the name of the player*/
  public String getName() {
    return playerName;
  }
  
  /** Takes the specified number of coins, it will not 
    * try to take more than what is left in the coinStack
    * as we have accounted for it in the stack's takeCoins
    * method */
  public int takeCoin(int n){
    stack.takeCoins(n);
    return n;
  }
  
  
  /** Returns a String representation of the player*/
  public String toString() {
    String s = "";
    s += "Player: " + playerName;
    return s;
  }
  
  
  public static void main(String[] args) { 
    CoinStack s = new CoinStack();
    Player human = new Player("Human", s);
    System.out.println(human.getName());
    System.out.println(human);
    human.takeCoin(4);
    System.out.println("45: "+ s.numCoins());
    human.takeCoin(4);
    System.out.println("41: "+ s.numCoins());
    human.takeCoin(3);
    System.out.println("38: "+ s.numCoins());
    for (int i = 0; i<9; i++) {
      human.takeCoin(4);
    }
    System.out.println("2: "+ s.numCoins());
    human.takeCoin(3); //should print out error message
    
    
  }
  

  
}
