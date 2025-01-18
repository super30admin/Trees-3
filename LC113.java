// TC: O(N)
// SC: O(N) for recursive stack (in worst case) and runningList (Ignoring output list as it is not considered as extra space)

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

class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    private void recurse(TreeNode root, List<Integer> runningList, int targetSum) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            if (targetSum == root.val) {
                runningList.add(root.val);
                ans.add(new ArrayList<>(runningList));
                runningList.remove(runningList.size() - 1);
            }
            return;
        }
        runningList.add(root.val);
        recurse(root.left, runningList, targetSum - root.val);
        recurse(root.right, runningList, targetSum - root.val);
        runningList.remove(runningList.size() - 1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        recurse(root, new ArrayList<>(), targetSum);
        return ans;
    }
}