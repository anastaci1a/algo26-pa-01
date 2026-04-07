// dep

import assignment.ana.util.math.MathExt;
import assignment.ana.util.theme.Palette;
import assignment.heaps.HeapUtil;
import assignment.ana.io.cli.Cli;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;


// main

public class HeapTester {
    // const

    public static final int LIST_SIZE = 20;

    public static final int STR_MAX_LENGTH = 5;
    public static final String STR_CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    // cli

    public static final Cli.TextFamily out = Cli.TextFamily.DEFAULT.withModif(
        Palette.getRandom(), // random color for TextType style
        null, null
    );

    // main

    public static void main(String[] args) {
        // generate list
        List<String> unsorted = generateRandomList(() -> {
            // random str init
            StringBuilder strb = new StringBuilder();

            // build string
            int strLen = 1 + (int) (STR_MAX_LENGTH * Math.random());
            for (int j = 0; j < strLen; j++) {
                // get & append random character
                int idx = MathExt.randInt(0, STR_CHARS.length());
                strb.append(STR_CHARS.charAt(idx));
            }

            // return generated string
            return strb.toString();
        });

        // sort array (copy)
        List<String> sorted = new ArrayList<>(unsorted);
        HeapUtil.sort(sorted);

        // output results
        out.mdPrintf(
            "\n## __**Unsorted**__ – Random Array:\n*%s*\n# __**Sorted**__ – After *HeapUtil.sort*:\n*%s*",
            unsorted, sorted
        );
    }

    // util

    private static <T> List<T> generateRandomList(Supplier<? extends T> generateItem) {
        return generateRandomList(generateItem, LIST_SIZE);
    }

    private static <T> List<T> generateRandomList(Supplier<? extends T> generateItem, int size) {
        List<T> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(generateItem.get());
        }

        return list;
    }
}
