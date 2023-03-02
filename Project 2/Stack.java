// Kristiyan Stoilov
// ID: 260990847

import java.util.ArrayList;

/**
 * Class Stack contains methods and variables allowing it to act was a Stack AbstractDataType.
 */
public class Stack {
    /**
     * Variable stores integers in an ArrayList.
     */
     private static ArrayList<Integer> stack = new ArrayList<Integer>();

    /**
     * Method pushes an integer into the stack ArrayList.
     * @param number integer that will be added to the stack.
     */
    public static void push(int number) {
        stack.add(number);
    }

    /**
     * Method pops from the stack, returning the latest integer.
     * @return returns the value of the integer that was popped, 0 if stack is empty.
     */
    public static int pop() {
        // Verify if the stack is empty before popping
        if (!isEmpty()) {
            int popInt = stack.get((stack.size()) - 1);
            stack.remove((stack.size()) - 1);
            return popInt;
        } else {
            System.out.print("Cannot pop empty stack.");
            return 0;
        }
    }

    /**
     * Method pops the last two elements in stack (if there are at least 2 elements) and pushes their sum.
     */
    public static void add() {
        if (hasAtLeast2()){
            push(pop()+pop());
        }
    }

    /**
     * Method pops the last two elements in stack (if there are at least 2 elements) and pushes their product.
     */
    public static void multiply() {
        if (hasAtLeast2()){
            push(pop()*pop());
        }
    }

    /**
     * Method prints the whole stack.
     */
    public static void printAll(){
        System.out.println(stack.toString());
    }

    /**
     * Method verifies if the stack has at least two values.
     * @return Returns boolean true if stack has at least two values, and false if not.
     */
    private static boolean hasAtLeast2(){
        if (stack.size()>=2) {
            return true;
        } else return false;
    }

    /**
     * Method verifies if the stack is empty.
     * @return Returns boolean true if stack is empty, and false if not.
     */
    private static boolean isEmpty(){
        if (stack.size()==0){
            return true;
        } else return false;
    }
}
