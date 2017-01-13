import java.util.*;
/**
 * Created by D'codex on January 2017.
 */
public class cyclicNum {
    static String combinations="";
    public static Object[] combinationArray(int input){
        Object out[];
        String inp=String.valueOf(input);
        String arr[]=new String[inp.length()];
        for (int i=0;i<inp.length();i++){
            arr[i]=String.valueOf(inp.charAt(i));
        }
        String init[]={"0","1","2","3","4","5","6","7","8","9"};
        HashMap<String, Integer> duplicates = new LinkedHashMap<String, Integer>();
        for (String word0:init){
            duplicates.put(word0,0);
        }
        for(String word:arr){
            Integer count=duplicates.get(word);
            if(count==null)
                count=1;
            else {
                count = count + 1;
            }
            duplicates.put(word,count);
        }
        out=duplicates.values().toArray();
        return out;
    }

    public static boolean cyclic(int num){
        boolean flag=true;
        Object specimen[]=combinationArray(num);
        for(int i=0;i<specimen.length;i++){
            System.out.print(specimen[i]+" ");
        }
        System.out.println();
        for (int i=1;i<String.valueOf(num).length();i++){
            Object check[]=combinationArray(num*i);
            if(!Arrays.equals(check,specimen)){
                flag=false;
            }
        }
        return flag;
    }

    static void combine(String instr, StringBuffer outstr, int index)
    {
        for (int i = index; i < instr.length(); i++)
        {
            outstr.append(instr.charAt(i));
            combinations=outstr+" "+combinations;
            //System.out.println(outstr);
            combine(instr, outstr, i + 1);
            outstr.deleteCharAt(outstr.length() - 1);
        }
    }

    public static void cyclic(String input){
        combine(input,new StringBuffer(),0);
        System.out.print("All possible combinations of the input are    \n");
        System.out.println(combinations);
    }

    public static void main(String Args[]){
        Scanner in=new Scanner(System.in);
        System.out.print("Enter a number    :");
        int num=in.nextInt();
        if (cyclic(num)){
            System.out.println("The number is cyclic");
        }
        else
            System.out.println("The number not is cyclic");
        cyclic(String.valueOf(num));
    }
}
