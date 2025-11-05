package cracking_the_coding_interview.ch_01;

public class StringCompression {

    private static String compress(String s) {

        StringBuilder sb = new StringBuilder();
        int counter = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            counter++;

            if (i + 1 == s.length() || s.charAt(i + 1) != ch) {
                sb.append(ch).append(counter);
                counter = 0;
            }
        }

        return (sb.length() < s.length()) ? sb.toString() : s;
    }

}
