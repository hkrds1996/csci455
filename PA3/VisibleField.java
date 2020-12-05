// Name: Kangrong Hu
// USC NetID: kangrong
// CS 455 PA3
// Fall 2020

/**
 * VisibleField class This is the data that's being displayed at any one point
 * in the game (i.e., visible field, because it's what the user can see about
 * the minefield), Client can call getStatus(row, col) for any square. It
 * actually has data about the whole current state of the game, including the
 * underlying mine field (getMineField()). Other accessors related to game
 * status: numMinesLeft(), isGameOver(). It also has mutators related to actions
 * the player could do (resetGameDisplay(), cycleGuess(), uncover()), and
 * changes the game state accordingly.
 * 
 * It, along with the MineField (accessible in mineField instance variable),
 * forms the Model for the game application, whereas GameBoardPanel is the View
 * and Controller, in the MVC design pattern. It contains the MineField that
 * it's partially displaying. That MineField can be accessed (or modified) from
 * outside this class via the getMineField accessor.
 */
public class VisibleField {
   // ----------------------------------------------------------
   // The following public constants (plus numbers mentioned in comments below) are
   // the possible states of one
   // location (a "square") in the visible field (all are values that can be
   // returned by public method
   // getStatus(row, col)).

   // Covered states (all negative values):
   public static final int COVERED = -1; // initial value of all squares
   public static final int MINE_GUESS = -2;
   public static final int QUESTION = -3;

   // Uncovered states (all non-negative values):

   // values in the range [0,8] corresponds to number of mines adjacent to this
   // square

   public static final int MINE = 9; // this loc is a mine that hasn't been guessed already (end of losing game)
   public static final int INCORRECT_GUESS = 10; // is displayed a specific way at the end of losing game
   public static final int EXPLODED_MINE = 11; // the one you uncovered by mistake (that caused you to lose)
   // ----------------------------------------------------------

   // <put instance variables here>
   private MineField mineField;
   private int[][] status;
   private int numMinesLeft;
   private boolean isGameOver;
   private int numLeft;

   /**
    * Create a visible field that has the given underlying mineField. The initial
    * state will have all the mines covered up, no mines guessed, and the game not
    * over.
    * 
    * @param mineField the minefield to use for for this VisibleField
    */
   public VisibleField(MineField mineField) {
      this.mineField = mineField;
      this.status = new int[this.mineField.numRows()][this.mineField.numCols()];
      this.initializeStatus();
      this.isGameOver = false;
      this.numMinesLeft = this.mineField.numMines();
      this.numLeft = this.mineField.numCols() * this.mineField.numRows() - this.mineField.numMines();
   }

   /**
    * Reset the object to its initial state (see constructor comments), using the
    * same underlying MineField.
    *
    */
   public void resetGameDisplay() {
      this.initializeStatus();
      this.isGameOver = false;
      this.numMinesLeft = this.mineField.numMines();
      this.numLeft = this.mineField.numCols() * this.mineField.numRows() - this.mineField.numMines();
   }

   /**
    * Returns a reference to the mineField that this VisibleField "covers"
    * 
    * @return the minefield
    */
   public MineField getMineField() {
      return this.mineField;
   }

   /**
    * Returns the visible status of the square indicated.
    * 
    * @param row row of the square
    * @param col col of the square
    * @return the status of the square at location (row, col). See the public
    *         constants at the beginning of the class for the possible values that
    *         may be returned, and their meanings. PRE: getMineField().inRange(row,
    *         col)
    */
   public int getStatus(int row, int col) {
      return this.status[row][col];
   }

   /**
    * Returns the the number of mines left to guess. This has nothing to do with
    * whether the mines guessed are correct or not. Just gives the user an
    * indication of how many more mines the user might want to guess. This value
    * can be negative, if they have guessed more than the number of mines in the
    * minefield.
    * 
    * @return the number of mines left to guess.
    */
   public int numMinesLeft() {
      return numMinesLeft;

   }

   /**
    * Cycles through covered states for a square, updating number of guesses as
    * necessary. Call on a COVERED square changes its status to MINE_GUESS; call on
    * a MINE_GUESS square changes it to QUESTION; call on a QUESTION square changes
    * it to COVERED again; call on an uncovered square has no effect.
    * 
    * @param row row of the square
    * @param col col of the square PRE: getMineField().inRange(row, col)
    */
   public void cycleGuess(int row, int col) {
      if (this.getStatus(row, col) == COVERED) {
         if (numMinesLeft > 0) {
            this.status[row][col] = MINE_GUESS;
            this.numMinesLeft--;
         }
      } else if (this.getStatus(row, col) == QUESTION) {
         this.status[row][col] = COVERED;
      } else if (this.status[row][col] == MINE_GUESS) {
         this.numMinesLeft++;
         this.status[row][col] = QUESTION;
      }
   }

   /**
    * Uncovers this square and returns false iff you uncover a mine here. If the
    * square wasn't a mine or adjacent to a mine it also uncovers all the squares
    * in the neighboring area that are also not next to any mines, possibly
    * uncovering a large region. Any mine-adjacent squares you reach will also be
    * uncovered, and form (possibly along with parts of the edge of the whole
    * field) the boundary of this region. Does not uncover, or keep searching
    * through, squares that have the status MINE_GUESS. Note: this action may cause
    * the game to end: either in a win (opened all the non-mine squares) or a loss
    * (opened a mine).
    * 
    * @param row of the square
    * @param col of the square
    * @return false iff you uncover a mine at (row, col) PRE:
    *         getMineField().inRange(row, col)
    */
   public boolean uncover(int row, int col) {
      if (this.mineField.hasMine(row, col)) {
         this.isGameOver = true;
         this.endStatus(row, col);
         return false;
      } else {
         emptyRecursion(row, col);
         if (this.numLeft == 0) {
            this.isGameOver = true;
         }
         return true;
      }
   }

   /**
    * Returns whether the game is over. (Note: This is not a mutator.)
    * 
    * @return whether game over
    */
   public boolean isGameOver() {
      return this.isGameOver;
   }

   /**
    * Returns whether this square has been uncovered. (i.e., is in any one of the
    * uncovered states, vs. any one of the covered states).
    * 
    * @param row of the square
    * @param col of the square
    * @return whether the square is uncovered PRE: getMineField().inRange(row, col)
    */
   public boolean isUncovered(int row, int col) {
      return (this.getStatus(row, col) >= 0 && this.getStatus(row, col) <= 8);
   }

   // <put private methods here>

   /**
    * When we want to restart our game, we need to recover the square.
    *
    */
   private void initializeStatus() {
      for (int row = 0; row < this.mineField.numRows(); row++) {
         for (int col = 0; col < this.mineField.numCols(); col++) {
            this.status[row][col] = COVERED;
         }
      }
   }

   /**
    * When the player lose the game, we need show the player how good he did in
    * this game. We need show the locations of mines and tell him that did he guess
    * mines correctly.
    *
    * @param rowEnd
    * @param colEnd
    */
   private void endStatus(int rowEnd, int colEnd) {
      for (int row = 0; row < this.mineField.numRows(); row++) {
         for (int col = 0; col < this.mineField.numCols(); col++) {
            if (this.mineField.hasMine(row, col)) {
               this.status[row][col] = MINE;
            } else {
               if (this.getStatus(row, col) == MINE_GUESS) {
                  this.status[row][col] = INCORRECT_GUESS;
               }
            }
         }
      }
      this.status[rowEnd][colEnd] = EXPLODED_MINE;
   }

   /**
    * This method can get the border of empty area by using recursion. At first, we
    * need break the recursion before row and col break the precondition that "0 <=
    * row < GameBoard.rowSize" and "0 <= col < GameBoard.colSize". We terminate the
    * recursion when the square's weight isn't 0. Besides, when the postion's
    * weight is 0, we will continue our recursion but we don't change status
    * because we won't discover the square that is guessed as mine, we use a
    * conditional statement to help us.
    *
    * @param row
    * @param col
    */
   private void emptyRecursion(int row, int col) {
      if (!this.mineField.inRange(row, col) || this.getStatus(row, col) == MINE_GUESS) {
         return;
      }
      if (this.getStatus(row, col) < 0) {
         if (this.mineField.numAdjacentMines(row, col) == 0) {
            this.status[row][col] = 0;
            this.numLeft--;
            for (int i = row - 1; i < row + 2; ++i) {
               for (int j = col - 1; j < col + 2; ++j) {
                  if (!((i == row) && (j == col))) {
                     emptyRecursion(i, j);
                  }
               }
            }
         } else {
            this.status[row][col] = this.mineField.numAdjacentMines(row, col);
            this.numLeft--;
         }
      }
   }
}
