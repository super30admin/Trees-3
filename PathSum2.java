// Time Complexity :O(n) n is number of nodes
// Space Complexity : O(h) h is height of the tree worst case height is n 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    List<List<Integer>> output;
    int targetSum;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        output = new ArrayList<List<Integer>>();
        targetSum = sum;
        List<Integer> path = new ArrayList<Integer>();
        helper(root,path,0);
        return output;
    }
    
    private void helper (TreeNode root, List<Integer> path, int currSum)
    {
        if(root==null) return;
        currSum += root.val;
        path.add(root.val);
        if(root.left==null && root.right==null && currSum == targetSum)
        {
            output.add(new ArrayList<>(path));
        }
        helper(root.left,path,currSum);
        helper(root.right,path,currSum);
        path.remove(path.size()-1);
    }    
}