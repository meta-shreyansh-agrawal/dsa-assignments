package Session5.Question1; 

public class Node {
    int key;
    String value;
    Node left, right;

    Node(int key, String value) {
        this.key = key;
        this.value = value;
        left = right = null;
    }
}