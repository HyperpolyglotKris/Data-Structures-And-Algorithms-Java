// Kristiyan Stoilov

import java.util.Arrays;
import java.util.Random;

public class Main {
    // The array for the search
    public static int[] array;
    // The number to find
    public static int myVal = 5;
    public static BinarySearchTree binarySearchTree = new BinarySearchTree();

    /**
     * Executable main method of the Assignment 3.
     * 
     * @param args
     */
    public static void main(String[] args) {
        // Create the Array
        createArray();
        // Create the BinarySearchTree
        createBinarySearchTree(array);
        // (OPTIONAL: For visual, prints the sorted array and the searching variable in
        // terminal, to verify accuracy.)
        printSortedArray();
        printSearchVariable();

        // (OPTIONAL: For experimenting, using binary search method directly on the
        // sorted array, and not on the tree.)
        // Timing the Binary Search Method with the sorted array
        // Start the timer
        double startTime = System.nanoTime();
        // Run the sorting algorithm
        boolean result = binarySearch(array, myVal);
        // End the timer
        double endTime = System.nanoTime();
        double duration = (endTime - startTime); // divide by 1000000 to get milliseconds.
        // Print elapsed time
        System.out.println();
        System.out.println(
                "OPTIONAL: The time it took with BinarySearch through sorted array is: " + duration + " Nanoseconds.");
        System.out.println("OPTIONAL: The result was: " + result);

        // Timing the BinarySearchTree
        // Start the timer
        startTime = System.nanoTime();
        // Run the sorting algorithm
        result = binarySearchTree.containsNode(myVal);
        // End the timer
        endTime = System.nanoTime();
        duration = (endTime - startTime); // divide by 1000000 to get milliseconds.
        // Print elapsed time
        System.out.println();
        System.out.println("The time it took with BinarySearchTree is: " + duration + " Nanoseconds.");
        System.out.println("The result was: " + result);

        // Timing the Loop Search
        // Start the timer
        startTime = System.nanoTime();
        // Run the sorting algorithm
        result = loopSearch(array, myVal);
        // End the timer
        endTime = System.nanoTime();
        duration = (endTime - startTime); // divide by 1000000 to get milliseconds.
        // Print elapsed time
        System.out.println();
        System.out.println("The time it took with LoopSearch through sorted array is: " + duration + " Nanoseconds.");
        System.out.println("The result was: " + result);
    }

    /**
     * Method to create a BinarySearchTree ADT, takes an integer array as input, and
     * adds every value.
     * 
     * @param array Integer array that is transformed into a BinarySearchTree.
     */
    public static void createBinarySearchTree(int[] array) {
        for (int i = 0; i < array.length; i++) {
            binarySearchTree.add(array[i]);
        }
    }

    /**
     * Method creates a random integer array with numItem determining the amount of
     * entries.
     * Provided to us from Assignment 2.
     */
    public static void createArray() {
        int numItem = 100; // This decides how big you array is
        array = new int[numItem];
        Random myRand = new Random(); // Creating Random object
        // Range for random to select from
        int min = 1;
        int max = 100;

        int indexMin = 0;

        for (int i = 0; i < array.length; i++) {
            array[i] = myRand.nextInt(max - min + 1) + min; // storing random integers in an array
        }
    }

    /**
     * Prints the array after sorting it.
     */
    public static void printSortedArray() {
        Arrays.sort(array);
        System.out.println();
        System.out.println("The Sorted Array is:");
        System.out.println(Arrays.toString(array));
    }

    /**
     * Prints what the target integer for the methods is.
     */
    public static void printSearchVariable() {
        System.out.println();
        System.out.println("The Value to find is: " + myVal);
    }

    /**
     * Method uses binary search algorithm to go through array and find target
     * integer.
     * 
     * @param array  Integer array for searching through.
     * @param target Target to find in the array.
     * @return Boolean true if target is present.
     */
    public static boolean binarySearch(int[] array, int target) {
        int low = 0;
        int high = array.length;
        int mid;
        while (high - low > 1) {
            mid = (high + low) / 2;
            if (target == array[mid]) {
                return true;
            } else if (target > array[mid]) {
                low = mid;
            } else if (target < array[mid]) {
                high = mid;
            }
        }
        if (array[0] == target) {
            return true;
        }
        return false;
    }

    /**
     * Method iterates through integer array with a for loop to find target integer.
     * 
     * @param array  Integer array for searching through.
     * @param target Target to find in the array.
     * @return Boolean true if target is present.
     */
    public static boolean loopSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return true;
            } else if (array[i] > target) {
                break;
            }
        }
        return false;
    }
}
