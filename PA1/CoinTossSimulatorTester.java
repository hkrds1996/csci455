public class CoinTossSimulatorTester{
   public static void main(String[] arg){
      CoinTossSimulator test = new CoinTossSimulator();
      int numTrials = test.getNumTrials();
      int twoHeads = test.getTwoHeads();
      int twoTails = test.getTwoTails();
      int headTails = test.getHeadTails();
      Boolean result = numTrials == (twoHeads + twoTails + headTails);
      System.out.println("After constructor:");
      System.out.printf("Number of trials [exp:0]: %d\n", numTrials);
      System.out.printf("Two-head tosses: %d\n",twoHeads);
      System.out.printf("Two-tail tosses: %d\n", twoTails);
      System.out.printf("One-head one-tail tosses: %d\n", headTails);
      System.out.print("Tosses add up correctly? ");
      System.out.println(result);
      
      System.out.println("After run(1):");
      test.run(1);
      numTrials = test.getNumTrials();
      twoHeads = test.getTwoHeads();
      twoTails = test.getTwoTails();
      headTails = test.getHeadTails();   
      result = numTrials == (twoHeads + twoTails + headTails);
      System.out.printf("Number of trials [exp:1]: %d\n", numTrials);
      System.out.printf("Two-head tosses: %d\n",twoHeads);
      System.out.printf("Two-tail tosses: %d\n", twoTails);
      System.out.printf("One-head one-tail tosses: %d\n", headTails);
      System.out.print("Tosses add up correctly? ");
      System.out.println(result);
      
      System.out.println("After run(10):");
      test.run(10);
      numTrials = test.getNumTrials();
      twoHeads = test.getTwoHeads();
      twoTails = test.getTwoTails();
      headTails = test.getHeadTails();   
      result = numTrials == (twoHeads + twoTails + headTails);
      System.out.printf("Number of trials [exp:11]: %d\n", numTrials);
      System.out.printf("Two-head tosses: %d\n",twoHeads);
      System.out.printf("Two-tail tosses: %d\n", twoTails);
      System.out.printf("One-head one-tail tosses: %d\n", headTails);
      System.out.print("Tosses add up correctly? ");
      System.out.println(result);
      
      System.out.println("After run(100):");
      test.run(100);
      numTrials = test.getNumTrials();
      twoHeads = test.getTwoHeads();
      twoTails = test.getTwoTails();
      headTails = test.getHeadTails();   
      result = numTrials == (twoHeads + twoTails + headTails);
      System.out.printf("Number of trials [exp:111]: %d\n", numTrials);
      System.out.printf("Two-head tosses: %d\n",twoHeads);
      System.out.printf("Two-tail tosses: %d\n", twoTails);
      System.out.printf("One-head one-tail tosses: %d\n", headTails);
      System.out.print("Tosses add up correctly? ");
      System.out.println(result);
      
      System.out.println("After reset:");
      test.reset();
      numTrials = test.getNumTrials();
      twoHeads = test.getTwoHeads();
      twoTails = test.getTwoTails();
      headTails = test.getHeadTails();   
      result = numTrials == (twoHeads + twoTails + headTails);
      System.out.printf("Number of trials [exp:0]: %d\n", numTrials);
      System.out.printf("Two-head tosses: %d\n",twoHeads);
      System.out.printf("Two-tail tosses: %d\n", twoTails);
      System.out.printf("One-head one-tail tosses: %d\n", headTails);
      System.out.print("Tosses add up correctly? ");
      System.out.println(result);
      
      System.out.println("After run(1000):");
      test.run(1000);
      numTrials = test.getNumTrials();
      twoHeads = test.getTwoHeads();
      twoTails = test.getTwoTails();
      headTails = test.getHeadTails();   
      result = numTrials == (twoHeads + twoTails + headTails);
      System.out.printf("Number of trials [exp:1000]: %d\n", numTrials);
      System.out.printf("Two-head tosses: %d\n",twoHeads);
      System.out.printf("Two-tail tosses: %d\n", twoTails);
      System.out.printf("One-head one-tail tosses: %d\n", headTails);
      System.out.print("Tosses add up correctly? ");
      System.out.println(result);
   }      
}