package IndependantModules;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by SYSTEM15 on 12/20/2016.
 */
public class writer {
    String fileName;
    writer(){
        fileName="users";
    }
    public writer(String input){
        fileName="input";
    }
    public void Write(String input) throws IOException {
        FileWriter fw = new FileWriter(fileName+".txt",true);
        BufferedWriter bw=new BufferedWriter(fw);
        PrintWriter pw=new PrintWriter(bw);
        if(input=="ERROR"){
            return;
        }
        else{
            //System.out.println(input);
            pw.println(input);
        }
        pw.close();
        bw.close();
        fw.close();
    }
    public void Write(Object obj[]) throws IOException {
        FileWriter fw = new FileWriter(fileName+".txt",true);
        BufferedWriter bw=new BufferedWriter(fw);
        PrintWriter pw=new PrintWriter(bw);
            //System.out.println(input);
            //use pw.println(); to print to file
        pw.println(obj);
        pw.close();
        bw.close();
        fw.close();
    }
}
