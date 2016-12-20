package Resort;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by D'codex on December 2016.
 */
public class statistics {
    void printAllUsers()throws IOException{
        Scanner sf = new Scanner(new File("users.txt"));
        Scanner sc = new Scanner(new File("userid.txt"));
        while(sf.hasNext()&&sc.hasNext()){
            String temp=sf.nextLine();
            String tem0=sc.nextLine();
            System.out.println("Name    :"+temp);
            System.out.println("User ID :"+tem0);
            System.out.println("______________________________");
        }
    }
}
