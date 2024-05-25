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

Merge sort is a very different type of sorting algorithm that relies on splitting an array into half, sorting each of the halves recursively, and then merging the arrays together, sorting as needed. It is recursive, because each time you split the array in half, you get a new array that you can call merge sort on. You start with your initial array, breaking it in half until you have subarrays of size 1. Then you merge each of these into a sorted order. This means that the merge sort algorithm can be split into two parts, a function that handles sorting + merging the two halves of the array together along with a recursive function that keeps splitting and merging an array.

This might sound weird in theory (or maybe not), so let's see how exactly this looks in code.

```java
    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    void merge(int arr[], int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        // Create temp arrays
        int L[] = new int[n1];
        int R[] = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i) {
            L[i] = arr[l + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = arr[m + 1 + j];
        }

        // Merge the temp arrays

        // Initial indices of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    void sort(int arr[], int l, int r)
    {
        if (l < r) {

            // Find the middle point
            // Note: because `m` is an integer this will truncate and not have a 0.5
            // Refer to type casting in Lec1 for a reminder
            int m = l + (r - l) / 2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
```

So what exactly do these `sort()` and `merge()` functions do? Looking at the code, when we want to sort an array, we pass it into `sort()` along with the indices we want to sort from. This might seem redundant, since we usually want to sort from 0 to the end of the array. However, this makes the function more generalizable, since there may be a time where we only want to sort part of an array. Furthermore, since it's a recursive function, the recursive calls might pass in varying values for `l` and `r`, as we will see soon.

From here, `sort()` goes through and splits the array into two halves. It then recursively calls `sort()`. We pass the original array back in, but now we go from `l` to `m` in the first call, and `m+1` to `r` in the second call. Each of these `sort()` subcalls just see an array, and a start/end point passed into them - they have no context about the parent function calling them. They in turn will sort their array by continuing to divide it. Eventually, `l` will equal `r`, as `m` continues to be calculated. This will ensure that when the array we want to sort (defined by the `l` and `r` values) is just one element, we don't do anything, ending the recursive calls. So up to this point, we just have a series of `sort()` function calls, where each `sort()` spawns another two `sort()` functions. Once we reach that base case of `l == r` (notice this is an implicit base case since we only perform recursion on `l < r`), we stop "sorting" and go up the recursion tree.

Now, every `sort()` call is followed by a `merge()`. Merge is the actual worker here. We pass in the array and our `l`, `m`, and `r` values. Using these constraints on the section of the array we care about, we loop through the halves, actually performing the sort by combining the two pieces in order. Eventually, it goes back up to the initial `sort()`, where `merge()` will go from 0 to the array length, finishing up the merge.

So we've gone through the code, but let's run through a basic example that should hopefully provide a visual analogous to the code.

Say we want to sort the array, `[5, 2, 1, 0, 4, 3]`. The first step is to calculate `m` and split the array in half. As I list how the array goes through these function calls, the values (`l`, `r`) will be in parentheses next to the array to help better understand what is passed in

1. First we split it in half: `[5, 2, 1]` (0, 2) and `[0, 4, 3]` (3, 5)

2. Now we can call `sort()` on each of these subarrays: `[5]` (0, 0), `[2, 1]` (1, 2), `[0]` (3, 3), `[4, 3]` (4, 5)

3. We now only have 2 more arrays with more than one element, so we call `sort()` on those: <br/>
`[2]` (1, 1), `[1]` (2, 2), `[4]` (4, 4), `[3]` (5, 5)

4. Now we call `merge()` on the last set of split arrays. This would be `[2, 1]` and `[4, 3]`: <br/>
Representing this call as `merge(l, m, r)`, we get `merge(1, 1, 2) -> [1, 2]` and `merge(4, 4, 5) -> [3, 4]` <br/>
As this is inplace, the entire array up to now looks like `[5, 1, 2, 0, 3, 4]`

5. This means that we've merged + sorted up to the arrays split by step #3. We go up one more call to the split that happened in step #2, loosening the constraints placed on `merge` to include the 0th and 3rd indices. <br/>
This gives us `merge(0, 1, 2) -> [1, 2, 5]` and `merge(3, 4, 5) -> [0, 3, 4]` <br/>
Our array now looks like `[1, 2, 5, 0, 3, 4]`

6. The last step is to finish the merge on the first `sort()` call in step #1. We've sorted each half of the original array - now we merge + sort the halves into final result <br/>
`merge(0, 2, 5) -> [0, 1, 2, 3, 4, 5]`, giving us our final sorted array.

Hopefully the break down of the steps show how the recursion goes down the tree, splitting it into smaller and smaller halves, then goes in reverse almost to piece those together into a sorted order.

***

This lecture had a lot of info, but hopefully it shows what recursion is and how to use it. As you may notice, there are a lot of rules and nuances with recursion, but it can make writing functions that have distinct subparts or use previous values much easier. It's an important tool, and has various use cases. Merge sort is just one example, and it's a fairly efficient sorting algorithm (we'll see more on that soon).

<span class="fs-4" style="text-align:center; display:block">
[Prev](Lecture9.md){: .btn .btn-blue}
[Next](A3.md){: .btn .btn-blue .ml-2 }
</span>