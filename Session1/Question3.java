package Session1;

import Utility.Utils; // Import your Utils class for input validation
import java.util.Scanner;

class ListNode {
    int coefficient;
    ListNode next;
    NestedNode head;

    public ListNode(int coefficient) {
        this.coefficient = coefficient;
    }
}

class NestedNode {
    int power;
    char variable;
    NestedNode next;

    public NestedNode(char variable, int power) {
        this.variable = variable;
        this.power = power;
    }
}

public class Question3 {

    public static int degree(ListNode head) {
        int degree = 0;
        if (head == null) return degree;
        while (head != null) {
            int powSum = 0;
            NestedNode temp = head.head;
            while (temp != null) {
                powSum += temp.power;
                temp = temp.next;
            }
            degree = Math.max(powSum, degree);
            head = head.next;
        }
        return degree;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create the list
        System.out.println("Enter the number of Terms:");
        int numListNodes = Utils.inputNaturalNumber(sc);

        ListNode head = null, tail = null;

        for (int i = 0; i < numListNodes; i++) {
            System.out.println("Enter the coefficient for Term " + (i + 1) + ":");
            int coefficient = Utils.inputInteger(sc); 
            ListNode newNode = new ListNode(coefficient);

            System.out.println("Enter the number of variables for the term:");
            int numNestedNodes = Utils.inputNaturalNumber(sc);

            NestedNode nestedHead = null, nestedTail = null;

            for (int j = 0; j < numNestedNodes; j++) {
                System.out.println("Enter the variable (single character) " + (j + 1) + ":");
                char variable = sc.next().charAt(0);
                System.out.println("Enter the power for variable " + (j + 1) + ":");
                int power = Utils.inputNaturalNumber(sc);

                NestedNode newNestedNode = new NestedNode(variable, power);

                if (nestedHead == null) {
                    nestedHead = newNestedNode;
                    nestedTail = nestedHead;
                } else {
                    nestedTail.next = newNestedNode;
                    nestedTail = newNestedNode;
                }
            }
            newNode.head = nestedHead;

            if (head == null) {
                head = newNode;
                tail = head;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        //display the degree
        int maxDegree = degree(head);
        System.out.println("The maximum degree of the expression is: " + maxDegree);
        sc.close();
    }
}