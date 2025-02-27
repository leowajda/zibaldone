package cracking_the_coding_interview.ch_17;

import java.util.HashMap;
import java.util.Map;

public class LettersAndNumbers {

    private record Counter(int letterCount, int digitCount) {
        public int min() {
            return Math.min(letterCount, digitCount);
        }

        public Counter update(char ch) {
            boolean isDigit = Character.isDigit(ch);
            return isDigit ? new Counter(letterCount, digitCount + 1) : new Counter(letterCount + 1, digitCount);
        }
    }

    private static int lettersAndNumbers(char[] chars) {

        int n = chars.length;
        int longestSubarray = 0;
        Map<Integer, Counter> map = new HashMap<>(n);
        map.put(-1, new Counter(0, 0));

        for (int i = 0; i < n; i++) {
            var newCounter = map.get(i - 1).update(chars[i]);
            map.put(i, newCounter);
            int minCount = newCounter.min();
            var prevCounter = map.get(i - minCount * 2);

            if (minCount == newCounter.letterCount && (newCounter.digitCount - prevCounter.digitCount) == minCount)
                longestSubarray = Math.max(longestSubarray, minCount * 2);

            if (minCount == newCounter.digitCount && (newCounter.letterCount - prevCounter.letterCount) == minCount)
                longestSubarray = Math.max(longestSubarray, minCount * 2);
        }

        return longestSubarray;
    }
}
