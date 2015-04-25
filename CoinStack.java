/********************************************************************
  * Player.java 
  * Authors: Lilian Ma (L02) & Sunnia Ye (L01)
  * 
  * Creates a CoinStack, aka a stack of Booleans representing coins.
  * A Boolean of true represents the gold coin and is at the bottom;
  * A Boolean of false represents a copper coin and are on top of the
  * gold coin. There are only 2 important methods: numCoins(), which
  * returns the number of coins in the stack, and takeCoins(), which
  * removes coins from the stack if the input int is appropriate.
  ********************************************************************/

import javafoundations.*;

public class CoinStack extends ArrayStack<Boolean>{
  
  private ArrayStack stackOfCoins;
  private final int NUMBEROFCOINS = 49;
  private final int MIN = 1;
  private final int MAX = 4;
  
  /**********************************************************************
    * Constructor (Sunnia)
    ********************************************************************/
  public CoinStack() { 
    stackOfCoins = new ArrayStack();
    stackOfCoins.push(true); // one gold coin
    for (int i = 1; i < NUMBEROFCOINS; i++) { // 98 copper coins on top
      stackOfCoins.push(false);
    }
  }
  
  /**********************************************************************
    * Removes coins from the top. (Sunnia)
    ********************************************************************/
  public void takeCoins(int n) {
    // only take coins if there are enough coins to takee
    if (n <= numCoins()) {
      // only take coins within acceptable range
      if (n >= MIN && n <= MAX) {
        for (int i = 0; i < n; i++) {
          stackOfCoins.pop();
        }
      } else {
        System.out.println("Error: Attempt to take invalid number of coins.");
      }
    } else {
      System.out.println("Error: Attempt to take more coins than is in pile.");
    }
  }
  
  /**********************************************************************
    * Returns the number of coins in the stack. (Sunnia)
    ********************************************************************/
  public int numCoins() {
    return stackOfCoins.size();
  }
  
  /**********************************************************************
    * Returns a string representation of the stack. (Sunnia)
    ********************************************************************/
  public String toString() {
    int n = numCoins();
    String s = "There are " + n + " coins in the stack.";
//    // To check if last coin is indeed gold & rest are copper
//    for (int i = 0; i < n; i++) {
//      s += "\n" + stackOfCoins.pop(); // prints out each Boolean (coin)
//    }
    return s;
  }
  
  public static void main(String[] args) {
    
    // Sunnia: all testing
    
    System.out.println("New CoinStack: \"fourtynine\"");
    CoinStack fourtynine = new CoinStack();
    System.out.println(fourtynine);
    
    System.out.println("CoinStack \"fourtynine\" has " +
                       fourtynine.numCoins() + " coins.");
    
    System.out.println("\nTaking 1 coin from \"fourtynine\"...");
    fourtynine.takeCoins(1); // 48
    System.out.println(fourtynine);
    
    System.out.println("\nTaking 4 coins from \"fourtynine\"...");
    fourtynine.takeCoins(4); // 44
    System.out.println(fourtynine);
    
    System.out.println("\nTaking 0 coins from \"fourtynine\"...Shouldn't work...");
    fourtynine.takeCoins(0); // 44
    System.out.println(fourtynine);
    
    System.out.println("\nTaking 5 coins from \"fourtynine\"...Shouldn't work...");
    fourtynine.takeCoins(5); // 44
    System.out.println(fourtynine);
    
    System.out.println("\nTaking 9 coins from \"fourtynine\"...Shouldn't work...");
    fourtynine.takeCoins(9); // 44
    System.out.println(fourtynine);
    
    System.out.println("\nSuccessively taking many coins from \"fourtynine\"...\n"+
                       "reducing it to 4 coins...");
    fourtynine.takeCoins(4); // 40
    fourtynine.takeCoins(4); // 36
    fourtynine.takeCoins(4); // 32
    fourtynine.takeCoins(4); // 28
    fourtynine.takeCoins(4); // 24
    fourtynine.takeCoins(4); // 20
    fourtynine.takeCoins(4); // 16
    fourtynine.takeCoins(4); // 12
    fourtynine.takeCoins(4); // 8
    fourtynine.takeCoins(4); // 4
    System.out.println(fourtynine);
    
    System.out.println("\nTaking 2 coins from \"fourtynine\"...");
    fourtynine.takeCoins(2); // 2
    System.out.println(fourtynine);
    
    System.out.println("\nTaking 3 coins from \"fourtynine\"...Shouldn't work...");
    fourtynine.takeCoins(3); // Still 2
    System.out.println(fourtynine);
    
    System.out.println("\nTaking 2 coins from \"fourtynine\"...Should now be empty.");
    fourtynine.takeCoins(2); // 0
    System.out.println(fourtynine);
    
    System.out.println("---------------\nNew CoinStack: \"newStack\"");
    CoinStack newStack = new CoinStack();
    System.out.println(newStack);
    
    System.out.println("CoinStack \"newStack\" has " +
                       newStack.numCoins() + " coins.");
  }
  
}