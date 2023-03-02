import java.util.Arrays;

// Kristiyan Stoilov

/**
 * Class containing the methods that use Quick Sort algorithm.
 */
public class QuickSort {
    private int[] localArray;

    /**
     * Method for sorting an integer array by using the Quick Sort algorithm. Calls
     * a private recursive method that compares values around a pivot.
     * 
     * @param array The integer array that needs to be sorted.
     * @return Returns the sorted integer array.
     */
    public int[] sort(int[] array) {
        this.localArray = Arrays.copyOf(array, array.length);
        quickSort(localArray, 0, array.length - 1);
        return localArray;
    }

    /**
     * Recursive method for finding a pivot and comparing the array on both sides of
     * it.
     * 
     * @param array The integer array that needs to be sorted.
     * @param start The index of the start of the array for splitting.
     * @param end   The index of the end of the array for splitting.
     */
    private void quickSort(int[] array, int start, int end) {
        if (start < end) {
            int pivotIndex = pivot(array, start, end);
            // Sort Left
            quickSort(array, start, pivotIndex - 1);
            // Sort Right
            quickSort(array, pivotIndex + 1, end);
        }
    }

    /**
     * Method finds a new pivot, swaps value with end index and compares and sorts
     * values from left and right of pivot.
     * 
     * @param array The array to calculate the pivot with.
     * @param start The index of the start of the array for pivoting.
     * @param end   The index of the end of the array for pivoting.
     * @return Returns the index of the pivot.
     */
    private int pivot(int[] array, int start, int end) {
        // Set end as pivot
        int pivotValue = array[end];
        int pivotIndex = start - 1;

        // Compare values to pivot value and swap them if smaller
        for (int i = start; i < end; i++) {
            if (array[i] <= pivotValue) {
                pivotIndex++;
                int temporary = array[i];
                array[i] = array[pivotIndex];
                array[pivotIndex] = temporary;
            }
        }
        // Increment index and swap with pivot value (end)
        pivotIndex++;
        int temporary = array[pivotIndex];
        array[pivotIndex] = array[end];
        array[end] = temporary;
        return pivotIndex;
    }
}
