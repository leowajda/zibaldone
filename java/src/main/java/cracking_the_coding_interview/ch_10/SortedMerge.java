package cracking_the_coding_interview.ch_10;

public class SortedMerge {
    private static void sortedMerge(int[] a, int[] b, int lastA, int lastB) {
        int aPtr = lastA, bPtr = lastB;
        int pos  = a.length - 1;

        while (aPtr >= 0 && bPtr >= 0) a[pos--] = a[aPtr] >= b[bPtr] ? a[aPtr--] : b[bPtr--];
        while (aPtr >= 0)              a[pos--] = a[aPtr--];
        while (bPtr >= 0)              a[pos--] = b[bPtr--];
    }
}
