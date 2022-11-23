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

 //Time complexity is O(N)
 //Space complexity is O(N)
class Solution {
    List<List<Integer>> result = new ArrayList();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        helper(root, targetSum, new ArrayList());
        return result;
    }
    public void helper(TreeNode root, int target, List<Integer> li){
        if(root==null){
            return;
        }
        li.add(root.val);
        if(root.left==null && root.right==null){
            if(root.val==target){
                result.add(new ArrayList(li));
            }
        }

        
        helper(root.left, target-root.val, li);
        helper(root.right, target-root.val, li);
        li.remove(li.size()-1);

    }
}