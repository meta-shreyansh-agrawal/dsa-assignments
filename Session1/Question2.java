package Session1;

import Utility.Utils; // Import Utils class
import java.util.Scanner;

class Node {
    int data;
    Node next;
    Node(int val) {
        this.data = val;
    }
}

public class Question2 {
    public static boolean detectLoop(Node head) {
        if (head == null) return false;
        Node slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Create Linked List
        System.out.println("Enter the number of nodes in the linked list:");
        int numNodes = Utils.inputNaturalNumber(sc); // Validates natural number input
        
        Node head = null, tail = null;
        System.out.println("Enter the values of the nodes:");
        for (int i = 0; i < numNodes; i++) {
            int nodeValue = Utils.inputNaturalNumber(sc);
            Node newNode = new Node(nodeValue);
            if (head == null) {
                head = newNode;
                tail = head;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        // Step 2: Create Loop
        System.out.println("Do you want to create a loop in the linked list? (yes/no)");
        String createLoop = sc.nextLine().trim().toLowerCase();
        if (createLoop.equals("yes")) {
            System.out.println("Enter the position (1-based index) to link the last node:");
            int loopPosition = Utils.inputNumberInRange(sc, 1, numNodes);
            Node current = head;
            for (int i = 1; i < loopPosition; i++) {
                current = current.next;
            }
            tail.next = current;
            System.out.println("Loop created at position " + loopPosition);
        } else {
            System.out.println("No loop created.");
        }

        // Step 3: Detect Loop
        if (detectLoop(head))System.out.println("Loop detected in the linked list.");
        else System.out.println("No loop detected in the linked list.");
        sc.close();
    }
}