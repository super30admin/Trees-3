// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
    We perform a Pre-Order Traversal. In addition to which, we also backtrack the element from the array.
    In each recursive call, we add the current element to the array and proceed to explore the left and right subtree.
*/

class Solution {
    
    List<List<Integer>> overallResult;
    List<Integer> branchResult;
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        overallResult = new ArrayList<>();
        branchResult = new ArrayList<>();
        
        leafSum(root, targetSum, branchResult);
        
        return overallResult;
    }
    
    public void leafSum(TreeNode node, int targetSum, List<Integer> branchResult) {
        
        if (node == null) return;
        
        targetSum -= node.val;
        
        branchResult.add(node.val);
        
        if (node.left == null && node.right == null && targetSum == 0)
            overallResult.add(new ArrayList(branchResult));
        
        leafSum(node.left, targetSum, branchResult);
        leafSum(node.right, targetSum, branchResult);
        
        branchResult.remove(branchResult.size()-1);
    }
}