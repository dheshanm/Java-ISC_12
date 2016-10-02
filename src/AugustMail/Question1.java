package AugustMail;
import java.util.*;
/**
 * Created by D'codex on October 2016.
 A sentence in the Special Fashion can be printed by taking two integers (not beyond
 total number of words in the sentence or less than 1). These integers tell the word number of the
 sentence. Replace only those words present at those given integer places by the next character in
 a circular fashion according to the English Alphabets. If both the integers are same then replace
 only one word. let us consider the following examples:
 Input Sentence: He has good Books.
 Input Integers: 2, 4
 Output Sentence: He ibt good Cpplt.
 (i.e. word number 2 and 4 have been replaced by the next characters in a circular fashion)
 Input Sentence: Time and tide waits for
 Input Integers: 3, 3
 Output Sentence: Time and ujef waits for none.
 Write a case sensitive program that reads a sentence from console (the characters of the sentence
 may be capital or small or mixed) and two positive integers and output the same sentence after
 replacing those words present at those given integer places by the next character in a circular
 fashion according to the English Alphabets.
 In the first example given above, word number 2, i.e. “has” is replaced by next characters and
 hence it becomes “ibt”. Similarly, word number 4, i.e. “Books” is replaced by next characters
 and hence it becomes “Cpplt”.
 */
public class Question1 {
    static Scanner in=new Scanner(System.in);
    public static String shift(String input){
        String output="";char c1;int c;
        int l=input.length();
        for(int i=0;i<l;i++){
            c1=input.charAt(i);
            c=(int)c1+1;
            c1=(char)c;
            output=output+c1;
        }
        return output;
    }
    public static String checker(String input){
        String output="";char c1;int c;
        int l=input.length();
        for (int i=0;i<l;i++){
            c1=input.charAt(i);
            c=(int)c1;
            if(c<65&&c!=32){
                c=c-1;
                c1=(char)c;
            }
            output=output+c1;
        }
        return output;
    }
    public static void main(String Args[]){
        System.out.print("Enter your Sentence   :");
        String input=in.nextLine();String output="";
        //String Tokenizer
        StringTokenizer st=new StringTokenizer(input);
        int l=st.countTokens();
        String words[]=new String[l];
        for(int i=0;i<l;i++){
            words[i]=st.nextToken();
        }
        System.out.print("Enter Integers    :");
        String inpInt=in.nextLine();
        Scanner sc=new Scanner(inpInt);
        sc.useDelimiter(",");
        int p1=sc.nextInt()-1;
        int p2=sc.nextInt()-1;
        for(int i=0;i<l;i++){
            if(i==p1||i==p2){
                words[i]=shift(words[i]);
            }
        }
        //Display output
        for(int i=0;i<l;i++){
            output=output+words[i]+" ";
        }
        output=checker(output);
        System.out.println(output);
    }
}
