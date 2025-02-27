package cracking_the_coding_interview.ch_17;

public class Shuffle {

    private static int randomNum(int from, int to) {
        return from + (int) (Math.random() * (to - from + 1));
    }

    private static int[] shuffle(int[] cards) {

        for (int i = 0; i  < cards.length; i++) {
            int pos = randomNum(0, i);

            int tmp     = cards[pos];
            cards[pos]  = cards[i];
            cards[i]    = tmp;
        }

        return cards;
    }

}
