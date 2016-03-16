/********************************************************************
  * ComputerBegPlayer.java 
  * Authors: Lilian Ma (L02) & Sunnia Ye (L01)
  * Creates a computer player at the beginner level. We inherit the
  * Player class and override the method 'takeCoin(int n) to make sure 
  * that the computer tries to let the player win by playing the 'dumb’ 
  * way: computer deliberately tries to aim for “bad” numbers, i.e.
  * tries to make sure it (and not the player) gets piles of coins
  * that are multiples of five, except when coin pile is less than
  * 5, at which point it plays intelligently (always nearly guarantees 
  * a win for the player, no matter how badly they play)
  ********************************************************************/
import java.util.*;

public class ComputerBegPlayer extends Player{
  //Sunnia: instance variables
  private CoinStack stack;
  
  //Sunnia: constructor
  public ComputerBegPlayer(CoinStack stackOfCoins) { 
    super("Beginner Computer", stackOfCoins);
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
    * Computer takes the amount of coins based on the following algorithm:
    *
    * If the computer is currently stuck on a multiple of 5, it can't do
    * anything to make itself stuck on the next down multiple of 5.
    * As such, it takes a random number between 1 and 4 coins.
    *
    * If the computer is NOT stuck on a multiple of 5, then it is able to
    * stick itself with a multiple of 5 (to the benefit of the player).
    * It then does so by figuring out how far it is from a multiple of 5,
    * and then takes that number of coins.
    * 
    * If coin stack is empty, CoinStack class will catch exception.
    *******************************************************************/
  //original:
//  public int takeCoin(int n) {
//    int taken = 0;
//    
//    // takes number randomly ONLY if it's currently stuck on a bad number
//    if (stack.numCoins()%5 == 0) {
//      Random generator = new Random();
//      taken = generator.nextInt(4) + 1; // between 0 & 3, so +1
//      stack.takeCoins(taken);
//      
//    } else {
//      int smartNum = stack.numCoins();
//
//      while (smartNum %5 != 0) {
//        smartNum--; // updates smartNum to be the next down multiple of 5
//      }
//      // the computer takes the diff between the current numCoins()
//      // and smartNum, in order to reach smartNum
//      taken = stack.numCoins() - smartNum;
//      stack.takeCoins(taken);
//    }
//    return taken;
//  }
  
  
//new:
  public int takeCoin(int n) {
    int taken = 0;
    //if there is less than 5 coins left, the computer takes them all and wins
    if (stack.numCoins() < 5) {
      stack.takeCoins(stack.numCoins()); 
      //if the computer has been put in a bad position, it takes a random number
      //of coins
    } else if (stack.numCoins()%5 == 0) {
      Random generator = new Random();
      taken = generator.nextInt(4) + 1; // between 0 & 3, so +1
      stack.takeCoins(taken);
      
    } else {
      //we want to figure out how many coins we should NOT take
      int smartNum = stack.numCoins();
      while (smartNum %5 != 0) {
        smartNum--; // updates smartNum to be the next down multiple of 5
      }
      // the computer takes the diff between the current numCoins()
      // and smartNum, in order to reach smartNum
      int doNotTake = stack.numCoins() - smartNum;
      //if the random generator does come up with the doNotTake
      //number, we tell it to regenerate a number
      do {
        Random generator = new Random();
        taken = generator.nextInt(4) + 1; // between 0 & 3, so +1
      } while (taken == doNotTake);
      stack.takeCoins(taken);
    }
    return taken;
  }
  
  public static void main(String[] args) { 
    CoinStack s = new CoinStack();
    ComputerBegPlayer beg = new ComputerBegPlayer(s);
    System.out.println(beg.getName());
    Player human = new Player("human", s);
    System.out.println("Start: "+ s.numCoins());
    
    //testing for getting random number of coins case:
//    human.takeCoin(4);
//    System.out.println("Human has taken 4 coins: " + s.numCoins());
//    beg.takeCoin(0);
//    System.out.println("Comp takes random no.: " + s.numCoins());
    
    //testing for smart case:
//    human.takeCoin(1);
//    System.out.println("Human has taken 1 coin: " + s.numCoins());
//    beg.takeCoin(0);
//    System.out.println("Comp should not take 3: " 
//                         + s.numCoins());
    
    //testing for computer winning when left with less than equal
    //to four coins
    while (s.numCoins()>3) {
      human.takeCoin(4);
    }
    System.out.println(s.numCoins());
    beg.takeCoin(0);
    System.out.println("Comp should take 3 and leave us with 0: " +
                       s.numCoins());
    
  }
  
  
  
}



