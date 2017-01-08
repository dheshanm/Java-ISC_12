import java.util.*;
/**
 * Created by D'codex on January 2017.
 */
public class fireMatrix {
    public static void main(String args[]) {
        int n,a,c,b,d,k=1;
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the Number of rows and Columns\t:");
        n=sc.nextInt();
        int m[][]=new int[n][n];
        a=0;
        c=n-1;
        b=a;
        d=c;
        for(int i=(n*n);i>=2;i--) {
            if(k==1) {
                m[a][b]=i;
                k++;
            }
            else if(k==2) {
                m[c][d]=i;
                k++;
            }
            else if(k==3) {
                m[b][c]=i;
                k++;
            }
            else if(k==4) {
                m[d][a]=i;
                k=1;
                a++;
                c--;
                if(a==d&&c==b) {
                    a=b+1;
                    c=d-1;
                    b=a;
                    d=c;
                }
            }
        }
        if(n%2==0)
            m[n/2][(n/2)-1]=1;
        else
            m[(n-1)/2][(n-1)/2]=1;
        System.out.println();
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++)
                System.out.print(m[i][j]+"\t");
            System.out.println();
        }
    }
}
