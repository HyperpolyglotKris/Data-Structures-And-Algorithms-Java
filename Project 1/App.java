import java.util.Random; // this creates random for our program

// Kristiyan Stoilov

public class App {

    public static int minFinder(int[] array) {
        int index = 0;
        int smallest = array[0];
        // For loop to iterate through array
        for (int i = 0; i < array.length; i++) {
            // If value at index is smaller than current smallest, make that value the enw
            // smallest and update the index to current
            if (array[i] < smallest) {
                smallest = array[i];
                index = i;
            }
        }
        // Once you find the minimum value, return the index of it in the array
        return index;
    }

    // Recursive version of the minFinder, takes an integer array and initial index
    // 0
    public static int minFinder_recursive(int[] array, int index) {
        // Starting at the last recursion, return integer at index 0 of array
        if (index == array.length - 1) {
            return index;
        }
        // Assign minimum
        int minimumIndex = minFinder_recursive(array, index + 1);
        int minimum = array[minimumIndex];
        if (array[index] <= minimum) {
            return index;
        } else {
            return minimumIndex;
        }
    }

    public static void main(String[] args) throws Exception {
        int[] myArr = new int[100];
        Random myRand = new Random(); // creating Random object
        // Range for random to select from
        int min = 5;
        int max = 1000;

        int indexMin = 0;

        for (int i = 0; i < myArr.length; i++) {
            myArr[i] = myRand.nextInt(max - min + 1) + min; // storing random integers in an array
        }
        // here we check the last item of array to see if it is full:
        System.out.println("The last element is: " + myArr[myArr.length - 1]); // printing last element, not the biggest
                                                                               // or smallest but just the last one
        // now we find the minimum calling the function you wrote:
        indexMin = minFinder(myArr);
        System.out.println("The minimum is at location: " + indexMin + " The value is: " + myArr[indexMin]);

        // Duplicated test but this time for the recursion method
        indexMin = minFinder_recursive(myArr, 0);
        System.out.println("The minimum is at location: " + indexMin + " The value is: " + myArr[indexMin]);
    }
}