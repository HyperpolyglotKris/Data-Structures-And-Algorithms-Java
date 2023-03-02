// Kristiyan Stoilov

/**
 * Node class for the BinarySearchTree, contains integer value and pointers to
 * left-child and right-child.
 */
public class Node {
    int value;
    Node right;
    Node left;

    /**
     * Constructor for the Node.
     * 
     * @param value the integer value that needs to be stored.
     */
    Node(int value) {
        this.value = value;
        right = null;
        left = null;
    }
}
