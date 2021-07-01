// Time Complexity: O(n)
// Space Complexity: O(h)

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
class Solution {
    int target;
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        target = targetSum;
        result = new ArrayList<>();
        helper(root, 0, new ArrayList<>());
        return result;
    }
    
    public void helper(TreeNode root, int curSum, List<Integer> path){
        //base
        if(root == null)
            return;
        
        curSum = curSum + root.val;
        
        path.add(root.val);
        
        if(root.left == null && root.right == null){
            if(curSum == target)
                result.add( new ArrayList<>(path));
        }
        
        //logic
        helper(root.left, curSum, path);
        helper(root.right, curSum, path);
        
        path.remove(path.size() - 1);
    }
}