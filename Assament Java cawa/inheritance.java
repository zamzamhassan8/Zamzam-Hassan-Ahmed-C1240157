package Assamentcawa;

class Employee {
     String id;
     String name;
     String department;
    double salary;
    String Cetogrey;


    public Employee(String id, String name, String department, double salary,String cetogrey) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.Cetogrey=cetogrey;
    }

    public double calculateSalary() {
        return salary;
    }

    public void displayInfo() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("cetogrey:" + Cetogrey);
        System.out.println("salarey:" + salary);
    }
}

class FullTimeEmployee extends Employee {
    double allowance;

    public FullTimeEmployee(String id, String name, String department, double salary, double allowance ,String Cetogrey) {
        super(id, name, department, salary,Cetogrey);
        this.allowance = allowance;
    }

    @Override
    public double calculateSalary() {
        return salary + allowance;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
    }
}

class PartTimeEmployee extends Employee {
     int hours;
     int rate;

    public PartTimeEmployee(String id, String name, String department,double salary,String Cetogrey,int hours,int rate) {
        super(id, name, department,salary,Cetogrey);
        this.hours= hours;
        this.rate = rate;
    }

    @Override
    public double calculateSalary() {
        return hours * rate;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
    }
}

class Manager extends Employee {
     double bonus;

    public Manager(String id, String name, String department, double salary, String Cetogry,double bonus) {
        super(id, name, department, salary,Cetogry);
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return salary + bonus;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
    }
}

class EmployeeManagementSystem {
    public static void main(String[] args) {
        Employee e1 = new FullTimeEmployee("EMP001", "Ahmed Ali", "HR", 500, 150,"fulltime");
        Employee e2 = new PartTimeEmployee("EMP002", "Fatima Hassan", "Support",600,"parttime",23,500);
        Employee e3 = new Manager("EMP003", "Mohamed Omar", "Operations", 900,"manager",25);

        Employee[] employees = {e1, e2, e3};

        System.out.println(" EMPLOYEE SALARY REPORT");
        for (Employee e : employees) {
            e.displayInfo();
        }
    }
}