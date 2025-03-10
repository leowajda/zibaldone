package cracking_the_coding_interview.ch_01;

public class URLify {

    private static String urlIfy(String s, int trueLength) {
        char[] chars = s.toCharArray();

        for (int leftPtr = trueLength - 1, rightPtr = s.length() - 1; leftPtr >= 0; leftPtr--) {
            char ch = s.charAt(leftPtr);

            if (Character.isLetterOrDigit(ch)) {
                chars[rightPtr] = ch;
                rightPtr--;
                continue;
            }

            chars[rightPtr]     = '0';
            chars[rightPtr - 1] = '2';
            chars[rightPtr - 2] = '%';
            rightPtr -= 3;
        }

        return new String(chars);
    }

}
