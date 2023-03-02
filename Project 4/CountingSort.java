import java.util.Arrays;

// Kristiyan Stoilov

/**
 * Class containing the methods that use Counting Sort algorithm.
 */
public class CountingSort {
    private int[] localArray;

    /**
     * Method for sorting an integer array by using the Counting Sort algorithm.
     * Calls a private sorting method that sorts the array.
     * 
     * @param array The integer array that needs to be sorted.
     * @return Returns the sorted integer array.
     */
    public int[] sort(int[] array) {
        this.localArray = Arrays.copyOf(array, array.length);
        localArray = countingSort(localArray);
        return localArray;
    }

    /**
     * Method for sorting an integer array by using the Counting Sort algorithm.
     * Iterates through and counts the times an integer is present in an index
     * array, then constructs the sorted array.
     * 
     * @param array The integer array that needs to be sorted.
     */
    public int[] countingSort(int[] array) {
        int length = array.length;

        // Find the highest number in array
        int highest = array[0];
        for (int i = 1; i < length; i++) {
            if (array[i] > highest)
                highest = array[i];
        }

        // Create a new countArray with a size of highest+1
        int[] countArray = new int[highest + 1];

        // Initialize countArray with 0s
        for (int i = 0; i < highest; ++i) {
            countArray[i] = 0;
        }

        // Iterate through the array and count the number of occurrences of each
        // integer, increment every integer’s count at the index corresponding to its
        // value
        for (int i = 0; i < length; i++) {
            countArray[array[i]]++;
        }

        // Iterate again and add cumulatively each previous number in countArray, this
        // calculates the index of a number’s first encounter
        for (int i = 1; i <= highest; i++) {
            countArray[i] += countArray[i - 1];
        }

        // Starting at the end of the array, shift all to the right by 1, and value at
        // index 0 as 0
        for (int i = highest; i > 0; i--) {
            countArray[i] = countArray[i - 1];
        }
        countArray[0] = 0;

        // Create new array for result
        int[] resultArray = new int[length];

        // Iterate through the initial array, place each integer at index to their
        // appropriate place in resultArray and increment the count in countArray for
        // next instance
        for (int i = 0; i < length; i++) {
            resultArray[countArray[array[i]]] = array[i];
            countArray[array[i]]++;
        }

        return resultArray;
    }
}
