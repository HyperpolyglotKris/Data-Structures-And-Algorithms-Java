// Kristiyan Stoilov
// ID: 260990847

import java.util.ArrayList;

public class SortedPriorityQueue implements PriorityQueue{
    /**
     * Stores the integer ArrayList for the PriorityQueue
     */
    private static ArrayList<Integer> array;

    /**
     * Constructor for the SorterPriorityQueue class.
     * @param array ArrayList for the SortedPriorityQueue.
     */
    public SortedPriorityQueue(ArrayList array) {
        this.array=array;
    }

    /**
     * Insert method, iterates and inserts value in the PriorityQueue's ArrayList at the appropriate place (sorted).
     * @param value Integer to be inserted
     */
    @Override
    public void insert(int value) {
        for (int i= 0; i<array.size(); i++){
            if (array.get(i)>value);
            array.add(i, value);
            break;
        }
    }

    /**
     * Returns the minimum value (first value) from the PriorityQueue and removes if afterwards.
     * @return Returns the minimum value.
     */
    public int removeMin() {
        if (array.size()!=0) {
            int value = array.get(0);
            array.remove(0);
            return value;
        } else return Integer.parseInt(null);
    }

    /**
     * Returns the minimum value (first value) from the PriorityQueue.
     * @return Returns the minimum value.
     */
    @Override
    public int min() {
        if (array.size()!=0) {
            return array.get(0);
        } else return Integer.parseInt(null);
    }

    /**
     * Returns the size of the PriorityQueue.
     * @return Returns the size of the ArrayList.
     */
    @Override
    public int size() {
        return array.size();
    }

    /**
     * Method verifies if the PriorityQueue is empty.
     * @return Returns true if ArrayList is empty.
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
