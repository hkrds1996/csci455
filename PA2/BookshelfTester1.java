// Name: Kangrong Hu
// USC NetID: kangrong
// CSCI455 Lab5
// Fall 2020

import java.util.ArrayList;
public class BookshelfTester1{
   
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
   }
}