package cracking_the_coding_interview.ch_01;

public class IsUnique {

    private static boolean hasAllUniqueCharacters(String s) {

        int bitMask = 0b0;
        // assumes ASCII in range 'a' - 'z'
        for (int i = 0; i < s.length(); i++) {
            int val = s.charAt(i) - 'a';
            int marker = (1 << val);
            if ((bitMask & marker) != 0)
                return false;
            bitMask |= marker;
        }

        return true;
    }

}
