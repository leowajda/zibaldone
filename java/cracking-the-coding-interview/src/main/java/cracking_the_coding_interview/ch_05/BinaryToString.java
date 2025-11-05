package cracking_the_coding_interview.ch_05;

public class BinaryToString {

    private static String binaryToString(double num) {
        if (num <= 0 || num >= 1)
            return "ERROR";

        StringBuilder sb = new StringBuilder();
        double offset = 0.5;

        while (num > 0) {

            if (sb.length() >= 32)
                return "ERROR";

            if (num >= offset) {
                num -= offset;
                sb.append(1);
            } else
                sb.append(0);

            offset /= 2;
        }

        return sb.toString();
    }

}
