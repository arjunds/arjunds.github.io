---
title: Lecture 3 - Setup & Running Code
parent: Part 1 - Java Refresher & Setup
nav_order: 3
---

# Lecture 3 - Setup & Running Code

## Setup

So we learned some basic Java concepts, but now we actually want to put them to use. That means we need to run code. But before we can do that, we need to do some basic setup.

You can use any sort of text editor to write code. However, using an application that is specific for programming is beneficial, since it can have a bunch of features that generally make your life easier. The most commonly used one in industry is VSCode. There's plenty of VSCode tutorials and multiple extensions you can use to customize it (I think there's a pet dog one and definitely a subway surfers one because our attention spans are so bad). You can download it [here](https://code.visualstudio.com/download). In VSCode the Java extensions you should get are all in the "Extension Pack for Java".

Now that we have VSCode setup, we can write the programs, but there's still one more step to actually be able to run them. We need to have some way to compile and run the Java programs on our computers. To do this, download Oracle's Java Development Kit (JDK). You can get that [here](https://www.oracle.com/java/technologies/downloads/).

Once everything is installed, we can finally make a simple program to get started.

## Running Code

In the previous lectures we learned about different structures and concepts in Java, but how do we actually run any of this? We need something called a main method. A main method is a function all Java programs **must** have. When we run our program, Java will look for the main method and run it. All code we write must either be in the main method, or be called from the main method, otherwise it won't run.

What does the main method look like? It's very straightforward actually:

```java
public static void main(String[] args) {
    // code goes here
}
```

In our first assignment we'll just be writing all our code here, but as we progress, we'll learn how to split it up and make it far less messy.

So let's go ahead and write a very basic program - print "Hello World!". Create a new file called `HelloWorld.java` and put the following code in it:

```java
import java.util.*;

public class HelloWorld {
    public static void main (String[] args){
        System.out.println("Hello World!");
    }
}
```

Here the `import java.util.*;` just imports utilities that Java has, such as the printing function we briefly discussed last lecture.

This code snippet creates a new class named `HelloWorld`. We'll go more in depth on classes in the next lecture, but just remember that the class name **must** correspond to the filename. Then, we create a `main` method that just prints out "Hello World!".

The first step is to compile the code. This translates the human-readable Java code into an intermediate version that is more easily understood by the computer. Any syntax or typing errors are identified at this stage. Then, we can run the code by running this file.

To compile our file, we can goto the terminal (bottom screen in VSCode) and run the command `javac HelloWorld.java`. This should generate a new file `HelloWorld.class`. To run the program, we can do `java HelloWorld`. You should see the line "Hello World!" printed out. Feel free to mess around with this further using the info learned in the past 2 lectures.

***

With that, you should have enough info to get started on the first assignment. Because of the style of the course, the assignment writeups will conveyed through comments in the Java files, until they become too complicated for that. Take a look at `A1.java` to get started!

<span class="fs-4" style="text-align:center; display:block">
[Prev](Lecture2.md){: .btn .btn-blue}
[Next](A1.md){: .btn .btn-blue .ml-2 }
</span>