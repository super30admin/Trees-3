// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


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
class Solution {
    List<List<Integer>> result;
    int target;
public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    result = new ArrayList<>();
    target = targetSum;
    if(root==null) return result;
    dfs(root,0,new ArrayList<>());
    return result;
}
public void dfs(TreeNode root,Integer currsum,List<Integer> temp){
    if(root==null) return;
    currsum += root.val;
    temp.add(root.val);
    if(root.left== null && root.right == null){
        if(target == currsum){
            result.add(new ArrayList<>(temp));
        }
    }

dfs(root.left,currsum,temp);
dfs(root.right,currsum,temp);
temp.remove(temp.size()-1);
}
}