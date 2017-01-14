import java.io.*;
import java.util.*;
import java.time.format.*;
import java.time.*;

/**
 * Created by D'codex on January 2017.
 */
public class profile implements Serializable{
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    private static final long serialVersionUID = 1L;
    String Name,Address,contact;
    String recentHistory;
    String ID,memberSince;
    profile(){
        Name="";Address="";contact="";recentHistory="";
        ID="";memberSince="";
    }
    public void changeID()throws IOException, ClassNotFoundException{
        framework f=new framework();
        f.init();
        Scanner in=new Scanner(System.in);
        {
            boolean flag=true;
            while (flag) {
                System.out.print("Choose an ID dor yourself\t:");
                ID = in.nextLine();
                int test=0;
                for (int i = 0; i < 250; i++) {
                    String temp = f.Database.Data[i].ID;
                    if (temp.equalsIgnoreCase(ID)) {
                        System.out.println("ID already taken");
                        System.out.println("Try Again with a different ID");
                        test=1;
                        break;
                    }
                }
                if (test==0)
                    flag=false;
            }
        }
    }
    public void initialize()throws IOException, ClassNotFoundException{
        Scanner in=new Scanner(System.in);
        framework f=new framework();
        f.init();
        System.out.println("Enter your Details");
        System.out.print("Name\t\t\t:");
        Name=in.nextLine();
        changeID();
        System.out.print("Enter your Address\t:");
        Address=in.nextLine();
        System.out.print("Enter your Mobile/Phone No.\t:");
        contact=in.nextLine();
        LocalDateTime now = LocalDateTime.now();
        memberSince=dtf.format(now);
        recentHistory="";
    }
}
