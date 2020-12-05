// Name: Kangrong Hu
// USC NetID: kangrong
// CS 455 PA4
// Fall 2020

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * A dictionary of all anagram sets. Note: the processing is case-sensitive; so
 * if the dictionary has all lower case words, you will likely want any string
 * you test to have all lower case letters too, and likewise if the dictionary
 * words are all upper case.
 */
public class AnagramDictionary {
   
   //This's the invarient that records the subListSet.By using this obejct structure. 
   //When two words are anagrams, they should be in the same HashSet in the HashMap.
   private HashMap<String, HashSet<String>> mutliSet;

   /**
    * Create an anagram dictionary from the list of words given in the file
    * indicated by fileName.
    * 
    * @param fileName the name of the file to read from
    * @throws FileNotFoundException      if the file is not found
    * @throws IllegalDictionaryException if the dictionary has any duplicate words
    */
   public AnagramDictionary(String fileName) throws FileNotFoundException, IllegalDictionaryException {
      File file = new File(fileName);
      this.mutliSet = new HashMap<>();
      try (Scanner myScanner = new Scanner(file)) {
         HashSet<String> mySet = new HashSet<>();
         while (myScanner.hasNext()) {
            String templateString = myScanner.next();
            if (mySet.contains(templateString)) {
               throw new IllegalDictionaryException(templateString);
            }
            mySet.add(templateString);
            String sortedTemplateString = getKeyString(templateString);
            HashSet<String> tempHashSet = this.mutliSet.getOrDefault(sortedTemplateString, new HashSet<String>());
            tempHashSet.add(templateString);
            this.mutliSet.put(sortedTemplateString, tempHashSet);
         }
      }
   }

   /**
    * Get all anagrams of the given string. This method is case-sensitive. E.g.
    * "CARE" and "race" would not be recognized as anagrams.
    * 
    * @param s string to process
    * @return a list of the anagrams of s
    */
   public ArrayList<String> getAnagramsOf(String s) {
      HashSet<String> tempSet = this.mutliSet.get(getKeyString(s));
      if (tempSet == null) {
         return new ArrayList<String>();
      }
      return new ArrayList<String>(tempSet);
   }

   /**
    * Get the sorted letters in word, by this way, we can know other words are its
    * anagrams or not. E.g. "CARE" and "CAER" have the same sorted letters "[A, C,
    * E, R]". And "CARE" is "CAER"'s anagram.
    *
    * @param word string to process
    * @return the sorted letters in word.
    */
   public String getKeyString(String word) {
      ArrayList<Character> mArrayList = new ArrayList<>();
      for (int i = 0; i < word.length(); ++i) {
         mArrayList.add(word.charAt(i));
      }
      Collections.sort(mArrayList);
      return mArrayList.toString();
   }
}
