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

The main purpose of introducing ArrayLists was partially to go over a very commonly used class in Java, but also to segue into sorting. The idea is very basic - take a list of data (let's say integers), and sort it in ascending order. There's many different ways to sort data, so we'll go over a couple of them, along with ways to characterize performance of these sorting algorithms.

### Bubble Sort

Bubble sort is the simplest sorting algorithm (but also one of the least efficient). It basically works in theory by looping through the list and comparing the current value and the next one. Whichever one is larger, you swap to ensure its on the right, effectively "bubbling" it to the right-side of the list. You keep doing this until the list is sorted - ie you don't have to make any swaps. Let's see this in an example.

We have the list `[5, 2, 4, 6, 1]` which is clearly out of order. Bubble sort works by iterating through the list and simply ensuring that the largest number between a pair is on the right, stopping when we didn't swap any values. This is how our list would change in the first pass through it:

<pre>[<mark>5, 2</mark>, 4, 6, 1] &rarr; [2, <mark>5, 4</mark>, 6, 1] &rarr; [2, 4, <mark>5, 6</mark>, 1] &rarr; [2, 4, 5, <mark>6, 1</mark>] &rarr; [2, 4, 5, 1, 6]</pre>

The highlighted numbers above are the numbers that are being compared each iteration. Notice how since 5 and 6 don't swap, the list remains unchanged for two steps. Furthermore, it's only based on the current pair evaluated. Therefore, 1 is still in between 5 and 6. The algorithm would now go through the list again, making swaps as needed. We'll take a look at how another pass through would look like:

<pre>[<mark>2, 4</mark>, 5, 1, 6] &rarr; [2, <mark>4, 5</mark>, 1, 6] &rarr; [2, 4, <mark>5, 1</mark>, 6] &rarr; [2, 4, 1, 5, 6]</pre>

As you can see, the 1 is slowly being swapped to the left-side of the list. Furthermore, we have one less swap here since we already know that for 6 to be at the end of the list, it would have already compared with 5 transitively (either directly with 5 or with another number that was bigger than 5). Therefore, we don't need to compare it again and can stop after swapping 1 and 5. Eventually, the list will be `[1, 2, 4, 5, 6]`. Then, when bubble sort goes to compare the pairs, none of the values would swap, and therefore we know the list is fully sorted.

To summarize, the key idea of bubble sort is to iteratively "bubble" the larger numbers to the right and smaller numbers to the left.

How would this look like in Java?

```java
// example is on an array but it can be done on any list
void bubble_sort(int arr[])
{
    int i, j, temp;
    boolean swapped;
    int n = arr.length;

    // go through the array at most n - 1 times
    for (i = 0; i < n - 1; i++) {
        swapped = false;
        // go through all the pairs left - use n-i-1
        // since we keep decreasing how many potential swaps we need to do
        for (j = 0; j < n - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                    
                // Swap arr[j] and arr[j+1]
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
                swapped = true;
            }
        }

        // If no two elements were
        // swapped by inner loop, then break
        if (swapped == false)
            break;
    }
}
```

Try to understand the code above and what is happening - feel free to take a few minutes to copy it and add some print statements. Maybe run it on our example list above and see what happens. To see if you really understand what's going on, think about what changes need to be done to make this sort a list into descending order instead of ascending.

### Insertion Sort

The next sorting method we'll go over is insertion sort. At a high-level, the most common analogy to understand insertion sort is sorting cards. With a hand of cards, you sort it by going through it, and once you find something out of place, you move it back until it's less than the cards behind it, and larger than the cards in front of it. Similarly, insertion sort iterates through a list, and then once you find a value whose predecessors are larger than it, you loop back, swapping until it's in the right position. These swaps can be abstracted as you "inserting" the out of place value into the correct spot. Let's see an example with the same list as before: `[5, 2, 4, 6, 1]`.

1. As we iterate, we can immediately see that 2 is out of place - 5 is greater than 2. Therefore, we insert 2 at the front of the list, resulting in `[2, 5, 4, 6, 1]`
2. Then, we continue from 4. 5 is also greater than 4, so we insert 4 in between 2 and 5 to maintain the ascending order: `[2, 4, 5, 6, 1]`
3. Next, we check 6, but see that all the values before 6 are smaller than it, so we continue on to 1. 1 is clearly smaller than everything before it, so we insert it at the front of the list, resulting in the sorted version, `[1, 2, 4, 5, 6]`

The algorithm in Java would look like:

```java
void insertion_sort(int arr[])
{
    int n = arr.length;
    // starts at index 1 since we need predecessors to compare against
    for (int i = 1; i < n; ++i) {
        int key = arr[i];
        int j = i - 1; // get previous element

        /* Move elements of arr[0..i-1], that are
        greater than key, to one position ahead
        of their current position */
        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j]; // push up values to "fill in" gap left by removing key
            j = j - 1;
        }
        arr[j + 1] = key; // add key back into the list at the correct spot
    }
}
```

Just like with bubble sort, take a few minutes to fully digest what this code does. And definitely Google it to see other examples and explanations of how these sorting algorithms work. There's only so much that can be conveyed with text - sometimes learning in other ways is helpful.

### Performance

We'll go far more in depth on performance when we more formally cover algorithms later in the course, but it's good to get the idea started, especially when we've now introduced a few algorithms already.

What is performance? It's basically how efficient your code is - how many lines of code are actually executed. This is hard to quantify and very variable on the different inputs to the program and such, so we usually look at the worst-case performance (though depending on the context worst-case doesn't matter - ie you know for sure the worst-case would never happen). Loops introduce large performance uncertainties - by looping, you repeat instructions multiple times, potentially adding bottlenecks in your code. If you have one for loop that runs 5 times, it's not so bad, but the moment you nest the same for loop again inside, it's running 25 times! This is why performance is a key part of writing code and desigining algorithms; you want something that can not only solve the problem, but also do it efficiently.

For now, we don't really care about efficiency, but just keep it the back of your head as you continue with the course and we'll fully revisit it later. For example, think about the worst-case scenarios for bubble and insertion sort. Insertion sort seems to be "better" than bubble sort - it took seemingly less steps. However, "inserting" is just continuously swapping. So is it actually any faster than bubble sort? Try it out yourself with a small worst-case scenario (the worst-case scenario for lists would be one sorted in descending order already that you want to sort into ascending order).

***

This was a really in-depth lecture that initally covered a useful class in Java - ArrayLists - and then gave us our first taste of writing algorithms with sorting. The assignment will have you implement your own ArrayList by wrapping around an array, and then implement a different sorting method that isn't bubble or insertion sort.

<span class="fs-4" style="text-align:center; display:block">
[Prev](Lecture5.md){: .btn .btn-blue}
[Next](A2.md){: .btn .btn-blue .ml-2 }
</span>