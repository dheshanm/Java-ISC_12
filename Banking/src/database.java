import java.io.*;

/**
 * Created by D'codex on January 2017.
 */
public class database implements Serializable{
    private static final long serialVersionUID = 1L;
    account Data[];
    database(){
        Data=new account[250];
        for (int i=0;i<250;i++){
            Data[i]=new account();
        }
    }
}
