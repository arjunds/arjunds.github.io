---
title: Lecture 5 - OOP Semantics & Syntax
parent: Part 2 - Object Oriented Programming
nav_order: 2
---

# Lecture 5 - OOP Semantics and Syntax

## Field and Method Modifiers

Java has some keywords that are pretty helpful when it comes to working with methods and fields. We've already seen one of these - the `public` keyword on our `main` method. This is an access modifier - it determines who can access a method or a field. The most common access modifiers are `public` and `private`. `public` means that this can be access outside of the class, and `private` means it can only be accessed in the same class. There's one more access modifier that is used a little less commonly - `protected`. `protected` means that the field/method can be accessed only within the class, or a subclass. We'll learn more about subclasses and what this means at the end of this lecture.

Common practice is to make methods `public` because we want other classes to be able to call our methods, while keeping fields `private`, since we don't want other classes to be able to change attribute values unless we allow them to. This is why "getter" and "setter" methods are very common (such as `setName()` in `Dog`) - they retrieve or set the value of a field, since fields are usually private.

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

Object Oriented Programming has many benefits. It provides a clear structure in your program, delegates responsibility, and overall can be much more logical to read and write. All of these are encompassed by the programming principle, "Don't Repeat Yourself" (DRY). DRY promotes writing code that is logically separated so that each class and method provides functionality for a different task. You divide code into chunks so that each part can work individually and then combines seamlessly into a full program. This mentality ensures that every line of code you write is specific to the class or action you want it to do, and you reuse already written functions (or rewrite your code to avoid duplication) when you can.

## Inheritance

Inheritance is probably one of the most important parts of OOP and fully embodies the idea of DRY. The base idea of inheritance is to promote code reusability by having "parent" classes. A class might share some traits with another class, but then have some additional features as well. For example our `Dog` class might share common features with an `Animal` class. In this case, `Dog` would be a "child" of `Animal`. Child classes *inherit* all the attributes and methods of a parent class. Let's see what this looks like:

```java
public class Animal {
    protected String species; // all animals have a species
    protected int age; // all animals will have an age

    public Animal(String species, int age) {
        this.species = species;
        this.age = age;
    }

    public boolean isAlive() {
        return (age > 0 && age <= 100); // random metric I made up
    }

    public int getAge() {
        return age;
    }
}

public class Dog extends Animal {
    private String breed; // breed is specific to a dog

    public Dog (int age, String breed) {
        super("Canis familiaris", age); // calls the parent class constructor
        this.breed = breed;
    }

    @Override
    public boolean isAlive() {
        return (age > 0 && age <= 20); // random metric I made up
    }

    public String getBreed() {
        return breed;
    }
}

public static void main(String[] args) {
    Animal pet = new Dog(7, "Labrador");
    System.out.println(pet.isAlive());
    System.out.println(pet.getAge());
}
```

So this is a large code snippet with a lot of new things. Let's slowly digest it. First of all, the `Animal` and `Dog` classes, and the `main()` method, would all be in different files, but are condensed here for simplicity. First, I define a class named `Animal`. It looks pretty standard - nothing new here. However, when I make the `Dog` class, it *extends* `Animal`. This means that `Animal` is a "superclass" (parent) of `Dog` (making `Dog` the "subclass", or child). Like I mentioned before, `Dog` now *inherits* all of the fields and methods of `Animal`, meaning I don't need to redefine the `species` or `age` fields. In Dog's constructor, I do `super("Canis familiaris", age);`. The `super` keyword basically just calls the superclass method. Here, it calls the constructor for the animal class, passing in the species for dogs, and the age from the `Dog` constructor. We still need to set the value of `breed` so we do that as well. This means that after the `Dog` constructor is called, all 3 fields are set. Earlier, we glossed over the `protected` keyword, saying that it allowed subclasses to access those fields/methods. Here we see that in action: `Dog` is able to access `age` in the `isAlive()` method because `age` is a `protected` field.

{: .note }
If `age` was `private` instead of `protected`, `Dog` would need to use the `getAge()` method instead, because `private` restricts access to **only** the same class. You may see both `private` and `protected` used in superclasses depending on the context/programmer's preference

Moving onto the methods, because they both are `public`, `Dog` can access both of them. However, Dog's have a different metric of how old they usually live. So here, we "override" the `isAlive()` method from `Animal`, updating it with a new body. `@Override` isn't strictly necessary, but helps to specify to the programmer and the compiler that we are overriding a superclass's method.

## Polymorphism

Apart from code reusue, superclasses make inheritance a really useful through another semantic called "polymorphism". Polymorphism is the idea of having "many forms" – ie a superclass having many forms through its children. In our `main()` method, we define an `Animal` object, but create a new `Dog`.

This is polymorphism - the program knows that Dogs come from Animals, and therefore share attributes and methods of Animals. Therefore, I can call `isAlive()` and `getAge()` because they both are attributes of `Animal`. However, by the same idea, I can't call the `getBreed()` method on `pet` because that is specific to `Dog`.

The reason why polymorphism is so powerful is that I can have a method take in an `Animal`, and then pass in a `Dog`. Then when I call methods declared in `Animal`, it'll use overriden versions from `Dog`, if defined. So in our `main` method, it uses the `isAlive()` defined in the `Dog` class.

***

So this was a lot. I'd recommend taking a short break to process this and maybe reread the part on inheritance again. There's a couple more nuances to inheritance, but we'll cover those in part 3 - this introduction provides a starting point to work off of. But this covers most of the main semantic and syntax nuances of Java - from here you're pretty much ready to start programming large scale programs! The next lecture, we'll go over ArrayLists and sorting.

<span class="fs-4" style="text-align:center; display:block">
[Prev](Lecture4.md){: .btn .btn-blue}
[Next](Lecture6.md){: .btn .btn-blue .ml-2 }
</span>
