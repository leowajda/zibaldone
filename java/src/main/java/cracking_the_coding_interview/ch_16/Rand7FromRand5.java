package cracking_the_coding_interview.ch_16;

public abstract class Rand7FromRand5 {

    public abstract int getRand5();

    // getRand5() + getRand5() leads to an unbalanced distribution
    // increasing the range to [0, 21] fixes the problem because 21 % 7 == 0
    public int getRand7() {
        while (true) {
            int num = 5 * getRand5() + getRand5();
            if (num < 21) return num % 7;
        }
    }

}
