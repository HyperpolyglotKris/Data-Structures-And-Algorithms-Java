// Kristiyan Stoilov

public class MyLinkedList<Integer> {
    // Initializing values for: size (optional variable) and head
    int size = 0;
    Node head = null;

    // Creating Node class
    class Node {
        int value;
        Node next;
    }

    // Optional constructor (serves no use, because values are already declared and
    // initialized)
    public MyLinkedList() {
    }

    // Add a node to the head of the Linked List
    public void add(int number) {
        // Create new node
        Node newNode = new Node();
        // Assign given number to the new node's value (int) variable;
        newNode.value = number;
        // Assign new mode's next Node to current head
        newNode.next = head;
        // Assign the new node as the new head
        head = newNode;
        size++;
    }

    // Remove node containing the first instance of a given integer
    public void remove(int number) {
        // Create buffer to go through the List Array
        Node buffer = head;
        // Start iterating with the buffer using for loop
        for (int i = 0; i < size; i++) {
            // If the first value is the number to be removed, assign head to the next node,
            // decrease size and break.
            if (buffer.value == number) {
                head = buffer.next;
                size--;
                break;
            }
            // Else if the value of the node following the current buffer is the number to
            // be removed, skip that node and assign next to the following node, decrease
            // size and break.
            else if (buffer.next != null && buffer.next.value == number) {
                buffer.next = buffer.next.next;
                size--;
                break;
            }
            // Otherwise, if the next node is not null, simply go to next, or if the next
            // node is null then break.
            else {
                if (buffer.next != null) {
                    buffer = buffer.next;
                } else
                    break;
            }
        }
    }

    // Return size of the Linked List
    public int size() {
        return size;
    }

    // Check if Linked List has given value and return boolean
    public boolean contain(int check) {
        // Create buffer to go through the List Array
        Node buffer = head;
        // As long as buffer is not null, check if the value is the number we're looking
        // for
        while (buffer != null) {
            if (buffer.value == check) {
                // Print the following and return true
                return true;
            }
            buffer = buffer.next;
        }
        // Print the following and return false
        return false;
    }

    // Let buffer run through the Linked List and print everything
    public String print() {
        Node buffer = head;
        String string = "";
        // As long as buffer is not null, print value at buffer location
        while (buffer != null) {
            string += buffer.value;
            buffer = buffer.next;
            // If the next location is not null, add "->" for readability
            if (buffer != null) {
                string += "->";
            }
        }
        // Return the string
        return string;
    }

    // Compare two linked list to check if they are the same (static because it's
    // not for a single instance)
    public static boolean compare(MyLinkedList first, MyLinkedList second) {
        // Compare the two linked lists as String and return boolean
        return first.print().equals(second.print());
    }
}
