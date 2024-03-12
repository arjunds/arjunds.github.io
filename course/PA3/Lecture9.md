---
title: Lecture 9 - Recursion
parent: Part 3 - Wrapping Up Basics
nav_order: 3
---

# Lecture 9 - Recursion

## What is Recursion?

What is recursion? You may have heard this term before (if not, don't worry!), and may not fully understand what it is. The simplest way of explaining what recursion is, is that it's when a function calls itself. Now this is somewhat a crazy idea. A function. That we're currently writing and defining. Is going to call itself. But yes, it is actually possible. And we will see how that works, and why it's so important

## How does Recursion Work?

For our function to call itself, there are a couple things that need to happen. Firstly, we need to ensure that we have some way to stop calling ourself. Otherwise, our function will go through its definition, call itself, go through its definition, and so on, never stopping. This ends up being *infinite recursion*. We want to avoid that. To prevent this, **all** recursive functions have a *base case*. This is a case that **does not** make a recursive call (when the function calls itself). Instead, it does some other action that ends up not calling the function itself. We can have as many base cases as we want - the only requirement to avoid infinite recursion is that a base case **must** be reached when you make a recursive call. You can have base cases that cover a variety of "end points" for your recursive calls, but it must sufficiently prevent infinite recursion, otherwise your recursive function is inherently flawed. 

The other case is a lot less nuanced - the recursive case. This is simply just the part of the function that calls your function recursively. This might seem pointless, or confusing at the moment, but we'll jump straight into an example of where recursion makes a lot of sense.

## Fibonacci

Fibonacci is one of the quintessential recursion examples. This is because for going through the fibonacci sequence, you need to use previous numbers. How does this relate to recursion? Well previously, we said that recursion is when a function calls itself. Therefore, for fibonacci, to calculate a fibonacci number, you need to calculate the previous fibonacci numbers as well (thereby "calling" fibonacci again).

The general formula to calculate a fibonacci number is: $$ F_n = F_{n-1} + F_{n-2}; F_0 = 0, F_1 = 1 $$

Basically, given that the 0th and 1st fibonacci numbers are 0 and 1, respectively, we can calculate the nth fibonacci number by summing the previous two numbers. This conceptually as a formula is pretty straightforward, so let's see how this looks with recursion.

In recursion, we said that we have a *base case* and a *recursive case*. Here, these are pretty distinct. The initial fibonacci numbers are clearly the base case. We know that because they don't call fibonacci *at all*. The recursive case is when you sum the previous two fibonacci numbers. This explicitly calls the fibonacci formula again to calculate the nth number.

As a Java function, fibonacci would look something like:

```java
// function that calculates the nth fibonacci number
public int fibonacci(int n) {
    if (n <= 1) {
        return n;
    }
    
    return fibonacci(n-1) + fibonacci(n-2);
}
```

This function does exactly what our fibonacci formula does - if `n` is 0 or 1, return 0 or 1 respectively. I do `<=` to handle negative values for `n` as good coding practice to ensure that it works in all situations and there's no unexpected results. If `n` is a larger value, then recursively call fibonacci. Each of these recursive calls will recall the exact same function, but with different parameters.

## Visualizing Recursion

Sometimes recursion can get very complicated - after all, you're calling the same function over and over again with different values. Especially to debug recursive functions, it can be helpful to draw it out to visualize. Let's try to visualize what `fibonacci(5)` would return as we go through the recursive calls.

First we start with our initial call to `fibonacci(5)`. This calls two fibonacci functions: `fibonacci(4)` and `fibonacci(3)`

```
    fib(5)
   /      \
fib(4)   fib(3)
```

Then, each of these fibonacci calls have their own recursive calls, and so on, until we reach the base cases

```
                        fib(5)
               /                       \
            fib(4)                   fib(3)
           /        \               /       \
        fib(3)     fib(2)       fib(2)    fib(1)
      /      \    /      \       /    \
  fib(2)  fib(1) fib(1) fib(0) fib(1) fib(0) 
   /    \
fib(1) fib(0)   
```

We end the tree once we have reach a base case for every call, meaning there are no recursive calls left. Now, all that's left to do is to calculate return values. We do this from the bottom up, since each recursive call requires the lower level's return values to calculate its own return

```
                        5
                 /               \
                3                 2
           /        \           /    \
          2         1          1      1
      /      \    /    \     /    \
      1      1   1      0    1     0 
   /    \
  1      0
```

Counting out the fibonacci numbers: 0, 1, 1, 2, 3, 5, we do in fact get 5 as the 5th fibonacci number (starting from 0).

Visualizing and debugging recursion can be very convoluted, confusing, and painful because of all the recursive calls, but it helps to start with a small case like we did here, and build out a similar tree to see how your recursive function makes its calls, and goes from the base case up to the final result.

## Merge Sort

The last section of this lecture is going to be on merge sort, a sorting algorithm that uses recursion.

Merge sort is a very different type of sorting algorithm that relies on splitting an array into half, sorting each of the halves recursively, and then merging the arrays together, sorting as needed. It is recursive, because each time you split the array in half, you get a new array that you can call merge sort on.

***

<span class="fs-4" style="text-align:center; display:block">
[Prev](Lecture9.md){: .btn .btn-blue}
[Next](A3.md){: .btn .btn-blue .ml-2 }
</span>