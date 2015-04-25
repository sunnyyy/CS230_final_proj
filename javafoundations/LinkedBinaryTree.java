//*******************************************************************
//  LinkedBinaryTree.java       Java Foundations
//
//  Implements a binary tree using a linked representation.
//*******************************************************************

package javafoundations;

import java.util.Iterator;
import javafoundations.*;
import javafoundations.exceptions.*;

public class LinkedBinaryTree<T> implements BinaryTree<T>
{
  protected BTNode<T> root;
  
  //-----------------------------------------------------------------
  //  Creates an empty binary tree.
  //-----------------------------------------------------------------
  public LinkedBinaryTree()
  {
    root = null;
  }
  
  //-----------------------------------------------------------------
  //  Creates a binary tree with the specified element as its root.
  //-----------------------------------------------------------------
  public LinkedBinaryTree (T element)
  {
    root = new BTNode<T>(element);
  }
  
  //-----------------------------------------------------------------
  //  Creates a binary tree with the two specified subtrees.
  //-----------------------------------------------------------------
  public LinkedBinaryTree (T element, LinkedBinaryTree<T> left,
                           LinkedBinaryTree<T> right)
  {
    root = new BTNode<T>(element);
    root.setLeft(left.root);
    root.setRight(right.root);
  }
  
  //-----------------------------------------------------------------
  //  Returns the element stored in the root of the tree. Throws an
  //  EmptyCollectionException if the tree is empty.
  //-----------------------------------------------------------------
  public T getRootElement() {
    if (root == null)
      throw new EmptyCollectionException ("Get root operation "
                                            + "failed. The tree is empty.");
    
    return root.getElement();
  }
  
  //-----------------------------------------------------------------
  //  Returns the left subtree of the root of this tree.
  //-----------------------------------------------------------------
  public LinkedBinaryTree<T> getLeft() {
    if (root == null)
      throw new EmptyCollectionException ("Get left operation "
                                            + "failed. The tree is empty.");
    
    LinkedBinaryTree<T> result = new LinkedBinaryTree<T>();
    result.root = root.getLeft();
    
    return result;
  }
  
  //-----------------------------------------------------------------
  //  Returns the element in this binary tree that matches the
  //  specified target. Throws a ElementNotFoundException if the
  //  target is not found.
  //-----------------------------------------------------------------
  public T find (T target) {
    BTNode<T> node = null;
    
    if (root != null)
      node = root.find(target);
    
    if (node == null)
      throw new ElementNotFoundException("Find operation failed. "
                                           + "No such element in tree.");
    
    return node.getElement();
  }
  
  //-----------------------------------------------------------------
  //  Returns the number of elements in this binary tree.
  //-----------------------------------------------------------------
  public int size() {
    int result = 0;
    
    if (root != null)
      result = root.count();
    
    return result;
  }
  
  //-----------------------------------------------------------------
  //  Populates and returns an iterator containing the elements in
  //  this binary tree using an inorder traversal.
  //-----------------------------------------------------------------
  public Iterator<T> inorder() {
    ArrayIterator<T> iter = new ArrayIterator<T>();
    
    if (root != null)
      root.inorder (iter);
    
    return iter;
  }
  
  //-----------------------------------------------------------------
  //  Populates and returns an iterator containing the elements in
  //  this binary tree using a levelorder traversal.
  //-----------------------------------------------------------------
  public Iterator<T> levelorder() {
    LinkedQueue<BTNode<T>> queue = new LinkedQueue<BTNode<T>>();
    ArrayIterator<T> iter = new ArrayIterator<T>();
    
    if (root != null) {
      queue.enqueue(root);
      while (!queue.isEmpty()) {
        BTNode<T> current = queue.dequeue();
        
        iter.add (current.getElement());
        
        if (current.getLeft() != null)
          queue.enqueue(current.getLeft());
        if (current.getRight() != null)
          queue.enqueue(current.getRight());
      }
    }
    return iter;
  }
  
  //-----------------------------------------------------------------
  //  Satisfies the Iterable interface using an inorder traversal.
  //-----------------------------------------------------------------
  public Iterator<T> iterator() {
    return postorder();
  }
  
  //-----------------------------------------------------------------
  //  The following methods are left as programming projects.
  //-----------------------------------------------------------------
  
  public String toString() {
    String s = "";
    Iterator<T> printer = iterator();
    while (printer.hasNext()) {
      s = s + " " + printer.next();
    }
    return s;
  }

  public LinkedBinaryTree<T> getRight() {
    if (root == null)
      throw new EmptyCollectionException ("Get right operation "
                                            + "failed. The tree is empty.");
    
    LinkedBinaryTree<T> result = new LinkedBinaryTree<T>();
    result.root = root.getRight();
    
    return result;
  }
  
  public boolean contains (T target) {
    return (root.find(target) != null);
  }
  
  public boolean isEmpty() {
    return (root == null);
  }
  
  public Iterator<T> preorder() {
    ArrayIterator<T> iter = new ArrayIterator<T>();
    
    if (root != null)
      root.preorder (iter);
    
    return iter;
  }
  
  public Iterator<T> postorder() {
    ArrayIterator<T> iter = new ArrayIterator<T>();
    
    if (root != null)
      root.postorder (iter);
    
    return iter;
  }
  
  public int height() {
    return root.height();
  }
  
  public void spin() {
    root.spin();
  }
  
  public static void main (String[] args) {
    LinkedBinaryTree<String> left = new LinkedBinaryTree<String>("left");
    LinkedBinaryTree<String> right = new LinkedBinaryTree<String>("right");
    LinkedBinaryTree<String> test = new LinkedBinaryTree<String>("root", left, right);
    System.out.println(test + " " + test.height());
    
    LinkedBinaryTree<String> blank1 = new LinkedBinaryTree<String>();
    LinkedBinaryTree<String> blank2 = new LinkedBinaryTree<String>();
    
    LinkedBinaryTree<String> j = new LinkedBinaryTree<String>("J");
    LinkedBinaryTree<String> g = new LinkedBinaryTree<String>("G");
    LinkedBinaryTree<String> c = new LinkedBinaryTree<String>("C", blank1, j);
    LinkedBinaryTree<String> h = new LinkedBinaryTree<String>("H");
    
    LinkedBinaryTree<String> i = new LinkedBinaryTree<String>("I");
    LinkedBinaryTree<String> a = new LinkedBinaryTree<String>("A", g, c);
    LinkedBinaryTree<String> f = new LinkedBinaryTree<String>("F");
    LinkedBinaryTree<String> k = new LinkedBinaryTree<String>("K", h, blank2);
    
    LinkedBinaryTree<String> e = new LinkedBinaryTree<String>("E", i, a);
    LinkedBinaryTree<String> b = new LinkedBinaryTree<String>("B", f, k);
    LinkedBinaryTree<String> d = new LinkedBinaryTree<String>("D", e, b);
    System.out.println(d);
    
    test.spin();
    System.out.println(test);
  }
  
}

