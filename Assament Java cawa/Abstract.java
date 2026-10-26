package Assamentcawa;

abstract class MedicalService {
    String serviceId;
    String serviceName;
    double baseCost;

    MedicalService(String serviceId, String serviceName, double baseCost) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.baseCost = baseCost;
    }

    abstract double calculateTotalCost();

    void displayServiceInfo() {
        System.out.println("Service ID: " + serviceId);
        System.out.println("Service: " + serviceName);
        System.out.printf("Total Cost:"+ calculateTotalCost());
        System.out.println();
    }
}

class Consultation extends MedicalService {
    double drMoney;

    Consultation(String serviceId, String serviceName, double baseCost, double drMoney) {
        super(serviceId, serviceName, baseCost);
        this.drMoney = drMoney;
    }

    @Override
    double calculateTotalCost() {
        return baseCost + drMoney;
    }
}

class LaboratoryTest extends MedicalService {
    double labCharge;

    LaboratoryTest(String serviceId, String serviceName, double baseCost, double labCharge) {
        super(serviceId, serviceName, baseCost);
        this.labCharge = labCharge;
    }

    @Override
    double calculateTotalCost() {
        return baseCost + labCharge;
    }
}

class Ultrasound extends MedicalService {
    double ultraCost;

    Ultrasound(String serviceId, String serviceName, double baseCost, double ultraCost) {
        super(serviceId, serviceName, baseCost);
        this.ultraCost = ultraCost;
    }

    @Override
    double calculateTotalCost() {
        return baseCost + ultraCost;
    }
}

class AMLA {
    public static void main(String[] args) {
        MedicalService obj = new Consultation("S001", "Consultation", 15, 10);
        MedicalService obj1 = new LaboratoryTest("S002", "Laboratory Test", 10, 8);
        MedicalService obj2 = new Ultrasound("S003", "Ultrasound", 30, 10);

        System.out.println("==HOSPITAL BILLING SYSTEM ==");
        System.out.println();

        obj.displayServiceInfo();
        obj1.displayServiceInfo();
        obj2.displayServiceInfo();

        double total = obj.calculateTotalCost() + obj1.calculateTotalCost() + obj2.calculateTotalCost();

        System.out.println("---");
        System.out.printf("Total Hospital Bill:"+ total);
    }
}