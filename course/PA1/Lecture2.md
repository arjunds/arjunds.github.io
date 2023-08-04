---
title: Lecture 2 - Strings and Scope
parent: Part 1 - Java Refresher & Setup
nav_order: 2
---

# Lecture 2 - Strings and Scope

## Strings

Strings are a key part of any programming language. Being able to represent text is key to being able to make a program more user interactive. But how do we represent pieces of text in our programs? Java has a built in String type that falls under the "Object" class of non-primitives. What this String type does behind the scenes is just represent an array of `chars`. Because after all, a String is just a list of characters concatenate together. With this in mind, we can work with Strings as if they were just collections of characters - we can iterate through all their characters, we can access specific characters, and we can modify or delete characters.

A basic example of creating a String looks like:

```Java
String s = "Hello World!";
```

To print a String in Java, we can use the line `System.out.println();` to print a string passed in followed by a newline, or `System.out.print()` to do the same except without the newline.

So to print our string `s`, we can do

```Java
System.out.println(s);
```

This is also handy for printing out any variable, so that when you debug, you can get real time information on what its value is.

Since there's so much you can do with strings, I'm going to point you to the String API. APIs are collections of references that explain how to use a library or piece of code. The String     API will give detailed instructions on different methods you can call on a string along with examples. Learning how to read APIs is key to programming and will be very useful for the first PA. The Java String API can be found [here](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/String.html)

## Scope

The other part to this short lecture is variable scope. We learned about defining and using variables, but how long can we actually access them for? The simple answer to that is until the end of their corresponding curly bracket. But what does that actually mean?

If I have the following code:

```Java
int x = 0;
if (x == 0) {
    int y = 3;
}
```

Trying to access `y` outside of the `if` would result in an error. This is because it was defined in the `if` and therefore can only be accessed inside the `if`. It doesn't actually exist outside the `if` so the program has no clue what it is. If there was a `for` loop in the if statement, I could access `y` in the for loop and anything further nested, but the moment I exit this main `if`, I can't access `y`.

This makes logical sense since we should only be able to access something within the area it was defined for, or it's scope. But when can this be an issue? Take a look at the following code snippet:

```Java
int x = 0;
if (x == 0) {
    int x = 3;
}
```

Here I have 2 variables in overlapping scopes that are named `x`. Is this valid code?

It is actually. But then what happens if I try to access `x` in the if statement? It uses the one with the most recent scope. This means that it will use the local variable to the `if` statement, where `x = 3` instead of the one where `x = 0`, because the former was defined in the closer to the current scope. However, the moment we exit the `if` statement, the variable whee `x = 3` will be out of scope, and the one `x = 0` will be used because it is still in scope.

***

In the next lecture, we'll wrap up with setting up Java and VSCode, along with an understanding of compiling and running Java code.
