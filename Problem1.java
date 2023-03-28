// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * Maintain two lists, one which will keep altering the path when nodes are added and one list when one path is complete with elements reaching target value. 
 * Compute the currentSum for each local path and check if it reaches target. 
 * Calculate left and right recursion for the tree with the helper function. 
 * Remove the element from the path if the sum doesn't equate target sum and reaches null. 
 */

class Problem1 { 
    List<List<Integer>> result;
    List<Integer> path;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        path = new ArrayList<>();
        helper(root, 0 , targetSum);
        return result;
    }
    private void helper(TreeNode root, int currSum, int targetSum){
        if(root == null )
            return ;
        currSum = currSum + root.val; 
        path.add(root.val);
        if(root.left == null && root.right == null){
            if(currSum == targetSum)
                result.add(new ArrayList<>(path));
        }
        helper(root.left, currSum, targetSum);
        helper(root.right, currSum, targetSum);
        path.remove(path.size()-1);
    }
}
