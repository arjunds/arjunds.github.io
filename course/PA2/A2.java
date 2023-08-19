import java.util.*;

public class A2 {

    public static void selectionSort(ResizableArray list) {
        // Selection sort works by traversing a list and finding the minimum value
        // and swapping it to the minimum spot. It keeps doing this until the list is sorted
        // It essentially "selects" a value to move to the front of the list.
        // This means that after the first iteration, index 0 has the smallest element. Therefore,
        // we only need to go through index 1 through n-1.

        // Part of the purpose of this assignment is to familiarize yourself with looking up and understanding
        // material from different sources - Googling things is a key part of programming. There's plenty of
        // examples on selection sort online, with step by step examples of the list changing. Use them!

        // I've already implemented a swap() method in ResizableArray that you can easily use to swap the elements
        // at two specified indices. It won't do anything if the indices are out of bounds



    }

    public static void main(String[] args) {
        
        // Methods for testing - Do not modify below code
        // Put any tests you want to do above this section
        System.out.println("--------------- Testing Section ---------------");
        System.out.println("Ensure that all of these return true");

        ResizableArray list = new ResizableArray();
        System.out.println("List size is 0 on initialization: " + (list.size() == 0));
        System.out.println("Is empty on initialization: " + (list.isEmpty() == true));

        list.append(1);
        list.append(2);
        list.append(3);

        int[] test = new int[ResizableArray.SIZE_INCREMENT];
        test[0] = 1; test[1] = 2; test[3] = 3;

        System.out.println("Appended 3 elements properly: " + (Arrays.equals(test, list.getArray())));

        list.insert(4, 2);
        list.insert(5, 0);
        test[0] = 5; test[1] = 1; test[2] = 2; test[3] = 4; test[4] = 3;

        System.out.println("Inserted 2 elements properly: " + (Arrays.equals(test, list.getArray())));

        System.out.println("Adjusted size properly: " + (list.getSize() == 5));

        list = new ResizableArray(3);
        System.out.println("Sets inner array size properly on initialization: " + (list.getArray().length == 3));

        list.append(1);
        list.append(0);
        list.append(1);
        list.append(3);

        System.out.println("Resizes properly: " + (list.getArray().length == 3 + ResizableArray.SIZE_INCREMENT));
        System.out.println("Inserts after resizing properly: " + (list.get(3) == 3 && list.size() == 4));

        System.out.println("IndexOf works on existing element: " + (list.indexOf(0) == 1));
        System.out.println("IndexOf returns first index when there are multiple: " + (list.indexOf(1) == 0));
        System.out.println("IndexOf returns -1 on no match: " + (list.indexOf(5) == -1));
        System.out.println("Get() returns -1 on out of bounds index: " + (list.get(5) == -1));

        list.remove(3);
        System.out.println("Remove works on end of list case: " + (list.size() == 3 && list.indexOf(3) == -1 && list.get(3) == -1));
        list.remove(1);
        System.out.println("Remove only removes first instance: " + (list.size() == 2 && list.indexOf(1) == 1 && list.get(2) == -1));
        System.out.println("Remove returns -1 on element not in list: " + (list.remove(5) == -1));
        list.clear();
        
        System.out.println("Clear works: " + (list.size() == 0 && list.isEmpty() == true));

        list = new ResizableArray(5);
        list.append(5);
        list.append(4);
        list.append(2);
        list.append(3);
        list.append(1);

        selectionSort(list);

        test = new int[5];
        test[0] = 1; test[1] = 2; test[2] = 3; test[3] = 4; test[4] = 5;
        System.out.println("Selection sort implemented properly: " + Arrays.equals(test, list.getArray()));
    }

}