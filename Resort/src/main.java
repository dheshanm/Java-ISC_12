import com.sun.jndi.cosnaming.IiopUrl;

import java.util.*;
import java.io.*;
import java.time.format.*;
import java.time.*;

/**
 * Created by D'codex on January 2017.
 */
public class main {
    public static void readAboutResort() throws FileNotFoundException {
        Scanner reader0=new Scanner(new File("aboutResort.txt"));
        while(reader0.hasNextLine()){
            System.out.println(reader0.nextLine());
        }
    }
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    public static void main(String Args[]) throws IOException, ClassNotFoundException {
        int failsafe=0;String temp="";
        String ID="";
        Scanner reader=new Scanner(new File("idThreshold.txt"));
        while(reader.hasNext()){
            failsafe=reader.nextInt();;
        }
        profile ac=new profile();
        framework f=new framework();
        try {
            f.init();
        }
        catch (EOFException | StreamCorruptedException e){
            f.Database.Data[1]=new profile();
            f.uploadChanges();
            f.init();
        }
        boolean flag=true;
        Scanner in=new Scanner(System.in);
        while (flag) {
            System.out.print("Are you a new User ( Sign UP? ):");
            temp = in.next();
            if (temp.equalsIgnoreCase("yes") || temp.equalsIgnoreCase("1")) {
                ac = new profile();
                ac.initialize();
                f.Database.Data[failsafe]=ac;
                f.uploadChanges();
                f.init();
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
        System.out.println("Enjoy your Suite of Entertainment on your Stay");
        System.out.println("1:Edit Profile\t\t2:Profile Details\t\t3:About This Resort");
        System.out.print("Selected choice   :");
        int ch=in.nextInt();
        switch (ch){
            case 1:
                Scanner c1=new Scanner(System.in);
                System.out.println("What do you want to Edit    :");
                System.out.println("1:Address\t2:Contact\t3:ID");
                System.out.print("Enter selected choice");
                int c=c1.nextInt();
                switch (c){
                    case 1:
                        Scanner c11=new Scanner(System.in);
                        System.out.println("Enter new Address below :");
                        temp=c11.nextLine();
                        ac.Address=temp;
                        break;

                    case 2:
                        Scanner c12=new Scanner(System.in);
                        System.out.println("Enter new Contact below :");
                        temp=c12.nextLine();
                        ac.contact=temp;
                        break;

                    case 3:
                        ac.changeID();
                        break;

                    default:
                        System.out.println("INVALID Choice");
                }
                f.Database.Data[failsafe]=ac;
                f.uploadChanges();
                f.init();
                break;

            case 2:
                System.out.println("Your Details");
                System.out.println("Name\t:"+ac.Name);
                System.out.println("ID\t\t:"+ac.ID);
                System.out.println("Address\t:"+ac.Address);
                System.out.println("Contact\t:"+ac.contact);
                System.out.println("Member Since\t:"+ac.memberSince);
                break;

            case 3:
                readAboutResort();
                break;

            default:
                System.out.println("INVALID Choice");
                readAboutResort();

        }
        FileWriter fw = new FileWriter("idThreshold.txt",true);
        BufferedWriter bw=new BufferedWriter(fw);
        PrintWriter pw=new PrintWriter(bw);
        pw.println(failsafe+1);
        pw.close();
        bw.close();
        fw.close();
    }
}
