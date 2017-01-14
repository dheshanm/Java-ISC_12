package Retirement;

/**
 * Created by SYSTEM15 on 3/27/2012.
 */
public class Retire extends Personal{
    int Yrs;
    double Pf,Grat;
    Retire(int Yrs0,String Name0,long Pan0,double basic_pay0,long acc_no0){
        Yrs=Yrs0;
        Name=Name0;
        Pan=Pan0;   basic_pay=basic_pay0;   acc_no=acc_no0;
    }
    void provident(){
        Pf=(0.02*basic_pay)*Yrs;
    }
    void gratuity(){
        if(Yrs>=10){
            Grat=10*basic_pay;
        }
        else
            Grat=0;

    }
    void display1(){
        display();
        System.out.println("PF       :"+Pf);
        System.out.println("Gratuity :"+Grat);
    }
}
