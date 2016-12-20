import java.util.*;

/**
 * Created by SYSTEM15 on 3/27/2012.
 */
public class Pendulam {
    static Scanner in =new Scanner(System.in);
    public static void Sort(String[] input,int ArrayElements){
        /**for(int j=0;j<ArrayElements;j++) {
            for (int i = 0; i < (ArrayElements-1)-j; i++) {
                int n=input[i].compareTo(input[i+1]);
                if(n<0){
                //if (Long.parseLong(input[i]) < Long.parseLong(input[i + 1])) {
                    String temp = input[i];
                    input[i] = input[i + 1];
                    input[i + 1] = temp;
                }
            }
        }*/
        for(int j=0;j<ArrayElements;j++) {
            for (int i = 0; i < (ArrayElements-1)-j; i++) {
                int n=input[i].compareTo(input[i+1]);
                if(n>0){
                    //if (Long.parseLong(input[i]) < Long.parseLong(input[i + 1])) {
                    String temp = input[i];
                    input[i] = input[i + 1];
                    input[i + 1] = temp;
                }
            }
        }
    }
    public static void main(String Arg[]){
        int inp;
        System.out.print("Enter Number of Elements  :");
        inp=in.nextInt();
        String input[]=new String[inp];
        for(int i=0;i<inp;i++){
            System.out.print("Enter "+i+"th Element  :");
            input[i]=in.next();
        }
        Sort(input,inp);
        System.out.println("Output  :");
        for(int i=inp-1;i>=0;i--){
            System.out.print(input[i]+"  ");
            i=i-1;
        }
        for(int j=(inp%2);j<inp;j++){
            System.out.print(input[j]+"  ");
            j=j+1;
        }
    }
}
