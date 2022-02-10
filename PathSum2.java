import java.util.*;

public class PathSum2 {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        helper(root, targetSum, 0, new ArrayList());
        return result;
    }

    public void helper(TreeNode root, int targetSum, int currSum, List<Integer> currList) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null && (currSum + root.val == targetSum)) {
            currList.add(root.val);
            result.add(new ArrayList(currList));
            currList.remove(currList.size() - 1);
        }
        currSum += root.val;
        currList.add(root.val);

        helper(root.left, targetSum, currSum, currList);
        helper(root.right, targetSum, currSum, currList);
        currList.remove(currList.size() - 1);
    }

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
    }
}