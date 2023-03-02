import java.util.Arrays;
import java.util.Random;

// Kristiyan Stoilov

public class Main {
    // Variables declaration and/or initialization
    private static int numItem;
    private static int[] originalArray;
    private static int[] mergeSortArray;
    private static int[] quickSortArray;
    private static int[] countingSortArray;

    /**
     * Main function of the Assignment 4, times the runtime of each sorting
     * algorithm.
     * 
     * @param args
     */
    public static void main(String[] args) {
        // Define size of the array
        numItem = 1000;

        // Create the Array
        createArray();

        // Initialize Classes
        MergeSort mergeSort = new MergeSort();
        QuickSort quickSort = new QuickSort();
        CountingSort countingSort = new CountingSort();

        // Initialize Arrays
        mergeSortArray = new int[originalArray.length];
        quickSortArray = new int[originalArray.length];
        countingSortArray = new int[originalArray.length];

        // Print size of the array
        System.out.println("The size of the array is:" + numItem);

        // Timing the MergeSort algorithm
        // Start the timer
        double startTime = System.nanoTime();
        // Run the sorting algorithm
        mergeSortArray = mergeSort.sort(originalArray);
        // End the timer
        double endTime = System.nanoTime();
        double duration = (endTime - startTime); // divide by 1000000 to get milliseconds.
        // Print elapsed time
        System.out.println();
        System.out.println("The time it took to sort the array with MergeSort is: " + duration + " Nanoseconds.");

        // Timing the QuickSort algorithm
        // Start the timer
        startTime = System.nanoTime();
        // Run the sorting algorithm
        quickSortArray = quickSort.sort(originalArray);
        // End the timer
        endTime = System.nanoTime();
        duration = (endTime - startTime); // divide by 1000000 to get milliseconds.
        // Print elapsed time
        System.out.println();
        System.out.println("The time it took to sort the array with QuickSort is: " + duration + " Nanoseconds.");

        // Timing the CountingSort algorithm
        // Start the timer
        startTime = System.nanoTime();
        // Run the sorting algorithm
        countingSortArray = countingSort.sort(originalArray);
        // End the timer
        endTime = System.nanoTime();
        duration = (endTime - startTime); // divide by 1000000 to get milliseconds.
        // Print elapsed time
        System.out.println();
        System.out.println("The time it took to sort the array with CountingSort is: " + duration + " Nanoseconds.");
    }

    /**
     * Method creates a random integer array with numItem determining the amount of
     * entries.
     * Provided to us from Assignment Instructions.
     */
    public static void createArray() {
        originalArray = new int[numItem];
        Random myRand = new Random(); // Creating Random object
        // Range for random to select from
        int min = 5;
        int max = 1000;

        int indexMin = 0;

        for (int i = 0; i < originalArray.length; i++) {
            originalArray[i] = myRand.nextInt(max - min + 1) + min; // storing random integers in an array
        }
    }
}
