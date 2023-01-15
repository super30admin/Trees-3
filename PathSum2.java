// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// We keep track of curSum and curList at each node and when we reach a leaf node, if the curSum and target sum are equal, we add curList to result
// We use backtracking approach to keep track of curList as it is getting passed by reference

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        helper(root, 0, new ArrayList<>(), targetSum);
        return result;
    }

    private void helper(TreeNode root, int curSum, List<Integer> curList, int targetSum){
        if(root==null)
            return;
        curSum+= root.val;
        curList.add(root.val);
        if(root.left == null && root.right == null && curSum == targetSum)
            result.add(new ArrayList<>(curList));
        helper(root.left, curSum, curList, targetSum);
        helper(root.right, curSum, curList, targetSum);
        curList.remove(curList.size()-1);
        return; 
    }
}