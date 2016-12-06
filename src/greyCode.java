import java.util.Scanner;

/**
 * Created by latttice on 6/12/16.
 */
public class greyCode {
    // append reverse of order n gray code to prefix string, and print
    public static void gray0(String prefix, int n) {
        if (n == 0)
            System.out.println(prefix);
        else {
            gray(prefix + "1", n - 1);
            gray0(prefix + "0", n - 1);
        }
    }

    // append order n gray code to end of prefix string, and print
    public static void gray(String prefix, int n) {
        if (n == 0)
            System.out.println(prefix);
        else {
            gray(prefix + "0", n - 1);
            gray0(prefix + "1", n - 1);
        }
    }

    public static void main(String[] Args) {
        System.out.print("Enter the Number of bits  :");
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        gray("", n);
    }

}
