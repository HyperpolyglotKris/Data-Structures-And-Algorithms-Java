// Kristiyan Stoilov
// ID: 260990847

import java.util.Arrays;
import java.util.Random; // this creates random for our program

public class App {
    public static int[] originalArray;
    public static int[] selectionSortedArray;
    public static int[] insertionSortedArray;
    public static int[] heapSortedArray;

    /**
     * Main method of the app. Contains a method to create an integer array, and 3 different sorting algorithms.
     * @param args No arguments needed.
     * @throws Exception Throws exception, already provided.
     */
    public static void main(String[] args) throws Exception {
        // Create the Array
        createArray();

        // Start the timer
        double startTime = System.nanoTime();

        // Print original array
        System.out.println();
        System.out.println("Initial Array");
        System.out.println(Arrays.toString(originalArray));

        // Run the sorting algorithm desired
        heapSortedArray = heapSort(originalArray);
        selectionSortedArray = selectionSort(originalArray);
        insertionSortedArray = insertionSort(originalArray);

        // Print resulting array
        System.out.println("Heap Sorting");
        System.out.println(Arrays.toString(heapSortedArray));
        System.out.println("Selection Sorting");
        System.out.println(Arrays.toString(selectionSortedArray));
        System.out.println("Insertion Sorting");
        System.out.println(Arrays.toString(insertionSortedArray));

        // End the timer
        double endTime = System.nanoTime();
        double duration = (endTime - startTime); // divide by 1000000 to get milliseconds.

        // Print elapsed time
        System.out.println();
        System.out.println("The time it took to sort is: " + duration + " Nanoseconds.");
    }

    /**
     * Method creates a random integer array with numItem determining the amount of entries.
     * Already provided to us from starter code, but copy-pasted into a separate method to lighten main method.
     */
    public static void createArray(){
        int numItem = 10; // This decides how big you array is
        originalArray = new int[numItem];
        Random myRand = new Random(); // creating Random object
        // Range for random to select from
        int min = 5;
        int max = 1000;

        int indexMin = 0;

        for (int i = 0; i < originalArray.length; i++) {
            originalArray[i] = myRand.nextInt(max - min + 1) + min; // storing random integers in an array
        }
    }

    /**
     * Method uses Selection Sort to sort an integer array.
     * @param array Insert integer array that needs sorting.
     * @return Returns the resulting sorted integer array.
     */
    public static int[] selectionSort(int[] array) {

        for (int i=0; i<array.length-1; i++) {
            int lowestNumberIndex = i;
            for (int j=i+1; j<array.length; j++) {
                if (array[j] < array[lowestNumberIndex]){
                    lowestNumberIndex = j;
                }
            }
            int temporary = array[lowestNumberIndex];
            array[lowestNumberIndex] = array[i];
            array[i] = temporary;
        }
        return array;
    }

    /**
     * Method uses Insertion Sort to sort an integer array.
     * @param array Insert integer array that needs sorting.
     * @return Returns the resulting sorted integer array.
     */
    public static int[] insertionSort(int[] array) {

        for (int i=1; i<array.length; i++) {
            int initialNumber = array[i];
            int comparatorIndex = i-1;
            while (comparatorIndex >= 0 && array[comparatorIndex] > initialNumber) {
                array[comparatorIndex+1] = array[comparatorIndex];
                comparatorIndex --;
            }
            array[comparatorIndex+1] = initialNumber;
        }

        return array;
    }

    /**
     * Method uses Heap Sort to sort an integer array.
     * @param array Insert integer array that needs sorting.
     * @return Returns the resulting sorted integer array.
     */
    public static int[] heapSort(int[] array) {
        // Assign length to a variable
        int n = array.length;
        // Create binary tree/heap
        for (int i=n/2-1; i>=0; i--)
            heapify(array, n, i);
        // Modify heap
        for (int i=n-1; i>=0; i--) {
            int temporary = array[0];
            array[0] = array[i];
            array[i] = temporary;
            heapify(array, i, 0);
        }
        return array;
    }

    /**
     * Helper method to heapSort(). Organizes the binary tree for the heap.
     * @param array The array used as a binary tree/heap.
     * @param n Length of the array.
     * @param i Index from the caller method.
     */
    public static void heapify(int[] array, int n, int i) {
        // Make the largest as root
        int largest = i;
        // Calculates location of left and right children
        int left = 2*i+1;
        int right = 2*i+2;
        // Compare left with root/largest
        if (left < n && array[left] > array[largest]){
            largest = left;
        }
        // Compare right with root/largest
        if (right < n && array[right] > array[largest]){
            largest = right;
        }
        // Verify if largest is not root
        if (largest != i) {
            int temporary = array[i];
            array[i] = array[largest];
            array[largest] = temporary;
            // Recursion
            heapify(array, n, largest);
        }
    }
}

