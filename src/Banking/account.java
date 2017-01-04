package Banking;
import java.util.*;

/**
 * Created by D'codex on January 2017.
 */
public class account {
    String Name,ID,transactionHistory;
    String balance;
    account(){
        Name="";
        ID="";
        transactionHistory="";
        balance="";
    }
    void initialize(){
        Scanner in=new Scanner(System.in);
        System.out.println("Enter your Details");
        System.out.print("Name\t\t:");
        Name=in.nextLine();
        System.out.print("ID\t\t:");
        ID=in.nextLine();
        transactionHistory="";
        balance="";
    }
}
