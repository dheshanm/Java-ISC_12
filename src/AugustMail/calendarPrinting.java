package AugustMail;
import java.util.*;
/**
 * Created by D'codex on October 2016.
 Write a program to accept the year, month and the weekday name of the 1st day of
 that month and generate its calendar.
 Example :
 INPUT : 
 Year : 2016
 Month : February
 1st day of February : Monday

 OUTPUT :
 -------------------------------------------
               February 2016
 -------------------------------------------
 SUN    MON   TUE   WED   THU   FRI   SAT
 -------------------------------------------
         1      2    3     4     5     6
 -------------------------------------------
  7      8      9    10    11    12    13
 -------------------------------------------
  14     15     16   17    18    19    20
 -------------------------------------------
  21     22     23   24    25    26    27
 -------------------------------------------
  28     29
 -------------------------------------------
 */
public class calendarPrinting {
    static Scanner in=new Scanner(System.in);
    public static void main (String Args[]){
        System.out.print("Year  :");
        String Year=in.nextLine();
        System.out.print("Month  :");
        String Month=in.nextLine();
        System.out.print("1st day of "+Month+"  :");
        String day=in.nextLine();
        boolean leap=false;int j=0;
        if(Integer.parseInt(Year)%4==0)
            leap=true;
        int Days[]={31,28,31,30,31,30,31,31,30,31,30,31};
        String Months[]={"January","February","March","April","May","June",
                         "July","August","September","October","November","December"};
        int calendar[][]=new int[5][7];
        if(day.equalsIgnoreCase("Sunday"))
            j=0;
        else if(day.equalsIgnoreCase("Monday"))
            j=1;
        else if(day.equalsIgnoreCase("Tuesday"))
            j=2;
        else if(day.equalsIgnoreCase("Wednesday"))
            j=3;
        else if(day.equalsIgnoreCase("Thursday"))
            j=4;
        else if(day.equalsIgnoreCase("Friday"))
            j=5;
        else if(day.equalsIgnoreCase("Saturday"))
            j=6;
        String row1="";int count=1;
        for(int i=0;i<7;i++){
            if(i==j){
                row1=row1+"    "+count;
                count=count+1;
            }
            else{
                if(count!=1){
                    row1=row1+"    "+count;
                    count=count+1;
                }
                else
                    row1=row1+"    "+0;
            }
        }
        //System.out.print(row1);
        Scanner sc=new Scanner(row1);
        for(int i=0;i<7;i++){
            calendar[0][i]=sc.nextInt();
        }
        int limiter=0;
        for(int i=0;i<12;i++){
            if(Months[i].equalsIgnoreCase(Month))
                limiter=Days[i];
        }
        if(limiter==28&&leap)
            limiter=29;
        for(int i=1;i<5;i++){
            for(int k=0;k<7;k++){
                if(count<=limiter){
                    calendar[i][k]=count;
                    count=count+1;
                }
                else
                    calendar[i][k]=0;
            }
        }
        System.out.println
                       ("--------------------------------------\n" +
                        "         "+Month+" "+Year+"\n" +
                        "--------------------------------------\n" +
                        //"SUN    MON   TUE   WED   THU   FRI   SAT\n" +
                        "SUN\tMON\tTUE\tWED\tTHU\tFRI\tSAT\n"+
                        "--------------------------------------");
        for(int i=0;i<5;i++){
            for(int k=0;k<7;k++){
                if(calendar[i][k]!=0){
                    System.out.print(calendar[i][k]+"\t");
                }
                else
                    System.out.print("  "+"\t");
            }
            System.out.print("\n");
        }
        System.out.print("--------------------------------------");
    }
}
