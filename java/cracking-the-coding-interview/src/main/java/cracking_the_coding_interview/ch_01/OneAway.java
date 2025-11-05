package cracking_the_coding_interview.ch_01;

public class OneAway {

    private static boolean isOneAway(String a, String b) {
        if (Math.abs(a.length() - b.length()) >= 2)
            return false;

        String left  = (a.length() <= b.length()) ? a : b;
        String right = (a.length() <= b.length()) ? b : a;

        boolean isTwoAway = false;
        int leftPtr = 0, rightPtr = 0;

        while (leftPtr < left.length() && rightPtr < right.length()) {
            char leftChar = left.charAt(leftPtr), rightChar = right.charAt(rightPtr);

            if (leftChar == rightChar) {
                leftPtr++;
                rightPtr++;
                continue;
            }

            if (isTwoAway) {
                return false;
            }

            if (left.length() == right.length()) {
                leftPtr++;
            }

            isTwoAway = true;
            rightPtr++;
        }

        return true;
    }

}
