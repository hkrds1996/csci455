// Name: Kangrong Hu
// USC NetID: kangrong
// CSCI455 PA2
// Fall 2020

import java.util.Scanner;
import java.lang.String;
import java.util.ArrayList;

/**
 * Class BookshelfKeeperProg Implements a client that can manage a
 * BookshelfKeeper. It's the interface that processes I/O information.
 */

public class BookshelfKeeperProg {

   /**
    * This is a program that helps managing a BookshelfKeeper. We can put a book
    * into bookShelf and do some operations to this bookShelf. However, we can only
    * use three commands "put", "pick" and "end". The "put" method will put a book
    * with special height into bookShelf. "pick" operation allows we picking a book
    * from a given position (index). "end" operation will end this program. We can
    * use "java BookshelfKeeperProg < input > out.out" to run this program.
    */
   public static void main(String[] arg) {
      try {
         System.out.println("Please enter initial arrangement of books followed by newline:");
         Scanner scanner = new Scanner(System.in);
         ArrayList<Integer> initiateArrList = readArrayList(scanner.nextLine());

         // check initiate ArrayList is valid.
         if (checkArrayList(initiateArrList)) {
            // implement a BookshelfKeeper from information we get from string
            Bookshelf bookShelf = new Bookshelf(initiateArrList);
            BookshelfKeeper myBookShelfKeeper = new BookshelfKeeper(bookShelf);
            System.out.println(myBookShelfKeeper.toString());
            System.out.println("Type pick <index> or put <height> followed by newline. Type end to exit.");
            while (scanner.hasNext()) {
               String operation = readAndValidateString(scanner);
               if (operation.equals("end")) {
                  break;
               } else {
                  if (processString(myBookShelfKeeper, operation)) {
                     System.out.println(myBookShelfKeeper.toString());
                  } else {
                     break;
                  }
               }
            }
         }
         scanner.close();
      } 
      catch (Exception e) {
         System.out.println(e.getMessage());
      } finally {
         System.out.println("Exiting Program.");
      }
   }

   /**
    * Checking operation command is correct or not.It's a valid command that when
    * you use "pick", "put",or "end".
    * 
    * @param scanner
    * @return
    */
   public static String readAndValidateString(Scanner scanner) {
      try {
         String strLine = scanner.nextLine();
         Scanner lineScanner = new Scanner(strLine);
         String str = lineScanner.next();
         if (str.equals("end")) {
            lineScanner.close();
            return "end";
         }
         if (str.equals("put") || str.equals("pick")) {
            lineScanner.close();
            return strLine;
         } else {
            lineScanner.close();
            throw new IllegalArgumentException("ERROR: Operation should be either pick or put.");
         }
      } catch (IllegalArgumentException exception) {
         System.out.println(exception.getMessage());
         return "end";
      }
   }

   /**
    * Checking operation command's argument is valid or not. When you want to "put"
    * something, you should "put" a positive number into Bookshelf.When you want to
    * "pick" a book from Bookshelf, the position should be [0, Bookshelf.size()).
    * 
    * @param myBookShelfKeeper
    * @param strLine
    * @return
    */
   public static boolean processString(BookshelfKeeper myBookShelfKeeper, String strLine) {
      Scanner lineScanner = new Scanner(strLine);
      String str = lineScanner.next();
      if (str.equals("put")) {
         try {
            int number = Integer.parseInt(lineScanner.next());
            if (number > 0) {
               myBookShelfKeeper.putHeight(number);
            } else {
               lineScanner.close();
               throw new IllegalArgumentException("ERROR: Height of a book must be positive.");
            }
         } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            lineScanner.close();
            return false;
         }

      } else {
         try {
            int number = lineScanner.nextInt();
            int size = myBookShelfKeeper.getNumBooks();
            if (number >= 0 && number < size) {
               myBookShelfKeeper.pickPos(number);
            } else {
               lineScanner.close();
               throw new IllegalArgumentException("ERROR: Entered pick operation is invalid on this shelf.");
            }
         } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
         }
      }
      lineScanner.close();
      return true;
   }

   /**
    * Reading ArrayList from a String
    * 
    * @param strLine
    * @return
    */
   public static ArrayList<Integer> readArrayList(String strLine) {
      Scanner lineScanner = new Scanner(strLine);
      ArrayList<Integer> tempArr = new ArrayList<>();
      while (lineScanner.hasNextInt()) {
         tempArr.add(lineScanner.nextInt());
      }
      lineScanner.close();
      return tempArr;
   }

   /**
    * Checking inlitiated ArrayList is valid
    * 
    * @param initiateArrList
    * @return
    */
   public static boolean checkArrayList(ArrayList<Integer> initiateArrList) {
      try {
         if (initiateArrList.size() != 0) {
            if (initiateArrList.get(0) <= 0) {
               throw new IllegalArgumentException("ERROR: Height of a book must be positive.");
            }
            for (int i = 1; i < initiateArrList.size(); ++i) {
               if (initiateArrList.get(i) <= 0) {
                  throw new IllegalArgumentException("ERROR: Height of a book must be positive.");
               }
            }
            for (int i = 1; i < initiateArrList.size(); ++i) {
               if (initiateArrList.get(i - 1) > initiateArrList.get(i)) {
                  throw new IllegalArgumentException("ERROR: Heights must be specified in non-decreasing order.");
               }
            }
         }
      } catch (IllegalArgumentException e) {
         System.out.println(e.getMessage());
         return false;
      }
      return true;
   }
}
