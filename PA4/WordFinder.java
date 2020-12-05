// Name: Kangrong Hu
// USC NetID: kangrong
// CS 455 PA4
// Fall 2020

/**
 * WordFinder -- main class for a console-based program.
 * Program helps us find out all the possible words that we can make from a rack of Scrabble tiles.
 * 
 * To run it from the command line:
 *    java WordFinder [dictionaryFile]
 * We use "sowpods.txt" as the default dictionaryFile.
 * 
 */

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;

public class WordFinder {
    public static void main(String[] args) {
        String fileName = "sowpods.txt";
        if (args.length != 0) {
            fileName = args[0];
        }
        try {
            ControllerField myVisibleField = new ControllerField(fileName);
            System.out.println("Type . to quit.");
            System.out.print("Rack? ");
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()) {
                String s = scanner.next();
                if (s.equals(".")) {
                    break;
                } else {
                    myVisibleField.newInput(processString(s));
                    outputScore(s, myVisibleField.getScoreMap());
                    System.out.print("Rack? ");
                }
            }
        } catch (FileNotFoundException exception) {
            System.out.println("ERROR: Dictionary file \"" + fileName + "\"" + " does not exist.");
            System.out.println("Exiting program.");
        } catch (IllegalDictionaryException exception) {
            System.out.println(
                    "ERROR: Illegal dictionary: dictionary file has a duplicate word: " + exception.getMessage());
            System.out.println("Exiting program.");
        }
    }

    /**
     * This method helps us filter the special chars. Like: "asd*asd" We just want
     * to process "asdasd" part. Therefore, we need process the original string.
     * 
     * @param s the string we want to process.
     * @return the string we processed.
     */
    private static String processString(String s) {
        String result = "";
        for (int i = 0; i < s.length(); ++i) {
            if (((s.charAt(i) >= 'a') && (s.charAt(i) <= 'z')) || ((s.charAt(i) >= 'A') && (s.charAt(i) <= 'Z'))) {
                result += s.charAt(i);
            }
        }
        return result;
    }

    /**
     * Show the user the score of possible words.
     */
    private static void outputScore(String word, Map<String, Integer> mMap){
        ArrayList<Map.Entry<String, Integer>> arr = new ArrayList<>(mMap.entrySet());
        Collections.sort(arr, Collections.reverseOrder(new myComparator()));
        System.out.println("We can make " + arr.size() + " words from \"" + word + "\"");
        if(arr.size()!=0){
            System.out.println("All of the words with their scores (sorted by score):");
        }        
        for (Map.Entry<String, Integer> entry : arr) {
            System.out.println(entry.getValue() + ": " + entry.getKey());
        }
    }
}

/**
 * This the custom comparator class implements from Comparator<Map.Entry<String, Integer>>.
 * We can use this to use "Collections.sort(ArrayList, new myComparator())" do custom sorting.
 * 
 */
class myComparator implements Comparator<Map.Entry<String, Integer>> {

    /**
     * The method is required by implementing Comparator.
     * 
     * @param entry1 the object1 that we wanted to compare
     * @param entry2 the object2 that we wanted to compare
     * @return When entry1 > entry2 returns positive number, entry1 == entry2 returns 0 and 
     * entry1 < entry2 returns negative number.
     */
    public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
        if (entry1.getValue() == entry2.getValue()) {
            return entry2.getKey().compareTo(entry1.getKey());
        } else {
            return entry1.getValue() - entry2.getValue();
        }
    }
}