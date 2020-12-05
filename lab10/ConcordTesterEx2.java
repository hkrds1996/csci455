
import java.util.Scanner;

public class ConcordTesterEx2{
   public static void main(String[] args){
      Concord concord = new Concord();		
      Scanner in = new Scanner(System.in);		
      concord.addData(in);			
      concord.printSorted(System.out);
   }
}