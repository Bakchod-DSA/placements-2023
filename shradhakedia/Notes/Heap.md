# Heap

Heap also referred as a Priority Queue is a special type of binary tree. 
It is a complete binary tree, so height of the tree is (log n).
There are two types of heaps : 
- max Heap
- min Heap

The elements are placed in the tree based on their priority i.e. in a max heap it is guaranteed that the parent is 
greater than its children thus making root the largest element. In a min heap its vice versa.
Representing a heap in form an array A, the root takes the place A[0]. Children takes the place 2i + 1, 2i + 2.

Java provides built-in heap feature through a class called Priority Queue.

Constructors:
- PriorityQueue<E> pq = new PriorityQueue<>();  **// Creates a PriorityQueue with the default initial capacity (11) that orders its elements according to their natural ordering.**
- PriorityQueue<E> pq = new PriorityQueue<>(Collection<E> c);  **// Creates a PriorityQueue containing the elements in the specified collection.**
- PriorityQueue<E> pq = new PriorityQueue<>(int initialCapacity);
- PriorityQueue<E> pq = new PriorityQueue<>(int initialCapacity, Comparator<E> comparator);  **// Creates a PriorityQueue with the specified initial capacity that orders its elements according to the specified comparator.**

The Priority Queue class provides various functions to remove, add or perform any operation in a heap.
Major useful functions are :
- **boolean add(Object o), boolean offer(Object o)** : Inserts the specified element into this priority queue in O(log n) time. 
  If, the element to be inserted is null they throw null pointer exception.
- **Object peek()** : returns the head, or returns null if pq is empty in O(1) time.
- **Object poll(), Object remove()** : returns and remove the head, or returns null if this queue is empty in O(log n) time.
- **boolean remove(Object o)** : removes a single instance of o and returns true, if it is present in O(n) time as it 
  linearly searches the element. returns false if not present in pq and unable to remove.


              Throws exception	Returns special value
    Insert	  add(e)                offer(e)
    Remove	  remove()	        poll()
    Examine	  element()	        peek()

**Each of these methods exists in two forms: one throws an exception if the operation fails, the other returns a special
value (either null or false, depending on the operation).**
- The latter form of the insert operation is designed specifically
for use with capacity-restricted Queue implementations; in most implementations, insert operations cannot fail.
- **The offer method** inserts an element if possible, otherwise returning false. **This differs from the Collection.add()** 
method, which can fail to add an element only by throwing an unchecked exception. The offer method is designed for use 
when failure is a normal, rather than exceptional occurrence, for example, in fixed-capacity (or "bounded") queues.
- **The remove() and poll() methods** remove and return the head of the queue. Exactly which element is removed from the 
queue is a function of the queue's ordering policy, which differs from implementation to implementation. The remove() 
and poll() methods differ only in their behavior when the queue is empty: the remove() method throws an exception, while
the poll() method returns null.  
- **The element() and peek() methods** return, but do not remove, the head of the queue. if queue is empty element() throws exception whereas peek returns null.

### Points to remember: 
- Use a heap when all you care about is the largest or smallest elements, you do not need the support of fast lookup, 
search or delete operations.
- It is a good choice when you need to compute k largest or k smallest or k frequents in a collection. **For largest k or 
frequent k elements, use min heaps and for smallest k use max heap.**
- Questions based on heap are mainly on sorting and can be done using other approaches such as count sorting, bucket sorting, 
binary search in some cases, Quick select algorithm. **But, sometimes using heap improves the time complexity of many problems.**
- We can also implement stack, queue using heap where we make custom comparator based on the timestamp of entry of elements
providing LIFO, FIFO criteria respectively.

### Finding k largest elements from a max Heap without manipulating it. The max Heap is represented in form of an array.

make a maxHeap by adding the root (A[0] -> element, 0 -> index i) type of elements. now iterate k times to pop the head 
add it to result and then add next possible larger candidates from the array that are at 2i + 1, 2i + 2 positions. continuing k times to get 
k largest elements in O(k log(k)) time.