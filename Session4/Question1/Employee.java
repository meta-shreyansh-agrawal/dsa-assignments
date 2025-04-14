package Session4.Question1;

import java.util.Objects;

public class Employee{
    private static int idCount = 1; 

    private final int id;
    private final String name; 
    private final String adress;

    public Employee(String name, String adress) {
        this.id = idCount++;
        this.name = name;
        this.adress = adress;
    } 

    // To add duplicate Employees using id,name,adress;
    public Employee(int id, String name,String adress){
        this.id = id; 
        this.name = name; 
        this.adress = adress; 
    }

    public int getId(){
        return this.id; 
    }

    public String getName(){
        return this.name; 
    }
    
    // Printing whole object with all details
    public void print(){
        System.out.println("Id: "+this.id+"\nName: "+this.name+"\nAdress: "+this.adress);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id); 
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj)return true; // same reference
        if (obj == null || getClass() != obj.getClass()) return false; // Null or different class
        Employee emp = (Employee)obj;
        return this.getId() == emp.getId(); 
    }
}