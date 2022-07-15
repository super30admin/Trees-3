// Time Complexity :O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No


class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        helper(root, targetSum, new ArrayList<>(), 0);
        return result;
    }

    // 2,ts,[1],1
    public void helper(TreeNode root, int targetSum, List<Integer> path, int currentSum) {

        if (root == null)
            return;
        currentSum += root.val;
        // System.out.println("helper method"+root.val);
        // System.out.println("helper method currSum"+currentSum);
        if (root.left == null && root.right == null && targetSum == currentSum) {
            // System.out.println("path is"+path);
            // System.out.println("and root is"+ root);
            path.add(root.val);
            System.out.println("inside if and path is" + path);
            result.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }
        // edge case

        // logic
        path.add(root.val);
        helper(root.left, targetSum, (path), currentSum);
        helper(root.right, targetSum, (path), currentSum);
        // System.out.println("before removing path is"+path);
        path.remove(path.size() - 1);
        // System.out.println("path is"+path);
        // System.out.println("and root is"+ root.val);
    }
}