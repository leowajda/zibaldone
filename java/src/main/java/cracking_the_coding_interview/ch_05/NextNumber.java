package cracking_the_coding_interview.ch_05;

public class NextNumber {

    private static int getNext(int num) {

        int numZeros = countZeros(num), numOnes = countOnes(num);
        int pos = numZeros + numOnes;

        if (pos == 31 || pos == 0)
            return -1;

        num |= (1 << pos);
        num &= ~((1 << pos) - 1);
        num |= (1 << (numOnes - 1)) - 1;
        return num;
    }

    private static int getPrev(int num) {

        int numZeros = countZeros(num), numOnes = countOnes(num);
        int pos = numOnes + numZeros;

        num &= ((~0) << (pos + 1));
        int mask = (1 << (numOnes + 1)) - 1;
        num |= mask << (numZeros - 1);
        return num;
    }

    private static int countOnes(int num) {
        int numOnes = 0;
        while ((num & 1) == 1) {
            numOnes++;
            num >>= 1;
        }
        return numOnes;
    }

    private static int countZeros(int num) {
        int numZeros = 0;
        while (((num & 1) == 0) && num != 0) {
            numZeros++;
            num >>= 1;
        }
        return numZeros;
    }

}
