// Name: Kangrong Hu
// USC NetID: kangrong
// CSCI455 Lab5
// Fall 2020

import java.util.ArrayList;
public class TestAssert{
   
   /**
   * this's the program testing assert method.
   */  
   public static void main(String[] args){
      ArrayList<Integer> temp = new ArrayList<>();
      //temp.add(0); // By doing this, the booshelf has non-positive height
      temp.add(1);
      temp.add(3);
      //temp.add(5); // By doing this, the booshelf should have decreasing structure
      temp.add(4);
      temp.add(5);
      Bookshelf myBookShelf2 = new Bookshelf(temp);
      myBookShelf2.addFront(-1); //
      //myBookShelf2.addFront(1);
      //myBookShelf2.addLast(-1);
      //myBookShelf2.addLast(1);
      //because we know that the size of bookshelf is 4, we can use removeLast() 5 times to determine assert of removeLast() whether work.
      //myBookShelf2.removeLast();myBookShelf2.removeLast();myBookShelf2.removeLast();myBookShelf2.removeLast();myBookShelf2.removeLast();
      //because we know that the size of bookshelf is 4, we can use removeFront() 5 times to determine assert of removeFront() whether work.
      //myBookShelf2.removeFront();myBookShelf2.removeFront();myBookShelf2.removeFront();myBookShelf2.removeFront();myBookShelf2.removeFront();
      //myBookShelf2.getHeight(-1);
   }
}