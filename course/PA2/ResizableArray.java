
public class ResizableArray {
    
    private int[] list;
    private int size;

    public static final int SIZE_INCREMENT = 10;

    public ResizableArray() {
        // if you aren't sure what this() does look it up!
        this(ResizableArray.SIZE_INCREMENT);
    }

    // TODO
    public ResizableArray(int startSize) {
        // create a new int array here
        // set size appropriately (hint: are there any elements in the list initially?)

        size = 0;
        list = new int[startSize];
    }

    // TODO
    public boolean isEmpty() {
        // placeholder to compile
        return size == 0;
    }

    // TODO
    public int size() {
        // placeholder to compile
        return size;
    }

    // TODO
    // Note: this method is private because users shouldn't be able to access it
    private void resize() {
        // This method should increase the size of the list by SIZE_INCREMENT amount
        // It should create a new int array, copy over all the elements of the current
        // one and then set the field to the new array

        if (size < list.length)
            return;

        int[] temp = new int[list.length + SIZE_INCREMENT];
        for (int i = 0; i < list.length; i++) {
            temp[i] = list[i];
        }

        list = temp;
    }

    // TODO
    public void append(int element) {
        // append the element to the end of the list, resizing as needed
        // don't forget to increment size!

        resize();
        list[size] = element;
        size++;
    }
    
    // TODO
    public void insert(int element, int index) {
        // this should insert the specified element at the specified index
        // it should effectively shift all elements to the right of the index
        // over. Resize as needed
        resize();
        for(int i = size; i > index; i--) {
            list[i] = list[i-1]; // shift right
        }
        list[index] = element;
        size++;
    }

    // TODO
    public int indexOf(int element) {
        // similar to String's indexOf(), return the index of the first instance
        // of element in the list. If element is not in the list, return -1
        for (int i = 0; i<size; i++){
            if (list[i] == element) {
                return i;
            }
        }
        return -1;
    }

    // TODO
    public int get(int index) {
        // return the element at the given index, or -1 if the index is out of bounds
        if (index < 0 || index >= size) return -1;

        return list[index];
    }

    // TODO
    public int remove(int element) {
        // remove the first instance of the specified element from the list
        // this shouldn't leave a gap in the list, so any elements to the right
        // of the removed one should be shifted to the left
        // By convention, remove methods tend to return the removed element, or -1
        // if the element isn't in the list

        int rIndex = -1;
        for(int i = 0; i < size; i++) {
            if (list[i] == element) {
                rIndex = i;
                break;
            }
        }

        if (rIndex == -1) return -1;

        for (int i =rIndex; i<size-1; i++) {
            list[i] = list[i+1];
        }

        size--;

        return element;
    }

    // TODO
    public void clear() {
        // remove all elements in the list
        size = 0;
    }


    // Methods below are just used for testing in A2.java

    public int[] getArray() {
        return list;
    }

    public int getSize() {
        return size;
    }

    public void swap(int i, int j) {
        if (i < 0 || j < 0 || i >= size || j >= size) return;

        int temp = list[i]; list[i] = list[j]; list[j] = temp;
    }

}