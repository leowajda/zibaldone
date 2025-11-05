package cracking_the_coding_interview.ch_05;

public class Insertion {

    public int insert(int m, int n, int j, int i) {

        int bottomMask = (~0 << (j + 1));
        int topMask    = ((1 << i) - 1);

        n &= (bottomMask | topMask);
        return n | (m << i);
    }

}
