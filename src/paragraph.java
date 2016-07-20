import java.util.*;
/**
 * Created by D'codex on July 2016.
 */
public class paragraph {
    static String input;
    static int SentenceCount;
    public static void SentenceCounter(String input){
        for(int i=0;i<input.length();i++){
            if(input.charAt(i)=='.'||input.charAt(i)=='?'||input.charAt(i)=='!'){
                SentenceCount=SentenceCount+1;
            }
        }
    }
    public static void ArrayConstructor0(String input,String SentenceDatabase[]){
        int i=0;
        int index=0;
        do{
            if(input.charAt(i)=='.'||input.charAt(i)=='?'||input.charAt(i)=='!'){
                SentenceDatabase[index]=input.substring(0,i)+" ";
                index=index+1;
                input=input.substring(i+1);
                i=0;
            }
            if(input.charAt(i)=='^')
                break;
            i=i+1;
        }while(true);
    }
    public static void ArrayContructor1(String SentenceDatabase[],int WordCount[]) {
        int index = 0;
        do{
            int l = SentenceDatabase[index].length();
            int WordCounter = 0;
            for (int i = 0; i < l; i++) {
                if (SentenceDatabase[index].charAt(i) == ' '||SentenceDatabase[index].charAt(i) == '.'||SentenceDatabase[index].charAt(i) == '?'||SentenceDatabase[index].charAt(i) == '!')
                    WordCounter = WordCounter + 1;
            }
            WordCount[index] = WordCounter;
            index=index+1;
        }while (index<SentenceCount);
    }
    public static void display(int WordCount[]){
        System.out.println("The paragraph has "+SentenceCount+" Sentence");
        for(int i=0;i<SentenceCount;i++){
            System.out.println("Sentence "+(i+1)+" has "+WordCount[i]+" words in it.");
        }
    }
    public static void main(String Args[]){
        Scanner in=new Scanner(System.in);
        System.out.println("Enter the paragraph to be analysed :");
        input=in.nextLine()+"^";
        SentenceCounter(input);
        String SentenceDatabase[]=new String[SentenceCount];
        int WordCount[]=new int[SentenceCount];
        ArrayConstructor0(input,SentenceDatabase);
        ArrayContructor1(SentenceDatabase,WordCount);
        display(WordCount);
    }
}
