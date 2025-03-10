package cracking_the_coding_interview.ch_17;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class SmallestK {

    private static List<Integer> smallestK(List<Integer> nums, int k) {

        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        for (var num : nums)
            if (queue.size() < k) queue.add(num);
            else                  queue.add(Math.min(num, queue.remove()));

        return queue.stream().toList();
    }

}
