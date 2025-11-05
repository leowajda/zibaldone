package cracking_the_coding_interview.ch_10;

public class FindDuplicates {

    private static void findDuplicates(int[] nums) {

        var bitSet = new BitSet(32_000);
        for (var num : nums)
            if (bitSet.get(num)) System.out.println(num);
            else                 bitSet.set(num);
    }

    private static class BitSet {
        private static final int BASE = 32;
        private final int[] bitSet;

        public BitSet(int size) {
            this.bitSet = new int[(size / BASE) + 1];
        }

        public boolean get(int num) {
            int idx    = (num / BASE);
            int bitIdx = (num % BASE);
            return (bitSet[idx] & (1 << bitIdx)) != 0;
        }

        public void set(int num) {
            int idx    = (num / BASE);
            int bitIdx = (num % BASE);
            bitSet[idx] |= (1 << bitIdx);
        }

    }

}
