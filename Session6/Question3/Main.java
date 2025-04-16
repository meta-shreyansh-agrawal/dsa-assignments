package Session6.Question3;

import java.util.Scanner;

import Utility.Utils;

public class Main {

    public static void main(String[] args) {
        //create an instance of EmployeeLinkedList
        EmployeeList employeeList = new EmployeeList();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of employees:");
        int n = Utils.inputNaturalNumber(scanner); 

        // take input for employees
        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for Employee " + (i + 1) + ":");
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Age: ");
            int age = Utils.inputNaturalNumber(scanner); 
            System.out.print("Salary: ");
            int salary = Utils.inputWholeNumber(scanner); 
            employeeList.insert(name, age, salary);
        }

        System.out.println("Before Sorting:");
        employeeList.display();    // Display the list before sorting

        // Sort the employee list
        employeeList.sort();

         // Display the list after sorting
        System.out.println("After Sorting:");
        employeeList.display();

        scanner.close();
    }
}