package cracking_the_coding_interview.ch_16;

import java.util.*;

public class MasterMind {

    private record Result(int hits, int pseudoHits) {}

    enum Ball { Red, Yellow, Green, Blue }

    private static Result masterMind(Ball[] solution, Ball[] guess) {
        if (solution == null || guess == null || solution.length != guess.length)
            return new Result(-1, -1);

        Map<Ball, Integer> frequency = new HashMap<>(solution.length);
        int hits = 0;

        for (int i = 0; i < solution.length; i++) {
            frequency.merge(solution[i], 1, Integer::sum);
            if (solution[i] == guess[i]) {
                frequency.merge(solution[i], -1, Integer::sum);
                hits++;
            }
        }

        int pseudoHits = 0;
        for (int i = 0; i < guess.length; i++)
            if (frequency.getOrDefault(guess[i], 0) > 0 && solution[i] != guess[i]) {
                frequency.merge(guess[i], -1, Integer::sum);
                pseudoHits++;
            }

        return new Result(hits, pseudoHits);
    }

}
