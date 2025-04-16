package Session6.Question3;

import Session5.Question2.Employee;
import Session5.Question2.EmployeeLinkedList;

public class EmployeeList extends EmployeeLinkedList {
    
    @Override
    public void sort() {
        head = quickSort(head, getTail(head));
    }

    //quick sort main method
    private Employee quickSort(Employee start, Employee end) {
        if (start == null || start == end || start == end.next) return start;

        Employee[] partitionResult = partition(start, end);
        Employee newHead = partitionResult[0];
        Employee pivot = partitionResult[1];
        Employee newTail = partitionResult[2];

        if (newHead != pivot) {
            Employee temp = newHead;
            while (temp.next != pivot) temp = temp.next;
            temp.next = null;

            newHead = quickSort(newHead, temp);

            temp = getTail(newHead);
            temp.next = pivot;
        }

        pivot.next = quickSort(pivot.next, newTail);

        return newHead;
    }

    //Partition the linked list
    private Employee[] partition(Employee start, Employee end) {
        Employee pivot = end;
        Employee prev = null, curr = start, tail = pivot;
        Employee newHead = null, newTail = pivot;

        while (curr != pivot) {
            if (curr.compareTo(pivot) < 0) {
                if (newHead == null) newHead = curr;
                prev = curr;
            } else {
                if (prev != null) prev.next = curr.next;
                Employee temp = curr.next;
                curr.next = null;
                tail.next = curr;
                tail = curr;
                curr = temp;
                continue;
            }
            curr = curr.next;
        }

        if (newHead == null) newHead = pivot;

        newTail = tail;

        return new Employee[] { newHead, pivot, newTail };
    }

    // to get the tail of the list
    private Employee getTail(Employee node) {
        while (node != null && node.next != null) node = node.next;
        return node;
    }

}
