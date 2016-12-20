import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by SYSTEM15 on 3/27/2012.
 */
public class Encrypt {
    static int Key=0;
    static Scanner in=new Scanner(System.in);
    public static void Key(String input){
        for (int i=0;i<input.length();i++){
            Key=Key+Integer.valueOf(input.charAt(i));
        }
        Key=Key/2;
    }
    public static String Encrytor(String input){
        String output="";
        for(int i=0;i<input.length();i++){
            char temp=input.charAt(i);
            int tempo=(int)temp;
            tempo=tempo+Key;
            output=output+(char)tempo;
        }
        return  output;
    }
    public static String Decrypt(String input){
        String output="";
        for(int i=0;i<input.length();i++){
            char temp=input.charAt(i);
            int tempo=(int)temp;
            tempo=tempo-Key;
            output=output+(char)tempo;
        }
        return output;
    }
    public static String PARTIAL(String input){
        System.out.print("Enter the position of the word to be Encrypted    :");
        int pos=in.nextInt();int i=0;
        String temp;
        StringTokenizer st=new StringTokenizer(input);
        while(st.hasMoreTokens()){
            if(pos==i){
                temp=st.nextToken();
                return Encrytor(temp);
            }
            temp=st.nextToken();
            i=i+1;
        }
        return "ERROR";
    }
    public static String Packer(String input,int pos){
        String output="";int i=0;String temp;
        StringTokenizer st=new StringTokenizer(input);
        if(st.countTokens()-1<pos){
            return "ERROR";
        }
        while(st.hasMoreTokens()){
            if(pos==i){
                temp=st.nextToken();
                output=output+Encrytor(temp)+" ";
            }
            if(st.hasMoreTokens()) {
                temp = st.nextToken();
                output = output + temp + " ";
            }
            i=i+1;
        }
        return output;
    }
    public static void main(String Args[]){
        String output="";
        System.out.println("Encrytor v0.01 Beta");
        System.out.println("Choose a Method   :\n\t1:-FULL SENTENCE\n\t2:-PARTIAL[From a given WORD INDEX]\n\t3:-Decrypt");
        System.out.print("Choose your Method   :");
        String choice=in.nextLine();
        if(choice.equals("3")) {
            System.out.print("Enter Sentence to be Decrypted    :");
        }
        else {
            System.out.print("Enter Sentence to be Encrypted    :");
        }
        String input=in.nextLine();
        System.out.print("Enter an Encrytion key    :");
        String EncrytionKey=in.nextLine();
        if(EncrytionKey.length()>=10) {
            EncrytionKey = EncrytionKey.substring(0, 10);
        }
        Key(EncrytionKey);
        switch (choice){
            case "1":
                output= Encrytor(input);
                break;
            case "2":
                System.out.print("Enter Number of Words to be Encrypted  :");
                int count=in.nextInt();
                for(int i=0;i<count;i++) {
                    System.out.print("Enter the position of the word to be Encrypted    :");
                    int pos = in.nextInt();
                    if(i==0)
                        output = Packer(input, pos);
                    else
                        output = Packer(output, pos);
                }
                break;
            case "3":
                output=Decrypt(input);
                break;
            default:
                output="ERROR";
                break;
        }
        if (output!="ERROR") {
            System.out.println("Encrypted Code      :" + output);
            System.out.println("Please remember to use te same Encryption Code while Decrypting.");
        }
        else
            System.out.println("PROGRAM TERMINATED UNEXPECTEDLY");
    }
}
