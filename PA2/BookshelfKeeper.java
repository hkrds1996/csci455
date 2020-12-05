// Name: Kangrong Hu
// USC NetID: kangrong
// CSCI455 PA2
// Fall 2020

/**
 * Class BookshelfKeeper
 *
 * Enables users to perform efficient putPos or pickHeight operation on a
 * bookshelf of books kept in non-decreasing order by height, with the
 * restriction that single books can only be added or removed from one of the
 * two *ends* of the bookshelf to complete a higher level pick or put operation.
 * Pick or put operations are performed with minimum number of such adds or
 * removes.
 */
public class BookshelfKeeper {
   
   /**
    * Representation invariant: 
    * condition 1: bookshelf should be non-decreasing
    * ex: [3, 5, 10, 5]
    * 
    */

   // <add instance variables here>

   private Bookshelf bookShelf;
   private int totalTimes;
   private int lastTimes;

   /**
    * Creates a BookShelfKeeper object with an empty bookshelf
    */
   public BookshelfKeeper() {
      this.bookShelf = new Bookshelf();
      this.totalTimes = 0;
      assert this.isValidBookshelfKeeper();
   }

   /**
    * Creates a BookshelfKeeper object initialized with the given sorted bookshelf.
    * Note: method does not make a defensive copy of the bookshelf.
    *
    * PRE: sortedBookshelf.isSorted() is true.
    */
   public BookshelfKeeper(Bookshelf sortedBookshelf) {
      this.bookShelf = new Bookshelf();
      while (sortedBookshelf.size() != 0) {
         this.bookShelf.addLast(sortedBookshelf.removeFront());
      }
      this.totalTimes = 0;
      assert this.isValidBookshelfKeeper();
   }

   /**
    * Removes a book from the specified position in the bookshelf and keeps
    * bookshelf sorted after picking up the book.
    * 
    * Returns the number of calls to mutators on the contained bookshelf used to
    * complete this operation. This must be the minimum number to complete the
    * operation.
    * 
    * PRE: position must be in the range [0, getNumBooks()).
    */
   public int pickPos(int position) {
      int mid = this.bookShelf.size() / 2;
      Bookshelf temp = new Bookshelf();
      int count = mid > position ? 0 : this.bookShelf.size() - 1;
      int result = 0;
      if (mid > position) {
         while (count < position) {
            count++;
            temp.addLast(this.bookShelf.removeFront());
            result++;
         }
         this.bookShelf.removeFront();
         result++;
         while (temp.size() != 0) {
            this.bookShelf.addFront(temp.removeLast());
            result++;
         }
      } else {
         while (count > position) {
            count--;
            temp.addFront(this.bookShelf.removeLast());
            result++;
         }
         this.bookShelf.removeLast();
         result++;
         while (temp.size() != 0) {
            this.bookShelf.addLast(temp.removeFront());
            result++;
         }
      }
      this.totalTimes += result;
      this.lastTimes = result;
      assert this.isValidBookshelfKeeper();
      return result; // dummy code to get stub to compile
   }

   /**
    * Inserts book with specified height into the shelf. Keeps the contained
    * bookshelf sorted after the insertion.
    * 
    * Returns the number of calls to mutators on the contained bookshelf used to
    * complete this operation. This must be the minimum number to complete the
    * operation.
    * 
    * PRE: height > 0
    */
   public int putHeight(int height) {
      // int mid = this.bookShelf.size() / 2;
      Bookshelf temp = new Bookshelf();
      int result = 0;
      if (this.bookShelf.size() == 0) {
         this.bookShelf.addFront(height);
         this.totalTimes += 1;
         this.lastTimes = 1;
         assert this.isValidBookshelfKeeper();
         return 1;
      }
      int point1 = 0;
      int point2 = this.bookShelf.size() - 1;
      while ((this.bookShelf.getHeight(point2) > height) && (this.bookShelf.getHeight(point1) < height) && (point2 >= 0)
            && (point1 < this.bookShelf.size())) {
         point1++;
         point2--;
      }
      if ((this.bookShelf.getHeight(point2) > height)) {
         int count = this.bookShelf.getHeight(0);
         while (count < height) {
            temp.addLast(this.bookShelf.removeFront());
            count = this.bookShelf.getHeight(0);
            result++;
         }
         this.bookShelf.addFront(height);
         result++;
         while (temp.size() != 0) {
            this.bookShelf.addFront(temp.removeLast());
            result++;
         }
      } else {
         int count = this.bookShelf.getHeight(this.bookShelf.size() - 1);
         while (count > height) {
            temp.addFront(this.bookShelf.removeLast());
            count = this.bookShelf.getHeight(this.bookShelf.size() - 1);
            result++;
         }
         this.bookShelf.addLast(height);
         result++;
         while (temp.size() != 0) {
            this.bookShelf.addLast(temp.removeFront());
            result++;
         }
      }
      this.totalTimes += result;
      this.lastTimes = result;
      assert this.isValidBookshelfKeeper();
      return result; // dummy code to get stub to compile
   }

   /**
    * Returns the total number of calls made to mutators on the contained bookshelf
    * so far, i.e., all the ones done to perform all of the pick and put operations
    * that have been requested up to now.
    */
   public int getTotalOperations() {
      assert this.isValidBookshelfKeeper();
      return this.totalTimes;
   }

   /**
    * Returns the number of books on the contained bookshelf.
    */
   public int getNumBooks() {
      assert this.isValidBookshelfKeeper();
      return this.bookShelf.size(); 
   }

   /**
    * Returns string representation of this BookshelfKeeper. Returns a String
    * containing height of all books present in the bookshelf in the order they are
    * on the bookshelf, followed by the number of bookshelf mutator calls made to
    * perform the last pick or put operation, followed by the total number of such
    * calls made since we created this BookshelfKeeper.
    * 
    * Example return string showing required format: “[1, 3, 5, 7, 33] 4 10”
    * 
    */
   public String toString() {

      String str = this.bookShelf.toString() + " " + this.lastTimes + " " + this.totalTimes;
      assert this.isValidBookshelfKeeper();
      return str;

   }

   /**
    * Returns true iff the BookshelfKeeper data is in a valid state. (See
    * representation invariant comment for details.)
    */
   private boolean isValidBookshelfKeeper() {
      try {
         if (!this.bookShelf.isSorted()) {
            throw new IllegalArgumentException("ERROR: Heights must be specified in non-decreasing order.");
         }
         return true; // dummy code to get stub to compile
      } catch (IllegalArgumentException exception) {
         System.out.println(exception.getMessage());
         return false;
      }

   }

   // add any other private methods here

}
