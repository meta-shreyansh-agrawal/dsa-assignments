package Session1; 

class Node{
    int data; 
    Node next; 
    Node(int val){
        this.data = val; 
    }
}

public class Question2 {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(4);
        head.next.next.next = head.next;

        if(detectLoop(head))System.out.println("true");
        else System.out.println("false");
    }
    
    public static boolean detectLoop(Node head){
        if(head==null)return false; 
        Node slow = head,fast = head; 

        while(fast!=null && fast.next!=null){
            slow = slow.next; 
            fast = fast.next.next; 
            if(slow == fast)return true; 
        }
        return false; 
    }
}
