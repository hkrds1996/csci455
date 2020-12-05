
import java.util.Stack;
import java.util.Scanner;

// problem from E15.20 in Big Java: Early Objects, 7th ed
public class Html {   
   public static void main(String[] args) {

      // WARNING: the expected results here have not been set yet to correspond to the
      // string being tested: part of the lab is to update these correctly
      testOneString("<p> </p>", true);
      testOneString("<p> <p>", false);
      testOneString("<p> </q>", false);
      testOneString("<p>", false);
      testOneString("<p> <ul> <li> </li> </ul> <a> </a> </p>", true);
      testOneString("<p> <ul> <li> </li> </ul> <a> </p>", false);
      testOneString("<p> <ul> <li> </li> </ul> <a> </a>", false);

      testOneString("<p> <ul> <li> <a> </a> </li> </ul> <a> </a> </p>", true);
      
      testOneString("<p> xxx <ul> yyy <li> zzz </li> www xxx </ul> yyy <a> </a> zzz </p> mmm",
                    true);
      
      testOneString("<p> xxx <ul> yyy <li> zzz </li> www xxx yyy <a> </a> zzz </p> mmm", false);

   }

   // tests matchingTags method on the String html
   // exp is the expected result
   private static void testOneString(String html, boolean exp) {
      
      boolean match = matchingTags(new Scanner(html));
      System.out.println(html);
      System.out.print("Matching? " + match); 
      System.out.print(" (Expected result: " + exp + ")");
      if (match != exp) { System.out.print(" FAILED");}
      System.out.println();
      System.out.println();
   }

   // returns true iff this string has text with properly nested html tags.
   // PRE: only works if the tags are separated by whitespace, and the other text
   //   is separated from the tags with whitespace
    public static boolean matchingTags(Scanner in) {
        Stack<String> result = new Stack<>();
        while (in.hasNext()) {
            String word = in.next();
            if(isOpening(word)){
                result.push(getTagName(word));
            }else if(isClosing(word)){
                if(result.peek().equals(getTagName(word))){
                    result.pop();
                }else{
                    return false;
                }
            }
        }
        return result.isEmpty()? true : false;
    }

   private static boolean isOpening(String word) {
      return (word.length() > 1
              && word.charAt(0) == '<'
              && word.charAt(1) != '/'
              && word.charAt(word.length() -1) == '>');
   }

   private static boolean isClosing(String word) {
      return (word.length() > 2
              && word.charAt(0) == '<'
              && word.charAt(1) == '/'
              && word.charAt(word.length() -1) == '>');
   }

   // pre: isOpening(tag) or isClosing(tag)
   private static String getTagName(String tag) {
      int start = 1;
      if (tag.charAt(1) == '/') { start = 2; }
      return tag.substring(start, tag.length() - 1);
   }
   
}