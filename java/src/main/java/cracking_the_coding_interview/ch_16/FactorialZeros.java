package cracking_the_coding_interview.ch_16;

public class FactorialZeros {

    private static int factorialZeros(int n) {

        int factorialZeros = 0;
        while (n >= 5) {
            factorialZeros += n / 5;
            n /= 5;
        }

        return factorialZeros;
    }

}
