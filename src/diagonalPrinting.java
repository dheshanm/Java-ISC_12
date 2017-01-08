import java.util.*;
/**
 * Created by D'codex on January 2017.
 */
public class diagonalPrinting {
    public static void main(String Args[]){
        Scanner in=new Scanner(System.in);
        System.out.print("Enter the number of rows and columns\t:");
        int n=in.nextInt();
        int arr[][]=new int[n][n];
        for(int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                System.out.print("Enter number for Matrix["+i+"]["+j+"]\t:");
                arr[i][j]=in.nextInt();
            }
        }
    }
}
