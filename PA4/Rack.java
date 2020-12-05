// Name: Kangrong Hu
// USC NetID: kangrong
// CS 455 PA4
// Fall 2020

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Rack -- corresponds to the idea of the rack in the problem. This Rack
 * inculdes the methods that processes the rack of scabble tiles.
 */

public class Rack {

   private ArrayList<String> mRackArrayList; // Storing all subString in the dictionary.
   private String word; // the orignal string.

   /**
    * 
    * @param word        the string we tried to process.
    * @param mDictionary the proccessed dictionary list.
    */
   public Rack(String word, AnagramDictionary mDictionary) {
      this.word = word;
      ArrayList<String> templateArrayList = allSubsets(word);
      this.mRackArrayList = new ArrayList<>();
      for (String s : templateArrayList) {
         ArrayList<String> Anagrams = mDictionary.getAnagramsOf(s);
         if (Anagrams.size() != 0) {
            for (String subS : Anagrams) {
               this.mRackArrayList.add(subS);
            }
         }
      }
   }

   /**
    * The wallper of recursion function. From this method, we can get all the
    * subsets of word.
    * 
    * @param word the word that we want to operate.
    * @return all subsets of the indicated multiset.
    */
   public static ArrayList<String> allSubsets(String word) {
      HashMap<Character, Integer> myMap = new HashMap<>();
      for (Character c : word.toCharArray()) {
         int value = myMap.getOrDefault(c, 0);
         myMap.put(c, value + 1);
      }
      String unique = "";
      int[] mult = new int[myMap.size()];
      int index = 0;
      for (HashMap.Entry<Character, Integer> c : myMap.entrySet()) {
         mult[index] = c.getValue();
         unique += c.getKey();
         index++;
      }
      return allSubsets(unique, mult, 0);
   }

   /**
    * Finds all subsets of the multiset starting at position k in unique and mult.
    * unique and mult describe a multiset such that mult[i] is the multiplicity of
    * the char unique.charAt(i). PRE: mult.length must be at least as big as
    * unique.length() 0 <= k <= unique.length()
    * 
    * @param unique a string of unique letters
    * @param mult   the multiplicity of each letter from unique.
    * @param k      the smallest index of unique and mult to consider.
    * @return all subsets of the indicated multiset. Unlike the multiset in the
    *         parameters, each subset is represented as a String that can have
    *         repeated characters in it.
    * @author Claire Bono
    */
   private static ArrayList<String> allSubsets(String unique, int[] mult, int k) {
      ArrayList<String> allCombos = new ArrayList<>();

      if (k == unique.length()) { // multiset is empty
         allCombos.add("");
         return allCombos;
      }

      // get all subsets of the multiset without the first unique char
      ArrayList<String> restCombos = allSubsets(unique, mult, k + 1);

      // prepend all possible numbers of the first char (i.e., the one at position k)
      // to the front of each string in restCombos. Suppose that char is 'a'...

      String firstPart = ""; // in outer loop firstPart takes on the values: "", "a", "aa", ...
      for (int n = 0; n <= mult[k]; n++) {
         for (int i = 0; i < restCombos.size(); i++) { // for each of the subsets
                                                       // we found in the recursive call
            // create and add a new string with n 'a's in front of that subset
            allCombos.add(firstPart + restCombos.get(i));
         }
         firstPart += unique.charAt(k); // append another instance of 'a' to the first part
      }

      return allCombos;
   }

   /**
    * The interface for outer object.
    *
    * @return Return all the substring in the dictionary.
    */
   public ArrayList<String> getmRackArrayList() {
      return mRackArrayList;
   }

   /**
    * The interface for outer object
    *
    * @return return the string we processed.
    */
   public String getWord() {
      return word;
   }
}