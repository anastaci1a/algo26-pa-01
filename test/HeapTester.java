// dep

import assignment.ana.util.theme.Palette;
import assignment.heaps.HeapUtil;
import assignment.ana.io.cli.Cli;

import java.util.Arrays;


// main

public class HeapTester {
    // const

    public static final int ARR_LENGTH = 20;
    public static final int NUMBER_MAX = 100;

    // cli

    public static final Cli.TextFamily out = Cli.TextFamily.DEFAULT.withModif(
        Palette.getRandom(), // random color for TextType style
        null, null
    );

    // main

    public static void main(String[] args) {
        // generate array
        int[] arr = new int[ARR_LENGTH];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * NUMBER_MAX);
        }

        // sort array (copy)
        int[] sorted = Arrays.copyOf(arr, arr.length);
        HeapUtil.sort(sorted);

        // output results
        out.mdPrintf(
            "\n## __**Unsorted**__ – Random Array:\n*%s*\n# __**Sorted**__ – After *HeapUtil.sort*:\n*%s*",
            Arrays.toString(arr),
            Arrays.toString(sorted)
        );
    }
}
