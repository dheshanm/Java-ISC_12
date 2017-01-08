package AugustMail;
import java.util.*;
/**
 * Created by D'codex on October 2016.
 Write a program to accept a date in the string format dd/mm/yyyy and accept
 the name of the day on 1st of January of the corresponding year. Find the day for the given
 date
 Example:
 INPUT:
 Date : 5/7/2001
 Day on 1st January : MONDAY
 OUTPUT: Day on 5/7/2001 : THURSDAY
 */
public class dayFinder {
    static Scanner in=new Scanner(System.in);
    public static void main(String Args[]){
        int Days[]={31,28,31,30,31,30,31,31,30,31,30,31};
        String Months[]={"January","February","March","April","May","June",
                "July","August","September","October","November","December"};
        String Day[]={"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
        System.out.print("Enter date in the format[DD/MM/YYYY]  :");
        String dateString=in.nextLine();int outstandingDays=0;
        int date=Integer.parseInt(dateString.substring(0,2));
        int month=Integer.parseInt(dateString.substring(3,5));
        int year=Integer.parseInt(dateString.substring(6));
        for(int i=0;i<month-1;i++){
            outstandingDays=outstandingDays+Days[i];
        }
        outstandingDays=outstandingDays+date;
        System.out.print("Day on 1st January    :");
        String dayon1=in.nextLine();
        int temp=0,temp0=0;
        for(int i=0;i<7;i++){
            if(dayon1.equalsIgnoreCase(Day[i]))
                temp=i;
        }
        outstandingDays=outstandingDays%7;
        if(outstandingDays>temp){
            temp=outstandingDays+temp;
            temp=temp%7;
        }
        else if(temp>outstandingDays){
            temp=temp+outstandingDays;
            temp=temp%7;
        }
        System.out.print("Day on "+dateString+" :"+Day[temp-1]);
    }
}
