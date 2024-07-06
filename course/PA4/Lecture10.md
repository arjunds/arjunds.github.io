---
title: Lecture 10 - Stack & Queue
parent: Part 4 - Data Structure Cram
nav_order: 1
---

# Lecture 10 - Stack & Queue

## Intro to Data Stuctures

What are data structures? Data structures in CS are any sort of object that can *hold* data. Obviously an integer holds data, so more specifically, data structures can hold objects, primitives - anything you want. This means that arrays are data structures, along with ArrayLists and the ResizableArray class we made in Section 2. This section will focus on different types of data structures, and why we use certain types over others.

### What can Data Structures Do?

So we now know that data structures hold data, but what exactly are all data structures expected to do? When you use a data structure, you usually want to be able to *insert*, *remove*, and *lookup*. These are all key features of data structures, as these methods define how you manipulate the data you want to store. With this in mind, let's look at two different key data structures - stacks and queues.

### Stack

A Stack is a last in, first out, data structure (LIFO). This means that the last item placed into the stack is the first item that is retrieved. We can think of this like a stack of books, or any arbitrary item. When stacking books, if we want to take a book from the stack, we take the first (top) one off. The top one also must be the last one we placed, therefore making it last in, first out.

With a stack, we can *push* data onto the top of the stack, which adds data to our data structure. We can also *pop* data from the top, which removes the top element and returns it. Finally, we can *peek* data, which returns the top element without removing it. These operations are critical to how a stack functions with it's LIFO structure.

### Queue

Similarly to a stack, a Queue is a first in, first out, data structure (FIFO). This means that the first item in the queue is the first one that comes out. This is similar to a line to order food. The first person who got in line is the first person that orders. If you just joined the line at the end, you have to wait for everyone else to go first, before it's your turn.

With a queue, we again have *push*, *pop*, and *peek* functions (these may also be called *enqueue*, *dequeue*, and *front* respectively). However, the functionality differs slightly, since *push* will add to the end of the queue, *pop* will remove from the start of the queue, and *peek* will look at the front of the queue as well.

### Summary

Stacks and queues are the most fundamental linear data structures. By linear, it just means that the data is stored in a "straight line", so that there's a direct relation between adding data and removing it. This isn't always the case, as we'll see in later sections. Now, let's see how these data structures are actually implemented in code.

## Implementation

### Stack

```java
public class Stack {
    private int[] stack;
    private int size;
    private int numElements;

    public Stack(int size) {
        this.stack = new int[size];
        this.size = size;
        this.numElements = 0;
    }

    // return true if the push was successful
    public boolean push(int value) {
        if (numElements >= size) {
            return false;
        }
        stack[numElements] = value;
        numElements++;
        return true;
    }

    // return -1 if the pop is unsuccessful (empty stack)
    public int pop() {
        if (numElements <= 0) {
            return -1;
        }
        numElements--;
        return stack[numElements];
    }

    // return -1 if the peek is unsuccessful (empty stack)
    // also known as top
    public int peek() {
        if (numElements <= 0) {
            return -1;
        }
        return stack[numElements-1];
    }

    public boolean isEmpty() {
        return numElements == 0;
    }
}
```

This implementation is fairly straightforward. We use an array as the backend for our stack, which has a set size that we take in the constructor. When we `push()` an element, we increase the number of elements in the stack, and when we `pop()` we decrease it. `peek()` just returns the top value. We ensure we have checks to make sure that we aren't popping from an empty stack, or pushing to a full stack. Additionally, most data structures will have helper methods such as `isEmpty()` that allow you to easily query whether there's data or not.

### Stack

```java
public class Queue {
    private int[] queue;
    private int size;
    private int numElements;

    public Queue(int size) {
        this.queue = new int[size];
        this.size = size;
        this.numElements = 0;
    }

    // return true if the push was successful
    // also known as enqueue
    public boolean push(int value) {
        if (numElements >= size) {
            return false;
        }
        queue[numElements] = value;
        numElements++;
        return true;
    }

    // return -1 if the pop is unsuccessful (empty stack)
    // also known as dequeue
    public int pop() {
        if (numElements <= 0) {
            return -1;
        }
        
        int front = queue[0];

        // shift all the elements to the left by one
        for (int i = 0; i < rear - 1; i++) {
            queue[i] = queue[i + 1];
        }

        return front;
    }

    // return -1 if the peek is unsuccessful (empty stack)
    // also known as front
    public int peek() {
        if (numElements <= 0) {
            return -1;
        }
        return queue[numElements-1];
    }

    public boolean isEmpty() {
        return numElements == 0;
    }
}
```
The main difference between a queue and a stack is just whether we remove from the "front" or the "back", when thinking about it as a linear array. With a stack, we remove from the back, since it's LIFO, so removal was as easy as removing the last element. With a queue being FIFO, we need to remove the 0th index element, and then shift the remaining elements forward by one. This is what the for loop in `pop()` is doing.

This may seem pretty inefficient, so we'll see some better ways to implement a queue in the next section, using a technique called a Linked List.

## Summary

Overall, stacks and queues are pretty fundamental data structures that have important functions. The main reason we explicitly use a stack or a queue instead of just an array, is because these data structures **guarantee** certain functions, ie being LIFO or FIFO. Therefore, when we use them, we can automatically have certain assumptions about how the data goes in and out. This makes our life easier when we have code that use these data structures.

Stacks and queues are used broadly throughout computer science with different use cases and contexts. We may introduce some of these scenarios later in the course, but for now it's good to keep them in mind as a straightforward way to manipulate data.

***

<span class="fs-4" style="text-align:center; display:block">
[Prev](index.md){: .btn .btn-blue}
[Next](Lecture11.md){: .btn .btn-blue .ml-2 }
</span>