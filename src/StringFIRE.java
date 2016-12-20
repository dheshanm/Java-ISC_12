import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by SYSTEM15 on 3/27/2012.
 */
public class StringFIRE {
    public static void breaker (String word[][],int wordHelper[]){
        for(int i=0;i<26;i++){
            word[i][wordHelper[i]]="!END";
        }
    }
    public static void main (String Args[]) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the String to be Analysed   :");
        String input = in.nextLine();
        System.out.print("Enter the Characters to be searched and Classified    :");
        String srch = in.nextLine();
        String output = "";int k=0;
        String tmp = "";int tp=0,t=0;
        String flag ="";boolean fl=true;
        char temp;
        srch = srch.trim();
        int l = srch.length();
        char Database[] = new char[l];
        for (int i = 0; i < l; i++) {
            temp = srch.charAt(i);
            Database[i] = temp;
        }
        String word[][]=new String[26][25];
        int wordHelper[]=new int[26];
        int wordHelperX[]=new int[26];
        for(int i=0;i<26;i++){
            wordHelper[i]=0;
            wordHelperX[i]=0;
        }
        StringTokenizer st = new StringTokenizer(input);
        int n = st.countTokens();
        while(st.hasMoreTokens()){
            tmp=st.nextToken();
            temp=tmp.charAt(0);
            tp=(int)temp;
            if(tp>=97)
                tp=tp-32;
            k=wordHelper[tp-65];
            word[tp-65][k]=tmp;
            wordHelper[tp-65]=k+1;
        }
        breaker(word,wordHelper);
        while(fl){
            for(int i=0;i<l;i++){
                temp=Database[i];
                tp=(int)temp;
                if(tp>=97)
                    tp=tp-32;
                if(wordHelper[tp-65]==0){
                    output=output+"  "+"*";
                    t=t+1;
                }
                else{
                    //for(int j=0;j<wordHelper[tp-65];j++){
                    //}
                    k=wordHelperX[tp-65];
                    tmp=word[tp-65][k];
                    //wordHelper[tp-65]=wordHelper[tp-65]-1;
                    output=output+"  "+tmp;
                    t=t+1;
                    word[tp-65][k]="!END";
                    wordHelperX[tp-65]=wordHelperX[tp-65]+1;
                    wordHelper[tp-65]=wordHelper[tp-65]-1;
                }
                if(t%3==0&&t!=0)
                    output=output+"\n";
                flag="";
                for(int j=0;j<l;j++){
                    temp=Database[j];
                    tp=(int)temp;
                    if(tp>97)
                        tp=tp-32;
                    if(wordHelper[tp-65]==0){
                        flag=flag+"0";
                    }
                    else
                        flag=flag+"1";
                }
                if(flag.equalsIgnoreCase("000"))
                    fl=false;
            }
        }
        System.out.println("Result\n"+output);
    }
}
