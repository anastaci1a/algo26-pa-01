package assignment.heaps;


// dep

import java.util.List;


// main

public interface HeapUtil {
    // const

    boolean ASCENDING = false;

    // static

    /// Sort the entire input list {@code list}.
    static <T extends Comparable<T>> void sort(List<T> list) {
        sort(list, list.size());
    }

    /// Sort a subset of the list {@code list}, by amount {@code size}.
    static <T extends Comparable<T>> void sort(List<T> list, int size) {
        maxHeapify(list, size);              // build max heap from scratch (no requirements)
        for (int i = size - 1; i > 0; i--) { // start at end, decrement to start (excl.)
            swap(list, 0, i);                // swap current max with subset end {@code i}
            siftDown(list, 0, i);            // rebuild max heap after swap
        }
    }

    /// Reorder a subset of the list {@code list} into a max heap, by amount {@code size}.
    static <T extends Comparable<T>> void maxHeapify(List<T> list, int size) {
        int iStart = iParent(size - 1);     // get index of last child's parent ("half")
        for (int i = iStart; i >= 0; i--) { // start at "half", decrement to start (incl.)
            siftDown(list, i, size);        // rebuild max heap for each child node (all non-max heaps)
        }
    }

    /// Reorder a subset of the list {@code list} into a max heap, by amount {@code size}.
    /// Requires that the left and right children of the node at index {@code start} are max heaps.
    static <T extends Comparable<T>> void siftDown(List<T> list, int start, int end) {
        int l = iChildL(start);                      // (get left child index)
        int r = iChildR(start);                      // (get right child index)

        int iMax = l;                                // set max val to left child

        if (r < end && compare(list, r, l)) {        // if right child in range, and right node > left node...
            iMax = r;                                // ...set max to right child
        }

        if (l < end && compare(list, iMax, start)) { // if left child in range, and max node > current node...
            swap(list, start, iMax);                 // ...swap current and max
            siftDown(list, iMax, end);               // ...recursively sift down to rebuild max heap after swap
        }
    }

    // priv util

    /// Compare the values at index {@code i} and {@code j} in list {@code list} (determined by {@code HeapUtil.ASCENDING}).
    private static <T extends Comparable<T>> boolean compare(List<T> list, int i, int j) {
        if (ASCENDING) return lt(list, j, i);
        else return lt(list, i, j);
    }

    /// Compare the values at index {@code i} and {@code j} in list {@code list} ({@code list.at(i) < list.at(j)}).
    private static <T extends Comparable<T>> boolean lt(List<T> list, int i, int j) {
        T iVal = list.get(i);
        T jVal = list.get(j);

        return iVal.compareTo(jVal) < 0; // less than
    }

    /// Swap the values at index {@code i} and {@code j} in list {@code list}.
    private static <T extends Comparable<T>> void swap(List<T> list, int i, int j) {
        T temp = list.get(i);

        list.set(i, list.get(j));
        list.set(j, temp);
    }

    /// Get the left child's index of a node at index {@code i}.
    private static int iChildL(int i) { return (2 * i) + 1; }

    /// Get the right child's index of a node at index {@code i}.
    private static int iChildR(int i) { return (2 * i) + 2; }

    /// Get the parent's index of a node at index {@code i}.
    private static int iParent(int i) { return (i - 1) / 2; }
}
