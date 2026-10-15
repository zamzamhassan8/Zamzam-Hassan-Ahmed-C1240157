package hospital;

public class Bukaan {
    String Name;
    int fee;
    Bukaan(String name,int fee){
        this. Name=name;
        this.fee=fee;

    }
    public void Display(){
        System.out.println("bukaanka magacisa:"+Name);
        System.out.println("lacagta numberka:"+fee);
    }
}
class Bukaansocod extends Bukaan {
    double labcharges;

    Bukaansocod(String name, int fee, double labcharges) {
        super(name, fee);
        this.labcharges = labcharges;
    }

    public void calculateBill() {
        double Bill = labcharges + fee;
        System.out.println("Bill:" + Bill);
    }


    public void DisplayBukaansocod(){
        Display();

        System.out.println("labcharges:"+labcharges);
        calculateBill();

    }
}

class Bukaanjiif extends Bukaan{
    double Roomcharges;
    int Numberofdays;
    Bukaanjiif(String name,int fee,double roomcharges,int numberofdays){
        super(name,fee);
        this.Roomcharges=roomcharges;
        this.Numberofdays=numberofdays;
    }
    public void calculateBill(){
        double Biil=(Roomcharges*Numberofdays)+fee;
        System.out.println("Bill:"+Biil);
    }

    public void DisplayBukaanjiif(){
        Display();

        System.out.println("Roomcharges:"+Roomcharges);
        System.out.println("numberofdays:"+Numberofdays);
        calculateBill();

    }
}
