---
title: Lecture 6 - ArrayLists & Sorting
parent: Part 2 - Object Oriented Programming
nav_order: 3
---

# Lecture 6 - ArrayLists & Sorting

## ArrayLists

We've covered arrays in previous lectures - a way to store a *fixed* number of values of the same data type. This works perfectly when we know how many elements we plan on storing ahead of time. It also makes our program faster, since our program knows how big the array is, and can optimize use its memory usage accordingly. However, what if we want to increase/decrease the size of our array? The only way to do this is by creating a new array with the new desired size, copying over the elements we want to keep, and then using this new array instead.

ArrayLists solve this problem. ArrayLists are a built-in Java class that basically extend arrays. With an ArrayList, you don't specify a size - you can increase and decrease the size of the list you use dynamically. When you need to add an element, it will automatically increase the size of the list to accomodate the new element. However, just like arrays, ArrayLists can only hold elements of the same data type.

This is all pretty straightforward - Java class that's similar to an array. Let's see how it's used in practice alongside arrays:

```java

public static void main(String[] args) {
    int[] array = new int[2]; // create a normal array of size 2
    ArrayList<Integer> list = new ArrayList<Integer>(); // create an integer ArrayList

    // setting the first 2 values
    array[0] = 1;
    array[1] = 3;

    list.add(1);
    list.add(3);

    // looping through both the array and the list
    for (int i =0; i < array.length; i++) {
        System.out.println(array[i]);
        System.out.println(list.get(i));
    }

    // ArrayList specific
    list.clear(); // empty the ArrayList

    // add some numbers
    list.add(5);
    list.add(7);
    list.add(9);
    list.add(11);

    int len = list.size();
    list.set(0, 4); // set element at index 0 to be 4

    list.remove(1); // remove element at index 1

    // shorthand way to write a for loop over an array or arraylist
    // it reads as "for each element 'variable name' in 'list' do .."
    for (int i : list) {
        System.out.println(i);
    }
}

```

So here, we can see how much more ArrayLists can do over simple arrays. They're extrememly handy when you don't know how big you want your array to be, and know that it might expand/contract depending on the situation. You can read more on the ArrayList methods in the Java API [here](https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html).

## Sorting