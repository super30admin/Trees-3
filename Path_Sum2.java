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
    //Time O(N)
    //Space O(H)
    List<List<Integer>> result;
    int target;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<List<Integer>>();
        if(root == null)
        {
            return result;
        }
        target = targetSum;
        helper(root, new ArrayList<Integer>(), 0);
        return result;
    }
    public void helper(TreeNode root, List<Integer> lis, int currSum)
    {
        if(root == null)
        {
            return;
        }
        currSum += root.val;
        lis.add(root.val);
        if(root.left == null && root.right == null)
        {
            if(currSum == target)
            {
                result.add(new ArrayList<>(lis));
            }
        }
        helper(root.left, lis, currSum);
        helper(root.right, lis, currSum);
        //BackTrack
        lis.remove(lis.size()-1);
    }
}