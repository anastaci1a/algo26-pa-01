package assignment.heaps;


// main

public class HeapUtil {
    // main

    /// Sort the entire input array {@code arr}
    public static void sort(int[] arr) {
        sort(arr, arr.length);
    }

    /// Sort a subset of the array {@code arr}, by amount {@code size}
    public static void sort(int[] arr, int size) {
        maxHeapify(arr, size);               // build max heap from scratch (no requirements)
        for (int i = size - 1; i > 0; i--) { // start at end, decrement to start (excl.)
            swap(arr, 0, i);                 // swap current max with subset end {@code i}
            siftDown(arr, 0, i);             // rebuild max heap after swap
        }
    }

    /// Reorder a subset of the array {@code arr} into a max heap, by amount {@code size}.
    public static void maxHeapify(int[] arr, int size) {
        int iStart = iParent(size - 1);     // get index of last child's parent ("half")
        for (int i = iStart; i >= 0; i--) { // start at "half", decrement to start (incl.)
            siftDown(arr, i, size);         // rebuild max heap for each child node (all non- max heaps)
        }
    }

    /// Reorder a subset of the array {@code arr} into a max heap, by amount {@code size}.
    /// Requires that the left and right children of the node at index {@code start} are max heaps.
    public static void siftDown(int[] arr, int start, int end) {
        int l = iChildL(start);                  // (get left child index)
        int r = iChildR(start);                  // (get right child index)

        int iMax = l;                            // set greatest val to left child

        if (r < end && arr[r] > arr[l]) {        // if right child in range, and right > left...
            iMax = r;                            // ...set max to right child
        }

        if (l < end && arr[iMax] > arr[start]) { // if left child in range, greatest > current
            swap(arr, start, iMax);              // ...swap current and greatest
            siftDown(arr, iMax, end);            // ...recursively sift down to rebuild max heap after swap
        }
    }

    // priv util

    /// Swap the values at index {@code i} and {@code j} in array {@code arr}.
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];

        arr[i] = arr[j];
        arr[j] = temp;
    }

    /// Get the left child's index of a node at index {@code i}.
    private static int iChildL(int i) { return (2 * i) + 1; }

    /// Get the right child's index of a node at index {@code i}.
    private static int iChildR(int i) { return (2 * i) + 2; }

    /// Get the parent's index of a node at index {@code i}.
    private static int iParent(int i) { return (i - 1) / 2; }
}
