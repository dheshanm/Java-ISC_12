import java.io.*;
/**
 * Created by D'codex on January 2017.
 */
public class database implements Serializable{
    private static final long serialVersionUID = 1L;
    profile Data[];
    database(){
        Data=new profile[250];
        for (int i=0;i<250;i++){
            Data[i]=new profile();
        }
    }
}