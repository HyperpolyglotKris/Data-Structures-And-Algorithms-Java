// Kristiyan Stoilov
// ID: 260990847

import java.util.Scanner;

/**
 * Main used for running stackTest() and stackCustomCommands() methods that interact with Stack.
 */
public class Main {
    public static void main(String[] args) {
//        stackTest();
        stackCustomCommands();
    }


    /**
     * This is a test method that uses Scanner with hard coded commands for testing the Stack.
     * (For using a System.in Scanner please use stackCustomCommands() method.).
     *
     * Method has no input parameters and no returns.
     */
    public static void stackTest(){
        System.out.println();
        // We are tasked to pop the 26 before doing the multiplication but that leaves only one item in the stack.
        System.out.println("Predefined test with parameters: 10 ? 12 ? 14 + p * ? z");
        System.out.println("Expected results: [10], [10,12], 26, [10]");
        System.out.println();
        System.out.println("Results:");
        Scanner scanner = new Scanner("10 ? 12 ? 14 + p * ? z");
        String string="";
        // For every inputted command, verify which method to execute.
        while (true){
            string = scanner.next();
            if (isInteger(string)) {
                Stack.push(Integer.parseInt(string));
            } else if (string.equals("+")) {
                Stack.add();
            } else if (string.equals("*")) {
                Stack.multiply();
            } else if (string.equals("?")) {
                Stack.printAll();
            } else if (string.equalsIgnoreCase("p")) {
                int popValue = Stack.pop();
                if (popValue!=0) {
                    System.out.println(popValue);
                }
            } else if (string.equalsIgnoreCase("z")) {
                break;
            }
        }
    }

    /**
     * This is a method that takes user input through System.in console Scanner
     * and interacts with the Stack.
     *
     * The commands use space or new line characters as delimiters.
     * The allowed commands are integers, "+", "*", "?", "p", "z".
     *
     * Method has no input parameters and no returns.
     */
    public static void stackCustomCommands(){
        System.out.println();
        System.out.println("Enter command(s):");
        Scanner scanner = new Scanner(System.in);
        String string="";
        // For every inputted command, verify which method to execute.
        while (true){
            string = scanner.next();
            if (isInteger(string)) {
                Stack.push(Integer.parseInt(string));
            } else if (string.equals("+")) {
                Stack.add();
            } else if (string.equals("*")) {
                Stack.multiply();
            } else if (string.equals("?")) {
                Stack.printAll();
            } else if (string.equalsIgnoreCase("p")) {
                int popValue = Stack.pop();
                if (popValue!=0) {
                    System.out.println(popValue);
                }
            } else if (string.equalsIgnoreCase("z")) {
                break;
            }
        }
    }

    /**
     * Method verifies if the inputted String contains strictly integers.
     * @param string The string that needs to be verified for containing only integers.
     * @return Returns boolean true if the String is uniquely composed of integers, and false if not.
     */
    public static boolean isInteger(String string) {
        if(string==null||string.equals("")) {
            return false;
        }
        try {
            int integer = Integer.parseInt(string);
            return true;
        } catch (Exception e) {} return false;
    }
}
