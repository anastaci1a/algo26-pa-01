## Heapsort / Heap Utilities
> ***Algorithm Design & Analysis*** @ SCSU, *Spring '26*

| Packages                                                                                          | Description                          |
|:--------------------------------------------------------------------------------------------------|:-------------------------------------|
| [*assignment.heaps*](https://github.com/anastaci1a/algo26-pa-01/tree/master/src/assignment/heaps) | Heap utils and sorting functionality |
| [*assignment.ana*](https://github.com/anastaci1a/algo26-pa-01/tree/master/src/assignment/ana)     | Extra testing/cli utils              |

> [!NOTE]
> The subpackages in [*assignment.ana*](https://github.com/anastaci1a/algo26-pa-01/tree/master/src/assignment/ana) are unaltered copies of several utilities in the ***[ana.\*](https://anastaci1a.github.io/ana-dot-star/)*** module (proprietary).

---

### [HeapUtil.java](https://github.com/anastaci1a/algo26-pa-01/blob/master/src/assignment/heaps/HeapUtil.java)
> *./src/assignment/heaps/* **HeapUtil.java**

| Static Methods                                               | Description                                                                                                                                                                                   |
|:-------------------------------------------------------------|:----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| <code>void sort(List<T> list)</code>                         | Sort the entire input list <code>list</code>.                                                                                                                                                 |
| <code>void sort(List<T> list, int size)</code>               | Sort a subset of the list <code>list</code>, by amount <code>size</code>.                                                                                                                     |
| <code>void maxHeapify(List<T> list, int size)</code>         | Reorder a subset of the list <code>list</code> into a max heap, by amount <code>size</code>.                                                                                                  |
| <code>void siftDown(List<T> list, int start, int end)</code> | Reorder a subset of the list <code>list</code> into a max heap, by amount <code>size</code>. Requires that the left and right children of the node at index <code>start</code> are max heaps. |

---

### [HeapTester.java](https://github.com/anastaci1a/algo26-pa-01/blob/master/test/HeapTester.java) – *Example Output*
> *./test/* **HeapTester.java**

![example-output](res/example-output-0.png)
