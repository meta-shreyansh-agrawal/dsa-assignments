package Session1;

import Utility.Utils;
import java.util.Scanner;

public class Question1 {

    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.println("null");
    }

    public static Node rotateSubList(Node head, int L, int R, int N) {
        if (head == null || L >= R) return head;
        
        int sublistLength = R - L + 1;
        N %= sublistLength;
        if (N == 0) return head;
    
        Node dummy = new Node(0); 
        dummy.next = head;
        Node a = dummy; 
        for (int i = 0; i < L - 1; i++) a = a.next;
    
        Node b = a.next; // First node of sublist
        Node c = b; 
        for (int i = 0; i < sublistLength - 1; i++) c = c.next;
    
        Node d = c.next;
    
        Node newHead = b;
        for (int i = 0; i < sublistLength - N; i++) newHead = newHead.next;
    
        c.next = b; 
        a.next = newHead;
        for (int i = 0; i < sublistLength - N - 1; i++) b = b.next;
        b.next = d; 
    
        // Return modified list
        return dummy.next; 
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Get Linked List Input
        System.out.println("Enter the number of nodes in the linked list:");
        int numNodes = Utils.inputNaturalNumber(sc);
        System.out.println("Enter the values of the nodes:");
        Node head = new Node(Utils.inputNaturalNumber(sc));
        Node current = head;
        for (int i = 1; i < numNodes; i++) {
            current.next = new Node(Utils.inputNaturalNumber(sc));
            current = current.next;
        }

        System.out.println("Original Linked List:");
        printList(head);

        // Step 2: Get Input for L, R, N
        System.out.println("Enter the value of L (start index of the sublist):");
        int L = Utils.inputNumberInRange(sc, 1, numNodes);
        System.out.println("Enter the value of R (end index of the sublist):");
        int R = Utils.inputNumberInRange(sc, L, numNodes);
        System.out.println("Enter the value of N (number of rotations):");
        int N = Utils.inputNumberInRange(sc, 0, R - L + 1);

        // Step 3: Modify Linked List
        head = rotateSubList(head, L, R, N);
        System.out.println("Modified Linked List:");
        printList(head);

        sc.close();
    }
}