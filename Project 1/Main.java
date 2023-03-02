// Kristiyan Stoilov

public class Main {
    public static void main(String[] args) {
        // Execute method for testing MyLinkedList
        testMyLinkedList();
    }

    public static void testMyLinkedList() {
        // Print statement for the test
        System.out.println();
        System.out.println("----- Testing class MyLinkedList -----");
        System.out.println();
        // Creating 3 different MyLinkedList for testing (two being the same and one
        // different)
        // Consult MyLinkedList.java to see the class's methods

        // Adding 3 values to the first MyLinkedList
        MyLinkedList<Integer> firstList = new MyLinkedList<>();
        firstList.add(1);
        firstList.add(2);
        firstList.add(3);

        // Adding 3 different values to the second MyLinkedList
        MyLinkedList<Integer> secondList = new MyLinkedList<>();
        secondList.add(4);
        secondList.add(5);
        secondList.add(6);

        // Adding the same 3 values as the first MyLinkedList
        MyLinkedList<Integer> thirdList = new MyLinkedList<>();
        thirdList.add(1);
        thirdList.add(2);
        thirdList.add(3);

        // Comparing the first and the second (expecting false)
        System.out.println("1st list: " + firstList.print());
        System.out.println("2nd list: " + secondList.print());
        System.out.println("Are the lists the same? = " + MyLinkedList.compare(firstList, secondList));
        System.out.println();
        // Comparing the first and the third (expecting true)
        System.out.println("1st list: " + firstList.print());
        System.out.println("3rd list: " + thirdList.print());
        System.out.println("Are the lists the same? = " + MyLinkedList.compare(firstList, thirdList));
        System.out.println();

        // Testing all the methods only with the first MyLinkedList
        System.out.println(firstList.print());
        // Testing adding to the head of the list
        firstList.add(4);
        firstList.add(5);
        firstList.add(2);
        // Testing toString **Changed to "print" because of conflict with
        // java.lang.Object**
        System.out.println(firstList.print());
        // Testing removing non-existent value and existing value and if it only removes
        // first instance
        firstList.remove(99);
        firstList.remove(2);
        System.out.println(firstList.print());
        // Testing size of the list
        System.out.println("The size of the list is: " + firstList.size());
        // Testing contain from the list
        System.out.println("The list contains number 5? = " + firstList.contain(5));
        System.out.println("The list contains number 6? = " + firstList.contain(6));

        // Print statements for the test
        System.out.println();
        System.out.println("----- Finished testing -----");
    }
}
