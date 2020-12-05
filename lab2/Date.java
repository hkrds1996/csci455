import java.time.LocalDate;

public class Date{
   public static void main(String[] arg){
      LocalDate myDate = LocalDate.of(1995,01,20);   
      System.out.println(String.valueOf(myDate.getMonthValue())+"/"+String.valueOf(myDate.getDayOfMonth())+"/"+String.valueOf(myDate.getYear()));
      LocalDate later = myDate.plusDays(20);
      System.out.println(String.valueOf(later.getMonthValue())+"/"+String.valueOf(later.getDayOfMonth())+"/"+String.valueOf(later.getYear()));
   }
}