package AugustMail;
import java.util.*;
/**
 * Created by D'codex on October 2016.
 Write a Program in Java to input a number and check whether it is
 a Fascinating Number or not..
 Fascinating Numbers : Some numbers of 3 digits or more exhibit a very interesting
 property. The property is such that, when the number is multiplied by 2 and 3, and both
 these products are concatenated with the original number, all digits from 1 to 9 are present
 exactly once, regardless of the number of zeroes.

 Let’s understand the concept of Fascinating Number through the following example:
 Consider the number 192,
 192 x 1 = 192
 192 x 2 = 384
 192 x 3 = 576
 Concatenating the results : 192384576
 It could be observed that ‘192384576’ consists of all digits from 1 to 9 exactly once.
 Hence, it could be concluded that 192 is a Fascinating Number.Some examples of
 fascinating Numbers are : 192, 219, 273, 327, 1902, 1920, 2019 etc.
 */
public class fascinatingNumber {
    static Scanner in=new Scanner(System.in);
    public static int sumOfDigits(String input){
        int output=0;
        int l=input.length();
        for(int i=0;i<l;i++){
            output=output+Integer.valueOf(input.substring(i,i+1));
        }
        return output;
    }
    public static boolean nullCheck(int input[]){
        int flag=0;
        for(int i=0;i<9;i++){
            if(input[i]!=0)
                flag=1;
        }
        if(flag==0)
            return true;
        else
            return false;
    }
    public static void main(String Args[]){
        System.out.print("Enter a Number    :");
        String input=in.nextLine();char ch;int c;
        String result=input+String.valueOf(Integer.parseInt(input)*2)+String.valueOf(Integer.parseInt(input)*3);
        int check[]={1,2,3,4,5,6,7,8,9};
        for(int i=0;i<result.length();i++){
            ch=result.charAt(i);
            c=Integer.parseInt(result.substring(i,i+1));
            for(int j=0;j<9;j++){
                if(c==check[j]){
                    check[j]=0;
                    break;
                }
            }
        }
        int sod=sumOfDigits(result);
        if(sod==45&&nullCheck(check)){
            System.out.println("The number is a Fascinating Number");
        }
        else
            System.out.println("The number not is a Fascinating Number");
    }
}
