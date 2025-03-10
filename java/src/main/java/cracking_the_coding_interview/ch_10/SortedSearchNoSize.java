package cracking_the_coding_interview.ch_10;

public class SortedSearchNoSize {

    private abstract static class Listy {
        public abstract int elementAt(int idx);
    }

    private static int search(Listy listy, int target) {

        int left = 0, right = Integer.MAX_VALUE;
        while (left <= right) {

            int middle    = left + (right - left) / 2;
            int middleVal = listy.elementAt(middle);

            if (middleVal == target) return middle;

            if (middleVal == -1 || middleVal > target) right = middle - 1;
            else                                       left  = middle + 1;
        }

        return -1;
    }

}
