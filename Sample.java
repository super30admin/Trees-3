Problem1 (https://leetcode.com/problems/path-sum-ii/)
// Time Complexity : O(n^2)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


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
Approach: Recursion
class Solution {
    List<List<Integer>> result;
    int target;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        result=new ArrayList<>();
        if(root==null) return result;
        target=sum;
        helper(root, 0, new ArrayList<>());
        return result;
    }
    public void helper(TreeNode root, int currSum, List<Integer> path){
        if(root==null) return;
        currSum+=root.val;
        path.add(root.val);
        if(root.left==null && root.right==null){
            if(currSum==target){
                result.add(path);
            }
        }        
        helper(root.left, currSum, new ArrayList<>(path));
        helper(root.right, currSum, new ArrayList<>(path));

    }
}


Problem2 (https://leetcode.com/problems/symmetric-tree/)
// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
Approach: 
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
    boolean result; // false by default
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        result=true;
        helper(root.left, root.right);
        return result;
    }
    private void helper(TreeNode left, TreeNode right){
        if(left==null && right==null) return;
        if(left==null || right==null || left.val!=right.val){
            result=false;
            return;
        }
        helper(left.left, right.right);
        helper(left.right, right.left);
    } 
}