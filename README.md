# Programming Pearls

Exercises from the famous Programming Pearls by Jon Bentley.

***
# Current content

# Column 1

* Fast system sort implementation using a **bitmap** data structure along with an efficient algorithm for 
sampling `k` unique elements in range `[1, n]`, for which I used the **floyd's random sampling algorithm.** The problem is to design an efficient algorithm to sort a list of 
`1,000,000` distinct positive elements all lesser than `10,000,000` using lesser than `2 MB` storage. The sorting 
algorithm designed here beats the Java system sort by a factor of `4`.


# Column 2 - Algorithms

* Group anagrams in a list of words. Solved by assigning each word a **signature** that is its sorted form 
and grouping all words with the same signature together.
* Rotate a vector by `i` positions in-place. Boils down to changing vector `ab` to `ba` where `a` and `b`
represent a contiguous block of elements. This is elegantly solved by employing a bunch of `reverse` operations
on the array. 
* Rotate matrix in place. Solved by using an in-place transposition algorithm.


# Column 3 - Data Structures

* Design a clean and maintable algorithm to process tax amounts for various input incomes. Key was to use 
an array.

# Column 8 - Algorithm Design Techniques

* A turnpike consists of `n - 1` streches of road between `n` toll stations. Each strech has an associated cost
of travel. Design a data structure that requires `O(n)` space but allows the cost of any route to be computed in 
constant time. Key was the use of **prefix arrays.**

# Column 14 - Heaps

* Implement a Priority Queue.
* Implemented a sequencial disk access method that adds an additional pointer to every node to enable logarithmic index access time. Time and space complexity is `log(n)` when there are `n` elements in the list. The logarithmic access time is achieved by storing an additional `jump` pointer at every node. The functionality is similar to that of finding the `ith` power of a number in `log(i)` time. For example, to find the `5th` element, we would visit `5 -> 4 -> 2 -> 1`. 

# Column 15 - String Of Pearls

* Find the longest repeated substring in a string. Example, `LRS(banana) = ana`. The problem can be solved using **suffix arrays.**
* Given a new input string, how would you search a suffix array to find the longest match in the given text? Solved using **binary search.**
