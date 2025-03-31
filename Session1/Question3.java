package Session1;

class ListNode{
    int cofficient; 
    ListNode next; 
    NestedNode head;

    public ListNode(int cofficient){
        this.cofficient = cofficient; 
    }
}

class NestedNode{
    int power; 
    char variable; 
    NestedNode next;

    public NestedNode(char variable,int power){
        this.variable = variable; 
        this.power = power; 
    }
}

public class Question3 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(5);
        node1.next = node2;

        NestedNode innerNode1 = new NestedNode('x', 2);
        NestedNode innerNode2 = new NestedNode('y', 3);
        innerNode1.next = innerNode2;
        node1.head = innerNode1;

        NestedNode innerNode3 = new NestedNode('z', 1);
        node2.head = innerNode3;

        int maxDegree = degree(node1);
        System.out.println(maxDegree);

    }

    public static int degree(ListNode head){
        int degree = 0; 
        if(head==null)return degree; 
        while(head!=null){
            int powSum = 0; 
            NestedNode temp = head.head; 
            while(temp!=null){
                powSum += temp.power; 
                temp = temp.next; 
            }
            degree += powSum; 
            head = head.next; 
        }
        return degree; 
    }
}

