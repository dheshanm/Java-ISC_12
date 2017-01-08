import java.util.*;
/**
 * Created by D'codex on January 2017.
 */
public class wonderousMatrix {
    static void display(int arr[][]){
        System.out.println("Input Matrix");
        for (int i=0;i<arr.length;i++){
            for (int j=0;j<arr.length;j++){
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        Scanner in=new Scanner(System.in);
        System.out.print("Enter the number of rows and columns\t:");
        int n=in.nextInt();
        int arr[][]=new int[n][n];
        int temp[]=new int[n];
        int temp0[]=new int[n];
        for(int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                System.out.print("Enter number for Matrix["+i+"]["+j+"]\t:");
                arr[i][j]=in.nextInt();
            }
        }
        boolean check=true;
        boolean flag=false;
        int sum=0,sum0=0,m=0;
        for(int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                for (int k=0;k<n;k++){
                    for(int l=0;l<n;l++){
                        if(i!=k&&j!=l)
                            if(arr[i][j]==arr[k][l]||arr[i][j]<1||arr[i][j]>(n*n))
                                check=false;
                    }
                }
            }
        }
        if (check){
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    sum=sum+arr[i][j];
                    sum0=sum0+arr[j][i];
                }
                temp[m]=sum;
                temp0[m]=sum0;
                m=m+1;
            }
            int s=(int)(n*((n*n)+1)*0.5);
            for(int i=0;i<m;i++) {
                if(temp[i]!=s||temp0[i]!=s)
                    flag=true;
            }
            if (!flag) {
                display(arr);
                System.out.println("The Matrix is a Wonderous Matrix");
            }
            else {
                display(arr);
                System.out.println("The Matrix is not a Wonderous Matrix");
            }
        }
        else {
            display(arr);
            System.out.println("The Matrix is not a Wonderous Matrix");
        }
    }
}
