package Banking;
import java.util.*;

/**
 * Created by D'codex on January 2017.
 */
public class main {
    public static void main(String Args[]){
        String ID="";
        Scanner in=new Scanner(System.in);
        System.out.print("Are you a new User():");
        String temp=in.next();
        if(temp.equalsIgnoreCase("yes")||temp.equalsIgnoreCase("1")){
            account newacc=new account();
            newacc.initialize();
        }
        else{
            System.out.print("Enter your ID   :");
        }
    }
}
