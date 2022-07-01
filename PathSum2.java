/*This code utilizes recursion with backtracking to find the paths with the target sum. First, at every step
the current sum of node values along a particular path is calculated. Then the current node value is also tracked
along the current execution path. Whenever we reach a leaf node and the current sum matches the target sum, we 
add all the node values we have been tracking on that path to the resultant list. Along the way, whenever we
travel upwards on a path, we maintain the order of the path by removing the last element as we go up.

Did this code run on leetcode: Yes
*/
class Solution {
    int target;
    List<List<Integer>> result;
    
    //Time Complexity = O(n)
    //Space Complexity = O(h)
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) 
    {
        target = targetSum;
        result = new ArrayList<>();
        
        if(root == null)
            return result;
        
        helper(root, 0, new ArrayList<>());
        
        return result;
    }
    
    private void helper(TreeNode root, int currSum, List<Integer> path)
    {
        if(root == null)
            return;
        
        currSum += root.val;
        path.add(root.val);
        
        helper(root.left, currSum, path);
        helper(root.right, currSum, path);
        
        //Post-order check is done for the target sum.
        if(root.left == null && root.right == null && currSum == target)
            result.add(new ArrayList<>(path));
        
        //We remove the last element in our list before we return the function, so that our path is correct when we return to the higher function
        path.remove(path.size() - 1);
        
    }
}