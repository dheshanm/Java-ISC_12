/**
 * Created by D'codex on August 2016.
 */
import java.util.*;

public class EqualizeNumbers {
    public static String Equalizer(String input,int length){
        for(int i=input.length();i<length;i++){
            input="0"+input;
        }
        return input;
    }
    public static String Add(String num1,String num2){
        int temp1,temp2,tempout,carry=0;
        String output="";
        if(num1.length()!=num2.length()){
            if(num1.length()>num2.length())
                num2 = Equalizer(num2, num1.length());
            else
                num1=Equalizer(num1,num2.length());
        }
        for(int i=num1.length()-1;i>=0;i--){
            temp1=Integer.parseInt(num1.substring(i,i+1));
            temp2=Integer.parseInt(num2.substring(i,i+1));
            tempout=temp1+temp2;
            if(tempout>9){
                if(carry==1){
                    tempout=tempout+carry;
                    String temp526=String.valueOf(tempout);
                    output=temp526.charAt(temp526.length()-1)+output;
                    carry=tempout/10;
                }
                else{
                    String temp527=String.valueOf(tempout);
                    output=temp527.charAt(temp527.length()-1)+output;
                    carry=1;
                }

            }
            else{
                if(carry==1){
                    tempout=tempout+carry;
                    carry=tempout/10;
                    if(tempout>9){
                        String temp525=String.valueOf(tempout);
                        output=temp525.charAt(temp525.length()-1)+output;
                    }
                    else
                        output=String.valueOf(tempout)+output;

                }
                else{
                    output=String.valueOf(tempout)+output;
                }
            }
        }
        if(carry==1){
            output="1"+output;
        }
        return output;
    }
    public static String sumOfDigits(String input){
        String output="0";
        for(int i=0;i<input.length();i++){
            output=Add(output,String.valueOf(input.charAt(i)));
        }
        return output;
    }
    public static void main(String Args[]){
        Scanner in=new Scanner(System.in);
        System.out.print("Enter a number M Greater than 100 but less than 10000 :");
        String M=in.nextLine();
        System.out.print("Enter a number N :");
        String N=in.nextLine();
        String output=M;
        String sum;
        while (true){
            output=Add(output,"1");
            sum=sumOfDigits(output);
            if(sum.equalsIgnoreCase(N)){
                break;
            }
        }
        System.out.print("The required Output is "+output);
    }
}
