package Retirement;

/**
 * Created by SYSTEM15 on 3/27/2012.
 */
public class Personal {
    String Name;
    long Pan,acc_no;
    double basic_pay;
    Personal(String Name0,long Pan0,double basic_pay0,long acc_no0){
        Name=Name0;
        Pan=Pan0;   basic_pay=basic_pay0;   acc_no=acc_no0;
    }
    Personal(){
        Name="null";
        Pan=0;   basic_pay=0;   acc_no=0;
    }
    void display(){
        System.out.println("Name     :"+Name);
        System.out.println("PAN No.  :"+Pan);
        System.out.println("Basic Pay:"+basic_pay);
        System.out.println("Acc No.  :"+acc_no);
    }
}
