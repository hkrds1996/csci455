// Name: Kangrong Hu
// USC NetID: kangrong
// CSCI455 PA2
// Fall 2020

import java.util.ArrayList;

/**
 * Class Bookshelf Implements idea of arranging books into a bookshelf. Books on
 * a bookshelf can only be accessed in a specific way so books don’t fall down;
 * You can add or remove a book only when it’s on one of the ends of the shelf.
 * However, you can look at any book on a shelf by giving its location (starting
 * at 0). Books are identified only by their height; two books of the same
 * height can be thought of as two copies of the same book.
 */

public class Bookshelf {
   
   /**
    * Representation invariant:
    * 
    * condition 1: The height of book should be non-negative: [-10,24,50,60] is an
    * invariant.
    * 
    */

   // <add instance variables here>
   private ArrayList<Integer> bookShelf;

   /**
    * Creates an empty Bookshelf object i.e. with no books
    */
   public Bookshelf() {
      this.bookShelf = new ArrayList<Integer>();
      assert this.isValidBookshelf();
   }

   /**
    * Creates a Bookshelf with the arrangement specified in pileOfBooks. Example
    * values: [20, 1, 9].
    * 
    * PRE: pileOfBooks contains an array list of 0 or more positive numbers
    * representing the height of each book.
    */
   public Bookshelf(ArrayList<Integer> pileOfBooks) {
      this.bookShelf = new ArrayList<Integer>(pileOfBooks);
      assert this.isValidBookshelf();
   }

   /**
    * Inserts book with specified height at the start of the Bookshelf, i.e., it
    * will end up at position 0.
    * 
    * PRE: height > 0 (height of book is always positive)
    */
   public void addFront(int height) {
      assert height > 0 : "height must be higher than 0";
      this.bookShelf.add(0, height);
      assert this.isValidBookshelf();
   }

   /**
    * Inserts book with specified height at the end of the Bookshelf.
    * 
    * PRE: height > 0 (height of book is always positive)
    */
   public void addLast(int height) {
      assert height > 0 : "height must be higher than 0";
      this.bookShelf.add(height);
      assert this.isValidBookshelf();
   }

   /**
    * Removes book at the start of the Bookshelf and returns the height of the
    * removed book.
    * 
    * PRE: this.size() > 0 i.e. can be called only on non-empty BookShelf
    */
   public int removeFront() {
      assert this.size() > 0 : "this.size() must be higher than 0";
      assert this.isValidBookshelf();
      return this.bookShelf.remove(0);

   }

   /**
    * Removes book at the end of the Bookshelf and returns the height of the
    * removed book.
    * 
    * PRE: this.size() > 0 i.e. can be called only on non-empty BookShelf
    */
   public int removeLast() {
      assert this.size() > 0 : "this.size() must be higher than 0";
      assert this.isValidBookshelf();
      return this.bookShelf.remove(this.bookShelf.size() - 1);
   }

   /*
    * Gets the height of the book at the given position.
    * 
    * PRE: 0 <= position < this.size()
    */
   public int getHeight(int position) {
      assert ((position >= 0) && (position < this.size())) : "Position must be 0 <= position < this.size()";
      this.isValidBookshelf();
      return this.bookShelf.get(position); 
   }

   /**
    * Returns number of books on the this Bookshelf.
    */
   public int size() {
      assert this.isValidBookshelf();
      return this.bookShelf.size(); 
   }

   /**
    * Returns string representation of this Bookshelf. Returns a string with the height of all
    * books on the bookshelf, in the order they are in on the bookshelf, using the format shown
    * by example here:  “[7, 33, 5, 4, 3]”
    */
   public String toString() {
      String returnString = "";
      if(this.bookShelf.size() == 0) {
         return returnString +"[]";
      }
      returnString += "[";
      for(int i = 0; i < this.bookShelf.size() -1; i++){
         if(i != 0) returnString +=" ";
         returnString += String.valueOf(this.bookShelf.get(i))+",";
         
      }
      if(this.bookShelf.size()!= 1) {returnString +=" ";}
      returnString += String.valueOf(this.bookShelf.get(this.bookShelf.size()-1)) +"]";
      assert this.isValidBookshelf();
      return returnString;   // dummy code to get stub to compile

   }

   /**
    * Returns true iff the books on this Bookshelf are in non-decreasing order.
    * (Note: this is an accessor; it does not change the bookshelf.)
    */
   public boolean isSorted() {
      for (int i = 0; i < this.bookShelf.size() - 1; ++i) {
         if (this.bookShelf.get(i) > this.bookShelf.get(i + 1))
            return false;
      }
      assert this.isValidBookshelf();
      return true; // dummy code to get stub to compile
   }

   /**
    * Returns true iff the Bookshelf data is in a valid state. (See representation
    * invariant comment for more details.)
    */
   private boolean isValidBookshelf() {
      try {
         for (Integer i : this.bookShelf) {
            if (i <= 0) {
               throw new IllegalArgumentException("ERROR: Height of a book must be positive.");
            }
         }
         return true;
      } catch (IllegalArgumentException e) {
         System.out.println(e.getMessage());
         return false;
      }
   }

}
