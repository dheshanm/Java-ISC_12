import java.util.*;

/**
 * Created by D'codex on January 2017.
 */
public class rotateMatrix {
    public static void main(String Args[]){
        Scanner in=new Scanner(System.in);
        System.out.print("Enter the number of rows and columns of the Matrix   :");
        int n=in.nextInt();
        int inp[][]=new int[n][n];
        int out[][]=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print("Enter Matrix["+i+"]["+j+"]\t:");
                inp[i][j]=in.nextInt();
            }
        }
        int temp=0;
        for(int i=(n-1);i>=0;i--) {
            for(int j=0;j<n;j++) {
                out[j][temp]=inp[i][j];
            }
            temp=temp+1;
        }
        System.out.println("Input Matrix\t\tOutput Matrix");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(inp[i][j]+"\t");
            }
            System.out.print("\t\t\t\t");
            for(int j=0;j<n;j++){
                System.out.print(out[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
