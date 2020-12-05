// Name: Kangrong Hu
// USC NetID: kangrong
// CSCI455 PA2
// Fall 2020

/**
 * Class BookshelfKeeperTester
 *
 * Before we implement the program's interface, we should test BookshelfKeeper first.
 * 
 *
 */

import java.util.ArrayList;
public class BookshelfKeeperTester{  
   
   /**
   * this's the program testing BookshelfKeeper class.
   */
   public static void main(String[] arg){
      ArrayList<Integer> arrList = new ArrayList<>();
      arrList.add(1);
      arrList.add(5);
      arrList.add(8);
      Bookshelf bookShelf = new Bookshelf(arrList);
      BookshelfKeeper myBookshelfKeeper = new BookshelfKeeper(bookShelf);
      System.out.println("Build a BookshelfKeeper with [1, 5, 8]: Expection: [1, 5, 8] 0 0");
      System.out.println(myBookshelfKeeper.toString());
      myBookshelfKeeper.putHeight(10);
      System.out.println("Call putHeight(10): Expection: [1, 5, 8, 10] 1 1 ");
      System.out.println(myBookshelfKeeper.toString());
      myBookshelfKeeper.putHeight(6);
      System.out.println("Call putHeight(6): Expection: [1, 5, 6, 8, 10] 5 6");
      System.out.println(myBookshelfKeeper.toString());
      myBookshelfKeeper.putHeight(4);
      System.out.println("Call putHeight(4): Expection: [1, 4, 5, 6, 8, 10] 3 9 ");
      System.out.println(myBookshelfKeeper.toString());
      myBookshelfKeeper.putHeight(4);
      System.out.println("Call putHeight(4): Expection: [1, 4, 4, 5, 6, 8, 10] 3 12 ");
      System.out.println(myBookshelfKeeper.toString());
      myBookshelfKeeper.putHeight(4);
      System.out.println("Call putHeight(4): Expection: [1, 4, 4, 4, 5, 6, 8, 10] 3 15");
      System.out.println(myBookshelfKeeper.toString());
      myBookshelfKeeper.putHeight(2);
      System.out.println("Call putHeight(2): Expection: [1, 2, 4, 4, 4, 5, 6, 8, 10] 3 18 ");
      System.out.println(myBookshelfKeeper.toString());
      myBookshelfKeeper.putHeight(4);
      System.out.println("Call putHeight(4): Expection: [1, 2, 4, 4, 4, 4, 5, 6, 8, 10] 5 23");
      System.out.println(myBookshelfKeeper.toString());
      myBookshelfKeeper.pickPos(3);
      System.out.println("Call pickPos(3): Expection: [1, 2, 4, 4, 5, 6, 6, 8, 10] 7 30 ");
      System.out.println(myBookshelfKeeper.toString());
   }
}