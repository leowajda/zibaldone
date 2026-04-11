package cracking_the_coding_interview.ch_08;

import java.util.Deque;

public class TowersOfHanoi {

    private static void move(int n, Deque<Integer> origin, Deque<Integer> destination, Deque<Integer> buffer) {
        if (n <= 0) return;
        move(n - 1, origin, buffer, destination);
        destination.push(origin.pop());
        move(n - 1, buffer, destination, origin);
    }

}
