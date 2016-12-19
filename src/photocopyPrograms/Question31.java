package photocopyPrograms;
import java.util.*;

/**
 * Created by D'codex on December 2016.
 */
public class Question31 {
    int N;
    Question31(int n){
        int N=n;
    }
    Question31(){
        Scanner in=new Scanner(System.in);
        System.out.print("Enter the Number N  :");
        int n = in.nextInt();
        N=n;
    }
    void initiate() {
        split(N, N, "");
    }
    void split(int n, int max, String prefix) {
        if (n == 0) {
            System.out.println(prefix);
            return;
        }

        for (int i = Math.min(max, n); i >= 1; i--) {
            split(n-i, i, prefix + " " + i);
        }
    }


    public static void main(String[] args) {
        Question31 ob=new Question31();
        ob.initiate();
    }
}
