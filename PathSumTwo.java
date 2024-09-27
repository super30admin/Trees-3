// Time Complexity : O(n^2) --> where n is number of nodes in the tree
// Space Complexity : O()n
// Did this code successfully run on Leetcode (113): Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    List<List<Integer>> result;
    int target;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        result = new ArrayList<>(); 
        target = sum;
        if (root == null) return result;
        
        helper(root, 0, new ArrayList<>());
        return result;
    }
    
    private void helper(TreeNode root, int currSum, List<Integer> temp) {
        // base case
        if (root == null) return;
        
        // logic
        currSum += root.val;
        temp.add(root.val);
        
        if (root.left == null && root.right == null) {
            if (currSum == target) {
                result.add(new ArrayList<>(temp));
            }
        }
        // recurse
        helper(root.left, currSum, temp);
        helper(root.right, currSum, temp);
        
        // backtrack
        temp.remove(temp.size() - 1);
    }
}