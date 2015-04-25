/********************************************************************
  * PlayerQueue.java 
  * Authors: Lilian Ma (L02) & Sunnia Ye (L01)
  * Creates a queue containing players
  *******************************************************************/

import javafoundations.*;
import javafoundations.exceptions.*;

public class PlayerQueue extends LinkedQueue<Player>{
  
  private LinkedQueue<Player> order;
  
  public PlayerQueue() { 
    order = new LinkedQueue();
//    order.enqueue(p);
//    for (int i = 0; i < list.length; i++) {
//      order.enqueue(list[i]);
//    }
  }
  
  public void addPlayer(Player add){
    order.enqueue(add);
  }
  
  /*********************************************************************
    * Dequeues the player currently at the front & enqueues that player
    * at the end of the queue.
    *******************************************************************/
  public void changeTurns() {
    order.enqueue(order.dequeue());
  }
  
  /*********************************************************************
    * Returns the player currently at the front of the queue.
    *******************************************************************/
  public Player whoseTurn() {
    return order.first();
  }
  
  public String toString(){
    String s = "There are " + order.size() + " players:\n";
    
    LinkedQueue<Player> temp = new LinkedQueue();
    int n = order.size();
    for (int i = 0; i < n; i++) {
      s += order.first().getName() + " ";
      temp.enqueue(order.dequeue());
    }
    order = temp;
    
    return s;
  }
  
  
  public static void main (String[] args) {
   PlayerQueue pq = new PlayerQueue();
   CoinStack s = new CoinStack();
   Player lilian = new Player ("Lilian", s);
   pq.addPlayer(lilian);
//    System.out.println("It's currently " + pq.whoseTurnIsIt().getName() + "'s turn.");
//    pq.changeTurns();
//    System.out.println("It's currently " + pq.whoseTurnIsIt().getName() + "'s turn.");
//    pq.changeTurns();
//    System.out.println("It's currently " + pq.whoseTurnIsIt().getName() + "'s turn.");
//    pq.changeTurns();
//    System.out.println("It's currently " + pq.whoseTurnIsIt().getName() + "'s turn.");
//    CoinStack s = new CoinStack();
//    PlayerQueue q = new PlayerQueue(new ComputerIntermediatePlayer(s));
  
}
}