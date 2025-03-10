package cracking_the_coding_interview.ch_05;

public class Conversion {

    private static int convert(int a, int b) {
        int counter = 0;
        for (int c = a ^ b; c != 0; c &= c - 1) counter++;
        return counter;
    }

}
