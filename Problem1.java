// Time Complexity : O(N*N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach: 

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
    List<List<Integer>> final_List;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        final_List = new ArrayList<List<Integer>>();
        helper(sum, new ArrayList<>(), root, 0);
        return final_List;
    }
    
    private void helper(int Target, List<Integer> array_List, TreeNode root, int curr_sum){
        if(root == null) return;
        
        array_List.add(root.val);
        curr_sum += root.val;
        
        if(root.left == null && root.right == null && curr_sum == Target){
            final_List.add(new ArrayList(array_List));
        }
        else{
            helper(Target, array_List, root.left, curr_sum);
            helper(Target, array_List, root.right, curr_sum);
        }
        
        array_List.remove(array_List.size()-1);
    }
}
