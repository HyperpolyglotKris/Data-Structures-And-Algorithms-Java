import java.util.Arrays;

// Kristiyan Stoilov

/**
 * Class containing the methods that use Merge Sort algorithm.
 */
public class MergeSort {
    private int[] localArray;

    /**
     * Method for sorting an integer array by using the Merge Sort algorithm. Calls
     * a private recursive method for splitting the array into halves, then sorts
     * and merges them.
     * 
     * @param array The integer array that needs to be sorted.
     * @return Returns the sorted integer array.
     */
    public int[] sort(int[] array) {
        this.localArray = Arrays.copyOf(array, array.length);
        mergeSort(localArray, 0, array.length - 1);
        return localArray;
    }

    /**
     * Recursive method for splitting the array into halves, until it reaches arrays
     * with single value, then calls a helper method to merge the arrays into
     * progressively bigger sorted array.
     * 
     * @param array The integer array that needs to be sorted.
     * @param start The index of the start of the array for splitting.
     * @param end   The index of the end of the array for splitting.
     */
    private void mergeSort(int[] array, int start, int end) {
        if (start < end) {
            int middle = (start + end) / 2;
            mergeSort(array, start, middle);
            mergeSort(array, middle + 1, end);
            merge(array, start, middle, end);
        }
    }

    /**
     * Method for merging two already sorted arrays into one new sorted array, by
     * comparing every value.
     * 
     * @param array  The original array of integers.
     * @param start  The index of the start of the left integer array.
     * @param middle The index of the middle of the integer arrays (end of left,
     *               start of right).
     * @param end    The index of the end of the right integer array.
     */
    private void merge(int[] array, int start, int middle, int end) {
        int leftArrayLength = middle - start + 1;
        int rightArrayLength = end - middle;

        // Create left array and right away for comparing
        int[] leftArray = new int[leftArrayLength];
        int[] rightArray = new int[rightArrayLength];

        // Put appropriate values in each array
        for (int i = 0; i < leftArrayLength; i++) {
            leftArray[i] = array[start + i];
        }
        for (int i = 0; i < rightArrayLength; i++) {
            rightArray[i] = array[(middle + 1) + i];
        }

        // Assign indexes for comparing arrays and for new array
        int leftIndex = 0;
        int rightIndex = 0;
        int arrayIndex = start;

        // If leftIndex and rightIndex are both within bounds, compare and assign to new
        // array
        while (leftIndex < leftArrayLength && rightIndex < rightArrayLength) {
            if (leftArray[leftIndex] <= rightArray[rightIndex]) {
                array[arrayIndex] = leftArray[leftIndex];
                leftIndex++;
            } else {
                array[arrayIndex] = rightArray[rightIndex];
                rightIndex++;
            }
            arrayIndex++;
        }
        // If only leftIndex is within bounds, assign to new array
        while (leftIndex < leftArrayLength) {
            array[arrayIndex] = leftArray[leftIndex];
            leftIndex++;
            arrayIndex++;
        }
        // If only rightIndex is within bounds, assign to new array
        while (rightIndex < rightArrayLength) {
            array[arrayIndex] = rightArray[rightIndex];
            rightIndex++;
            arrayIndex++;
        }
    }

}
