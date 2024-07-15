// Time Complexity : O(N)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

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
 public  class PathSumII {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path;
        int target = 0;
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            this.path = new ArrayList<>();
            this.target = targetSum;
            helper(root, 0);

            return result;

        }

        public void helper(TreeNode root, int currentSum) {

            // base
            if(root == null) return;

            // logic
            currentSum+= root.val;
            path.add(root.val);

            if(root.left == null && root.right == null) {
                if(currentSum == target){
                    System.out.println(path);
                    result.add(new ArrayList<>(path));
                }
            }

            helper(root.left, currentSum);

            helper(root.right, currentSum);

            // backtrack
            path.remove(path.size() - 1);

        }
}