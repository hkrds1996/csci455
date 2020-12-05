import java.time.LocalDate;
import java.util.Scanner;
public class Birthday{
   public static void main(String[] arg){
      Scanner myscanner = new Scanner(System.in);
      System.out.print("Enter your birth month [1..12]: ");
      int month = myscanner.nextInt();
      System.out.print("Enter your birth day of month: ");
      int day = myscanner.nextInt();
      System.out.print("Enter your birth year [4-digit year]: ");
      int year = myscanner.nextInt();
      LocalDate nowDate = LocalDate.now();
      if(nowDate.getMonthValue()>month){
         System.out.println("Your birthday has already happened this year.");
      }else if(nowDate.getMonthValue()==month){
         if(nowDate.getDayOfMonth() >= day){
            System.out.println("Your birthday has already happened this year.");
         }else{
            System.out.println("Your birthday has not yet happened this year.");
         }           
      }else{
         System.out.println("Your birthday has not yet happened this year.");
      }            
   }
}