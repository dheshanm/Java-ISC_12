package FIRE;

import java.io.*;

/**
 * Created by my pc on 8/3/2016.
 */
public class vowel {
    public static void main(String ar[])throws IOException{
        int i,j,c=0,cnt=0;
        char ch,ch1,swp;
        String a="";
        String b="";
        InputStreamReader read=new InputStreamReader(System.in);
        BufferedReader in=new BufferedReader(read);
        System.out.println("Enter a String:");
        String st=in.readLine();
        int l=st.length();
        for(i=0;i<l;i++){
            ch=st.charAt(i);
            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'||ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U')
                c=c+1;
        }
        for(i=0,j=(l-1);i<l&&j>=0;i++,j--)
        {
            ch=st.charAt(i);
            ch1=st.charAt(j);
            if ((ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') && (ch1 != 'a' && ch1 != 'e' && ch1 != 'i' && ch1 != 'o' && ch1 != 'u' && ch1 != 'A' && ch1 != 'E' && ch1 != 'I' && ch1 != 'O' && ch1 != 'U'))
            {
                i--;
                b = ch1 + b;
            }

            if ((ch1 == 'a' || ch1 == 'e' || ch1 == 'i' || ch1 == 'o' || ch1 == 'u' || ch1 == 'A' || ch1 == 'E' || ch1 == 'I' || ch1 == 'O' || ch1 == 'U') && (ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u' && ch != 'A' && ch != 'E' && ch != 'I' && ch != 'O' && ch != 'U'))
            {
                j++;
                a = a + ch;
            }
            if ((ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') && (ch1 == 'a' || ch1 == 'e' || ch1 == 'i' || ch1 == 'o' || ch1 == 'u' || ch1 == 'A' || ch1 == 'E' || ch1 == 'I' || ch1 == 'O' || ch1 == 'U'))
            {
                swp = ch;
                ch = ch1;
                ch1 = swp;
                a = a + ch;
                b = ch1 + b;
                cnt = cnt + 1;
            }

            if((ch!='a'&&ch!='e'&&ch!='i'&&ch!='o'&&ch!='u'&&ch!='A'&&ch!='E'&&ch!='I'&&ch!='O'&&ch!='U')&&(ch1!='a'&&ch1!='e'&&ch1!='i'&&ch1!='o'&&ch1!='u'&&ch1!='A'&&ch1!='E'&&ch1!='I'&&ch1!='O'&&ch1!='U'))
            {
                a=a+ch;
                b=ch1+b;
            }
            if(cnt==c/2)
            {
                break;
            }

        }
        String rem=st.substring(i+1,j);
        System.out.println(a+rem+b);
    }
}
