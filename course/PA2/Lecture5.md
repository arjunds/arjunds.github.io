---
title: Lecture 5 - OOP Semantics & Syntax
parent: Part 2 - Object Oriented Programming
nav_order: 2
---

# Lecture 5 - OOP Semantics and Syntax

## Field and Method Modifiers

Java has some keywords that are pretty helpful when it comes to working with methods and fields. We've already seen one of these - the `public` keyword on our `main` method. This is an access modifier - it determines who can access a method or a field. The most common access modifiers are `public` and `private`. `public` means that this can be access outside of the class, and `private` means it can only be accessed in the same class. Common practice is to make methods `public` because we want other classes to be able to call our methods, while keeping fields `private`, since we don't want other classes to be able to change attribute values unless we allow them to. This is why "getter" and "setter" methods are very common (such as `setName()` in `Dog`) - they retrieve or set the value of a field, since fields are usually private.

`private` and `public` is pretty self-explanatory, but the wackier modifiers fall outside the access modifier group. They determine *how* a field or method can be used. The two main ones are `final` and `static`. `final` is used only for fields. If a field is `final`, it means that its value cannot be changed after setting it. This is useful for defining constants that you know will never change.

`static` is a little trickier. It means that you *don't* need an object to use the method or field. Let's say I have the following field and methods in `Dog`:

```java
private static int numDogs;

public static int getNumDogs(){
    return numDogs;
}

public static void incNumDogs(){
    this.numDogs++;
}
```

Here, `numDogs` is a static field in the `Dog` class. If I wanted to retrieve the value of it, I could call the `getNumDogs()` method, and similarly increment its value with `incNumDogs()`. The difference with these being static methods (because it's for a static field), is that to call these methods, I would do `Dog.getNumDogs()` or `Dog.incNumDogs()`. Because of the `static` keyword, I don't need to create an Object to actually interact with the fields and methods. This also means that if I increment `numDogs`, it applies for all instances of the `Dog` class during the program's runtime. This example is representative of that - if I increment `numDogs` in the `Dog` constructor, for example, it would track how many dogs have been created. The value of `numDogs` would be shared among all these objects since it's tied to the class itself.

This isn't a comprehensive guide to keywords, but covers the 4 most common ones. If you want to delve deeper into it, or just try to understand it a little better, go [here](https://www.w3schools.com/java/java_modifiers.asp).

## Method Overloading

Method overloading is another Java semantic that comes in handy when designing classes. Sometimes, you want to have methods that perform a very similar functionality, but might take in differing parameters. For example, you might have a `bark()` method that just prints "Woof!" if you call it with no parameters, but might print something else if you pass in a string, or it might print out something a certain number of times if you pass in an integer. With Java, we can define multiple `bark()` methods, *as long as they have different parameters*. The above example in a code snippet might look like this:

```java
public void bark() {
    System.out.println("Woof!");
}

public void bark(String s) {
    System.out.println(s);
}

public void bark(String s, int n) {
    for (int i = 0; i < n; i++) {
        System.out.println(s);
    }
}
```

Depending on what parameters you pass into the `bark()` method when you call it, Java will determine which version of the method you want to call. A consequence of method overloading is that you can have multiple constructors as well. Remember how we defined constructors as "special methods"? Well, by the same rules, we can have multiple constructors, as long as they take in differing parameters to differentiate them.

## Why Use OOP?

## Inheritance

Inheritance is probably one of the most important parts of OOP.