import java.io.*;
import java.util.*;
/**
 * Created by SYSTEM15 on 3/27/2012.
 */
public class LibraryManagement {
    public static void Writer(String input) throws IOException {

        FileWriter fw = new FileWriter("LibraryDatabase.txt",true);
        BufferedWriter bw=new BufferedWriter(fw);
        PrintWriter pw=new PrintWriter(bw);
        if(input=="ERROR"){

        }
        else{
            //System.out.println(input);
            pw.println(input);
        }
        pw.close();
        bw.close();
        fw.close();
    }
    public static String SpaceNullifier(String input){
        String output="";
        StringTokenizer st = new StringTokenizer(input);
        while(st.hasMoreTokens()){
            output=output+st.nextToken();
        }
        return output;
    }
    static Scanner in = new Scanner(System.in);
    public static void main(String Args[]) throws IOException {
        String ck="";
        while (true) {
            System.out.println("Enter the Operation to perform : ");
            System.out.println("1   :Add Entry");
            System.out.println("2   :Display Records");
            System.out.print("Enter your choice   : ");
            String choice = in.nextLine();
            String toWrite = "", Name, class0, date, bookname0, booknum;
            switch (choice) {
                case "1":
                    Scanner c1 = new Scanner(System.in);
                    System.out.print("Enter your Name     :");
                    Name = c1.nextLine();
                    toWrite = toWrite + SpaceNullifier(Name);
                    for (int i = Name.length(); i < 16; i++) {
                        Name = Name + " ";
                    }
                    System.out.print("Enter your Standard :");
                    class0 = c1.nextLine();
                    toWrite = toWrite + "\t\t" + SpaceNullifier(class0);
                    System.out.print("Enter Date in DD/MM/YY     :");
                    date = c1.nextLine();
                    toWrite = toWrite + "\t\t" + SpaceNullifier(date);
                    System.out.print("Do you want to Take[PRESS 1] or Return[PRESS 2] :");
                    int choicec1 = c1.nextInt();
                    switch (choicec1) {
                        case 2:
                            Scanner c1c1 = new Scanner(System.in);
                            System.out.print("Enter Book Name :");
                            bookname0 = c1c1.nextLine();
                            System.out.print("Enter Books Number    :");
                            booknum = c1c1.nextLine();
                            toWrite = toWrite + "\t\t" + SpaceNullifier(bookname0 + "[" + booknum + "]") + "\t\t" + "NIL";
                            c1c1.close();
                            break;

                        case 1:
                            Scanner c1c2 = new Scanner(System.in);
                            System.out.print("Enter Book Name :");
                            bookname0 = c1c2.nextLine();
                            System.out.print("Enter Books Number    :");
                            booknum = c1c2.nextLine();
                            toWrite = toWrite + "\t\t" + "NIL" + "\t\t\t\t\t" + SpaceNullifier(bookname0 + "[" + booknum + "]");
                            c1c2.close();
                            break;

                        default:
                            System.out.println("WRONG CHOICE");
                            System.out.println("Error code :0x0000008");
                            toWrite = "ERROR";
                    }
                    if (toWrite != "ERROR") {
                        System.out.print("Writing Data to LibraryDatabase\n");
                        Writer(toWrite);
                        System.out.println("Transaction Successful\n");
                    }
                    break;

                case "2":
                    Scanner c2 = new Scanner(new File("LibraryDatabase.txt"));
                    System.out.print("Name\t\tClass\tDate\t\t\tBook Returned\t\tBook Taken");
                    System.out.print("\n----------------------------------------------------------------------\n");
                    while (c2.hasNextLine()) {
                        String temp = c2.nextLine();
                        System.out.print(temp.substring(0, 16));
                        System.out.println(temp.substring(16));
                    }
                    System.out.println("_______________________________________________________________________\n");
                    System.out.print("Continue    :");
                    ck=in.nextLine();
                    break;

                default:
                    System.out.print("_______________________________________________________________________\n");
                    System.out.print("ERROR...Continue      ?");
                    ck=in.nextLine();
            }
            if(ck=="1"||ck.equalsIgnoreCase("Yes")){
                System.out.println("_______________________________________________________________________");
                ck="";
                continue;
            }
            else {
                System.out.print("_______________________________________________________________________\n");
                System.out.print("PROGRAM TERMINATED");
                break;
            }
        }
    }
}
