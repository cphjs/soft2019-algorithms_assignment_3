
# Priority Queue

File `BinaryPriorityQueue` is an implementation of a priority queue(lowest numbers are considered higher priority) using a binary tree stored in an array. The underlying data structure is a binary tree kept in an array. 

Both enqueing and dequeuing maintain the binary tree structure by reheapifying. Because it is a binary tree and the process of re-heapifying is equivalent to inserting a new element into the tree the time complexity is **O(N * log N)**. Like all min-heaps the lowest value is kept in the known place in the heap(in this case 1st index of the array) thus _finding_ the minimum element has the time complexity of **O(1)**. 