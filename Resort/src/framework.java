import java.io.*;
/**
 * Created by D'codex on January 2017.
 */
public class framework {
    database Database=new database();
    public void uploadChanges()throws IOException{
        FileOutputStream fos = new FileOutputStream(new File("ResortDatabase"+".txt"));
        ObjectOutputStream out=new ObjectOutputStream(fos);
        out.writeObject(Database);

        fos.close();
        out.close();
    }
    public void init() throws IOException, ClassNotFoundException {
        FileInputStream fi = new FileInputStream(new File("ResortDatabase"+".txt"));
        ObjectInputStream oi = new ObjectInputStream(fi);
        Database=(database)oi.readObject();
    }
}
