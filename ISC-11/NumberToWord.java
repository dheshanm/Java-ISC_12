import java.util.*;
/**
 * Created by Dheshan M (@D-codex) on 2/29/2016.
 */
public class NumberToWord{
    private static final String[] specialNames = {
            ""," thousand"," million"," billion"," trillion"," quadrillion"," quintillion"};
    private static final String[] tensNames = {
            ""," ten"," twenty"," thirty"," forty"," fifty"," sixty"," seventy"," eighty"," ninety"};
    private static final String[] numNames = {
            ""," one"," two"," three"," four"," five"," six"," seven"," eight"," nine",
            " ten"," eleven"," twelve"," thirteen"," fourteen"," fifteen"," sixteen"," seventeen",
            " eighteen"," nineteen"};

    private String convertLessThanOneThousand(int number) {
        String current;
        if (number % 100 < 20){
            current = numNames[number % 100];
            number /= 100;
        }
        else {
            current = numNames[number % 10];
            number /= 10;

            current = tensNames[number % 10] + current;
            number /= 10;
        }
        if (number == 0) return current;
        return numNames[number] + " hundred" + current;
    }
    public String convert(int number) {
        if (number == 0) { return "zero"; }
        String prefix = "";
        if (number < 0) {
            number = -number;
            prefix = "negative";
        }
        String current = "";
        int place = 0;
        do {
            int n = number % 1000;
            if (n != 0){
                String s = convertLessThanOneThousand(n);
                current = s + specialNames[place] + current;
            }
            place++;
            number /= 1000;
        } while (number > 0);

        return (prefix + current).trim();
    }
    private static String input;
    private static int num;
    private static String[] units= {""," One"," Two"," Three"," Four"," Five"," Six"," Seven"," Eight"," Nine"};
    private static String[] teen= {
            " Ten"," Eleven"," Twelve"," Thirteen"," Fourteen"," Fifteen"," Sixteen"," Seventeen"," Eighteen"," Nineteen"};
    private static String[] tens= {" Twenty"," Thirty"," Forty"," Fifty"," Sixty"," Seventy"," Eighty"," Ninety"};
    private static String[] maxs= {"",""," Hundred"," Thousand"," Lakh"," Crore"};

    public String convertNumberToWords(int n)
    {
        input=numToString(n);
        String converted="";
        int pos=1;
        boolean hun=false;
        while(input.length()> 0)
        {
            if(pos==1) // TENS AND UNIT POSITION
            {   if(input.length()>= 2) // TWO DIGIT NUMBERS
            {
                String temp=input.substring(input.length()-2,input.length());
                input=input.substring(0,input.length()-2);
                converted+=digits(temp);
            }
            else if(input.length()==1) // 1 DIGIT NUMBER
            {
                converted+=digits(input);
                input="";
            }
                pos++;
            }
            else if(pos==2) // HUNDRED POSITION
            {
                String temp=input.substring(input.length()-1,input.length());
                input=input.substring(0,input.length()-1);
                if(converted.length()> 0&&digits(temp)!="")
                {
                    converted=(digits(temp)+maxs[pos]+" and")+converted;
                    hun=true;
                }
                else
                {
                    if (digits(temp)=="");
                    else converted=(digits(temp)+maxs[pos])+converted;hun=true;
                }
                pos++;
            }
            else if(pos > 2) // REMAINING NUMBERS PAIRED BY TWO
            {
                if(input.length()>= 2) // EXTRACT 2 DIGITS
                {
                    String temp=input.substring(input.length()-2,input.length());
                    input=input.substring(0,input.length()-2);
                    if(!hun&&converted.length()> 0)
                        converted=digits(temp)+maxs[pos]+" and"+converted;
                    else
                    {
                        if(digits(temp)=="")  ;
                        else converted=digits(temp)+maxs[pos]+converted;
                    }
                }
                else if(input.length()==1) // EXTRACT 1 DIGIT
                {
                    if(!hun&&converted.length()> 0)
                        converted=digits(input)+maxs[pos]+" and"+converted;
                    else
                    {
                        if(digits(input)=="")  ;
                        else converted=digits(input)+maxs[pos]+converted;
                        input="";
                    }
                }
                pos++;
            }
        }
        return converted;
    }
    private String digits(String temp) // TO RETURN SELECTED NUMBERS IN WORDS
    {
        String converted="";
        for(int i=temp.length()-1;i >= 0;i--) {
            int ch=temp.charAt(i)-48;
            if(i==0&&ch>1 && temp.length()> 1)
                converted=tens[ch-2]+converted; // IF TENS DIGIT STARTS WITH 2 OR MORE IT FALLS UNDER TENS
            else if(i==0&&ch==1&&temp.length()==2) // IF TENS DIGIT STARTS WITH 1 IT FALLS UNDER TEENS
            {
                int sum=0;
                for(int j=0;j < 2;j++)
                    sum=(sum*10)+(temp.charAt(j)-48);
                return teen[sum-10];
            }
            else
            {
                if(ch > 0)
                    converted=units[ch]+converted;
            } // IF SINGLE DIGIT PROVIDED
        }
        return converted;
    }
    private String numToString(int x) // CONVERT THE NUMBER TO STRING
    {
        String num = "";
        while (x != 0) {
            num = ((char) ((x % 10) + 48)) + num;
            x /= 10;
        }
        return num;
    }
    public static String getRomanNumeral(int arabicNumber) {
        if (arabicNumber > 0 && arabicNumber < 4000) {
            final LinkedHashMap<Integer, String> numberLimits = new LinkedHashMap<>();

            numberLimits.put(1, "I");
            numberLimits.put(4, "IV");
            numberLimits.put(5, "V");
            numberLimits.put(9, "IX");
            numberLimits.put(10, "X");
            numberLimits.put(40, "XL");
            numberLimits.put(50, "L");
            numberLimits.put(90, "XC");
            numberLimits.put(100, "C");
            numberLimits.put(400, "CD");
            numberLimits.put(500, "D");
            numberLimits.put(900, "CM");
            numberLimits.put(1000, "M");
            String romanNumeral = "";

            while (arabicNumber > 0) {
                int highestFound = 0;
                for (Map.Entry<Integer, String> current : numberLimits.entrySet()){
                    if (current.getKey() <= arabicNumber)
                        highestFound = current.getKey();
                }
                romanNumeral += numberLimits.get(highestFound);
                arabicNumber -= highestFound;
            }
            return romanNumeral;
        }
        else {
            return("Input Invalid or <4000");
        }
    }

    public static void main(String[] args) {
        NumberToWord obj = new NumberToWord();
        Scanner in=new Scanner(System.in);
        System.out.print("Enter the number you want converted   :");
        int input=in.nextInt();
        System.out.println("_________________________________________________________");
        System.out.println("International :"+obj.convert(input));
        System.out.println("Indian        :"+obj.convertNumberToWords(input).trim());
        System.out.println("Roman         :"+obj.getRomanNumeral(input));
    }
}
