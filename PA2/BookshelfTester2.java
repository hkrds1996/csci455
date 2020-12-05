// Name: Kangrong Hu
// USC NetID: kangrong
// CSCI455 Lab5
// Fall 2020

import java.util.ArrayList;
public class BookshelfTester2{
   
   /**
   * this's the program testing Bookshelf class.
   */
   public static void main(String[] args){
      Bookshelf myBookShelf = new Bookshelf();
      ArrayList<Integer> temp = new ArrayList<>();
      temp.add(1);
      temp.add(2);
      temp.add(3);
      temp.add(20);
      temp.add(500);
      Bookshelf myBookShelf2 = new Bookshelf(temp);
      System.out.println("Building an emtpy bookshelf: Expection: []");
      System.out.println(myBookShelf.toString());
      System.out.println("Building an bookshelf with books: Expection: [1,2,3,20,500]");
      System.out.println(myBookShelf2.toString());
      System.out.println("Calling removeFront method: Expection: [2,3,20,500]");
      myBookShelf2.removeFront();
      System.out.println(myBookShelf2.toString());
      System.out.println("Calling removeLast method: Expection: [2,3,20]");
      myBookShelf2.removeLast();
      System.out.println(myBookShelf2.toString());
      System.out.println("Calling isSorted method: Expection: ture");
      System.out.println(myBookShelf2.isSorted());
      System.out.println("Calling size method: Expection: 3");
      System.out.println(myBookShelf2.size());                               
   }
}