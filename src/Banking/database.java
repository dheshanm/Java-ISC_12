package Banking;
import java.io.*;

/**
 * Created by D'codex on January 2017.
 */
public class database {
    account Data[];
    Object databaseFile[];
    database(){
        Data=new account[250];
    }
    void writeData()throws IOException{
        databaseFile=Data;
        IndependantModules.writer file =new IndependantModules.writer("BankingDatabase");
        file.Write(Data);
    }
}
