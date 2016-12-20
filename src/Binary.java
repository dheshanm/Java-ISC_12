import java.util.*;
/**
 * Created by SYSTEM15 on 3/27/2012.
 */
public class Binary {
    static String inputDecimal0;
    static String inputDecimal1;
    static String Binary0;
    static String Binary1;
    static Scanner in=new Scanner(System.in);
    static int divisionflag=0;
    public static String BinaryConverter(long decimal){
        String output="";
        while(decimal>0){
            output=String.valueOf(decimal%2)+output;
            decimal=decimal/2;
        }
        return(output);
    }
    public static String DecimalConverter(String binary){
        double output=0;
        for(int i=binary.length()-1;i>0;i--){
            if(binary.charAt(i)=='1'){
                output=output+Math.pow(2,i);
            }
        }
        return String.valueOf((int)output);
    }
    public static String Equilizer(String in0,String in1){
        while(in0.length()!=in1.length()){
            in1="0"+in1;
        }
        return in1;
    }
    public static void swap(){
        String temp=inputDecimal0;
        inputDecimal0=inputDecimal1;
        inputDecimal1=temp;
    }
    public static String Complement(String input){
        String output="";
        for(int i=0;i<input.length();i++) {
            if (input.charAt(i) == '0')
                output = output + '1';
            else if (input.charAt(i) == '1')
                output = output + '0';
        }
        Addition(output,"1");
        return output;
    }
    public static String Addition (String in0,String in1){
        String output="";
        in1=Equilizer(in0,in1);
        int l0=String.valueOf(in0).length();
        int l1=String.valueOf(in1).length();
        char carry='0';
        for(int i=l0-1;i>=0;i--){
            char ch0=String.valueOf(in0).charAt(i);
            char ch1=String.valueOf(in1).charAt(i);
            if(ch0=='0'&&ch1=='0'&&carry=='0'){
                output='0'+output;
                carry='0';
            }
            else if (ch0=='0'&&ch1=='1'&&carry=='0'){
                output='1'+output;
                carry='0';
            }
            else if (ch0=='1'&&ch1=='0'&&carry=='0'){
                output='1'+output;
                carry='0';
            }
            else if (ch0=='0'&&ch1=='0'&&carry=='1'){
                output='1'+output;
                carry='0';
            }
            else if (ch0=='1'&&ch1=='1'&&carry=='0'){
                output='0'+output;
                carry='1';
            }
            else if (ch0=='0'&&ch1=='1'&&carry=='1'){
                output='0'+output;
                carry='1';
            }
            else if (ch0=='1'&&ch1=='0'&&carry=='1'){
                output='0'+output;
                carry='1';
            }
            else if (ch0=='1'&&ch1=='1'&&carry=='1'){
                output='1'+output;
                carry='1';
            }
        }
        if(carry=='1')
            output='1'+output;
        return output;
    }
    public static String SubtractionDivision (String in0,String in1){
        String output;
        if((Integer.parseInt(DecimalConverter(in1))>Integer.parseInt(DecimalConverter(in0)))){
            return("0");
        }
        String Binary11=Complement(in1);
        output=Addition(in0,Binary11);
        output=Addition(output,"1");
        return output.substring(1);
    }
    public static String Subtraction (String in0,String in1){
        String output;
        String Binary11=Complement(in1);
        output=Addition(in0,Binary11);
        output=Addition(output,"1");
        return output.substring(1);
    }
    public static String multiplication(){
        String output=Binary0;
        if(Binary0=="0"||Binary1=="0"){
            output = "0";
            return output;
        }
        else {
            for (int i = 1; i < Integer.parseInt(inputDecimal1); i++) {
                output = Addition(output, Binary0);
            }
            return output;
        }
    }
    public static String division(){
        String temp="",decimal;
        int output=0;
        int i=0;
        while(true){
            if(i==0){
                temp=Subtraction(Binary0,Binary1);
                i=i+1;
                output=output+1;
            }
            if(Long.parseLong(temp)<Long.parseLong(Binary1)){
                divisionflag=1;
                //System.out.println(output+" 01");
                return "NOT DIVISIBLE";
            }
            else if(temp.equals(Binary1)){
                return BinaryConverter((long)output+1);
            }
            else if(Integer.parseInt(temp)==0){
                //System.out.println(output+" 02");
                return BinaryConverter((long)output);
            }
            output=output+1;
            temp=Subtraction(temp,Binary1);
        }
    }
    public static void main(String Args[]){
        System.out.print("Enter a Decimal Number [A]  :");
        inputDecimal0=in.nextLine();
        System.out.print("Enter a Decimal Number [B]  :");
        inputDecimal1=in.nextLine();
        if(Integer.valueOf(inputDecimal0)<Integer.valueOf(inputDecimal1))
            swap();
        Binary0=BinaryConverter(Long.parseLong(inputDecimal0));
        Binary1=BinaryConverter(Long.parseLong(inputDecimal1));
        Binary1=Equilizer(Binary0,Binary1);
        System.out.println("The Number in binary for "+inputDecimal0+"\tis "+Binary0);
        System.out.println("The Number in binary for "+inputDecimal1+"\tis "+Binary1);
        System.out.println("Addition        :"+Addition(Binary0,Binary1));
        System.out.println("Subtraction     :"+Subtraction(Binary0,Binary1));
        System.out.println("Multiplication  :"+multiplication());
        System.out.println("Division        :"+division());
        if(divisionflag==1){
            System.out.println("The Number is not exactly divisible");
        }
    }
}
