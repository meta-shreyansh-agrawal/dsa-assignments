package Session1; 

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

    public static void main(String[] args) {
        Node head = new Node(2);
        head.next = new Node(3);
        head.next.next = new Node(4);
        head.next.next.next = new Node(5);
        head.next.next.next.next = new Node(6);
        head.next.next.next.next.next = new Node(7);
        System.out.println("Original Linked List:");
        printList(head);
        head = rotateSubList(head, 2,5,2);
        System.out.println("Modified Linked List:");
        printList(head);
    }
    
    public static Node rotateSubList(Node head, int L, int R, int N) {
        if(head == null)return head; 
        Node a = head;  
        for(int i = 0;i<L-2;i++){
            a = a.next; 
        }
        Node b = a; 
        for(int i = 0;i<N;i++){
            b =  b.next; 
        }
        Node c = head; 
        for(int i = 0;i<R-1;i++){
            c = c.next; 
        }
        Node d = c.next; 
        c.next = a.next; 
        a.next = b.next; 
        b.next = d; 
        return head; 
    }
}