/********************************************************************
  * ComputerInterPlayer.java 
  * Authors: Lilian Ma (L02) & Sunnia Ye (L01)
  * Creates a computer player at the intermediate level. We inherit the
  * Player class and override the method 'takeCoin(int n) such that
  * the computer will take a random number of coins each time it is
  * their turn. However, when the coin pile contains less than 5 coins,
  * it will take all the remaining coins and win the game.
********************************************************************/
import java.util.*;

public class ComputerInterPlayer extends Player{
  //Lilian: instance variables
  private CoinStack stack;
  
  //Lilian: constructor
  public ComputerInterPlayer(CoinStack stackOfCoins) { 
    super("Intermediate Computer", stackOfCoins);
    stack = stackOfCoins;
  }
    
  /** Returns the name of the player*/
  public String getName() {
    return super.getName();
  }
    
  /** Returns a String representation of the player*/
  public String toString() {
    return super.toString();
  }
 
  /*********************************************************************
    * Computer takes coins at random, in most cases. If there are only
    * 4, 3, 2, or 1 coins left in the pile, the computer will take all
    * of them, thereby winning the game.
    * 
    * If coin stack is empty, CoinStack class will catch exception.
    *******************************************************************/
  public int takeCoin(int n){
    int num = stack.numCoins();
    
    // if there are fewer than 5 coins, the comp takes them all & wins.
    if (num < 5) {
      stack.takeCoins(num); 
      
      // otherwise, the comp takes a random # of coins
    } else {
      Random gen = new Random();
      num = gen.nextInt(3) + 1;
      stack.takeCoins(num);
    }
    return num;
  }
  
  
  public static void main(String[] args) { 
    CoinStack s = new CoinStack();
    ComputerInterPlayer inter = new ComputerInterPlayer(s);
    System.out.println(inter.getName());
    Player human = new Player("human", s);
    System.out.println("Start: "+ s.numCoins());
//    human.takeCoin(4);
//    System.out.println("Human has taken 4 coins: " + s.numCoins());
//    inter.takeCoin(0);
//    System.out.println("Comp takes random no.: " + s.numCoins());
//    human.takeCoin(1);
//    System.out.println("Human has taken 1 coin: " + s.numCoins());
//    inter.takeCoin(0);
//    System.out.println("Comp should take random still: " 
//                         + s.numCoins());
    while (s.numCoins()>3) {
      human.takeCoin(4);
    }
    System.out.println(s.numCoins());
    inter.takeCoin(0);
    System.out.println("Comp should take 3 and leave us with 0: " +
                       s.numCoins());
    
  }
  

  
}
