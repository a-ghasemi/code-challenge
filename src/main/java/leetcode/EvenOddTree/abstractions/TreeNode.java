package leetcode.EvenOddTree.abstractions;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode fillByArray(Integer[] input) {
        return fillByArray(input, 0);
    }

    public static TreeNode fillByArray(Integer[] input, int index) {
        if (index >= input.length || input[index] == null) return null;

        return new TreeNode(input[index],
                fillByArray(input, 2 * index + 1),
                fillByArray(input, 2 * index + 2)
        );

    }
}
