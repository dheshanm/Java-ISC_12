package Resort;
import java.util.*;
import java.io.*;

/**
 * Created by SYSTEM15 on 12/20/2016.
 */
public class writer {
    String fileName;
    writer(){
        fileName="users";
    }
    writer(String input){
        fileName="input";
    }
    public void Write(String input) throws IOException {
        FileWriter fw = new FileWriter(fileName+".txt",true);
        BufferedWriter bw=new BufferedWriter(fw);
        PrintWriter pw=new PrintWriter(bw);
        if(input=="ERROR"){
            //return;
        }
        else{
            //System.out.println(input);
            pw.println(input);
        }
        pw.close();
        bw.close();
        fw.close();
    }
}
