package Practicals;
import java.util.*;

/**
 * Created by SYSTEM15 on 1/5/2017.
 */
public class lotharCollatz {
    public static void main(String Args[]){
        Scanner in=new Scanner(System.in);
        System.out.print("Enter a Number  :");
        int n=in.nextInt();
        System.out.print("The Collatz sequence for "+n+" is ");
        while (n!=1){
            if(n%2!=0)
                n=n*3+1;
            else
                n=n/2;
            System.out.print(" "+n);
        }
    }
}
