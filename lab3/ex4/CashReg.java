/**
   A cash register totals up sales and computes change due.

   Version for CS 455 lab 3.  Modified from version from Big Java, 6th
   ed.

   Changes [made by CMB]:

     * This version of the class is called CashReg (instead of CashRegister)
     * Added getTotal() accessor function.
     *  Made constants private.

   Ex:
   CashReg register = new CashReg();
   register.recordPurchase(0.59);  // ring something up
   register.recordPurchase(1.99);  // ring up another item
   register.recordPurchase(5.0);   // ring up a third item
   double tot = register.getTotal();    // total of purchases so far: 7.58
   register.receivePayment(10,0,0,0,0);  // customer pays with a 10
   int change = register.giveChange();  // compute change owed: 2.42
                                        // and zeroes out register

   register.recordPurchase(1.0);  // now we start ringing up someone else . . .

*/
public class CashReg
{
   private static final double QUARTER_VALUE = 0.25;
   private static final double DIME_VALUE = 0.1;
   private static final double NICKEL_VALUE = 0.05;
   private static final double PENNY_VALUE = 0.01;

   private int purchase;
   private double payment;

   /**
      Constructs a cash register with no money in it.
   */
   public CashReg()
   {
      purchase = 0;
      payment = 0;
   }

   /**
      Records the purchase price of an item.
      @param amount the price of the purchased item
   */
   public void recordPurchase(double amount)
   {
      purchase = purchase + (int)Math.round(amount * 100);
   }
   
   /**
      Gets total of all purchases made.
   */
    public double getTotal() {
       return purchase/100.0;
    }; 

   /**
      Enters the payment received from the customer.
      @param dollars the number of dollars in the payment
      @param quarters the number of quarters in the payment
      @param dimes the number of dimes in the payment
      @param nickels the number of nickels in the payment
      @param pennies the number of pennies in the payment
   */
   public void receivePayment(Change change)
   {
      payment = change.totalValue()/100.0;
   }
   
   /**
      Computes the change due and resets the machine for the next customer.
      @return the change due to the customer
   */
   public Change giveChange()
   {
      double change = payment - purchase/100.0;
      int dollars,quarters,dimes,nickels,pennies= 0;
      dollars = (int)change;
      quarters = (int)Math.round((change - dollars)*100)/25;      
      dimes = (int)Math.round((change - dollars - 0.25 * quarters) * 100)/10;
      nickels = (int)Math.round((change - dollars - 0.25 * quarters - 0.10 * dimes) * 100)/5;
      pennies = (int)Math.round((change - dollars - 0.25 * quarters - 0.10 * dimes - 0.05 * nickels) * 100 )/1;   
      purchase = 0;
      payment = 0;
      return (new Change(dollars, quarters, dimes, nickels, pennies));
   }
}
