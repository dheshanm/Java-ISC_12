import java.util.*;

/**
 * Created by D'codex on January 2017.
 */
public class startendWithVowel {
    public static void main(String Args[]){
        Scanner in=new Scanner(System.in);
        System.out.print("Enter a String    :");
        String inp=in.nextLine();
        String out="";
        StringTokenizer st=new StringTokenizer(inp);
        while (st.hasMoreTokens()){
            String temp=st.nextToken();
            temp=temp.toLowerCase();
            char ch=temp.charAt(0);
            if (ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u') {
                char c=temp.charAt(temp.length() - 1);
                if (c=='a'||c=='e'||c=='i'||c=='o'||c=='u')
                    out = out + " " + temp;
            }
        }
        System.out.println("\nThe words starting and ending with Vowels are\n"+out);
    }
}
