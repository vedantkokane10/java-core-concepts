import java.util.*;


abstract class Employee{
    private int employeeID;
    private String employeeName;
    private String employeeDepartment;
    
    Employee(int employeeID, String employeeName, String employeeDepartment){
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.employeeDepartment = employeeDepartment;
    }
    
    public String getEmployeeName(){
        return this.employeeName;
    }
    
    public int getEmployeeId(){
        return this.employeeID;
    }
    
    public String getEmployeeDepartment(){
        return this.employeeDepartment;
    }
    
    public abstract double calculateSalary();
}

class FullTimeEmployee extends Employee{
    private double bonusAmount;
    private double baseSalary;
    
    FullTimeEmployee(int employeeID, String employeeName, String employeeDepartment, double baseSalary, double bonusAmount){
        super(employeeID, employeeName, employeeDepartment);
        this.baseSalary = baseSalary;
        this.bonusAmount = bonusAmount;
    }
    
    @Override
    public double calculateSalary(){
        return this.baseSalary + this.bonusAmount;
    }
}

class PartTimeEmployee extends Employee{
    private double workingHours;
    private double ratePerHour;
    
    PartTimeEmployee(int employeeID, String employeeName, String employeeDepartment, double workingHours, double ratePerHour){
        super(employeeID, employeeName, employeeDepartment);
        this.workingHours = workingHours;
        this.ratePerHour = ratePerHour;
    }
    
    @Override
    public double calculateSalary(){
        return this.workingHours * this.ratePerHour;
    }

}

class Intern extends Employee{
    private double stipend;
    
    Intern(int employeeID, String employeeName, String employeeDepartment, double stipend){
        super(employeeID, employeeName, employeeDepartment);
        this.stipend = stipend;
    }
    
    @Override
    public double calculateSalary(){
        return this.stipend;
    }
}

public class Main
{
	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<>();
		employees.add(new FullTimeEmployee(101, "Raj", "IT", 800000, 200000));
		employees.add(new PartTimeEmployee(102, "Yash", "IT", 4000,6));
		employees.add(new Intern(103, "Ved", "IT", 20000));
	    for(Employee x:employees){
	        System.out.println(x.getEmployeeName() + " from " + x.getEmployeeDepartment() + " deptartment has monthly salary/stipend of - " + x.calculateSalary());
	    }
	    
	}
}