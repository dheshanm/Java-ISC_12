package Resort;
import java.io.*;
import java.util.*;

/**
 * Created by SYSTEM15 on 12/20/2016.
 */
public class intro {
    void check()throws IOException{
        System.out.print("Enter your User ID   :");
        Scanner in=new Scanner(System.in);
        String id=in.nextLine();int i=0;String name="";boolean flag=true;
        Scanner sc = new Scanner(new File("userid.txt"));
        while(sc.hasNextLine()){
            String temp=sc.nextLine();
            if(temp==id){
                Scanner sf = new Scanner(new File("users.txt"));
                for(int k=0;k>=i;k++){
                    name=sf.nextLine();
                }
                System.out.println("Welcome "+name+"!");
                flag=false;
                sf.close();
            }
            else
                i=i+1;
        }
        if(flag){
            boolean duplicate=false;
            System.out.println("NEW User Detected");
            System.out.print("Enter your Name   :");
            String nameInp=in.nextLine();
            writer users=new writer("users");
            users.Write(nameInp);
            System.out.print("Enter a UserID    :");
            String IDInp=in.nextLine();
            writer userid=new writer("userid");
            Scanner sf = new Scanner(new File("userid.txt"));
            while(sf.hasNextLine()){
                String dupCheck=sf.nextLine();
                if(dupCheck==IDInp){
                    duplicate=true;
                }
            }
            if(duplicate){

            }
        }
    }
}
