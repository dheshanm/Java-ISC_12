import java.util.*;

/**
 * Created by D'codex on January 2017.
 * Question 15
 */
public class Duplicate {
    int num[];
    int count;String input;
    Object out[];
    Duplicate(int n){
        num=new int[n];
        count=n;
        input="";
    }
    void readList(){
        System.out.println("Enter the Array Details :");
        Scanner in=new Scanner(System.in);
        for(int i=0;i<count;i++){
            System.out.print("Element #"+i+"\t:");
            String temp=in.nextLine();
            num[i]=Integer.valueOf(temp);
            if(i==0)
                input=temp.trim();
            else
                input=input+" "+temp.trim();
        }
    }
    void packList(){
        HashMap<String, Integer> duplicates = new LinkedHashMap<String, Integer>();
        for(String word:input.split(" ")){
            Integer count=duplicates.get(word);
            if(count==null)
                count=1;
            else {
                count = count + 1;
            }
            duplicates.put(word,count);
        }
        out=duplicates.keySet().toArray();
    }
    void dispList(){
        System.out.print("Array without repetitive elements  :");
        for(int i=0;i<out.length;i++){
            System.out.print(out[i]+" ");
        }
    }
    public static void main(String Args[]){
        Scanner in=new Scanner(System.in);
        System.out.print("Enter the number of Array elements    :");
        int n=in.nextInt();
        Duplicate obj=new Duplicate(n);
        obj.readList();
        obj.packList();
        obj.dispList();
    }
}
