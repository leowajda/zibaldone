package cracking_the_coding_interview.ch_10;

public class SparseSearch {

    private static int search(String[] words, String target) {
        return target == null || target.isEmpty() ? -1 : helper(words, target, 0, words.length - 1);
    }

    private static int helper(String[] words, String target, int left, int right) {

        if (left > right) return -1;
        int middle = left + (right - left) / 2;
        var middleWord = words[middle];

        if (middleWord.equals(target))
            return middle;

        if (middleWord.isEmpty()) {
            int leftVal = helper(words, target, left, middle - 1);
            return leftVal != -1 ? leftVal : helper(words, target, middle + 1, right);
        }

        return middleWord.compareTo(target) < 0 ? helper(words, target, middle + 1, right) : helper(words, target, left, middle - 1);
    }


}
