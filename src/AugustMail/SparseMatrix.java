package AugustMail;
import java.util.*;
/**
 * Created by D'codex on October 2016.
 Write a java program to find out a given matrix is sparse matrix or not. Sparse
 matrix contains zero elements above a certain threshold. This threshold is given by (n*m)/2,
 where n and m are the rows and columns in matrix. Hence, if a matrix contains more than n*m/2
 number of zeros it is sparse matrix otherwise not.
 Enter the dimensions of the matrix:
 2 3

 Enter the elements of the matrix:
 1 0 0
 2 1 1

 The matrix is not a sparse matrix
 Enter the dimensions of the matrix:
 3 4
 Enter the elements of the matrix:
 1 0 0 0
 1 0 0 0
 1 0 0 0

 The matrix is a sparse matrix
 */
public class SparseMatrix {
    static Scanner in=new Scanner(System.in);
    public static void main(String Args[]){
        System.out.print("Enter the Dimensions of the matrix    :");
        String dim=in.nextLine();String temp;int count=0;
        Scanner sc=new Scanner(dim);
        sc.useDelimiter(",");
        int n=sc.nextInt();
        int m=sc.nextInt();
        sc.close();
        int matrix[][]=new int[n][m];
        System.out.println("Enter the Elements for the matrix(ONE ROW AT A TIME)    :");
        for(int i=0;i<n;i++){
            temp=in.nextLine();
            sc=new Scanner(temp);
            for(int j=0;j<m;j++){
                matrix[i][j]=sc.nextInt();
                if(matrix[i][j]==0)
                    count=count+1;
            }
        }
        int threshold=(n*m)/2;
        if(count>threshold)
            System.out.print("The matrix is a sparse matrix");
        else
            System.out.print("The matrix is not a sparse matrix");
    }
}
