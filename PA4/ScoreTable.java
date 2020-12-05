// Name: Kangrong Hu
// USC NetID: kangrong
// CS 455 PA4
// Fall 2020

import java.util.HashMap;
import java.util.Map;

/**
 * ScoreTable -- a custom class responsible for counting score.
 */

public class ScoreTable {

    // because we can't change the mapping from letter to score, we use final
    // variable.
    private static final int[] score = new int[] { 1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4,
            8, 4, 10 };
    // The map records words' score.
    private Map<String, Integer> mMap;

    /**
     * ScoreTable's constructor. From the possible words list, we can score these
     * words.
     * 
     * @param rack Rack class records all the possible words that we can get from a
     *             rack of Scabble tiles.
     * 
     */
    public ScoreTable(Rack rack) {
        this.mMap = new HashMap<>();
        for (String s : rack.getmRackArrayList()) {
            mMap.put(s, countingScore(s.toLowerCase()));
        }
    }

    /**
     * It's a method helping us counting single word's score.
     * 
     * @param s the word that we want to score.
     * @return the score of the word.
     */
    private int countingScore(String s) {
        int score = 0;
        for (Character c : s.toCharArray()) {
            score += this.score[c - 'a'];
        }
        return score;
    }

    /**
     * Interface of string and score map for outer object.
     * 
     * @return string and score map
     */
    public Map<String, Integer> getmMap() {
        return mMap;
    }
}