package cracking_the_coding_interview.ch_17;

public class AddWithoutPlus {

    private static int add(int a, int b) {

        while (b != 0) {
            int sumNoCarry  = a ^ b;
            int carry       = (a & b) << 1;
            a = sumNoCarry;
            b = carry;
        }

        return a;
    }

}
