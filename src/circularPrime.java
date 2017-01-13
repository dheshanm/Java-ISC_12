import java.util.*;

/**
 * Created by D'codex on January 2017.
 */
public class circularPrime {
    public static boolean isPrime(String inp){
        int n=Integer.valueOf(inp);
        boolean out=true;
        if (n==2)
            return true;
        for (int i=2;i<n;i++){
            if(n%i==0)
                out=false;
        }
        return out;
    }
    public static void main(String Args[]){
        Scanner in=new Scanner(System.in);
        System.out.print("Enter a number to be tested if Circular Prime   :");
        String inp=in.nextLine();
        String out=inp;
        boolean flag=true;
        do {
            if (!isPrime(out))
                flag=false;
            out=out.substring(1)+out.charAt(0);
        }while(inp.equalsIgnoreCase(out));
        if (flag)
            System.out.print("\nThe Given Number "+inp+" is a Circular Prime Number");
        else
            System.out.print("\nThe Given Number "+inp+" is a not Circular Prime Number");
    }
}
