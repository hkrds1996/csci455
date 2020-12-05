/**
   This class tests the CashReg class.
   Version for CS 455 lab 3.  Modified from version from Big Java, 6th ed.
   Also tests getTotal() accessor function.
*/
public class CashRegTester
{
   public static void main(String[] args)
   {
      CashReg register = new CashReg();
      
      register.recordPurchase(4.35);
      register.receivePayment(5,0,0,0,0);
      System.out.print("Total: ");
      System.out.println(register.getTotal());
      double change = register.giveChange();
      System.out.println("Expected: 0.75");
      System.out.println(String.valueOf(change));

      register.recordPurchase(0.75);
      System.out.print("Total: ");
      register.receivePayment(1,2,0,0,0);
      System.out.println(register.getTotal());
      System.out.println("Expected: 0.75");
      System.out.println(String.valueOf(register.giveChange()));

      register.recordPurchase(1.50);
      System.out.print("Total: ");
      register.receivePayment(3,3,0,0,0);
      System.out.println(register.getTotal());      
      System.out.print("Change: ");
      System.out.println(String.valueOf(register.giveChange()));
      System.out.println("Expected: 2.25");

      register.receivePayment(2, 0, 5, 0, 0);
      register.recordPurchase(2.25);
      System.out.print("Change: ");
      System.out.println(register.giveChange());
      System.out.println("Expected: 0.25");

      register.recordPurchase(2.25);
      register.receivePayment(4, 1, 0, 0, 0);
      System.out.print("Total: ");
      System.out.println(register.getTotal());      
      System.out.print("Change: ");
      System.out.println(String.valueOf(register.giveChange()));
      System.out.println("Expected: 2.25");

      register.recordPurchase(19.25);
      register.receivePayment(40, 3, 0, 0, 0);
      System.out.print("Total: ");
      System.out.println(register.getTotal());      
      System.out.print("Change: ");
      System.out.println(String.valueOf(register.giveChange()));
      System.out.println("Expected: 21.5");

      register.receivePayment(23, 2, 0, 0, 0);
      register.recordPurchase(21.50);
      System.out.print("Change: ");
      System.out.println(register.giveChange());
      System.out.println("Expected: 2.0");
   }
}
