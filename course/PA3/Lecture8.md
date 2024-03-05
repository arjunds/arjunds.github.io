---
title: Lecture 8 - 2D Arrays
parent: Part 3 - Wrapping Up Basics
nav_order: 2
---

# Lecture 8 - 2D Arrays

## What are 2D Arrays?

Before, we learned about arrays - essentially a list of items. You defined an array by giving an upper bound on the number of values it would hold, and then you could retrieve and modify each value by indexing through the array. We said that arrays could hold anything, primitive data types like `int`, or even objects like `String`. But what if each spot in an array holds another array? This is totally possible, and creates a 2D array! This is incredibly useful for being able to store data in 2 dimensions, effectively as a table with rows and columns. You could go crazy and have as many dimensions as you want (ie arrays that hold arrays that hold arrays ... and so on), but for the purposes of this lesson, we'll keep it simpler with only 2 dimensions

## Using 2D Arrays

```java

int[][] twoD = new int[4][5];

twoD[3][3] = 1;
twoD[1][3] = 5;

String[][] letters = { {"ab", "cd", "ef"}, {"gh", "ij", "kl"} };

```

Here, we can see the two ways of working with arrays: Initializing an empty array and then setting the values at each index, like the top example, or just directly filling the array on declaring by putting all the initial values in curly brackets. The difference between 2D and normal arrays is that with 2D arrays, you quite literally have arrays within arrays. This means that you need to define both the "inner" and "outer" arrays. For example, in the `letters` array, we have the "outer" array that has 2 elements - 2 `String` arrays. The "inner" arrays are those 2 `String` arrays that each have 3 `String` values. Similarly, the first array, `twoD` has an "outer" array of 4 elements (since this is the first value), and the "inner" arrays each have 5 `int` values. We read left to right to determine this. Another way to think about is that `twoD[3]` would return the third index of the `twoD` array. However, this itself is an array, meaning we can index into it further with `twoD[3][3]`, getting the third index of the array at `twoD[3]`.

This all can definitely be super confusing, so let's try to visualize it using actual tables

## Visualizing 2D Arrays

If we wanted to visualize `letters`, it would look something like the following:

| "ab" | "cd" | "ef" |
| "gh" | "ij" | "kl" |

Here, we can see that the two distinct "outer" arrays are the rows, and the "inner" arrays encompass the columns. This means that our first index (`letters[0]` or `letters[1]`) will retrieve a row, or an "outer" array. Then, indexing into each "outer" array or row will retrieve specific columns. For example, `letters[0][1]` would return `"cd"`.

We can also extend this to our `twoD` example. Let's assume that `twoD` is initialized to the following:

| 0 | 1 | 2 | 3 | 4 |
| 5 | 6 | 7 | 8 | 9 |
| 10 | 11 | 12 | 13 | 14 |
| 15 | 16 | 17 | 18 | 19 |

In this example, `twoD[3][3]` would correspond to the fourth row and fourth column (remember arrays are 0-indexed!). If we count that out, we get the value 18. Similarly, `twoD[0][4]` would get the first row and then the last column (so it'd be 4!). Try to think through a few of these examples to fully internalize the complexities of 2D arrays

## Why 2D Arrays?

Why do we even care about 2D arrays? This really depends on use case, but any situation that requires you to keep and store a table of data will definitely benefit from a 2D array. The possibilities are really endless and depend on what you want to do, which is why arrays of multiple dimensions are quite common. For example, images are 2-dimensional, but each pixel has 3 values (RGB). This makes it a 3D array, where each row/column pair corresponds to another 3 value array that stores the RGB value for that pixel. Another cool abstraction is, if you think of Strings as arrays of `char` values, then an array of Strings is technically a `char[][]`, since each row corresponds to a `String` (or `char[]`), and the columns are the individual `char` values in the `String`. 2D arrays have various use cases that you'll see all through your time programming

***

This was a fairly short lecture, but it focused on a very important part of programming - 2D arrays. These are extremely important to understand, since they start to reflect how important visualization is in programming, but also how you can store and work with different types of data past just the one dimension we've seen with arrays previously. This really is the intro to data structures that we will properly explore in Part 4.

<span class="fs-4" style="text-align:center; display:block">
[Prev](Lecture7.md){: .btn .btn-blue}
[Next](Lecture9.md){: .btn .btn-blue .ml-2 }
</span>
