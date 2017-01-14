import java.util.*;

/**
 * Created by D'codex on January 2017.
 */
public class special {
    int N;
    long arr[];
    special(){
        N=0;
        arr=new long[N];
        arr[0]=0;
    }
    special(int nx){
        N=nx;
        arr=new long[N];
    }
    long fact(long g){
        long out=1;
        String input=String.valueOf(g);
        for(int i=2;i<=g;i++){
            out=out*i;
        }
        return out;
    }
    void input_numbers(){
        Scanner in=new Scanner(System.in);
        for(int i=0;i<N;i++){
            System.out.print("Enter value for element #"+i+"\t:");
            arr[i]=in.nextLong();
        }
    }
    void print_special(){
        for(int i=0;i<N;i++){
            long num=arr[i];
            long temp=0;
            for(int j=0;j<String.valueOf(num).length();j++){
                char ch=String.valueOf(num).charAt(j);
                temp=temp+fact(Long.parseLong(String.valueOf(ch)));
            }
            if(num==temp)
                System.out.println(num+" is a Special Number");
            else
                System.out.println(num+" is not a Special Number:");
        }
    }
    public static void main(String Args[]){
        Scanner in=new Scanner(System.in);
        System.out.print("Enter the size of the Array   :");
        int inp=in.nextInt();
        special obj=new special(inp);
        obj.input_numbers();
        obj.print_special();
    }
}
