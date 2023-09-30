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

***

<span class="fs-4" style="text-align:center; display:block">
[Prev](index.md){: .btn .btn-blue}
[Next](Lecture8.md){: .btn .btn-blue .ml-2 }
</span>