import java.util.*;
import java.io.*;

/**
 * Created by D'codex on January 2017.
 */
public class main {
    public static void main(String Args[]) throws IOException, ClassNotFoundException {
        String ID="";
        int failsafe=0;
        Scanner reader=new Scanner(new File("idthreshold.txt"));
        while(reader.hasNext()){
            failsafe=reader.nextInt();;
        }
        account ac=new account();
        framework f=new framework();
        try {
            f.init();
        }
        catch (java.io.EOFException e){
            f.Database.Data[1]=new account();
            f.uploadChanges();
            f.init();
        }
        boolean flag=true;
        Scanner in=new Scanner(System.in);
        while (flag) {
            System.out.print("Are you a new User():");
            String temp = in.next();
            if (temp.equalsIgnoreCase("yes") || temp.equalsIgnoreCase("1")) {
                ac = new account();
                ac.initialize();
                flag=false;
            }
            else {
                boolean fl=true;
                Scanner in0=new Scanner(System.in);
                System.out.print("Enter your ID   :");
                ID = in0.nextLine();
                for (int i = 0; i < 250; i++) {
                    ac = f.Database.Data[i];
                    if (ac.ID.equalsIgnoreCase(ID)) {
                        failsafe=i;
                        fl=false;
                        flag=false;
                        break;
                    }
                }
                if(fl){
                    System.out.println("NoSuchUser Exception");
                }
            }
        }
        System.out.println("Welcome, "+ac.Name);
        System.out.println("____________________________________");
        System.out.println("What do you want to do ?");
        System.out.println("1:Withdraw\t\t2:Deposit\n3:Display Details");
        System.out.print("Enter your selection    :");
        int choice=in.nextInt();
        switch (choice){
            case 1:
                System.out.println("Deposit:");
                System.out.println("____________________________________");
                Scanner c1=new Scanner(System.in);
                System.out.print("Enter the Amount you want to withdraw   :");
                String withdraw=c1.nextLine();
                if(Integer.valueOf(ac.balance)<Integer.valueOf(withdraw)){
                    System.out.println("Insufficient Funds");
                    System.out.println("Transaction Failed");
                }
                else{
                    ac.balance=String.valueOf(Integer.valueOf(ac.balance)-Integer.valueOf(withdraw));
                    f.Database.Data[failsafe]=ac;
                    f.uploadChanges();
                    f.init();
                }
                break;

            case 2:
                Scanner c2=new Scanner(System.in);
                System.out.println("Withdraw:");
                System.out.println("____________________________________");
                System.out.print("Enter the Amount you want to Deposit   :");
                String deposit=c2.nextLine();
                ac.balance=String.valueOf(Integer.valueOf(ac.balance)+Integer.valueOf(deposit));
                f.Database.Data[failsafe]=ac;
                f.uploadChanges();
                f.init();
                System.out.println("Transaction Successful");
                break;

            case 3:
                System.out.println("Account Details");
                System.out.println("____________________________________");
                System.out.println("Name\t:"+ac.Name);
                System.out.println("ID\t\t:"+ac.ID);
                System.out.println("Balance\t:"+ac.balance);
        }
        FileWriter fw = new FileWriter("idthreshold.txt",true);
        BufferedWriter bw=new BufferedWriter(fw);
        PrintWriter pw=new PrintWriter(bw);
        pw.println(failsafe+1);
        pw.close();
        bw.close();
        fw.close();
    }

}
