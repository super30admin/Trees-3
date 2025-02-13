import java.util.ArrayList;
import java.util.List;

class TreeNode {
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
}
// TC: O(n) as all the elements are being traversed
// SC: O(h), where h is the height of the recursive call stack.

public class PathSum2 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5, new TreeNode(4), new TreeNode(8));
        root.left.left = new TreeNode(11, new TreeNode(7), new TreeNode(2));
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4, new TreeNode(5), new TreeNode(1));

        for (List<Integer> list : pathSum(root, 22)) {
            System.out.println(list);
        }
    }

    static List<List<Integer>> result;

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        if (root == null)
            return result;
        get(root, targetSum, 0, new ArrayList<>());
        return result;
    }

    private static void get(TreeNode root, int targetSum, int current, List<Integer> list) {
        if (root == null) {
            return;
        }
        current += root.val;
        list.add(root.val);
        if (root.left == null && root.right == null && current == targetSum)
            result.add(new ArrayList<>(list));
        get(root.left, targetSum, current, list);
        get(root.right, targetSum, current, list);
        list.remove(list.size() - 1);
    }

}
