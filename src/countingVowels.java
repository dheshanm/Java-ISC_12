import java.util.*;

/**
 * Created by D'codex on January 2017.
 */
public class countingVowels {
    public static void main(String Args[]){
        Scanner in=new Scanner(System.in);
        System.out.print("Enter a String    :");
        String inp=in.nextLine();
        inp=inp.toLowerCase();
        StringTokenizer st=new StringTokenizer(inp);
        int vowelCount=0,consonantCount=0;
        while(st.hasMoreTokens()){
            String temp=st.nextToken();
            for(int i=0;i<temp.length();i++){
                char tmp=temp.charAt(i);
                if (tmp=='a'||tmp=='e'||tmp=='i'||tmp=='o'||tmp=='u')
                    vowelCount+=1;
                else
                    consonantCount+=1;
            }
        }
        System.out.println("The given String Contains   :\n"+vowelCount+" vowels\n"+consonantCount+" consonants");
    }
}
