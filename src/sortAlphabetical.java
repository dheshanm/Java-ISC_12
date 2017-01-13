import java.util.*;

/**
 * Created by D'codex on January 2017.
 */
public class sortAlphabetical {
    public static void main(String Args[]){
        Scanner in=new Scanner(System.in);
        String arr[];
        System.out.println("Do you want to Enter the words to be sorted individually or as a String :");
        System.out.print("Enter 1 to enter individually or other number to enter as a String  :");
        int choice=in.nextInt();
        switch (choice){
            case 1:
                boolean f=false;
                System.out.print("Do you want sorting to be case SENSITIVE    :");
                f=in.nextBoolean();
                Scanner in0=new Scanner(System.in);
                System.out.println("Enter the number of words to be sorted   :");
                int temp=in0.nextInt();
                arr=new String[temp];
                System.out.println("Enter "+temp+" words");
                for (int i=0;i<temp;i++){
                    if(f)
                        arr[i]=in0.nextLine();
                    else
                        arr[i]=in0.nextLine().toUpperCase();
                }
                break;

            default:
                boolean f0=false;
                System.out.print("Do you want sorting to be case SENSITIVE    :");
                f=in.nextBoolean();
                Scanner in1=new Scanner(System.in);
                System.out.println("Enter the String with words to be sorted    :");
                String temp0=in1.nextLine();
                StringTokenizer st=new StringTokenizer(temp0);
                arr=new String[st.countTokens()];
                int i=0;
                while (st.hasMoreTokens()){
                    if (f0)
                        arr[i]=st.nextToken();
                    else
                        arr[i]=st.nextToken().toUpperCase();
                    i=i+1;
                }
        }
        for(int i=0;i<arr.length;i++){
            for (int j=i+1;j<arr.length;j++){
                if(arr[i].compareTo(arr[j])>0){
                    String temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        System.out.println("SORTED LIST");
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
