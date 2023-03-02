// Kristiyan Stoilov
// ID: 260990847

import java.util.ArrayList;

public class UnsortedPriorityQueue implements PriorityQueue{
    /**
     * Stores the integer ArrayList for the PriorityQueue
     */
    private static ArrayList<Integer> array;

    /**
     * Constructor for the UnsortedPriorityQueue class.
     * @param array ArrayList for the UnsortedPriorityQueue.
     */
    public UnsortedPriorityQueue(ArrayList array) {
        this.array = array;
    }

    /**
     * Inserts integer value at the end of the PriorityQueue (unsorted).
     * @param value Integer to be inserted.
     */
    @Override
    public void insert(int value) {
        array.add(value);
    }

    /**
     * Sorts through the PriorityQueue and prints the minimum value, then removes it.
     * @return Returns the minimum/smallest value.
     */
    @Override
    public int removeMin() {
        if (array.size() != 0) {
            int minIndex = 0;
            int minValue = array.get(0);
            for (int i = 0; i < array.size(); i++) {
                if (array.get(i) < minValue) {
                    minValue = array.get(i);
                    minIndex = i;
                }
            }
            int value = array.get(minIndex);
            array.remove(minIndex);
            return value;
        } else return Integer.parseInt(null);
    }

    /**
     * Sorts through the PriorityQueue and prints the minimum value.
     * @return Returns the minimum/smallest value.
     */
    @Override
    public int min() {
        if (array.size()!=0) {
            int minIndex = 0;
            int minValue = array.get(0);
            for (int i = 0; i < array.size(); i++) {
                if (array.get(i) < minValue) {
                    minValue = array.get(i);
                    minIndex = i;
                }
            }
            return array.get(minIndex);
        } else return Integer.parseInt(null);
    }

    /**
     * Returns the size of the PriorityQueue.
     * @return Returns the size of the PriorityQueue's ArrayList.
     */
    @Override
    public int size() {
        return array.size();
    }

    /**
     * Method verifies if the PriorityQueue's ArrayList is empty and returns a boolean.
     * @return Returns true if the ArrayList is empty.
     */
    @Override
    public boolean isEmpty() {
        if (array.size()==0) {
            return true;
        }
        else {
            return false;
        }
    }
}
