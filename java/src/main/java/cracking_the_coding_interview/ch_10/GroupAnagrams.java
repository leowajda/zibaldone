package cracking_the_coding_interview.ch_10;

import java.util.*;

public class GroupAnagrams {

    private static void groupAnagrams(String[] anagrams) {
        Map<String, List<String>> map = new HashMap<>(anagrams.length);

        for (var anagram : anagrams) {
            var key   = sort(anagram);
            var value = map.computeIfAbsent(key, any -> new ArrayList<>());
            value.add(anagram);
        }

        int pos = 0;
        for (var entry : map.entrySet())
            for (var anagram : entry.getValue())
                anagrams[pos++] = anagram;
    }

    private static String sort(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }


}
