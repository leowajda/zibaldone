package cracking_the_coding_interview.ch_17;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class WordDistance {

    private final File file;
    private final Map<String, List<Integer>> map;

    public WordDistance(File file) throws FileNotFoundException {
        this.file = file;
        this.map  = new HashMap<>();
        int counter = 0;

        try (var in = new Scanner(file)) {
            var word = in.next(" ");
            var pointers = map.computeIfAbsent(word, any -> new ArrayList<>());
            pointers.add(counter++);
        }
    }

    public WordDistance(String fileName) throws FileNotFoundException {
        this(new File(fileName));
    }

    public int shortestDistance(String a, String b) {
        if (!map.containsKey(a) || !map.containsKey(b))
            return -1;

        var aPointers = map.get(a);
        var bPointers = map.get(b);

        int minDistance = Integer.MAX_VALUE;
        int aPtr = 0, bPtr = bPointers.size() - 1;

        while (aPtr < aPointers.size() && bPtr >= 0) {
            int aVal = aPointers.get(aPtr);
            int bVal = bPointers.get(bPtr);

            int distance = Math.abs(aVal - bVal);
            if (distance < minDistance) {
                minDistance = distance;
                bPtr--;
            } else aPtr++;

        }

        return minDistance;
    }

}
