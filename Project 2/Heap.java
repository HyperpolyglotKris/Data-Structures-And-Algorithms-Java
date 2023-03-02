// Kristiyan Stoilov
// ID: 260990847

public class Heap {
    /**
     * Stores the integer array representing the heap.
     */
    private static int [] array;

    /**
     * Constructor for the Heap class.
     * @param array Array associated to the heap.
     */
    public Heap(int[] array) {
        this.array=array;
    }

    /**
     * Returns the location of the parent of a node inside a binary tree.
     * @param i Input index of which to find the parent.
     * @return Returns the index of the parent node.
     */
    public static int parent (int i){
        return (i-1)/2;
    }

    /**
     * Returns the location of the left child of a node inside a binary tree.
     * @param i Input index of which to find the left child.
     * @return Returns the index of the left child.
     */
    public static int left (int i){
        return (2*i)+1;
    }

    /**
     * Returns the location of the right child of a node inside a binary tree.
     * @param i Input index of which to find the right child.
     * @return Returns the index of the right child.
     */
    public static int right (int i){
        return (2*i)+2;
    }

    /**
     * Boolean that verifies if node has a left sibling.
     * @param i Index of the node.
     * @return Returns true if it has left.
     */
    public static boolean hasLeft(int i) {return left(i) < array.length;}

    /**
     * Boolean that verifies if node has a right sibling.
     * @param i Index of the node.
     * @return Returns true if it has right.
     */
    public static boolean hasRight(int i) {return right(i) < array.length;}

    /**
     * Swaps two nodes from the Binary Tree's array.
     * @param i First value for swapping.
     * @param j Second value for swapping.
     */
    public static void swap (int i, int j) {
        int temporary = array[i];
        array[i] = array[j];
        array[j] = temporary;
    }

    /**
     * COMPARE METHOD WAS NOT IN M8-HEAPS
     * @return
     */
//    public static void upheap (int i) {
//        while (i>0) {
//            int p = parent(i);
//            if (compare(array[i], array[p]) >= 0) break;
//            swap (i, p);
//            i = p;
//        }
//    }

    /**
     * COMPARE METHOD WAS NOT IN M8-HEAPS
     * @return
     */
//    public static void downheap (int i) {
//        while (hasLeft(i)) {
//            int leftIndex = left(i);
//            int smallChildIndex = leftIndex;
//            if (hasRight(i)) {
//                int rightIndex = right(i);
//                if(compare(array[leftIndex], array[rightIndex]) >0){
//                    smallChildIndex = rightIndex;
//                }
//            }
//            if (compare(array[smallChildIndex],array[i]) >= 0) {
//                swap(i, smallChildIndex);
//                i = smallChildIndex;
//            }
//        }
//    }

    /**
     * Returns the size of the Heap/Binary Tree.
     * @return Returns the size of the array.
     */
    public static int size() {return array.length;}

    /**
     * Returns the root/minimum value of the sorted Heap/Binary Tree.
     * @return Returns the integer at root.
     */
    public static int min() {
        if (size() > 0) {
            return array[0];
        } else return Integer.parseInt(null);
    }
}
