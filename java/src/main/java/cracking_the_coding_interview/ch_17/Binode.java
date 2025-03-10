package cracking_the_coding_interview.ch_17;

public class Binode {

    Binode left, right;
    int data;

    public Binode(Binode left, Binode right, int data) {
        this.left = left;
        this.right = right;
        this.data = data;
    }

    private static Binode prev;

    private static Binode convert(Binode root) {
        var dummy = new Binode(null, null, -1);
        prev = dummy;
        helper(root);
        return dummy.right;
    }

    private static void helper(Binode root) {
        if (root == null)
            return;

        helper(root.left);
        prev.right = root;
        prev       = root;
        root.left  = null;
        helper(root.right);
    }

}
