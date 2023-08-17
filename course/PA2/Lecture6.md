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

So here, we can see how much more ArrayLists can do over simple arrays. They're extrememly handy when you don't know how big you want your array to be, and know that it might expand/contract depending on the situation. One thing to note is how we created an ArrayList. In between `<>`, we put the class that we want to store in the ArrayList. We learned that `int` is a primitive data type, so we have to use the Java class equivalent - `Integer`. They represent the same thing, but `Integer` is just used for situations like this where you need a non-primitive data type.

You can read more on the ArrayList methods in the Java API [here](https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html).

## Sorting

The main purpose of introducing ArrayLists was partially to go over a very commonly used class in Java, but also to segue into sorting. The idea is very basic - take a list of data (let's say integers), and sort it in ascending order. There's many different ways to sort data, so we'll go over a few of them, along with ways to characterize performance of these sorting algorithms.

### Bubble Sort

Bubble sort is the simplest sorting algorithm (but also one of the least efficient). It basically works in theory by looping through the list and comparing the current value and the next one. Whichever one is larger, you swap to ensure its on the right, effectively "bubbling" it to the right-side of the list. You keep doing this until the list is sorted - ie you don't have to make any swaps. Let's see this in an example.

We have the list `[5, 2, 4, 6, 1]` which is clearly out of order. Bubble sort works by iterating through the list and simply ensuring that the largest number between a pair is on the right, stopping when we didn't swap any values. This is how our list would change in the first pass through it:

<pre>[<mark>5, 2</mark>, 4, 6, 1] &rarr; [2, <b>5, 4</b>, 6, 1] &rarr; [2, 4, <b>5, 6</b>, 1] &rarr; [2, 4, 5, <b>6, 1</b>] &rarr; [2, 4, 5, 1, 6]</pre>

Notice how since 5 and 6 don't swap, the list remains unchanged for two steps. Furthermore, it's only based on the current pair evaluated. Therefore, 1 is still in between 5 and 6. The algorithm would now go through the list again, making swaps as needed. We'll take a look at how another pass through would look like:

`[2, 4, 5, 1, 6]` &rarr; `[2, 4, 5, 1, 6]`