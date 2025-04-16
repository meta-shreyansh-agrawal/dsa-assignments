package Session5.Question1; 

import java.util.*;

import Utility.Utils;

class DictionaryBST implements DictonaryInterface {
    
    private Node root;

    //constructor to initialize the dictionary with given key-value pairs
    public DictionaryBST(Map<Integer, String> initialEntries) {
        root = null;
        for (Map.Entry<Integer, String> entry : initialEntries.entrySet()) {
            add(entry.getKey(), entry.getValue());
        }
    }

    // Add a key-value pair to the dictionary
    public void add(int key, String value) {
        root = addRecursively(root, key, value);
    }

    //helper to add value
    private Node addRecursively(Node node, int key, String value) {
        if (node == null) {
            return new Node(key, value);
        }
        if (key < node.key) {
            node.left = addRecursively(node.left, key, value);
        } else if (key > node.key) {
            node.right = addRecursively(node.right, key, value);
        } else { //updagte the current value
            node.value = value;
        }
        return node;
    }

    // delete a key-value pair from the dictionary
    public void delete(int key) {
        root = deleteRecursively(root, key);
    }

    private Node deleteRecursively(Node node, int key) {
        if (node == null) {
            return null;
        }
        if (key < node.key) {
            node.left = deleteRecursively(node.left, key);
        } else if (key > node.key) {
            node.right = deleteRecursively(node.right, key);
        } else {
            // Node to be deleted found
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }
            Node minNode = findMin(node.right);
            node.key = minNode.key;
            node.value = minNode.value;
            node.right = deleteRecursively(node.right, minNode.key);
        }
        return node;
    }

    // get the node with min key
    private Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    // get the value for a specific key
    public String get(int key) {
        Node node = getRecursively(root, key);
        return (node != null) ? node.value : null;
    }

    // get the node recursively
    private Node getRecursively(Node node, int key) {
        if (node == null || node.key == key) {
            return node;
        }
        return key < node.key ? getRecursively(node.left, key) : getRecursively(node.right, key);
    }

    // return a sorted list of key-value pairs
    public List<Map.Entry<Integer, String>> getSortedEntries() {
        List<Map.Entry<Integer, String>> entries = new ArrayList<>();
        inOrderTraversal(root, entries);
        return entries;
    }

    //Inorder traversal for the 
    private void inOrderTraversal(Node node, List<Map.Entry<Integer, String>> entries) {
        if (node != null) {
            inOrderTraversal(node.left, entries);
            entries.add(Map.entry(node.key, node.value));
            inOrderTraversal(node.right, entries);
        }
    }

    //Return the sorted list of key-value pairs in range [K1, K2]
    public List<Map.Entry<Integer, String>> getRange(int K1, int K2) {
        List<Map.Entry<Integer, String>> entries = new ArrayList<>();
        getRangeRecursively(root, entries, K1, K2);
        return entries;
    }

    private void getRangeRecursively(Node node, List<Map.Entry<Integer, String>> entries, int K1, int K2) {
        if (node == null) {
            return;
        }
        if (K1 < node.key) {
            getRangeRecursively(node.left, entries, K1, K2);
        }
        if (K1 <= node.key && K2 >= node.key) {
            entries.add(Map.entry(node.key, node.value));
        }
        if (K2 > node.key) {
            getRangeRecursively(node.right, entries, K1, K2);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Integer, String> initialEntries = Map.of(
            10, "Ten",
            20, "Twenty",
            30, "Thirty"
        ); 

        DictionaryBST dictionary = new DictionaryBST(initialEntries);

        while (true) {
            System.out.println("Choose an operation:");
            System.out.println("1. Add key-value pair");
            System.out.println("2. Delete key");
            System.out.println("3. Get value by key");
            System.out.println("4. Get sorted entries");
            System.out.println("5. Get range of entries");
            System.out.println("6. Exit");
            int choice = Utils.inputNumberInRange(scanner, 1, 6); 

            switch (choice) {
                case 1:
                    System.out.print("Enter key: ");
                    int key = Utils.inputInteger(scanner); 
                    System.out.print("Enter value: ");
                    String value = scanner.next();
                    dictionary.add(key, value);
                    break;
                case 2:
                    System.out.print("Enter key to delete: ");
                    int keyToDelete = Utils.inputInteger(scanner); 
                    dictionary.delete(keyToDelete);
                    break;
                case 3:
                    System.out.print("Enter key to get value: ");
                    int keyToGet =Utils.inputInteger(scanner); 
                    String retrievedValue = dictionary.get(keyToGet);
                    System.out.println("Value: " + (retrievedValue != null ? retrievedValue : "Key not found"));
                    break;
                case 4:
                    List<Map.Entry<Integer, String>> sortedEntries = dictionary.getSortedEntries();
                    System.out.println("Sorted entries: " + sortedEntries);
                    break;
                case 5:
                    System.out.print("Enter range start (K1): ");
                    int K1 = Utils.inputInteger(scanner); 
                    System.out.print("Enter range end (K2): ");
                    int K2 = Utils.inputInteger(scanner);
                    List<Map.Entry<Integer, String>> rangeEntries = dictionary.getRange(K1, K2);
                    System.out.println("Entries in range: " + rangeEntries);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}