package cracking_the_coding_interview.ch_17;


import java.util.Arrays;
import java.util.Comparator;

import static java.util.Comparator.comparingInt;

/*
    A circus is designing a tower routine consisting of people standing atop one another's shoulders.
    For practical and aesthetic reasons, each person must be both shorter and lighter than the person below him or her.
    Given the heights and weights of each person in the circus, write a method to compute the largest possible number of people in such a tower.

    people[i][0] <= people[i - 1][0] && people[i][1] <= people[i - 1][1]

    (5, 5) (4, 4) (3, 3) (2, 2)

    (10, 1) (6, 9) (3, 3) (2, 2)

    idx, count, int[]

*/
public class CircusTower {

    private static int circusTower(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int n = people.length;

        int[][] memo = new int[n + 1][n];
        Arrays.stream(memo).forEach(arr -> Arrays.fill(arr, -1));
        return helper(people, memo, -1, 0, 0);
    }

    private static int helper(int[][] people, int[][] memo, int prevIdx, int currIdx, int weightBound) {
        if (currIdx == people.length)
            return 0;

        if (memo[prevIdx + 1][currIdx] >= 0)
            return memo[prevIdx + 1][currIdx];

        int taken = 0;
        if (prevIdx < 0 || people[currIdx][1] > weightBound)
            taken = helper(people, memo, currIdx, currIdx + 1, people[currIdx][1]) + 1;

        int notTaken = helper(people, memo, prevIdx, currIdx + 1, weightBound);
        return memo[prevIdx + 1][currIdx] = Math.max(taken, notTaken);
    }



}

