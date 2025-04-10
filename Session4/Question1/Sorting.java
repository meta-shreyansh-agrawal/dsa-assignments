package Session4.Question1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import Utility.Utils;

public class Sorting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        List<Employee> employees = new ArrayList<Employee>(); 

        System.out.println("Enter the number of Employees");
        int count = Utils.inputNaturalNumber(sc);

        for(int i = 0; i<count; i++){
            System.out.print((i+1)+")Enter Employee name: ");
            String name = sc.nextLine(); 
            System.out.println((i+1)+")Enter Address: ");
            String adress = sc.nextLine(); 
            Employee emp = new Employee(name, adress); 
            employees.add(emp); 
        }

        System.out.println("Employees Sorting on Natural Order");
        employees.sort(Comparator.comparing(Employee::getId)); 
        for(Employee emp: employees)emp.print();
        
        System.out.println("Employees Sorting on Name");
        employees.sort(Comparator.comparing(Employee::getName)); 
        for(Employee emp: employees)emp.print(); 
        
        System.out.println("Enter number of more Employees to Add");
        int extra = Utils.inputWholeNumber(sc);

        for(int i = 0; i<extra; i++){
            System.out.print((i+1)+")Enter Employee Id: ");
            int id = Utils.inputNaturalNumber(sc); 
            System.out.print((i+1)+")Enter Employee name: ");
            String name = sc.nextLine(); 
            System.out.println((i+1)+")Enter Address: ");
            String adress = sc.nextLine(); 
            Employee emp = new Employee(id,name, adress); 
            employees.add(emp); 
        }

        Set<Employee> set = new HashSet<>(employees);
        System.out.println("All unique Employees");
        for(Employee emp: set)emp.print(); 
        
    }
}
