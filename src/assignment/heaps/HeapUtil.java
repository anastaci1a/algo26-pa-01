package assignment.heaps;


// main

public class HeapUtil {
    // main

    public static void sort(int[] arr) {
        sort(arr, arr.length);
    }

    public static void sort(int[] arr, int size) {
        maxHeapify(arr, size);

        for (int i = size - 1; i > 0; i--) {
            swap(arr, 0, i);
            siftDown(arr, 0, i);
        }
    }

    public static void maxHeapify(int[] arr, int size) {
        int iStart = iParent(size - 1);

        for (int i = iStart; i >= 0; i--) {
            siftDown(arr, i, size);
        }
    }

    public static void siftDown(int[] arr, int start, int end) {
        int l = iChildL(start);
        int r = iChildR(start);

        int iMax = l;

        if (r < end && arr[r] > arr[l]) {
            iMax = r;
        }

        if (l < end && arr[iMax] > arr[start]) {
            swap(arr, start, iMax);
            siftDown(arr, iMax, end);
        }
    }

    // priv util

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];

        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static int iChildL(int i) { return (2 * i) + 1; }
    private static int iChildR(int i) { return (2 * i) + 2; }
    private static int iParent(int i) { return (i - 1) / 2; }
}
