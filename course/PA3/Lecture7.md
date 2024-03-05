---
title: Lecture 7 - Abstract Classes & Interfaces
parent: Part 3 - Wrapping Up Basics
nav_order: 1
---

# Lecture 7 - Abstract Classes & Interfaces

## What is an Abstract Class or Interface?

Abstract classes and interfaces are types of classes that **can't** be instantiated as an object. Why would this be useful? Well if we look back to the examples in the previous section with `Animal` and `Dog`, can we really think of a situation where we want an `Animal` object? Not really - we're always going to instantiate the specific type of `Animal` we went, ie a `Dog`. But we still want the `Animal` class, since animals share similar traits and actions. This is where an abstract class comes in handy. We can define methods and fields that are inherited by the subclass, along with "abstract methods" that **must** be defined by the subclass (as we'll see very soon), providing an outline for what the child classes should look like.

What then is an "interface"? Interfaces are similar to abstract classes, except they only outline methods that the inheriting classes need to implement. Interfaces intend to provide a framework (or an interface) into how a class should operate. It specifies methods (and **only** methods) that the classes need to provide a definition for.

You can `extend` only one class, which makes abstract classes more of a parent-child relationship. However, you can `implement` as many interfaces as you want, making interfaces far more diverse.

Like we saw with polymorphism in the previous section, if a method takes in an "interface object" or an "abstract class object", then you can pass in any class that implements the specified interface or the abstract class, providing guarantees on what the parameter object can do. For example, if an interface guarantees a `print()` method, then if you have a parameter of that interface type, you're guaranteed the parameter will be able to call `print()` no matter what.

We'll see some code examples of how exactly this works.

## Using Abstract Classes

```java
public abstract class Animal {
    protected int age;

    public Animal(int age) {
        this.age = age;
    }

    // abstract method doesn't have a body
    public abstract boolean isAlive();
}

public class Dog extends Animal {
    private String breed; // breed is specific to a dog

    public Dog (int age, String breed) {
        super(age); // calls the parent class constructor
        this.breed = breed;
    }

    // define the body of the abstract method
    @Override
    public boolean isAlive() {
        return (age > 0 && age <= 20); // random metric I made up
    }

    public String getBreed() {
        return breed;
    }
}

public static void main(String[] args) {
    Animal generic = new Animal(10); // returns an error
    Animal pet = new Dog(7, "Labrador");
    System.out.println(pet.isAlive());
}
```

This long code snippet is very similar to the one from Lecture 5, where we first learned about inheritance. However, the major difference here is that `Animal` is an `abstract` class. This means that you cannot instantiate an object of type `Animal`, as shown in the main method. Furthermore, `abstract` classes can have `abstract` methods. These methods have empty bodies, placing the responsibility of defining the method on the subclass. Here, `Dog` **must** define `isAlive()`, otherwise there would be an error.

Next, we'll see how interfaces differ from abstract classes

## Using Interfaces

```java
public interface Animal {
    // interface methods don't have a body
    public boolean isAlive();
    public String getName();
}

// Dog now "implements" Animal
public class Dog implements Animal {
    // all of these fields are specific to Dog
    private String breed;
    private String name;
    private int age;

    public Dog (int age, String breed, String name) {
        this.breed = breed;
        this.age = age;
        this.name = name;
    }

    // Fill the method body for isAlive
    public boolean isAlive() {
        return (age > 0 && age <= 20); // random metric I made up
    }

    // Fill the method body for getName
    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }
}

public static void main(String[] args) {
    Animal generic = new Animal(10); // returns an error
    Animal pet = new Dog(7, "Labrador", "Buddy");
    System.out.println(pet.isAlive());
    System.out.println(pet.getName());
}
```

Here, we can see that the main difference between abstract classes and interfaces is that interfaces are very generic. They **only** provide method headers, and it's up to the child class to actually implement it. This is extremely useful when you want to guarantee that a class has certain methods you can call on it, and just pass in the interface, ie `Animal`, to a function. Then, you know that certain methods can **always** be called on the parameter. Because there are no fields at all in an interface, they are a little more limited than abstract classes. However, because you can `implement` *as many* interfaces as you want, there's a lot of flexibility by using them, as opposed to only being able to `extend` one class.

***

This lecture wrapped up the final two key parts of inheritance. We revisited how inheritance works in the context of abstract classes and interfaces, both of which force you to define method bodies in the subclass. The purpose of this is to ensure code security (only having code where you **need** to have it) and maintain that idea of `polymorphism` - having one type (such as `Animal`), take on multiple forms through its subclasses.

<span class="fs-4" style="text-align:center; display:block">
[Prev](index.md){: .btn .btn-blue}
[Next](Lecture8.md){: .btn .btn-blue .ml-2 }
</span>