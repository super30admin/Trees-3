// Time Complexity : O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach/**
//We will create a recursive function and traverse in preorder fashion
//Keep track of the elements in the lis as well as the sum of values
//When its leaf check for sum value and add to list of list
//Return the list of list result
 /* Definition for a binary tree node.
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
    int sum;
    List<List<Integer>> res;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        sum = 0;
        res = new ArrayList<List<Integer>>();
        solve(root, targetSum, new ArrayList<Integer>(), 0);
        return res;
    }
    private void solve(TreeNode root, int target, List<Integer> list, int num){
        if(root == null){
           // list.remove(list.size() - 1);
            return;
        }
        num += root.val;
        list.add(root.val);
        if(root.left == null && root.right == null){
            if(num == target){
                List<Integer> clone = new ArrayList<Integer>(list);
                res.add(clone);
            }
            list.remove(list.size() - 1);
            return;
        }
        solve(root.left, target, list, num);
        solve(root.right, target, list, num);
        list.remove(list.size() - 1);
    }
}