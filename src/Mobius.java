import java.util.*;

/**
 * Created by D'codex on December 2016.
 */
public class Mobius {
    static int count;
    static boolean isPrime(int input){
        boolean flag=true;
        for(int i=2;i<input;i++){
            if(input%i==0)
                flag=false;
        }
        return flag;
    }
    public static boolean isRepeating(String data) {
        HashMap<String, Integer> repeated = new LinkedHashMap<String, Integer>();
        boolean flag=false;
        for(String word:data.split(" ")){
            Integer count=repeated.get(word);
            if(count==null)
                count=1;
            else {
                count = count + 1;
                flag=true;
            }
            repeated.put(word,count);
        }
        count=repeated.size();
        return flag;
    }
    public static void main(String Args[]){
        Scanner in=new Scanner(System.in);
        System.out.print("Enter the Number N for M(N)   :");
        int N=in.nextInt();int num=N;
        if(N==1){
            System.out.println("M(1)=1");
            return;
        }
        String factors="";
        while(num!=1){
            for(int i=2;i<=num;i++){
                if(isPrime(i)&&num%i==0){
                    factors=i+" "+factors;
                    num=num/i;
                }
            }
        }
        if(isRepeating(factors)) {
            System.out.println("M(" + N + ")=0");   //Because it has repeating factors
            System.out.println(factors);
        }
        else{
            System.out.println("M(" + N + ")="+count*(-1));   //Because it has distinct factors
            System.out.println(factors);
        }

    }
}
