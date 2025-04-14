package Session5.Question2;

public class EmployeeLinkedList {

    Employee head; 

    public void insert(String name, int age , int salary){
        Employee emp = new Employee(name, age, salary); 
        if(head==null)head = emp; 
        else {
            Employee temp = head; 
            while(temp.next!=null)temp=temp.next; 
            temp.next = emp; 
        }
    }

    void sort() {
        if (head == null || head.next == null) return; // Empty or single node list
        Employee sorted = null; // Head of sorted list
        Employee current = head;
        //Inserting each node one by one into sorted order
        while (current != null) {
            Employee next = current.next;
            sorted = insertSorted(sorted, current);
            current = next;
        }
        head = sorted;
    }

    // Helper for sort to insert into sorted
    private Employee insertSorted(Employee sorted, Employee newEmployee) {
        if (sorted == null || sorted.compareTo(newEmployee) > 0) {
            newEmployee.next = sorted;
            return newEmployee;
        } else {
            Employee current = sorted;
            while (current.next != null && current.next.compareTo(newEmployee) <= 0) {
                current = current.next;
            }
            newEmployee.next = current.next;
            current.next = newEmployee;
        }
        return sorted;
    }

    void display() {
        Employee temp = head;
        while (temp != null) {
            System.out.println("Name: " + temp.getName() + ", Age: " + temp.getAge() + ", Salary: " + temp.getSalary());
            temp = temp.next;
        }
    }

}