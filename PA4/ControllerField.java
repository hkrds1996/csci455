// Name: Kangrong Hu
// USC NetID: kangrong
// CS 455 PA4
// Fall 2020

import java.io.FileNotFoundException;
import java.util.Map;

/**
 * ControllerField -- a custom class as Controller part in our program. It
 * connects models and interactive with user.
 */

public class ControllerField {

    // A dictionary of all anagram sets
    private AnagramDictionary mAnagramDictionary;
    // The possible words we can get from a rack of Scrabble tiles.
    private Rack mRack;
    // The scores we can get from possibe words.
    private ScoreTable mScoreTable;
    // a rack of Scrabble tiles.
    private String word;

    /**
     * The constructor of ControllerField. After we get sublists from dictionay, we
     * don't need to change it anymore.
     * 
     * @param fileName the address of dictionary.
     * @throws FileNotFoundException      if the file is not found
     * @throws IllegalDictionaryException if the dictionary has any duplicate words
     */
    public ControllerField(String fileName) throws FileNotFoundException, IllegalDictionaryException {
        mAnagramDictionary = new AnagramDictionary(fileName);
    }

    /**
     * When we have a new Input, we need to find out all the possible words that we
     * can get in the dictionay by this rack of tiles.
     * 
     * @param s the rack of tiles.
     * 
     */
    public void newInput(String s) {
        this.mRack = new Rack(s, this.mAnagramDictionary);
        this.word = s;
    }

    /**
     * Show the user the score of possible words.
     */
    public Map<String, Integer> getScoreMap() {
        this.mScoreTable = new ScoreTable(this.mRack);
        return this.mScoreTable.getmMap();
    }
}
