---
title: Lecture 4 - Object Oriented Programming (OOP)
parent: Part 2 - Object Oriented Programming
nav_order: 1
---

# Lecture 4 - Object Oriented Programming (OOP)

## What is OOP?

OOP is a common programming practice, or paradigm, where a program is separated into objects that each contain specific traits (fields) and actions (methods) that you can perform on them. A complete program would be multiple of these objects stitched together, instantiated from the main method.

There are many languages that are object-oriented, Java being one of them. However, there are still a few common languages that aren't object-oriented. We'll talk more about the tradeoffs between OOP and other language paradigms later, but for now let's better understand how OOP looks in Java.

## What are Objects?

So our basic premise of OOP is that we need to be able to divide our program into *distinct* functionalities, or these objects. But before we get into objects specifically, we need to talk about classes.

Remember how in the last lecture and first assignment, we had a line in our java files saying `public class` followed by `HelloWorld` or `A1`? Well, these are classes. A class is just a collection of java information. It can hold some variables, some functions. Everything you write in Java **must** be encapsulated in a class structure. This seems kind of confusing though - what are objects then and what are these classes used for?

Well, objects are instantiations of a class. It's like how dogs are animals, and all dogs can cuddle and play fetch, but then you have a specific representation of a dog - your pet or your neighbors pet. This specific dog still cuddles and fetches, but now has a specific species and name. This might seem super hand-wavy so let's think about an example you've seen before: Java Strings

Java Strings are actually just Objects! All Strings have certain capabilities that you can do (remember the methods you looked at in the String API from PA1), but what's the purpose of doing `length()` on a "`String`"? It doesn't really have a meaning. You want to have a String-typed variable with a value to call the `length()` method on. Strings are a Java class, and any String you create is an Object.

So to summarize, at their core, Objects are just concrete implementations of Classes, which are in turn just a collection of attributes and methods. But reading all this text about them doesn't really help to understand how to create/use our own Classes and Objects. So let's try to figure that out.

## Implementing Classes

Using our example of dogs, let's try to create a Dog class. First we need to specify that by creating a new file called `Dog.java` (as mentioned in the last lecture, filename should correspond to the class name). The initial lines we put in the file are:

```java
public class Dog {

}
```

to indicate that we have a class called `Dog`. Now, all dogs have certain traits. These might be unique to each dog, but they're things that **all** dogs have. For example, all dogs have a species, a name, or an age. These are all fields - traits that are global to dogs.

```java
public class Dog {
    String species;
    String name;
    int age;
}
```

We define fields outside of any functions, inside of the class. Remember variable scope? Declaring it just inside the class means that we can use these traits throughout the `Dog` class.

Dogs also have actions that they all perform. Some examples are fetching or barking. These are methods that we can define. Methods, also known as functions, are blocks of code that perform very specific tasks. They can optionally return a value, and can take in parameters. Lets see what this looks like in our `Dog` class:

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

The `this` keyword does this. `this` refers to *any* global attribute or method of a class. I could do `this.species` anywhere in the `Dog` class, or `this.bark()`, and have access to the field and call the method. This is **imperative** to do to ensure that you are properly using the global attributes/functions. The code snippet below, for example, would just set the parameter `name` to be itself, without touching the global value at all.

```java
void setName(String name) {
    name = name;
}
```

## Using Objects

So we've covered a lot of material on what classes are and implementing fields and methods to make a class "usable". But how do we actually use a class by instantiating objects?

Before we get into the syntax of instantiation, we need to cover one last aspect of classes - constructors.

Constructors define what happens when you create a new object. With our running `Dog` class example, say we wanted to set the values of the fields when we create a new dog object. We can do that with a constructor. We can think of a constructor as a special type of method that *never* returns anything, and is called when the class is instantiated into an object.

A common example of a constructor for `Dog` would look like:

```java
public Dog(int age, String species) {
    this.name = "";
    this.species = species;
    this.age = age;
}
```

This is a fairly common structure for a constructor - we take in parameters for the fields we want to set, update the field values to be that, and set a default value for any remaining fields (name is set to an empty string here). If you don't define a constructor, Java will just use a default constructor that does nothing on object instantiation.

Constructors aren't just limited to setting field values (though this is what they're most commonly used for). They can also be used to run code that you **always** want to run when an object is instantiated, or to handle different use cases for a class based on the constructor being called.

Now to finally get to creating an object. I'm going to create a new `Dog` object in a main method, assuming all of the previous code snippets were combined into one class.

```java
public static void main(String[] args) {
    // create a new Dog object. This is just a variable named "ace" of type "Dog"
    Dog ace = new Dog(5, "Golden Retriever");
    // call the setName() method, passing in a name
    ace.setName("Ace");
    int bone = ace.fetch();
    ace.bark();
}
```

So this main method creates a new dog. Notice that this is just like creating any other variable - just now we're using a custom class that we defined. This includes being able to access methods we wrote, such as `setName()`, `fetch()`, and `bark()`, with each of these methods acting exactly how we'd expect. The constructor will set Ace's age and species. The `setName()` method will update his name from an empty string (default set in the constructor) to "Ace". The `fetch()` method returns an integer, so we save that in another variable for future use. And lastly, `bark()` would print to the command-line, just like we programmed.

***

This was a quick, extensive rundown on how object oriented programming works. We went through what it is, how to implement classes, and how to actually use classes by instantiating objects. Next up, we'll go over some Java semantics and syntax that directly tie into Classes and Objects

<span class="fs-4" style="text-align:center; display:block">
[Prev](index.md){: .btn .btn-blue}
[Next](Lecture5.md){: .btn .btn-blue .ml-2 }
</span>