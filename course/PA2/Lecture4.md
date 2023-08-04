---
title: Lecture 4 - Object Oriented Programming (OOP)
parent: Part 2 - Object Oriented Programming
nav_order: 1
---

# What is OOP?

OOP is a common programming practice, or paradigm, where a program is separated into objects that each contain specific traits (fields) and actions (methods) that you can perform on them. A complete program would be multiple of these objects stitched together, instantiated from the main method.

There are many languages that are object-oriented, Java being one of them. However, there are still a few common languages that aren't object-oriented. We'll talk more about the tradeoffs between OOP and other language paradigms later, but for now let's better understand how OOP looks in Java.

# What are Objects?

So our basic premise of OOP is that we need to be able to divide our program into *distinct* functionalities, or these objects. But before we get into objects specifically, we need to talk about classes.

Remember how in the last lecture and first assignment, we had a line in our java files saying `public class` followed by `HelloWorld` or `A1`? Well, these are classes. A class is just a collection of java information. It can hold some variables, some functions. Everything you write in Java **must** be encapsulated in a class structure. This seems kind of confusing though - what are objects then and what are these classes used for?

Well, objects are instantiations of a class. It's like how dogs are animals, and all dogs can cuddle and play fetch, but then you have a specific representation of a dog - your pet or your neighbors pet. This specific dog still cuddles and fetches, but now has a specific species and name. This might seem super hand-wavy so let's think about an example you've seen before: Java Strings

Java Strings are actually just Objects! All Strings have certain capabilities that you can do (remember the methods you looked at in the String API from PA1), but what's the purpose of doing `length()` on a "`String`"? It doesn't really have a meaning. You want to have a String-typed variable with a value to call the `length()` method on. Strings are a Java class, and any String you create is an Object.

So to summarize, at their core, Objects are just concrete implementations of Classes, which are in turn just a collection of attributes and methods. But reading all this text about them doesn't really help to understand how to create/use our own Classes and Objects. So let's try to figure that out.

## Implementing/Using Classes & Objects

Using our example of dogs, let's try to create a Dog class. First we need to specify that by creating a new file called `Dog.java` (as mentioned in the last lecture, filename should correspond to the class name). The initial lines we put in the file are:

```java
public class Dog {

}
```

to indicated that we have a class called `Dog`. Now, all dogs have certain traits. These might be unique to each dog, but they're things that **all** dogs have. For example, all dogs have a species, a name, or an age. These are all fields - traits that are global to dogs.

```java
public class Dog {
    String species;
    String name;
    int age;
}
```

We define fields outside of any functions, inside of the class. Remember variable scope? Declaring it just inside the class means that we can use these traits throughout the `Dog` class.

Dogs also have actions that they all perform. These can be cuddling, fetching, or barking. These are methods that we can define. Methods, also known as functions, are blocks of code that perform very specific tasks. They can optionally return a value, and can take in parameters. Lets see what this looks like in our `Dog` class:

```java
public class Dog {
    String species;
    String name;
    int age;

    void bark() {
        System.out.println("Woof");
    }

    int fetch() {
        return 1;
    }

    void setName(String name) {
        this.name = name;
    }
}
```

So here we've introduced a lot. Let's break it down.

The first two methods, `bark()` and `fetch()` are fairly straightforward. We can return a value by specifying before the function name what the return type is (ie `int` for `fetch`). If there is no return value, we use the keyword `void`, like I did for `bark`.

{: .note }
Returning and printing are not the same thing. `bark()` prints out to the command line, but when we call `fetch()` it actually returns a usuable value that we can then save into a variable, use in a conditional, etc. We'll see more examples of this later on.

The final method, `setName()` takes in a parameter `name`. For parameters in Java, we need to specify what type they are. This method updates the global field `name` with the parameter `name`. If you remember variable scope, the parameter `name` takes precedence here. Therefore, we need a way to be able to refer to the global trait.

The `this` keyword does this. `this` refers to *any* global attribute or method of a class. I could do `this.species` anywhere in the `Dog` class, or `this.bark()`, and have access to the field and call the method. This is **imperative** to do to ensure that you are properly using the global attributes/functions. This code, for example, would just set the parameter `name` to be itself, without touching the global value at all.

```java
void setName(String name) {
    name = name;
}
```
