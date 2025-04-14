package Session5.Question2; 

class Employee implements Comparable<Employee> {
    private final String name;
    private int age;
    private double salary;
    Employee next;
    
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    public double getSalary() {
        return salary;
    }
    // constructor
    Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.next = null;
    }

    @Override
    public int compareTo(Employee o) {
        if (this.getSalary() != o.getSalary()) {
            return Double.compare(o.getSalary(), this.getSalary());
        }
        return Integer.compare(this.age, o.age);
    }
}

