public class PathSum2 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    // 1
    class Solution {
        List<List<Integer>> result = new ArrayList<>();
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            List<Integer> l1 = new ArrayList<>();
            dfs(root, 0, l1, targetSum);
            return result;
        }

        private void dfs(TreeNode root, int sum, List<Integer> l1, int targetSum) {
            if(root == null) return;
            sum = sum + root.val;
            l1.add(root.val);
            if(sum == targetSum && root.left == null && root.right == null) {
                result.add(l1);
            }
            dfs(root.left, sum, new ArrayList(l1), targetSum);
            dfs(root.right, sum, new ArrayList(l1), targetSum);
        }
    }
}

//2

class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> l1 = new ArrayList<>();
        dfs(root, 0, l1, targetSum);
        return result;
    }

    private void dfs(TreeNode root, int sum, List<Integer> l1, int targetSum) {
        if(root == null) return;
        sum = sum + root.val;
        l1.add(root.val);
        if(sum == targetSum && root.left == null && root.right == null) {
            result.add(new ArrayList<Integer>(l1));
        }
        if(root.left != null) {
            dfs(root.left, sum, l1, targetSum);
        }
        if(root.right != null) {
            dfs(root.right, sum, l1, targetSum);
        }
        l1.remove(l1.size()-1);
    }
}
