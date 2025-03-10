package cracking_the_coding_interview.ch_01;

public class StringRotation {

    private static boolean isRotation(String a, String b) {
        return a.length() == b.length() && a.repeat(2).contains(b);
    }

}
