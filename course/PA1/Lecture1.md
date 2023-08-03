# Lecture 1 - Java Refresher

Initially, we will use Java as the basis for learning programming concepts. Java has a fairly mild learning curve, is similar to many other languages, and provides a good baseline for a first language to learn. It is also fairly commonly used in practice, though the use cases tend to vary and other languages have taken over some of the common applications of Java, for reasons I'll discuss towards the end of the course.

However, the key takeaway shouldn't be to tie yourself to a specific language. Almost all languages share similar ideas, concepts, and constructs, and learning Java should hopefully enable you to use other languages as well with a little amount of Google/ChatGPT.

## Variables/Typing

To begin this quick refresher, any programming language you use will have variables. Here are some examples of variables below:

`int x = 5;`

`boolean y = true;`

`double z = 3.14;`

`char a = 'a';`

Here, we’ve defined the variables `x` , `y` , `z` , and `a` to have different values. Variables **must** have a type, and these types are categorized into “primitive” data types and “non-primitive” data types. The terminology and categorization can vary from language to language, but the key idea is that there are certain “base” types that are always representable. In some languages you might not need to declare a type explicitly (such as how in Python, the type is tied to the value assigned, not the variable). In Java, however, variables are assigned a type and are held to those types.

In Java, these types are `char` which represents a single character, `int` which represents an integer value (non-decimal), `boolean` which represents a true or false value, and then `double` which represents a decimal value. Some other variants you may come across are `byte` , `short` , and `long` which are for different sized integer values if you know you need to store smaller or larger values, and similarly `float` for smaller decimals.

What are "non-primitives" then? These are more complex data types. A very common example of a non-primitive is an array. An array can store a defined number of items of the same datatype. I can make an array of any datatype, primitive or non-primitive. I can even make an array of arrays (and so on)!
Here are some examples of using arrays:

`int[] arr = new int[5];` creates a new array of 5 ints that is empty
`int[] arr = {1,2,3,4};` creates an array of 4 ints that has values already initialized

To access an element from the array, I can do `arr[2]` to get the value `3`. Arrays use 0-indexing, meaning that the first element is the "0th" and it continues until `size-1`.

You can also initialize a variable size array by doing:

```java
int n = 3;
int[] arr = new int[n]
```

This would make an array of size `n`, where `n` in this instance is 3, but could be any integer value (user input, etc)

**Note: Arrays are fixed length. This means that once I define an array of a certain size, I can't expand it from, say, 4 to 5 elements, or even contract it from 4 to 3. If I want to change the size, I have to create a new array of the desired size, and copy over elements from the existing array as needed.**

The other type of non-primitive type in Java are classified as Objects. These have many names and different capabilities and limitations across different languages, but the key idea is that Objects can represent a consistent set of datatypes under one name. They're similar to arrays, except instead of only holding values of the same type, they can hold values of multiple different datatypes. We'll go into objects more in depth in the next set of lectures.

## Conditionals

Remember the primitives we just learned about - booleans? In all languages, there are statements called “Boolean expressions," which are just statements that evaluate to either true or false, meaning they evaluate to a Boolean. You can do something like `x < 5` or `y == 4`. One thing to note is that `=` is used for assigning values while `==` is used for comparing values. To check for values that aren't equal, you can do `!=`. If I want to combine Boolean expressions, I can use && to only return true if *both* expressions are true and `||` to return true if *either* expression is true. This can be chained for as many operations as you want. You can also do a negation with `!`, effectively inverting the expression to the opposite Boolean value.

Outside of these "logical operations" there are also normal numerical operations. Addition(+), subtraction(-), division(/), multiplication(*), and modulus(%) are natively supported, along with in place incrementation(++) and decrementation(`—-`). For a more detailed guide on all valid operations, check out this [link](https://www.w3schools.com/java/java_operators.asp).

This all might seem super arbitrary, so let's see how it's useful: conditionals.

Conditionals allow us to decide what to do based on an expression. The 2 forms of conditionals in most languages are `if` and `switch`. If statements take a Boolean expression as such: `if(x <= 4)` or `if(y != 1 && z > 5)` and if it's true, it proceeds to run the specified code. If it's false, it looks for an `else if` or `else` statement. Else ifs are just secondary conditions that are *only* checked if the initial if statement is false. Else statements are *always* run if all `if` and `else if` statements are false. Therefore, you must have an `if` for both `else if` and `else`, but an `if` can be on it's own. This is all fairly logical - we can think of it in words as "if something happens, do *this*, else if this other thing happens, do *something else*, or if neither of those happened, do *that thing*"
In a very general sense in code, this looks like:

```Java
if (expression1) {
    statements;
} else if (expression2) {
    statements;
} … // as many else ifs as you want
else {
    statements;
}
```

Another type of conditional is a `switch` statement. Instead of using Boolean expressions, it decides what to execute based on a value. This is useful when you want to do something based on a variable that can take multiple values. An example might be if you want to do something if a user enters a specific character - say continue on `'c'` or quit on `'q'`. You can also specify a default case if you choose to.
Switch statements look like:

```Java
switch (expression) {
    case case1:
        statements;
        break;
    case case2:
        statements;
        break;
    default:
        statements;
        break;
}
```

In this example, `expression` is what we want to decide execution based on. It could be a variable, a Boolean expression, or just a normal expression. `case1` and `case2` are 2 values that `expression` can take on that we care about. We can have as many of those "cases" as makes sense for the context of the `switch`. The optional `default` is there if `expression` takes a value other than `case1` or `case2` and we still want to do something.

**Note: the `break` after each case in the `switch` is important. It tells the program that we are done with the switch statement and to exit it. If we removed the break, it would continue to compare `expression` to the remaining cases (and potentially run the `default` case)**

Let's look at an actual example of a `switch` statement. Say we have a string input from the user stored in `input` and we want to execute `statement1` when `input` is `CS` and execute `statement2` when it's `PA`. In the default case we execute `statement3`. This would look like:

```Java
switch (input) {
    case "CS":
        statement1;
        break;
    case "PA":
        statement2;
        break;
    default:
        statement3;
        break;
}
```

## Loops

Loops are super useful for when we have code that runs multiple times until some condition is met. There are 2 main kinds of loops: `while` and `for`.

While loops are when you want to run some code until a condition is met. It works great when you have something being updated inside the loop and want to loop until that reaches a certain value or stops being a certain value. Because of this, while loops are extremely simple:

```Java
while (expression) {
    statements;
}
```

`expression` must be a Boolean expression, and if it never becomes `false` then you get an "infinite loop". Be sure to keep an eye on this when writing while loops as it's a very common mistake to make (but can be hard to figure out)!

The other kind of loop is a for loop. For loops are perfect when you want to iterate a specific number of times. This could be to go through the contents of an array, or to effectively be a counter. The syntax is slightly more complicated but still fairly straightforward.

```Java
for (initialization; condition; update) {
    statements;
}
```

`Initialization` is where you initialization the counter variable just as you would any other variable. `condition` is the condition for stopping the loop. This doesn't need to use the counter variable, but it's extremely good practice to do so outside of very niche situations. `update` is called at the end of each loop iteration and updates the counter variable as you choose.

A `for` loop to count every even number up to, but not including 10, would look like this:

```Java
for (int i = 0; i < 10; i+=2) {
    // do something with i here
}
```

This will initialize a new variable `i` to 0, then loop until `i` is greater than or equal to 10. Every iteration it increments `i` by 2.

For loops can also be represented by a while loop - how do you think that could be?
***

That concludes the basic programming fundamentals/syntax refresher - the next lecture will wrap it up with using Strings, variable scope, and actually running programs.
