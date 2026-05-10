package CollaboTodo.UI;

import java.time.LocalDate;

public class TodoCalendar{
    private LocalDate current = LocalDate.now();
    private int year = current.getYear();
    private int month = current.getMonthValue();

    public void prevMonth(){
        current = current.minusMonths(1);
    }

    public void nextMonth(){
        current = current.plusMonths(1);
    }

    public void printCalendar(){
        LocalDate first = LocalDate.of(year, month,1);
        int day = first.lengthOfMonth();
        int dayOfWeek = first.getDayOfWeek().getValue();
        dayOfWeek %= 7;
        System.out.printf("%d년 %d월\n",year,month);

        System.out.println("일\t월\t화\t수\t목\t금\t토\t");
        for(int i=0; i<dayOfWeek; i++){
            System.out.print("\t");
        }
        for(int date=0; date<day; date++){
            System.out.printf("%d\t",date);
            dayOfWeek++;
            if(dayOfWeek%7==0){
                System.out.println();
            }
        }
    }

}
