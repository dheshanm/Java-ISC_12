import java.util.Scanner;

/**
 * Created by D'codex on July 2016.
 */
public class calculator {
    public static String removePoint(String in){
        int l=in.length();
        char ch,ch1;
        for(int i=l-1;i>0;i--){
            ch=in.charAt(i);
            ch1=in.charAt(i-1);
            if((ch=='0')&&(ch1=='.')){
                in=in.substring(0,i-1);
                break;
            }
        }
        return(in);
    }
    public static char[] deleteArraychar(char c,char a[],int u){
        char b[]=new char [25];
        int j=0;
        for(int i=0;i<=u;i++){
            if(a[i]!=c){
                b[j]=a[i];
                j=j+1;
            }
        }
        return b;
    }
    public static double[] deleteArraydouble(double c,double a[],int u){
        double b[]=new double [25];
        int j=0;
        for(int i=0;i<=u;i++){
            if(a[i]!=c){
                b[j]=a[i];
                j=j+1;
            }
        }
        return b;
    }
    public static double CalculatorMain (String input){
        String buffer;
        double numbuffer;
        int u=0,l;
        char buf,check;
        input=input.trim();
        l=input.length();
        if(input.charAt(0)=='(' && input.charAt(l-1)==')')
            input=input.substring(1,l-1);
        input=input+" ";
        l=input.length();
        String buffRecursive;
        double num[]=new double[25];
        char func[]=new char[25];
        for(int i=0;i<l;i++){
            char chk=input.charAt(i);
            if(!Character.isDigit(chk)){
                if(chk=='('){
                    for(int j=i+1;i<l;j++){
                        char chk0=input.charAt(j);
                        if (chk0==')'){
                            buffRecursive=input.substring(i+1,j);
                            num[u] =CalculatorMain(buffRecursive);
                            check=input.charAt(j+1);
                            if(check!=' ') {
                                func[u]=input.charAt(j+1);
                                input=input.substring(j+2);
                                u = u + 1;
                                l = input.length();
                                i = 0;
                            }
                            else{
                                u = u + 1;
                                l = 0;
                                i = 0;
                            }
                            break;
                        }
                    }
                }
                else if(chk!='.') {
                    if(chk!=' ') {
                        check=input.charAt(0);
                        if (!Character.isDigit(check)){//check == '(') {
                            buffer = input.substring(1, i);
                        }
                        else {
                            buffer = input.substring(0, i);
                        }
                        numbuffer = Double.parseDouble(buffer);
                        num[u] = numbuffer;
                        buf = input.charAt(i);
                        func[u] = buf;
                        input = input.substring(i + 1);
                        u = u + 1;
                        l = input.length();
                        i = 0;
                    }
                }
            }
        }
        if (Character.isDigit(input.charAt(0))) {
            input = input.trim();
            numbuffer = Double.parseDouble(input);
            num[u] = numbuffer;
        }
        else{
            input = input.trim();
            input=input.substring(1);
            numbuffer = Double.parseDouble(input);
            num[u] = numbuffer;
        }
        for(int i=0;i<=u;i++){
            switch(func[i]){
                case '+':
                    num[i+1]=num[i]+num[i+1];
                    break;

                case '*':
                    num[i+1]=num[i]*num[i+1];
                    break;

                case '/':
                    num[i+1]=num[i]/num[i+1];
                    break;

                case '-':
                    num[i+1]=num[i]-num[i+1];
                    break;
            }
        }
        double ans=num[u];
        //String output=String.valueOf(ans);
        //output=removePoint(output);
        return(ans);
    }
    public static double calcBODMAS(String input){
        String buffer;
        double numbuffer;
        int u=0,l,cons=0;
        char buf,check;
        input=input.trim();
        l=input.length();
        if(input.charAt(0)=='(' && input.charAt(l-1)==')')
            input=input.substring(1,l-1);
        input=input+" ";
        l=input.length();
        String buffRecursive;
        double num[]=new double[25];
        char func[]=new char[25];
        for(int i=0;i<l;i++){
            char chk=input.charAt(i);
            if(!Character.isDigit(chk)){
                if(chk=='('){
                    for(int j=i+1;i<l;j++){
                        char chk0=input.charAt(j);
                        if (chk0==')'){
                            buffRecursive=input.substring(i+1,j);
                            num[u] =calcBODMAS(buffRecursive);
                            check=input.charAt(j+1);
                            if (check == ' ') {
                                u = u + 1;
                                l = 0;
                                i = 0;
                            }
                            else {
                                func[u]=input.charAt(j+1);
                                input=input.substring(j+2);
                                u = u + 1;
                                l = input.length();
                                i = 0;
                            }
                            break;
                        }
                    }
                }
                else if(chk!='.') {
                    if(chk!=' ') {
                        check=input.charAt(0);
                        if (!Character.isDigit(check)){//check == '(') {
                            buffer = input.substring(1, i);
                        }
                        else {
                            buffer = input.substring(0, i);
                        }
                        numbuffer = Double.parseDouble(buffer);
                        num[u] = numbuffer;
                        buf = input.charAt(i);
                        func[u] = buf;
                        input = input.substring(i + 1);
                        u = u + 1;
                        l = input.length();
                        i = 0;
                    }
                }
            }
        }
        if (Character.isDigit(input.charAt(0))) {
            input = input.trim();
            numbuffer = Double.parseDouble(input);
            num[u] = numbuffer;
        }
        else{
            input = input.trim();
            input=input.substring(1);
            numbuffer = Double.parseDouble(input);
            num[u] = numbuffer;
        }
        for(int i=0;i<=4;i++){
            cons=cons+1;
            for(int j=0;j<=u;j++){
                if(cons==1){
                    if(func[j]=='/'){
                        num[j]=num[j]/num[j+1];
                        func[j]='x';
                        func=deleteArraychar('x',func,u);
                        num[j+1]=1.147;
                        num=deleteArraydouble(1.147,num,u);
                        u=u-1;
                    }
                }
                if(cons==2){
                    if(func[j]=='*'){
                        num[j]=num[j]*num[j+1];
                        func[j]='x';
                        func=deleteArraychar('x',func,u);
                        num[j+1]=1.147;
                        num=deleteArraydouble(1.147,num,u);
                        u=u-1;
                    }
                }
                if(cons==3){
                    if(func[j]=='+'){
                        num[j]=num[j]+num[j+1];
                        func[j]='x';
                        func=deleteArraychar('x',func,u);
                        num[j+1]=1.147;
                        num=deleteArraydouble(1.147,num,u);
                        u=u-1;
                    }
                }
                if(cons==4){
                    if(func[j]=='-'){
                        num[j]=num[j]-num[j+1];
                        func[j]='x';
                        func=deleteArraychar('x',func,u);
                        num[j+1]=1.147;
                        num=deleteArraydouble(1.147,num,u);
                        u=u-1;
                    }
                }
            }
        }

        double ans=num[0];
        //String output=String.valueOf(ans);
        //output=removePoint(output);
        return(ans);
    }
    public static void main(String Args[]){
        Scanner in=new Scanner(System.in);
        System.out.print("Do you want to enable BODMAS rule ?");
        String choice=in.nextLine();
        String input,anss;
        double answer;
        switch (choice){
            case "1":
                System.out.print("Enter an Expression     :");
                input=in.nextLine();
                answer=calcBODMAS(input);
                anss=String.valueOf(answer);
                anss=removePoint(anss);
                System.out.print("RESULT :"+anss);
                break;
            default:
                System.out.print("Enter an Expression     :");
                input=in.nextLine();
                answer=CalculatorMain(input);
                anss=String.valueOf(answer);
                anss=removePoint(anss);
                System.out.print("RESULT :"+anss);
        }

    }
}
