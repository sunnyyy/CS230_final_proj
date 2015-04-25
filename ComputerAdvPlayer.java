/********************************************************************
  * ComputerAdvPlayer.java 
  * Authors: Lilian Ma (L02) & Sunnia Ye (L01)
  * Creates a computer player at the advanced level. We inherit the
  * Player class and override the method 'takeCoin(int n) to make sure 
  * that the computer tries to beat the player by playing the ‘smart’ way:
  * the computer continually tries to make sure you get stuck with a 
  * pile of coins that is a multiple of five UNLESS you set the
  * computer up such that they are in that scenario. At this point,
  * the computer takes coins randomly FOR THAT TURN. This means that
  * if the player makes an error at any point, they will definitely
  * lose. However, if they start correctly and continually set the
  * computer up with multiples of five, they win. 
********************************************************************/
import java.util.*;
public class ComputerAdvPlayer extends Player{
  
  //Sunnia: instance variables
  private CoinStack stack;
  
  //Sunnia: constructor
  public ComputerAdvPlayer(CoinStack stackOfCoins) {
    super("Advanced Computer", stackOfCoins);
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
    * Sunnia:
    * Computer takes the amount of coins based on the following algorithm:
    *
    * If the computer is currently stuck on a multiple of 5, it can't do
    * anything to make the player get stuck on a multiple of 5. As such,
    * it takes a random number between 1 and 4 coins.
    *
    * If the computer is NOT stuck on a multiple of 5, then it is able to
    * stick the player with a multiple of 5. 
    * 
    * If coin stack is empty, CoinStack class will catch exception.
    *******************************************************************/
  public int takeCoin(int n) {
    int taken = 0;
    
    //Sunnia:takes number randomly ONLY if it's currently stuck on a bad number
    if (stack.numCoins()%5==0) {
      Random generator = new Random();
      taken = generator.nextInt(4) + 1; // between 0 & 3, + 1
      stack.takeCoins(taken);
      
    } else {
      //Sunnia: figures out what the right number of coins it should take
      //to put the human player in a position where they are faced
      //with a multiple of five stack of coins
      int smartNum = stack.numCoins();
      while (smartNum > 4) {
        smartNum -= 5;
      }
      taken = smartNum;
      stack.takeCoins(taken);
    }
    return taken;
  }
  
  
  public static void main(String[] args) { 
    CoinStack s = new CoinStack();
    ComputerAdvPlayer adv = new ComputerAdvPlayer(s);
    System.out.println(adv.getName());
    Player human = new Player("human", s);
        System.out.println("Start: "+ adv.stack.numCoins());
        //testing for random no. of coins case
//    human.takeCoin(4);
//    System.out.println("Human has taken 4 coins: " + s.numCoins());
//    adv.takeCoin(0);
//    System.out.println("Comp takes random no.: " + s.numCoins());
        
        //testing for smart case
//    human.takeCoin(1);
//    System.out.println("Human has taken 1 coin: " + s.numCoins());
//    adv.takeCoin(0);
//    System.out.println("Comp should take 3: (leaves a multiple of five for the human: " 
//                         + adv.stack.numCoins());
    
   //testing for computer winning when left with less than equal
    //to four coins
      while (s.numCoins()>3) {
      human.takeCoin(4);
    }
    System.out.println(s.numCoins());
    adv.takeCoin(0);
    System.out.println("Comp should take 3 and leave us with 0: " +
                       s.numCoins());
    
    
  }
  

  
}
