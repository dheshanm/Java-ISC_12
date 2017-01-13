import java.io.*;
import java.util.*;

/**
 * Created by D'codex on January 2017.
 */
public class account implements Serializable{
    private static final long serialVersionUID = 1L;
    String Name,ID,transactionHistory;
    String balance;
    account(){
        Name="";
        ID="";
        transactionHistory="";
        balance="";
    }
    void initialize() throws IOException, ClassNotFoundException {
        framework f=new framework();
        f.init();
        Scanner in=new Scanner(System.in);
        System.out.println("Enter your Details");
        System.out.print("Name\t\t:");
        Name=in.nextLine();
        {
            boolean flag=true;
            while (flag) {
                System.out.print("ID\t\t:");
                ID = in.nextLine();
                int test=0;
                for (int i = 0; i < 250; i++) {
                    String temp = f.Database.Data[i].ID;
                    if (temp.equalsIgnoreCase(ID)) {
                        System.out.println("ID already in use");
                        System.out.println("RETRY");
                        test=1;
                        break;
                    }
                }
                if (test==0)
                    flag=false;
            }
        }
        transactionHistory="";
        balance="0";
    }
}
