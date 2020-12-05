
import java.util.Scanner;

public class ConcordTesterEx1{
   public static void main(String[] args){
      Concord concord = new Concord();		
      Scanner in = new Scanner(System.in);		
      concord.addData(in);				
      concord.print(System.out);
      System.out.println("---------- Breaking Line ------------");
      System.out.println("sorted result:");
      concord.printSorted(System.out);
   }
}