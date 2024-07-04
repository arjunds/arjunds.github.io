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

***

<span class="fs-4" style="text-align:center; display:block">
[Prev](index.md){: .btn .btn-blue}
[Next](Lecture11.md){: .btn .btn-blue .ml-2 }
</span>