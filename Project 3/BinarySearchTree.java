// Kristiyan Stoilov

/**
 * BinarySearchTree class, storing the tree in the root node.
 */
public class BinarySearchTree {
    Node root;

    /**
     * Adds a new value to the BinarySearchTree and re-arranges it, with use of
     * recursive helper method.
     * 
     * @param value the integer value to be stored.
     */
    public void add(int value) {
        root = addRecursive(root, value);
    }

    /**
     * Search method that verifies if the tree contains a given value, with use of
     * recursive helper method.
     * 
     * @param value The integer to search the tree for.
     * @return Returns true if integer is present, false otherwise.
     */
    public boolean containsNode(int value) {
        return containsNodeRecursive(root, value);
    }

    /**
     * Recursive add method that adds a new Node in the tree at the correct position
     * by comparing to other nodes.
     * 
     * @param current The root node initially, but recursively the node for
     *                comparing the integer.
     * @param value   Integer value that needs to be inserted into the tree.
     * @return Returns the root node containing the whole tree.
     */
    private Node addRecursive(Node current, int value) {
        // Verifies if Node is null
        if (current == null) {
            return new Node(value);
        }
        // If the value is smaller, go to left-child
        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        }
        // If the value is bigger, go to right-child
        else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        }
        // If value already present, return root (removes duplicates)
        else {
            return current;
        }
        return current;
    }

    /**
     * Recursive search method that searches the tree for given value by comparing
     * the search value with the nodes.
     * 
     * @param current The root node initially, but recursively the node for
     *                comparing the integer.
     * @param value   The integer value to search the tree for.
     * @return
     */
    private boolean containsNodeRecursive(Node current, int value) {
        // Verifies if Node is null
        if (current == null) {
            return false;
        }
        // Verifies if Node contains desired value
        if (value == current.value) {
            return true;
        }
        // Verifies if value is smaller to go to left-child, or bigger to go
        // right-child.
        if (value < current.value) {
            // Repeat method using this left-child.
            return containsNodeRecursive(current.left, value);
        } else {
            // Repeat method using this right-child.
            return containsNodeRecursive(current.right, value);
        }
    }
}