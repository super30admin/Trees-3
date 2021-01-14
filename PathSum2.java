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
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        helper(root, list, sum, 0);
        return result;
    }
    public void helper(TreeNode root, List<Integer> list, int target, int curSum){
        if(root == null)
            return;
        if(root.left == null && root.right == null){
            if(curSum + root.val == target){
                list.add(root.val);
                result.add(new ArrayList<>(list));
                list.remove(list.size()-1);
            }
            return;
        }
        list.add(root.val);
        helper(root.left, list, target, curSum+root.val);
        helper(root.right, list, target, curSum+root.val);
        list.remove(list.size()-1);
    }
}

//Time complexity : O(n^2) where n is the number of elements, N^2 because we are making  a deep copy of list
//Space complexity : O(h) h is the height of recursive stack
