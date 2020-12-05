// Name:
// USC NetID:
// CS 455 PA1
// Fall 2020
/**
 * class CoinTossSimulator
 * 
 * Simulates trials of repeatedly tossing two coins and allows the user to access the
 * cumulative results.
 * 
 * NOTE: we have provided the public interface for this class.  Do not change
 * the public interface.  You can add private instance variables, constants, 
 * and private methods to the class.  You will also be completing the 
 * implementation of the methods given. 
 * 
 * Invariant: getNumTrials() = getTwoHeads() + getTwoTails() + getHeadTails()
 * 
 */
public class CoinTossSimulator {
   int numTrails;
   int twoHead;
   int twoTail;
   int oneHeadoneTail;
   /**
      Creates a coin toss simulator with no trials done yet.
   */
   public CoinTossSimulator() {
      this.numTrails = 0;
      this.twoHead = 0;
      this.twoTail = 0;
      this.oneHeadoneTail = 0;
   }


   /**
      Runs the simulation for numTrials more trials. Multiple calls to this method
      without a reset() between them *add* these trials to the current simulation.
      
      @param numTrials  number of trials to for simulation; must be >= 1
    */
   public void run(int numTrials) {
      this.numTrails += numTrials;
      for(int i = 0; i < numTrails; ++i){
         int result = (int)Math.round(Math.random()) + (int)Math.round(Math.random());
         if(result == 0){
            this.twoHead ++;
         }else if(result == 2){
            this.twoTail ++;
         }else{
            this.oneHeadoneTail ++;
         }
      }
   }


   /**
      Get number of trials performed since last reset.
   */
   public int getNumTrials() {
       return this.numTrails; 
   }


   /**
      Get number of trials that came up two heads since last reset.
   */
   public int getTwoHeads() {
       return this.twoHead;
   }

   /**
     Get number of trials that came up two tails since last reset.
   */  
   public int getTwoTails() {
       return this.twoTail;
   }


   /**
     Get number of trials that came up one head and one tail since last reset.
   */
   public int getHeadTails() {
       return this.oneHeadoneTail;
   }


   /**
      Resets the simulation, so that subsequent runs start from 0 trials done.
    */
   public void reset() {
      this.numTrails = 0;
      this.twoHead = 0;
      this.twoTail = 0;
      this.oneHeadoneTail = 0;
   }
}
