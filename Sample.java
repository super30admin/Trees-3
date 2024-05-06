// Problem 1: (https://leetcode.com/problems/path-sum-ii/)
// Time Complexity : O(n)
// Space Complexity : O(h) where h is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach : I have used DFS approach to solve this problem. I have kept a track of current path and checked if the current  node is a leaf node with a value equal to the targetting sum. If yes, then I have added the path to the result list. If not, then I have recursively called the left and right child of the current node with the updated target sum. I have removed the last element from the path list after the recursive call to backtrack and explore other paths.
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(root, targetSum, path, result);
        return result;
    }

    private void dfs(TreeNode node, int targetSum, List<Integer> path, List<List<Integer>> result) {
        if (node == null) {
            return;
        }

        path.add(node.val);

        if (node.left == null && node.right == null && targetSum == node.val) {
            result.add(new ArrayList<>(path));
        }

        dfs(node.left, targetSum - node.val, path, result);
        dfs(node.right, targetSum - node.val, path, result);

        path.remove(path.size() - 1);
    }
}

// Problem 2: (https://leetcode.com/problems/symmetric-tree/)
// Time Complexity : O(n)
// Space Complexity : O(h) where h is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach : I have used DFS
// approach to solve this problem. I have checked if the left and right child of
// the current node are equal or not. If not, then I have returned false. If
// yes, then I have recursively called the left child of the left child and
// right child of the right child and vice versa. I have kept a flag to keep
// track of the symmetry of the tree.

class Solution {
    boolean flag;

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        this.flag = true;
        dfs(root.left, root.right);
        return flag;
    }

    private void dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return;
        }

        if (left == null || right == null || left.val != right.val) {
            flag = false;
            return;
        }
        dfs(left.left, right.right);
        dfs(left.right, right.left);
    }
}