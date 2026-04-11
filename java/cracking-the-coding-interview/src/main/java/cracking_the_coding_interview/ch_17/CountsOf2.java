package cracking_the_coding_interview.ch_17;

public class CountsOf2 {

    private static int count2(int num, int d) {
        int power       = (int) Math.pow(10, d);
        int nextPower   = (int) Math.pow(10, d + 1);
        int digit       = (num / power) % 10;
        int lowerBound  = num - (num % nextPower);
        int upperBound  = lowerBound + nextPower;

        if (digit < 2)  return lowerBound / 10;
        if (digit == 2) return (lowerBound / 10) + (num % power) + 1;
        return upperBound / 10;
    }

    private static int count2(int num) {
        int n = String.valueOf(num).length();
        int counter = 0;

        for (int i = 0; i < n; i++)
            counter += count2(num, i);

        return counter;
    }

}
